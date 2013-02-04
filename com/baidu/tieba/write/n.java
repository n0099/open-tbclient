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
        this.a.b();
        sVar = this.a.h;
        if (sVar != null) {
            sVar2 = this.a.h;
            sVar2.a();
        }
    }
}
