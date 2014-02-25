package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        bk bkVar;
        bk bkVar2;
        this.a.DeinitWaitingDialog();
        bkVar = this.a.r;
        if (bkVar != null) {
            bkVar2 = this.a.r;
            bkVar2.cancel();
        }
    }
}
