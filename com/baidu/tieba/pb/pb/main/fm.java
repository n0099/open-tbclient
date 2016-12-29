package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fm implements DialogInterface.OnCancelListener {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(er erVar) {
        this.egZ = erVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.egZ.egq;
        if (runnable == null) {
            this.egZ.egq = new fn(this);
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable2 = this.egZ.egq;
        eG.postDelayed(runnable2, 150L);
    }
}
