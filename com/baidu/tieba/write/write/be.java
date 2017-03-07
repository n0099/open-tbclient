package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.fQG.fQn;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.fQG.getPageContext().getPageActivity(), this.fQG.getCurrentFocus());
            this.fQG.fQo = System.currentTimeMillis();
        }
    }
}
