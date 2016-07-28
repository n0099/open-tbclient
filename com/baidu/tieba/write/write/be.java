package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.fVn.fVe;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.fVn.getPageContext().getPageActivity(), this.fVn.getCurrentFocus());
            this.fVn.fVf = System.currentTimeMillis();
        }
    }
}
