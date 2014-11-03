package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bCA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PersonChangeActivity personChangeActivity) {
        this.bCA = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.bCA.bCw;
        if (dialog != null) {
            dialog2 = this.bCA.bCw;
            com.baidu.adp.lib.g.j.b(dialog2, this.bCA);
        }
        this.bCA.ZX();
    }
}
