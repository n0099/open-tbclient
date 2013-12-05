package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2277a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImagePbActivity imagePbActivity) {
        this.f2277a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ae aeVar;
        ae aeVar2;
        this.f2277a.DeinitWaitingDialog();
        aeVar = this.f2277a.u;
        if (aeVar != null) {
            aeVar2 = this.f2277a.u;
            aeVar2.cancel();
        }
    }
}
