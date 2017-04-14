package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.fSq.fRX;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.fSq.getPageContext().getPageActivity(), this.fSq.getCurrentFocus());
            this.fSq.fRY = System.currentTimeMillis();
        }
    }
}
