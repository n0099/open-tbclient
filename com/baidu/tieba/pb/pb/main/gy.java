package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gy implements DialogInterface.OnCancelListener {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gy(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.eEv.eDO;
        if (runnable == null) {
            this.eEv.eDO = new gz(this);
        }
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable2 = this.eEv.eDO;
        fR.postDelayed(runnable2, 150L);
    }
}
