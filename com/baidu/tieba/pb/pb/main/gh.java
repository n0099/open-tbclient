package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gh implements DialogInterface.OnCancelListener {
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gh(fm fmVar) {
        this.epr = fmVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.epr.eoL;
        if (runnable == null) {
            this.epr.eoL = new gi(this);
        }
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable2 = this.epr.eoL;
        fS.postDelayed(runnable2, 150L);
    }
}
