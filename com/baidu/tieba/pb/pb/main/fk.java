package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fk implements DialogInterface.OnCancelListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(es esVar) {
        this.dVR = esVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.dVR.dVn;
        if (runnable == null) {
            this.dVR.dVn = new fl(this);
        }
        com.baidu.adp.lib.h.h dM = com.baidu.adp.lib.h.h.dM();
        runnable2 = this.dVR.dVn;
        dM.postDelayed(runnable2, 150L);
    }
}
