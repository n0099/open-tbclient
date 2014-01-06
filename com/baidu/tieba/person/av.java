package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
/* loaded from: classes.dex */
class av implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
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
        radioButton = this.a.u;
        if (radioButton.isChecked()) {
            bwVar7 = this.a.y;
            if (bwVar7 != null) {
                bwVar8 = this.a.y;
                if (bwVar8.a().getSex() != 1) {
                    this.a.G = true;
                }
            }
        } else {
            radioButton2 = this.a.v;
            if (radioButton2.isChecked()) {
                bwVar = this.a.y;
                if (bwVar != null) {
                    bwVar2 = this.a.y;
                    if (bwVar2.a().getSex() != 2) {
                        this.a.G = true;
                    }
                }
            }
        }
        z = this.a.G;
        if (z) {
            dialog = this.a.F;
            dialog.show();
            return;
        }
        bwVar3 = this.a.y;
        if (bwVar3 != null) {
            bwVar4 = this.a.y;
            if (bwVar4.a().getPhotoChanged()) {
                Intent intent = new Intent();
                bool = this.a.b;
                if (bool.booleanValue()) {
                    bwVar6 = this.a.y;
                    intent.putExtra("person_change_data", bwVar6.a());
                } else {
                    bwVar5 = this.a.y;
                    intent.putExtra("data", bwVar5.a());
                }
                this.a.setResult(-1, intent);
            }
        }
        this.a.finish();
    }
}
