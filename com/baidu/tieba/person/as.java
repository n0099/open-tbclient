package com.baidu.tieba.person;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.baidu.tieba.data.PersonChangeData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.bh bhVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.model.bh bhVar2;
        ax axVar;
        com.baidu.tieba.model.bh bhVar3;
        ax axVar2;
        ax axVar3;
        com.baidu.tieba.model.bh bhVar4;
        this.a.b();
        bhVar = this.a.z;
        PersonChangeData a = bhVar.a();
        editText = this.a.t;
        a.setIntro(editText.getText().toString());
        radioGroup = this.a.u;
        if (radioGroup.getCheckedRadioButtonId() != R.id.man) {
            radioGroup2 = this.a.u;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                bhVar2 = this.a.z;
                bhVar2.a().setSex(2);
            }
        } else {
            bhVar4 = this.a.z;
            bhVar4.a().setSex(1);
        }
        axVar = this.a.C;
        if (axVar == null) {
            PersonChangeActivity personChangeActivity = this.a;
            PersonChangeActivity personChangeActivity2 = this.a;
            bhVar3 = this.a.z;
            personChangeActivity.C = new ax(personChangeActivity2, bhVar3);
            axVar2 = this.a.C;
            axVar2.setPriority(3);
            axVar3 = this.a.C;
            axVar3.execute(new String[0]);
        }
    }
}
