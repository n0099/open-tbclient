package com.baidu.tieba.person;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.baidu.tieba.data.PersonChangeData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1663a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PersonChangeActivity personChangeActivity) {
        this.f1663a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.bn bnVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.model.bn bnVar2;
        aw awVar;
        com.baidu.tieba.model.bn bnVar3;
        aw awVar2;
        aw awVar3;
        com.baidu.tieba.model.bn bnVar4;
        this.f1663a.b();
        bnVar = this.f1663a.A;
        PersonChangeData a2 = bnVar.a();
        editText = this.f1663a.u;
        a2.setIntro(editText.getText().toString());
        radioGroup = this.f1663a.v;
        if (radioGroup.getCheckedRadioButtonId() != R.id.man) {
            radioGroup2 = this.f1663a.v;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                bnVar2 = this.f1663a.A;
                bnVar2.a().setSex(2);
            }
        } else {
            bnVar4 = this.f1663a.A;
            bnVar4.a().setSex(1);
        }
        awVar = this.f1663a.D;
        if (awVar == null) {
            PersonChangeActivity personChangeActivity = this.f1663a;
            PersonChangeActivity personChangeActivity2 = this.f1663a;
            bnVar3 = this.f1663a.A;
            personChangeActivity.D = new aw(personChangeActivity2, bnVar3);
            awVar2 = this.f1663a.D;
            awVar2.setPriority(3);
            awVar3 = this.f1663a.D;
            awVar3.execute(new String[0]);
        }
    }
}
