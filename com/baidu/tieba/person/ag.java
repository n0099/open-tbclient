package com.baidu.tieba.person;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.o oVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.b.o oVar2;
        al alVar;
        com.baidu.tieba.b.o oVar3;
        al alVar2;
        com.baidu.tieba.b.o oVar4;
        this.a.g();
        oVar = this.a.p;
        editText = this.a.j;
        oVar.a(editText.getText().toString());
        radioGroup = this.a.k;
        if (radioGroup.getCheckedRadioButtonId() == R.id.man) {
            oVar4 = this.a.p;
            oVar4.a(1);
        } else {
            radioGroup2 = this.a.k;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                oVar2 = this.a.p;
                oVar2.a(2);
            }
        }
        alVar = this.a.s;
        if (alVar == null) {
            PersonChangeActivity personChangeActivity = this.a;
            PersonChangeActivity personChangeActivity2 = this.a;
            oVar3 = this.a.p;
            personChangeActivity.s = new al(personChangeActivity2, oVar3);
            alVar2 = this.a.s;
            alVar2.execute(new String[0]);
        }
    }
}
