package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.bGa.bFW;
        if (dialog != null) {
            dialog2 = this.bGa.bFW;
            com.baidu.adp.lib.g.k.b(dialog2, this.bGa.getPageContext());
        }
        this.bGa.aao();
    }
}
