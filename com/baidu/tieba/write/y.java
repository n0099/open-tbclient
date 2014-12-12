package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity ceN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(VcodeActivity vcodeActivity) {
        this.ceN = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ab abVar;
        ab abVar2;
        this.ceN.destroyWaitingDialog();
        abVar = this.ceN.ceL;
        if (abVar != null) {
            abVar2 = this.ceN.ceL;
            abVar2.cancel();
        }
    }
}
