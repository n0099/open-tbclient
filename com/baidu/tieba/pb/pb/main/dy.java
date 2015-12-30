package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dy implements DialogInterface.OnCancelListener {
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(dk dkVar) {
        this.cKg = dkVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.cKg.cJP;
        if (runnable == null) {
            this.cKg.cJP = new dz(this);
        }
        com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
        runnable2 = this.cKg.cJP;
        hj.postDelayed(runnable2, 150L);
    }
}
