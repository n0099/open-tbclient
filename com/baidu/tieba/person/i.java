package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnClickListener {
    final /* synthetic */ h bBp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bBp = hVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        dialog = this.bBp.bBn;
        com.baidu.adp.lib.g.j.b(dialog, this.bBp.bBl);
    }
}
