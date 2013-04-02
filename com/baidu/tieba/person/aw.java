package com.baidu.tieba.person;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.s sVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.b.s sVar2;
        bb bbVar;
        com.baidu.tieba.b.s sVar3;
        bb bbVar2;
        com.baidu.tieba.b.s sVar4;
        this.a.i();
        sVar = this.a.z;
        editText = this.a.t;
        sVar.a(editText.getText().toString());
        radioGroup = this.a.u;
        if (radioGroup.getCheckedRadioButtonId() != R.id.man) {
            radioGroup2 = this.a.u;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                sVar2 = this.a.z;
                sVar2.a(2);
            }
        } else {
            sVar4 = this.a.z;
            sVar4.a(1);
        }
        bbVar = this.a.C;
        if (bbVar == null) {
            PersonChangeActivity personChangeActivity = this.a;
            PersonChangeActivity personChangeActivity2 = this.a;
            sVar3 = this.a.z;
            personChangeActivity.C = new bb(personChangeActivity2, sVar3);
            bbVar2 = this.a.C;
            bbVar2.execute(new String[0]);
        }
    }
}
