package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.cUM.destroyWaitingDialog();
        this.cUM.auo();
    }
}
