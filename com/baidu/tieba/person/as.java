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
    final /* synthetic */ PersonChangeActivity f2318a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.f2318a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.bw bwVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.model.bw bwVar2;
        ay ayVar;
        com.baidu.tieba.model.bw bwVar3;
        ay ayVar2;
        ay ayVar3;
        com.baidu.tieba.model.bw bwVar4;
        this.f2318a.a();
        bwVar = this.f2318a.y;
        PersonChangeData a2 = bwVar.a();
        editText = this.f2318a.s;
        a2.setIntro(editText.getText().toString());
        radioGroup = this.f2318a.t;
        if (radioGroup.getCheckedRadioButtonId() == R.id.man) {
            bwVar4 = this.f2318a.y;
            bwVar4.a().setSex(1);
        } else {
            radioGroup2 = this.f2318a.t;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                bwVar2 = this.f2318a.y;
                bwVar2.a().setSex(2);
            }
        }
        ayVar = this.f2318a.B;
        if (ayVar == null) {
            PersonChangeActivity personChangeActivity = this.f2318a;
            PersonChangeActivity personChangeActivity2 = this.f2318a;
            bwVar3 = this.f2318a.y;
            personChangeActivity.B = new ay(personChangeActivity2, bwVar3);
            ayVar2 = this.f2318a.B;
            ayVar2.setPriority(3);
            ayVar3 = this.f2318a.B;
            ayVar3.execute(new String[0]);
        }
    }
}
