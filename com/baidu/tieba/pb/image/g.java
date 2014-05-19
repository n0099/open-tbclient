package com.baidu.tieba.pb.image;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        v vVar;
        v vVar2;
        this.a.DeinitWaitingDialog();
        vVar = this.a.t;
        if (vVar != null) {
            vVar2 = this.a.t;
            vVar2.cancel();
        }
    }
}
