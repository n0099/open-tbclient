package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity cgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(VcodeActivity vcodeActivity) {
        this.cgl = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ab abVar;
        ab abVar2;
        this.cgl.destroyWaitingDialog();
        abVar = this.cgl.cgj;
        if (abVar != null) {
            abVar2 = this.cgl.cgj;
            abVar2.cancel();
        }
    }
}
