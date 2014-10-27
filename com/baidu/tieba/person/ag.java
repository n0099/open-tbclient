package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PersonChangeActivity personChangeActivity) {
        this.bCm = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        com.baidu.tieba.model.au auVar;
        Boolean bool;
        com.baidu.tieba.model.au auVar2;
        com.baidu.tieba.model.au auVar3;
        Dialog dialog2;
        dialog = this.bCm.bCi;
        if (dialog != null) {
            dialog2 = this.bCm.bCi;
            com.baidu.adp.lib.g.j.b(dialog2, this.bCm);
        }
        auVar = this.bCm.bCd;
        if (auVar.TT().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.bCm.bBQ;
            if (bool.booleanValue()) {
                auVar3 = this.bCm.bCd;
                intent.putExtra("person_change_data", auVar3.TT());
            } else {
                auVar2 = this.bCm.bCd;
                intent.putExtra("data", auVar2.TT());
            }
            this.bCm.setResult(-1, intent);
        }
        this.bCm.finish();
    }
}
