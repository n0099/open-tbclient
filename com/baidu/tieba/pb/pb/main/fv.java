package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fv implements DialogInterface.OnCancelListener {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fv(fa faVar) {
        this.etn = faVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.etn.esC;
        if (runnable == null) {
            this.etn.esC = new fw(this);
        }
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable2 = this.etn.esC;
        fM.postDelayed(runnable2, 150L);
    }
}
