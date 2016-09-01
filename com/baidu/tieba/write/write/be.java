package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.gfs.gfj;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.gfs.getPageContext().getPageActivity(), this.gfs.getCurrentFocus());
            this.gfs.gfk = System.currentTimeMillis();
        }
    }
}
