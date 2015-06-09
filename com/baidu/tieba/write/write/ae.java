package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity cCi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(VcodeActivity vcodeActivity) {
        this.cCi = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ah ahVar;
        ah ahVar2;
        this.cCi.destroyWaitingDialog();
        ahVar = this.cCi.cCg;
        if (ahVar != null) {
            ahVar2 = this.cCi.cCg;
            ahVar2.cancel();
        }
    }
}
