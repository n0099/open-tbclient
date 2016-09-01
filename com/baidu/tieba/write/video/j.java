package com.baidu.tieba.write.video;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class j implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteVideoActivity gcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteVideoActivity writeVideoActivity) {
        this.gcl = writeVideoActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.gcl.destroyWaitingDialog();
        this.gcl.beR();
    }
}
