package com.baidu.tieba.pb.image;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        w wVar;
        w wVar2;
        this.a.DeinitWaitingDialog();
        wVar = this.a.u;
        if (wVar != null) {
            wVar2 = this.a.u;
            wVar2.cancel();
        }
    }
}
