package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class m implements DialogInterface.OnCancelListener {
    final /* synthetic */ l dUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.dUP = lVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.dUP.dUO;
        loginActivity.destroyWaitingDialog();
    }
}
