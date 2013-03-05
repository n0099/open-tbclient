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
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        boolean z;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        com.baidu.tieba.b.r rVar5;
        Dialog dialog;
        com.baidu.tieba.b.r rVar6;
        com.baidu.tieba.b.r rVar7;
        radioButton = this.a.v;
        if (!radioButton.isChecked()) {
            radioButton2 = this.a.w;
            if (radioButton2.isChecked()) {
                rVar = this.a.z;
                if (rVar != null) {
                    rVar2 = this.a.z;
                    if (rVar2.b() != 2) {
                        this.a.H = true;
                    }
                }
            }
        } else {
            rVar6 = this.a.z;
            if (rVar6 != null) {
                rVar7 = this.a.z;
                if (rVar7.b() != 1) {
                    this.a.H = true;
                }
            }
        }
        z = this.a.H;
        if (!z) {
            rVar3 = this.a.z;
            if (rVar3 != null) {
                rVar4 = this.a.z;
                if (rVar4.d()) {
                    Intent intent = new Intent();
                    rVar5 = this.a.z;
                    intent.putExtra("data", rVar5);
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
