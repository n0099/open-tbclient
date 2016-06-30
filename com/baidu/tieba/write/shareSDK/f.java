package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.fFg.destroyWaitingDialog();
        this.fFg.bkD();
    }
}
