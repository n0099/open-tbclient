package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1578a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ImagePbActivity imagePbActivity) {
        this.f1578a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        af afVar;
        af afVar2;
        this.f1578a.g();
        afVar = this.f1578a.v;
        if (afVar != null) {
            afVar2 = this.f1578a.v;
            afVar2.cancel();
        }
    }
}
