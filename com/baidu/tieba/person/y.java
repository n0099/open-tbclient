package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        com.baidu.tieba.b.o oVar;
        com.baidu.tieba.b.o oVar2;
        boolean z;
        com.baidu.tieba.b.o oVar3;
        com.baidu.tieba.b.o oVar4;
        com.baidu.tieba.b.o oVar5;
        Dialog dialog;
        com.baidu.tieba.b.o oVar6;
        com.baidu.tieba.b.o oVar7;
        radioButton = this.a.l;
        if (radioButton.isChecked()) {
            oVar6 = this.a.p;
            if (oVar6 != null) {
                oVar7 = this.a.p;
                if (oVar7.b() != 1) {
                    this.a.x = true;
                }
            }
        } else {
            radioButton2 = this.a.m;
            if (radioButton2.isChecked()) {
                oVar = this.a.p;
                if (oVar != null) {
                    oVar2 = this.a.p;
                    if (oVar2.b() != 2) {
                        this.a.x = true;
                    }
                }
            }
        }
        z = this.a.x;
        if (z) {
            dialog = this.a.w;
            dialog.show();
            return;
        }
        oVar3 = this.a.p;
        if (oVar3 != null) {
            oVar4 = this.a.p;
            if (oVar4.d()) {
                Intent intent = new Intent();
                oVar5 = this.a.p;
                intent.putExtra("data", oVar5);
                this.a.setResult(-1, intent);
            }
        }
        this.a.finish();
    }
}
