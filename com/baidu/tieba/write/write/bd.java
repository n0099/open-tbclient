package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.dsa.destroyWaitingDialog();
        this.dsa.aCN();
    }
}
