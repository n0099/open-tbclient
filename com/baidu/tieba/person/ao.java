package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.f2314a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        com.baidu.tieba.model.bw bwVar;
        com.baidu.tieba.model.bw bwVar2;
        boolean z;
        com.baidu.tieba.model.bw bwVar3;
        com.baidu.tieba.model.bw bwVar4;
        Boolean bool;
        com.baidu.tieba.model.bw bwVar5;
        com.baidu.tieba.model.bw bwVar6;
        Dialog dialog;
        com.baidu.tieba.model.bw bwVar7;
        com.baidu.tieba.model.bw bwVar8;
        radioButton = this.f2314a.u;
        if (radioButton.isChecked()) {
            bwVar7 = this.f2314a.y;
            if (bwVar7 != null) {
                bwVar8 = this.f2314a.y;
                if (bwVar8.a().getSex() != 1) {
                    this.f2314a.G = true;
                }
            }
        } else {
            radioButton2 = this.f2314a.v;
            if (radioButton2.isChecked()) {
                bwVar = this.f2314a.y;
                if (bwVar != null) {
                    bwVar2 = this.f2314a.y;
                    if (bwVar2.a().getSex() != 2) {
                        this.f2314a.G = true;
                    }
                }
            }
        }
        z = this.f2314a.G;
        if (z) {
            dialog = this.f2314a.F;
            dialog.show();
            return;
        }
        bwVar3 = this.f2314a.y;
        if (bwVar3 != null) {
            bwVar4 = this.f2314a.y;
            if (bwVar4.a().getPhotoChanged()) {
                Intent intent = new Intent();
                bool = this.f2314a.b;
                if (bool.booleanValue()) {
                    bwVar6 = this.f2314a.y;
                    intent.putExtra("person_change_data", bwVar6.a());
                } else {
                    bwVar5 = this.f2314a.y;
                    intent.putExtra("data", bwVar5.a());
                }
                this.f2314a.setResult(-1, intent);
            }
        }
        this.f2314a.finish();
    }
}
