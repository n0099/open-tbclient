package com.baidu.tieba.write.shareSDK;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.cAt.destroyWaitingDialog();
        this.cAt.asx();
    }
}
