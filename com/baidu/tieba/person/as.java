package com.baidu.tieba.person;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.baidu.tieba.data.PersonChangeData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.f1326a = personChangeActivity;
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
        this.f1326a.b();
        bhVar = this.f1326a.z;
        PersonChangeData a2 = bhVar.a();
        editText = this.f1326a.t;
        a2.setIntro(editText.getText().toString());
        radioGroup = this.f1326a.u;
        if (radioGroup.getCheckedRadioButtonId() != R.id.man) {
            radioGroup2 = this.f1326a.u;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                bhVar2 = this.f1326a.z;
                bhVar2.a().setSex(2);
            }
        } else {
            bhVar4 = this.f1326a.z;
            bhVar4.a().setSex(1);
        }
        axVar = this.f1326a.C;
        if (axVar == null) {
            PersonChangeActivity personChangeActivity = this.f1326a;
            PersonChangeActivity personChangeActivity2 = this.f1326a;
            bhVar3 = this.f1326a.z;
            personChangeActivity.C = new ax(personChangeActivity2, bhVar3);
            axVar2 = this.f1326a.C;
            axVar2.setPriority(3);
            axVar3 = this.f1326a.C;
            axVar3.execute(new String[0]);
        }
    }
}
