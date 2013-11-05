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
    final /* synthetic */ PersonChangeActivity f2182a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.f2182a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.bv bvVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.model.bv bvVar2;
        ay ayVar;
        com.baidu.tieba.model.bv bvVar3;
        ay ayVar2;
        ay ayVar3;
        com.baidu.tieba.model.bv bvVar4;
        this.f2182a.b();
        bvVar = this.f2182a.A;
        PersonChangeData a2 = bvVar.a();
        editText = this.f2182a.u;
        a2.setIntro(editText.getText().toString());
        radioGroup = this.f2182a.v;
        if (radioGroup.getCheckedRadioButtonId() == R.id.man) {
            bvVar4 = this.f2182a.A;
            bvVar4.a().setSex(1);
        } else {
            radioGroup2 = this.f2182a.v;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                bvVar2 = this.f2182a.A;
                bvVar2.a().setSex(2);
            }
        }
        ayVar = this.f2182a.D;
        if (ayVar == null) {
            PersonChangeActivity personChangeActivity = this.f2182a;
            PersonChangeActivity personChangeActivity2 = this.f2182a;
            bvVar3 = this.f2182a.A;
            personChangeActivity.D = new ay(personChangeActivity2, bvVar3);
            ayVar2 = this.f2182a.D;
            ayVar2.setPriority(3);
            ayVar3 = this.f2182a.D;
            ayVar3.execute(new String[0]);
        }
    }
}
