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
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        boolean z;
        com.baidu.tieba.b.q qVar3;
        com.baidu.tieba.b.q qVar4;
        com.baidu.tieba.b.q qVar5;
        Dialog dialog;
        com.baidu.tieba.b.q qVar6;
        com.baidu.tieba.b.q qVar7;
        radioButton = this.a.v;
        if (!radioButton.isChecked()) {
            radioButton2 = this.a.w;
            if (radioButton2.isChecked()) {
                qVar = this.a.z;
                if (qVar != null) {
                    qVar2 = this.a.z;
                    if (qVar2.b() != 2) {
                        this.a.H = true;
                    }
                }
            }
        } else {
            qVar6 = this.a.z;
            if (qVar6 != null) {
                qVar7 = this.a.z;
                if (qVar7.b() != 1) {
                    this.a.H = true;
                }
            }
        }
        z = this.a.H;
        if (!z) {
            qVar3 = this.a.z;
            if (qVar3 != null) {
                qVar4 = this.a.z;
                if (qVar4.d()) {
                    Intent intent = new Intent();
                    qVar5 = this.a.z;
                    intent.putExtra("data", qVar5);
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
