package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class q implements DialogInterface.OnCancelListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        af afVar;
        af afVar2;
        this.a.DeinitWaitingDialog();
        afVar = this.a.u;
        if (afVar != null) {
            afVar2 = this.a.u;
            afVar2.cancel();
        }
    }
}
