package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class be implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.at atVar;
        int i;
        boolean z;
        com.baidu.tieba.model.at atVar2;
        com.baidu.tieba.model.at atVar3;
        Boolean bool;
        com.baidu.tieba.model.at atVar4;
        com.baidu.tieba.model.at atVar5;
        Dialog dialog;
        atVar = this.a.u;
        int sex = atVar.a().getSex();
        i = this.a.E;
        if (sex != i) {
            this.a.D = true;
        }
        z = this.a.D;
        if (!z) {
            atVar2 = this.a.u;
            if (atVar2 != null) {
                atVar3 = this.a.u;
                if (atVar3.a().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.a.b;
                    if (bool.booleanValue()) {
                        atVar5 = this.a.u;
                        intent.putExtra("person_change_data", atVar5.a());
                    } else {
                        atVar4 = this.a.u;
                        intent.putExtra("data", atVar4.a());
                    }
                    this.a.setResult(-1, intent);
                }
            }
            this.a.finish();
            return;
        }
        dialog = this.a.B;
        dialog.show();
    }
}
