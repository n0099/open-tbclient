package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ao aoVar;
        ao aoVar2;
        this.a.DeinitWaitingDialog();
        aoVar = this.a.g;
        if (aoVar != null) {
            aoVar2 = this.a.g;
            aoVar2.cancel();
        }
    }
}
