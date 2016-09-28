package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class w implements DialogInterface.OnCancelListener {
    final /* synthetic */ v eiU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.eiU = vVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        QALoginActivity qALoginActivity;
        qALoginActivity = this.eiU.eiT;
        qALoginActivity.destroyWaitingDialog();
    }
}
