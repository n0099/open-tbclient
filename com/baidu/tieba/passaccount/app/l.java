package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class l implements DialogInterface.OnCancelListener {
    final /* synthetic */ k cZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cZF = kVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.cZF.cZE;
        loginActivity.destroyWaitingDialog();
    }
}
