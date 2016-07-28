package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements DialogInterface.OnCancelListener {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(ew ewVar) {
        this.eiu = ewVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.eiu.ehO;
        if (runnable == null) {
            this.eiu.ehO = new fp(this);
        }
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        runnable2 = this.eiu.ehO;
        dL.postDelayed(runnable2, 150L);
    }
}
