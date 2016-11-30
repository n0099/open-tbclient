package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class m implements DialogInterface.OnCancelListener {
    final /* synthetic */ l eoN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.eoN = lVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.eoN.eoM;
        loginActivity.destroyWaitingDialog();
    }
}
