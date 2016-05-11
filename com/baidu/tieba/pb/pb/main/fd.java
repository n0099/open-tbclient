package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fd implements DialogInterface.OnCancelListener {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(el elVar) {
        this.dpu = elVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.dpu.doO;
        if (runnable == null) {
            this.dpu.doO = new fe(this);
        }
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        runnable2 = this.dpu.doO;
        dL.postDelayed(runnable2, 150L);
    }
}
