package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.ghD.ghs;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.ghD.getPageContext().getPageActivity(), this.ghD.getCurrentFocus());
            this.ghD.ght = System.currentTimeMillis();
        }
    }
}
