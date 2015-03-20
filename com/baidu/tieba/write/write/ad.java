package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity cxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(VcodeActivity vcodeActivity) {
        this.cxw = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ag agVar;
        ag agVar2;
        this.cxw.destroyWaitingDialog();
        agVar = this.cxw.cxu;
        if (agVar != null) {
            agVar2 = this.cxw.cxu;
            agVar2.cancel();
        }
    }
}
