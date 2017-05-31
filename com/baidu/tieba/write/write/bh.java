package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.gaR.gaw;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.gaR.getPageContext().getPageActivity(), this.gaR.getCurrentFocus());
            this.gaR.gax = System.currentTimeMillis();
        }
    }
}
