package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1570a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PersonChangeActivity personChangeActivity) {
        this.f1570a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        boolean z;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bm bmVar4;
        com.baidu.tieba.model.bm bmVar5;
        Dialog dialog;
        com.baidu.tieba.model.bm bmVar6;
        com.baidu.tieba.model.bm bmVar7;
        radioButton = this.f1570a.v;
        if (!radioButton.isChecked()) {
            radioButton2 = this.f1570a.w;
            if (radioButton2.isChecked()) {
                bmVar = this.f1570a.z;
                if (bmVar != null) {
                    bmVar2 = this.f1570a.z;
                    if (bmVar2.a().getSex() != 2) {
                        this.f1570a.H = true;
                    }
                }
            }
        } else {
            bmVar6 = this.f1570a.z;
            if (bmVar6 != null) {
                bmVar7 = this.f1570a.z;
                if (bmVar7.a().getSex() != 1) {
                    this.f1570a.H = true;
                }
            }
        }
        z = this.f1570a.H;
        if (!z) {
            bmVar3 = this.f1570a.z;
            if (bmVar3 != null) {
                bmVar4 = this.f1570a.z;
                if (bmVar4.a().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bmVar5 = this.f1570a.z;
                    intent.putExtra("data", bmVar5.a());
                    this.f1570a.setResult(-1, intent);
                }
            }
            this.f1570a.finish();
            return;
        }
        dialog = this.f1570a.G;
        dialog.show();
    }
}
