package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        com.baidu.tieba.c.be beVar;
        com.baidu.tieba.c.be beVar2;
        boolean z;
        com.baidu.tieba.c.be beVar3;
        com.baidu.tieba.c.be beVar4;
        com.baidu.tieba.c.be beVar5;
        Dialog dialog;
        com.baidu.tieba.c.be beVar6;
        com.baidu.tieba.c.be beVar7;
        radioButton = this.a.v;
        if (!radioButton.isChecked()) {
            radioButton2 = this.a.w;
            if (radioButton2.isChecked()) {
                beVar = this.a.z;
                if (beVar != null) {
                    beVar2 = this.a.z;
                    if (beVar2.d().b() != 2) {
                        this.a.H = true;
                    }
                }
            }
        } else {
            beVar6 = this.a.z;
            if (beVar6 != null) {
                beVar7 = this.a.z;
                if (beVar7.d().b() != 1) {
                    this.a.H = true;
                }
            }
        }
        z = this.a.H;
        if (!z) {
            beVar3 = this.a.z;
            if (beVar3 != null) {
                beVar4 = this.a.z;
                if (beVar4.d().d()) {
                    Intent intent = new Intent();
                    beVar5 = this.a.z;
                    intent.putExtra("data", beVar5.d());
                    this.a.setResult(-1, intent);
                }
            }
            this.a.finish();
            return;
        }
        dialog = this.a.G;
        dialog.show();
    }
}
