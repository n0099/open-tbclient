package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.gpp.goW;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.gpp.getPageContext().getPageActivity(), this.gpp.getCurrentFocus());
            this.gpp.goX = System.currentTimeMillis();
        }
    }
}
