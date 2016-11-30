package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ft implements DialogInterface.OnCancelListener {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(ey eyVar) {
        this.eCT = eyVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.eCT.eCk;
        if (runnable == null) {
            this.eCT.eCk = new fu(this);
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable2 = this.eCT.eCk;
        eG.postDelayed(runnable2, 150L);
    }
}
