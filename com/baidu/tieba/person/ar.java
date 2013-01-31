package com.baidu.tieba.person;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.q qVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.b.q qVar2;
        aw awVar;
        com.baidu.tieba.b.q qVar3;
        aw awVar2;
        com.baidu.tieba.b.q qVar4;
        this.a.i();
        qVar = this.a.z;
        editText = this.a.t;
        qVar.a(editText.getText().toString());
        radioGroup = this.a.u;
        if (radioGroup.getCheckedRadioButtonId() != R.id.man) {
            radioGroup2 = this.a.u;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                qVar2 = this.a.z;
                qVar2.a(2);
            }
        } else {
            qVar4 = this.a.z;
            qVar4.a(1);
        }
        awVar = this.a.C;
        if (awVar == null) {
            PersonChangeActivity personChangeActivity = this.a;
            PersonChangeActivity personChangeActivity2 = this.a;
            qVar3 = this.a.z;
            personChangeActivity.C = new aw(personChangeActivity2, qVar3);
            awVar2 = this.a.C;
            awVar2.execute(new String[0]);
        }
    }
}
