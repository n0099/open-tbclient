package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class l implements DialogInterface.OnCancelListener {
    final /* synthetic */ k cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cwn = kVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.cwn.cwm;
        loginActivity.destroyWaitingDialog();
    }
}
