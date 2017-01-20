package com.baidu.tieba.passaccount.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class v implements DialogInterface.OnCancelListener {
    final /* synthetic */ u ecs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.ecs = uVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        QALoginActivity qALoginActivity;
        qALoginActivity = this.ecs.ecr;
        qALoginActivity.destroyWaitingDialog();
    }
}
