package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f2713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VcodeActivity vcodeActivity) {
        this.f2713a = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        s sVar;
        s sVar2;
        this.f2713a.DeinitWaitingDialog();
        sVar = this.f2713a.h;
        if (sVar != null) {
            sVar2 = this.f2713a.h;
            sVar2.cancel();
        }
    }
}
