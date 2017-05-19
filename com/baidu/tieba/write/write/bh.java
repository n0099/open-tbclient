package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.fSV.fSA;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.fSV.getPageContext().getPageActivity(), this.fSV.getCurrentFocus());
            this.fSV.fSB = System.currentTimeMillis();
        }
    }
}
