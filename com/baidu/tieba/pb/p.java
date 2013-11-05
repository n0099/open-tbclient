package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2144a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ImagePbActivity imagePbActivity) {
        this.f2144a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        af afVar;
        af afVar2;
        this.f2144a.i();
        afVar = this.f2144a.v;
        if (afVar != null) {
            afVar2 = this.f2144a.v;
            afVar2.cancel();
        }
    }
}
