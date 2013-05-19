package com.baidu.tieba.person;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
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
        com.baidu.tieba.c.be beVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.c.be beVar2;
        aw awVar;
        com.baidu.tieba.c.be beVar3;
        aw awVar2;
        aw awVar3;
        com.baidu.tieba.c.be beVar4;
        this.a.b();
        beVar = this.a.z;
        com.baidu.tieba.a.an d = beVar.d();
        editText = this.a.t;
        d.a(editText.getText().toString());
        radioGroup = this.a.u;
        if (radioGroup.getCheckedRadioButtonId() != R.id.man) {
            radioGroup2 = this.a.u;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                beVar2 = this.a.z;
                beVar2.d().a(2);
            }
        } else {
            beVar4 = this.a.z;
            beVar4.d().a(1);
        }
        awVar = this.a.C;
        if (awVar == null) {
            PersonChangeActivity personChangeActivity = this.a;
            PersonChangeActivity personChangeActivity2 = this.a;
            beVar3 = this.a.z;
            personChangeActivity.C = new aw(personChangeActivity2, beVar3);
            awVar2 = this.a.C;
            awVar2.setPriority(3);
            awVar3 = this.a.C;
            awVar3.execute(new String[0]);
        }
    }
}
