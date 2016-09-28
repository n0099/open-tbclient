package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fp implements DialogInterface.OnCancelListener {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(ex exVar) {
        this.ewH = exVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.ewH.ewd;
        if (runnable == null) {
            this.ewH.ewd = new fq(this);
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable2 = this.ewH.ewd;
        eG.postDelayed(runnable2, 150L);
    }
}
