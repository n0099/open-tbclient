package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnCancelListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ae aeVar;
        ae aeVar2;
        this.a.DeinitWaitingDialog();
        aeVar = this.a.u;
        if (aeVar != null) {
            aeVar2 = this.a.u;
            aeVar2.cancel();
        }
    }
}
