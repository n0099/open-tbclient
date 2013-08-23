package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1606a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PersonChangeActivity personChangeActivity) {
        this.f1606a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        com.baidu.tieba.model.bl blVar;
        com.baidu.tieba.model.bl blVar2;
        boolean z;
        com.baidu.tieba.model.bl blVar3;
        com.baidu.tieba.model.bl blVar4;
        Boolean bool;
        com.baidu.tieba.model.bl blVar5;
        com.baidu.tieba.model.bl blVar6;
        Dialog dialog;
        com.baidu.tieba.model.bl blVar7;
        com.baidu.tieba.model.bl blVar8;
        radioButton = this.f1606a.w;
        if (!radioButton.isChecked()) {
            radioButton2 = this.f1606a.x;
            if (radioButton2.isChecked()) {
                blVar = this.f1606a.A;
                if (blVar != null) {
                    blVar2 = this.f1606a.A;
                    if (blVar2.a().getSex() != 2) {
                        this.f1606a.I = true;
                    }
                }
            }
        } else {
            blVar7 = this.f1606a.A;
            if (blVar7 != null) {
                blVar8 = this.f1606a.A;
                if (blVar8.a().getSex() != 1) {
                    this.f1606a.I = true;
                }
            }
        }
        z = this.f1606a.I;
        if (!z) {
            blVar3 = this.f1606a.A;
            if (blVar3 != null) {
                blVar4 = this.f1606a.A;
                if (blVar4.a().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.f1606a.f1592a;
                    if (bool.booleanValue()) {
                        blVar6 = this.f1606a.A;
                        intent.putExtra("person_change_data", blVar6.a());
                    } else {
                        blVar5 = this.f1606a.A;
                        intent.putExtra("data", blVar5.a());
                    }
                    this.f1606a.setResult(-1, intent);
                }
            }
            this.f1606a.finish();
            return;
        }
        dialog = this.f1606a.H;
        dialog.show();
    }
}
