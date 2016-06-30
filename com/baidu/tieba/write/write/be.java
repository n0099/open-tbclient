package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.fJw.fJn;
        if (z) {
            com.baidu.adp.lib.util.k.a(this.fJw.getPageContext().getPageActivity(), this.fJw.getCurrentFocus());
            this.fJw.fJo = System.currentTimeMillis();
        }
    }
}
