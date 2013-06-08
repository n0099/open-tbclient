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
        com.baidu.tieba.c.bh bhVar;
        com.baidu.tieba.c.bh bhVar2;
        boolean z;
        com.baidu.tieba.c.bh bhVar3;
        com.baidu.tieba.c.bh bhVar4;
        com.baidu.tieba.c.bh bhVar5;
        Dialog dialog;
        com.baidu.tieba.c.bh bhVar6;
        com.baidu.tieba.c.bh bhVar7;
        radioButton = this.a.v;
        if (!radioButton.isChecked()) {
            radioButton2 = this.a.w;
            if (radioButton2.isChecked()) {
                bhVar = this.a.z;
                if (bhVar != null) {
                    bhVar2 = this.a.z;
                    if (bhVar2.d().b() != 2) {
                        this.a.H = true;
                    }
                }
            }
        } else {
            bhVar6 = this.a.z;
            if (bhVar6 != null) {
                bhVar7 = this.a.z;
                if (bhVar7.d().b() != 1) {
                    this.a.H = true;
                }
            }
        }
        z = this.a.H;
        if (!z) {
            bhVar3 = this.a.z;
            if (bhVar3 != null) {
                bhVar4 = this.a.z;
                if (bhVar4.d().d()) {
                    Intent intent = new Intent();
                    bhVar5 = this.a.z;
                    intent.putExtra("data", bhVar5.d());
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
