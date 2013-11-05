package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2178a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.f2178a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        com.baidu.tieba.model.bv bvVar;
        com.baidu.tieba.model.bv bvVar2;
        boolean z;
        com.baidu.tieba.model.bv bvVar3;
        com.baidu.tieba.model.bv bvVar4;
        Boolean bool;
        com.baidu.tieba.model.bv bvVar5;
        com.baidu.tieba.model.bv bvVar6;
        Dialog dialog;
        com.baidu.tieba.model.bv bvVar7;
        com.baidu.tieba.model.bv bvVar8;
        radioButton = this.f2178a.w;
        if (radioButton.isChecked()) {
            bvVar7 = this.f2178a.A;
            if (bvVar7 != null) {
                bvVar8 = this.f2178a.A;
                if (bvVar8.a().getSex() != 1) {
                    this.f2178a.I = true;
                }
            }
        } else {
            radioButton2 = this.f2178a.x;
            if (radioButton2.isChecked()) {
                bvVar = this.f2178a.A;
                if (bvVar != null) {
                    bvVar2 = this.f2178a.A;
                    if (bvVar2.a().getSex() != 2) {
                        this.f2178a.I = true;
                    }
                }
            }
        }
        z = this.f2178a.I;
        if (z) {
            dialog = this.f2178a.H;
            dialog.show();
            return;
        }
        bvVar3 = this.f2178a.A;
        if (bvVar3 != null) {
            bvVar4 = this.f2178a.A;
            if (bvVar4.a().getPhotoChanged()) {
                Intent intent = new Intent();
                bool = this.f2178a.b;
                if (bool.booleanValue()) {
                    bvVar6 = this.f2178a.A;
                    intent.putExtra("person_change_data", bvVar6.a());
                } else {
                    bvVar5 = this.f2178a.A;
                    intent.putExtra("data", bvVar5.a());
                }
                this.f2178a.setResult(-1, intent);
            }
        }
        this.f2178a.finish();
    }
}
