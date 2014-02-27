package com.baidu.tieba.write;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ax implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        bj bjVar;
        bj bjVar2;
        this.a.DeinitWaitingDialog();
        bjVar = this.a.r;
        if (bjVar != null) {
            bjVar2 = this.a.r;
            bjVar2.cancel();
        }
    }
}
