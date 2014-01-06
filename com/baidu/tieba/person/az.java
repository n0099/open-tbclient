package com.baidu.tieba.person;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.baidu.tieba.data.PersonChangeData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.bw bwVar;
        EditText editText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        com.baidu.tieba.model.bw bwVar2;
        bf bfVar;
        com.baidu.tieba.model.bw bwVar3;
        bf bfVar2;
        bf bfVar3;
        com.baidu.tieba.model.bw bwVar4;
        this.a.a();
        bwVar = this.a.y;
        PersonChangeData a = bwVar.a();
        editText = this.a.s;
        a.setIntro(editText.getText().toString().replaceAll("\\s*", ""));
        radioGroup = this.a.t;
        if (radioGroup.getCheckedRadioButtonId() == R.id.man) {
            bwVar4 = this.a.y;
            bwVar4.a().setSex(1);
        } else {
            radioGroup2 = this.a.t;
            if (radioGroup2.getCheckedRadioButtonId() == R.id.woman) {
                bwVar2 = this.a.y;
                bwVar2.a().setSex(2);
            }
        }
        bfVar = this.a.B;
        if (bfVar == null) {
            PersonChangeActivity personChangeActivity = this.a;
            PersonChangeActivity personChangeActivity2 = this.a;
            bwVar3 = this.a.y;
            personChangeActivity.B = new bf(personChangeActivity2, bwVar3);
            bfVar2 = this.a.B;
            bfVar2.setPriority(3);
            bfVar3 = this.a.B;
            bfVar3.execute(new String[0]);
        }
    }
}
