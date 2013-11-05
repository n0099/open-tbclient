package com.baidu.tieba.kn.shake;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeActivity f1810a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ShakeActivity shakeActivity) {
        this.f1810a = shakeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        k kVar;
        if (i == -2) {
            kVar = this.f1810a.j;
            kVar.i();
            return;
        }
        this.f1810a.e();
    }
}
