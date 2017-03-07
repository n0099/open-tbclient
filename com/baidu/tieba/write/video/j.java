package com.baidu.tieba.write.video;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class j implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteVideoActivity fNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteVideoActivity writeVideoActivity) {
        this.fNq = writeVideoActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.fNq.destroyWaitingDialog();
        this.fNq.bdk();
    }
}
