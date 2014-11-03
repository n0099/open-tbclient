package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bCA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PersonChangeActivity personChangeActivity) {
        this.bCA = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        com.baidu.tieba.model.au auVar;
        Boolean bool;
        com.baidu.tieba.model.au auVar2;
        com.baidu.tieba.model.au auVar3;
        Dialog dialog2;
        dialog = this.bCA.bCw;
        if (dialog != null) {
            dialog2 = this.bCA.bCw;
            com.baidu.adp.lib.g.j.b(dialog2, this.bCA);
        }
        auVar = this.bCA.bCr;
        if (auVar.TW().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.bCA.bCe;
            if (bool.booleanValue()) {
                auVar3 = this.bCA.bCr;
                intent.putExtra("person_change_data", auVar3.TW());
            } else {
                auVar2 = this.bCA.bCr;
                intent.putExtra("data", auVar2.TW());
            }
            this.bCA.setResult(-1, intent);
        }
        this.bCA.finish();
    }
}
