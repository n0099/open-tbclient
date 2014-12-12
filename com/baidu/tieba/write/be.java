package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.cft.destroyWaitingDialog();
        this.cft.acy();
    }
}
