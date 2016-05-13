package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.fea.fdT;
        if (z) {
            com.baidu.adp.lib.util.k.a(this.fea.getPageContext().getPageActivity(), this.fea.getCurrentFocus());
            this.fea.fdU = System.currentTimeMillis();
        }
    }
}
