package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import com.baidu.tieba.model.bw;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.f2220a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        bw bwVar;
        bw bwVar2;
        boolean z;
        bw bwVar3;
        bw bwVar4;
        Boolean bool;
        bw bwVar5;
        bw bwVar6;
        Dialog dialog;
        bw bwVar7;
        bw bwVar8;
        radioButton = this.f2220a.u;
        if (radioButton.isChecked()) {
            bwVar7 = this.f2220a.y;
            if (bwVar7 != null) {
                bwVar8 = this.f2220a.y;
                if (bwVar8.a().getSex() != 1) {
                    this.f2220a.G = true;
                }
            }
        } else {
            radioButton2 = this.f2220a.v;
            if (radioButton2.isChecked()) {
                bwVar = this.f2220a.y;
                if (bwVar != null) {
                    bwVar2 = this.f2220a.y;
                    if (bwVar2.a().getSex() != 2) {
                        this.f2220a.G = true;
                    }
                }
            }
        }
        z = this.f2220a.G;
        if (z) {
            dialog = this.f2220a.F;
            dialog.show();
            return;
        }
        bwVar3 = this.f2220a.y;
        if (bwVar3 != null) {
            bwVar4 = this.f2220a.y;
            if (bwVar4.a().getPhotoChanged()) {
                Intent intent = new Intent();
                bool = this.f2220a.b;
                if (bool.booleanValue()) {
                    bwVar6 = this.f2220a.y;
                    intent.putExtra("person_change_data", bwVar6.a());
                } else {
                    bwVar5 = this.f2220a.y;
                    intent.putExtra("data", bwVar5.a());
                }
                this.f2220a.setResult(-1, intent);
            }
        }
        this.f2220a.finish();
    }
}
