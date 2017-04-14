package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ft implements DialogInterface.OnCancelListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.erv.eqL;
        if (runnable == null) {
            this.erv.eqL = new fu(this);
        }
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable2 = this.erv.eqL;
        fR.postDelayed(runnable2, 150L);
    }
}
