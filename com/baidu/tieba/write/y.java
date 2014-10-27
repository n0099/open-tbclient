package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity bTr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(VcodeActivity vcodeActivity) {
        this.bTr = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ab abVar;
        ab abVar2;
        this.bTr.destroyWaitingDialog();
        abVar = this.bTr.bTp;
        if (abVar != null) {
            abVar2 = this.bTr.bTp;
            abVar2.cancel();
        }
    }
}
