package com.baidu.tieba.kn.shake;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeActivity f1280a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ShakeActivity shakeActivity) {
        this.f1280a = shakeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        k kVar;
        if (i == -2) {
            kVar = this.f1280a.j;
            kVar.i();
            return;
        }
        this.f1280a.k();
    }
}
