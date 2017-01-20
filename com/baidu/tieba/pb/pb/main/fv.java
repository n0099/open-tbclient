package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fv implements DialogInterface.OnCancelListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fv(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.eqf.epw;
        if (runnable == null) {
            this.eqf.epw = new fw(this);
        }
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable2 = this.eqf.epw;
        eE.postDelayed(runnable2, 150L);
    }
}
