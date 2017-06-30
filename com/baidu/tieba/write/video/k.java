package com.baidu.tieba.write.video;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class k implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteVideoActivity gir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteVideoActivity writeVideoActivity) {
        this.gir = writeVideoActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.gir.destroyWaitingDialog();
        this.gir.bik();
    }
}
