package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.glP.glt;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.glP.getPageContext().getPageActivity(), this.glP.getCurrentFocus());
            this.glP.glu = System.currentTimeMillis();
        }
    }
}
