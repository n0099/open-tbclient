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
        com.baidu.tieba.b.r rVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.b.r rVar2;
        aw awVar;
        com.baidu.tieba.b.r rVar3;
        aw awVar2;
        com.baidu.tieba.b.r rVar4;
        this.a.i();
        rVar = this.a.z;
        editText = this.a.t;
        rVar.a(editText.getText().toString());
        radioGroup = this.a.u;
        if (radioGroup.getCheckedRadioButtonId() != R.id.man) {
            radioGroup2 = this.a.u;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                rVar2 = this.a.z;
                rVar2.a(2);
            }
        } else {
            rVar4 = this.a.z;
            rVar4.a(1);
        }
        awVar = this.a.C;
        if (awVar == null) {
            PersonChangeActivity personChangeActivity = this.a;
            PersonChangeActivity personChangeActivity2 = this.a;
            rVar3 = this.a.z;
            personChangeActivity.C = new aw(personChangeActivity2, rVar3);
            awVar2 = this.a.C;
            awVar2.execute(new String[0]);
        }
    }
}
