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
    final /* synthetic */ PersonChangeActivity f1614a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.f1614a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.bl blVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.model.bl blVar2;
        ax axVar;
        com.baidu.tieba.model.bl blVar3;
        ax axVar2;
        ax axVar3;
        com.baidu.tieba.model.bl blVar4;
        this.f1614a.b();
        blVar = this.f1614a.A;
        PersonChangeData a2 = blVar.a();
        editText = this.f1614a.u;
        a2.setIntro(editText.getText().toString());
        radioGroup = this.f1614a.v;
        if (radioGroup.getCheckedRadioButtonId() != R.id.man) {
            radioGroup2 = this.f1614a.v;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                blVar2 = this.f1614a.A;
                blVar2.a().setSex(2);
            }
        } else {
            blVar4 = this.f1614a.A;
            blVar4.a().setSex(1);
        }
        axVar = this.f1614a.D;
        if (axVar == null) {
            PersonChangeActivity personChangeActivity = this.f1614a;
            PersonChangeActivity personChangeActivity2 = this.f1614a;
            blVar3 = this.f1614a.A;
            personChangeActivity.D = new ax(personChangeActivity2, blVar3);
            axVar2 = this.f1614a.D;
            axVar2.setPriority(3);
            axVar3 = this.f1614a.D;
            axVar3.execute(new String[0]);
        }
    }
}
