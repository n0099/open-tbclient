package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PersonChangeActivity personChangeActivity) {
        this.bHK = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.bHK.bHG;
        if (dialog != null) {
            dialog2 = this.bHK.bHG;
            com.baidu.adp.lib.g.k.b(dialog2, this.bHK.getPageContext());
        }
        this.bHK.aaO();
    }
}
