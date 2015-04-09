package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity cxP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(VcodeActivity vcodeActivity) {
        this.cxP = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ag agVar;
        ag agVar2;
        this.cxP.destroyWaitingDialog();
        agVar = this.cxP.cxN;
        if (agVar != null) {
            agVar2 = this.cxP.cxN;
            agVar2.cancel();
        }
    }
}
