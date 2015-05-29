package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity cCh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(VcodeActivity vcodeActivity) {
        this.cCh = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ah ahVar;
        ah ahVar2;
        this.cCh.destroyWaitingDialog();
        ahVar = this.cCh.cCf;
        if (ahVar != null) {
            ahVar2 = this.cCh.cCf;
            ahVar2.cancel();
        }
    }
}
