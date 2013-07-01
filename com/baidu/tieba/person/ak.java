package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1318a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PersonChangeActivity personChangeActivity) {
        this.f1318a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        com.baidu.tieba.model.bh bhVar;
        com.baidu.tieba.model.bh bhVar2;
        boolean z;
        com.baidu.tieba.model.bh bhVar3;
        com.baidu.tieba.model.bh bhVar4;
        com.baidu.tieba.model.bh bhVar5;
        Dialog dialog;
        com.baidu.tieba.model.bh bhVar6;
        com.baidu.tieba.model.bh bhVar7;
        radioButton = this.f1318a.v;
        if (!radioButton.isChecked()) {
            radioButton2 = this.f1318a.w;
            if (radioButton2.isChecked()) {
                bhVar = this.f1318a.z;
                if (bhVar != null) {
                    bhVar2 = this.f1318a.z;
                    if (bhVar2.a().getSex() != 2) {
                        this.f1318a.H = true;
                    }
                }
            }
        } else {
            bhVar6 = this.f1318a.z;
            if (bhVar6 != null) {
                bhVar7 = this.f1318a.z;
                if (bhVar7.a().getSex() != 1) {
                    this.f1318a.H = true;
                }
            }
        }
        z = this.f1318a.H;
        if (!z) {
            bhVar3 = this.f1318a.z;
            if (bhVar3 != null) {
                bhVar4 = this.f1318a.z;
                if (bhVar4.a().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bhVar5 = this.f1318a.z;
                    intent.putExtra("data", bhVar5.a());
                    this.f1318a.setResult(-1, intent);
                }
            }
            this.f1318a.finish();
            return;
        }
        dialog = this.f1318a.G;
        dialog.show();
    }
}
