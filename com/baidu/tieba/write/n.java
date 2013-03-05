package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        s sVar;
        s sVar2;
        this.a.c();
        sVar = this.a.i;
        if (sVar != null) {
            sVar2 = this.a.i;
            sVar2.a();
        }
    }
}
