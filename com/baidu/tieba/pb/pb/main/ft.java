package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ft implements DialogInterface.OnCancelListener {
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(ey eyVar) {
        this.etN = eyVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.etN.etd;
        if (runnable == null) {
            this.etN.etd = new fu(this);
        }
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable2 = this.etN.etd;
        fS.postDelayed(runnable2, 150L);
    }
}
