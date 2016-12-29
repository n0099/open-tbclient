package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.fDQ.fDx;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.fDQ.getPageContext().getPageActivity(), this.fDQ.getCurrentFocus());
            this.fDQ.fDy = System.currentTimeMillis();
        }
    }
}
