package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity bTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(VcodeActivity vcodeActivity) {
        this.bTG = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ab abVar;
        ab abVar2;
        this.bTG.destroyWaitingDialog();
        abVar = this.bTG.bTE;
        if (abVar != null) {
            abVar2 = this.bTG.bTE;
            abVar2.cancel();
        }
    }
}
