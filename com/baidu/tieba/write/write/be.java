package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.fMl.fLS;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.fMl.getPageContext().getPageActivity(), this.fMl.getCurrentFocus());
            this.fMl.fLT = System.currentTimeMillis();
        }
    }
}
