package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f1938a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VcodeActivity vcodeActivity) {
        this.f1938a = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        s sVar;
        s sVar2;
        this.f1938a.g();
        sVar = this.f1938a.g;
        if (sVar != null) {
            sVar2 = this.f1938a.g;
            sVar2.cancel();
        }
    }
}
