package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class m implements DialogInterface.OnCancelListener {
    final /* synthetic */ l dTu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.dTu = lVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.dTu.dTt;
        loginActivity.destroyWaitingDialog();
    }
}
