package com.samuelvialle.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** Variables globales **/
    private static final String TAG = "Calculator";
    EditText etNumber1, etNumber2;
    TextView tvResult;

    /** LIen widget et  code **/
    public void init(){
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);
    }

    /** Ajout de la méthode de gestion du clic sur les boutons **/
    public void calculator(View view){
        // Récupération des informations pour la gestion du clic sur les boutons
        // Quelles sont les valeurs renseignées par l'utilisateur ?
        int number1 = Integer.parseInt(etNumber1.getText().toString());
        int number2 = Integer.parseInt(etNumber2.getText().toString());

        // Quel bouton vient d'être pressé dans la vue ?
        Button btnPressed = (Button) view;

        // Récupération de l'id pour être utilisé dans le switch ci-desous
        int buttonId = btnPressed.getId();
        // Log.i(TAG, btnPressed.toString()); // Popur voir à quoi ressemble un id décommenter

        int result = 0;
        String signe = "";

        switch (buttonId){
            case R.id.btnAdd:
                result = number1 + number2;
                signe =" + ";
                break;
            case R.id.btnSub:
                result = number1 - number2;
                signe =" - ";
                break;
            case R.id.btnDivide:
                result = number1 / number2;
                signe =" / ";
                break;
            case R.id.btnMultiply:
                result = number1 * number2;
                signe =" * ";
                break;
        }
        Log.i(TAG, number1 + signe + number2 + " = " + result);
        tvResult.setText(number1 + signe + number2 + " = " + result);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Appel de la méthode init
        init();
    }
}