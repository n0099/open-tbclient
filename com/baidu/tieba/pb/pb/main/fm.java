package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fm implements DialogInterface.OnCancelListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(eu euVar) {
        this.dnc = euVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Runnable runnable;
        Runnable runnable2;
        runnable = this.dnc.dmv;
        if (runnable == null) {
            this.dnc.dmv = new fn(this);
        }
        com.baidu.adp.lib.h.h hx = com.baidu.adp.lib.h.h.hx();
        runnable2 = this.dnc.dmv;
        hx.postDelayed(runnable2, 150L);
    }
}
