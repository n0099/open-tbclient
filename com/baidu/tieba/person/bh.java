package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.model.au auVar;
        int i;
        boolean z;
        com.baidu.tieba.model.au auVar2;
        com.baidu.tieba.model.au auVar3;
        Boolean bool;
        com.baidu.tieba.model.au auVar4;
        com.baidu.tieba.model.au auVar5;
        Dialog dialog;
        auVar = this.a.u;
        int sex = auVar.a().getSex();
        i = this.a.D;
        if (sex != i) {
            this.a.C = true;
        }
        z = this.a.C;
        if (!z) {
            auVar2 = this.a.u;
            if (auVar2 != null) {
                auVar3 = this.a.u;
                if (auVar3.a().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.a.b;
                    if (bool.booleanValue()) {
                        auVar5 = this.a.u;
                        intent.putExtra("person_change_data", auVar5.a());
                    } else {
                        auVar4 = this.a.u;
                        intent.putExtra("data", auVar4.a());
                    }
                    this.a.setResult(-1, intent);
                }
            }
            this.a.finish();
            return;
        }
        dialog = this.a.A;
        com.baidu.adp.lib.e.e.a(dialog, this.a);
    }
}
