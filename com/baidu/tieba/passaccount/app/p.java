package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class p implements DialogInterface.OnCancelListener {
    final /* synthetic */ o eon;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.eon = oVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        QALoginActivity qALoginActivity;
        qALoginActivity = this.eon.eom;
        qALoginActivity.destroyWaitingDialog();
    }
}
