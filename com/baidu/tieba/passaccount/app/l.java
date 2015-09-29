package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class l implements DialogInterface.OnCancelListener {
    final /* synthetic */ k cdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cdd = kVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.cdd.cdc;
        loginActivity.destroyWaitingDialog();
    }
}
