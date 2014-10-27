package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnClickListener {
    final /* synthetic */ h bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bBb = hVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        dialog = this.bBb.bAZ;
        com.baidu.adp.lib.g.j.b(dialog, this.bBb.bAX);
    }
}
