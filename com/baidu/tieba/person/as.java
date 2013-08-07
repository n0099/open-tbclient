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
    final /* synthetic */ PersonChangeActivity f1576a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.f1576a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.bm bmVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.model.bm bmVar2;
        ax axVar;
        com.baidu.tieba.model.bm bmVar3;
        ax axVar2;
        ax axVar3;
        com.baidu.tieba.model.bm bmVar4;
        this.f1576a.b();
        bmVar = this.f1576a.z;
        PersonChangeData a2 = bmVar.a();
        editText = this.f1576a.t;
        a2.setIntro(editText.getText().toString());
        radioGroup = this.f1576a.u;
        if (radioGroup.getCheckedRadioButtonId() != R.id.man) {
            radioGroup2 = this.f1576a.u;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                bmVar2 = this.f1576a.z;
                bmVar2.a().setSex(2);
            }
        } else {
            bmVar4 = this.f1576a.z;
            bmVar4.a().setSex(1);
        }
        axVar = this.f1576a.C;
        if (axVar == null) {
            PersonChangeActivity personChangeActivity = this.f1576a;
            PersonChangeActivity personChangeActivity2 = this.f1576a;
            bmVar3 = this.f1576a.z;
            personChangeActivity.C = new ax(personChangeActivity2, bmVar3);
            axVar2 = this.f1576a.C;
            axVar2.setPriority(3);
            axVar3 = this.f1576a.C;
            axVar3.execute(new String[0]);
        }
    }
}
