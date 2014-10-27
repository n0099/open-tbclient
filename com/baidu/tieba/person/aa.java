package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PersonChangeActivity personChangeActivity) {
        this.bCm = personChangeActivity;
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
        auVar = this.bCm.bCd;
        int sex = auVar.TT().getSex();
        i = this.bCm.mSex;
        if (sex != i) {
            this.bCm.JU = true;
        }
        z = this.bCm.JU;
        if (!z) {
            auVar2 = this.bCm.bCd;
            if (auVar2 != null) {
                auVar3 = this.bCm.bCd;
                if (auVar3.TT().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.bCm.bBQ;
                    if (bool.booleanValue()) {
                        auVar5 = this.bCm.bCd;
                        intent.putExtra("person_change_data", auVar5.TT());
                    } else {
                        auVar4 = this.bCm.bCd;
                        intent.putExtra("data", auVar4.TT());
                    }
                    this.bCm.setResult(-1, intent);
                }
            }
            this.bCm.finish();
            return;
        }
        dialog = this.bCm.bCi;
        com.baidu.adp.lib.g.j.a(dialog, this.bCm);
    }
}
