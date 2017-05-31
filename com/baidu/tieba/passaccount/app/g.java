package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ f efn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.efn = fVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.efn.efm;
        loginActivity.destroyWaitingDialog();
    }
}
