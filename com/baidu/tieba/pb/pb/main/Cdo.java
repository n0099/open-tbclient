package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements DialogInterface.OnCancelListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(da daVar) {
        this.cGh = daVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.cGh.cFQ;
        if (runnable == null) {
            this.cGh.cFQ = new dp(this);
        }
        com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
        runnable2 = this.cGh.cFQ;
        hj.postDelayed(runnable2, 150L);
    }
}
