package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo implements DialogInterface.OnCancelListener {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(dz dzVar) {
        this.cSw = dzVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.cSw.cRU;
        if (runnable == null) {
            this.cSw.cRU = new ep(this);
        }
        com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
        runnable2 = this.cSw.cRU;
        hr.postDelayed(runnable2, 150L);
    }
}
