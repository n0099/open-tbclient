package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        com.baidu.tieba.b.s sVar;
        com.baidu.tieba.b.s sVar2;
        boolean z;
        com.baidu.tieba.b.s sVar3;
        com.baidu.tieba.b.s sVar4;
        com.baidu.tieba.b.s sVar5;
        Dialog dialog;
        com.baidu.tieba.b.s sVar6;
        com.baidu.tieba.b.s sVar7;
        radioButton = this.a.v;
        if (!radioButton.isChecked()) {
            radioButton2 = this.a.w;
            if (radioButton2.isChecked()) {
                sVar = this.a.z;
                if (sVar != null) {
                    sVar2 = this.a.z;
                    if (sVar2.b() != 2) {
                        this.a.H = true;
                    }
                }
            }
        } else {
            sVar6 = this.a.z;
            if (sVar6 != null) {
                sVar7 = this.a.z;
                if (sVar7.b() != 1) {
                    this.a.H = true;
                }
            }
        }
        z = this.a.H;
        if (!z) {
            sVar3 = this.a.z;
            if (sVar3 != null) {
                sVar4 = this.a.z;
                if (sVar4.d()) {
                    Intent intent = new Intent();
                    sVar5 = this.a.z;
                    intent.putExtra("data", sVar5);
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
