package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.f1655a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        com.baidu.tieba.model.bn bnVar;
        com.baidu.tieba.model.bn bnVar2;
        boolean z;
        com.baidu.tieba.model.bn bnVar3;
        com.baidu.tieba.model.bn bnVar4;
        Boolean bool;
        com.baidu.tieba.model.bn bnVar5;
        com.baidu.tieba.model.bn bnVar6;
        Dialog dialog;
        com.baidu.tieba.model.bn bnVar7;
        com.baidu.tieba.model.bn bnVar8;
        radioButton = this.f1655a.w;
        if (!radioButton.isChecked()) {
            radioButton2 = this.f1655a.x;
            if (radioButton2.isChecked()) {
                bnVar = this.f1655a.A;
                if (bnVar != null) {
                    bnVar2 = this.f1655a.A;
                    if (bnVar2.a().getSex() != 2) {
                        this.f1655a.I = true;
                    }
                }
            }
        } else {
            bnVar7 = this.f1655a.A;
            if (bnVar7 != null) {
                bnVar8 = this.f1655a.A;
                if (bnVar8.a().getSex() != 1) {
                    this.f1655a.I = true;
                }
            }
        }
        z = this.f1655a.I;
        if (!z) {
            bnVar3 = this.f1655a.A;
            if (bnVar3 != null) {
                bnVar4 = this.f1655a.A;
                if (bnVar4.a().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.f1655a.b;
                    if (bool.booleanValue()) {
                        bnVar6 = this.f1655a.A;
                        intent.putExtra("person_change_data", bnVar6.a());
                    } else {
                        bnVar5 = this.f1655a.A;
                        intent.putExtra("data", bnVar5.a());
                    }
                    this.f1655a.setResult(-1, intent);
                }
            }
            this.f1655a.finish();
            return;
        }
        dialog = this.f1655a.H;
        dialog.show();
    }
}
