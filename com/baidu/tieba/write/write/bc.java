package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.feb.destroyWaitingDialog();
        this.feb.bcb();
    }
}
