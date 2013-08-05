package com.baidu.tieba.kn.shake;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class d implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeActivity f1250a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ShakeActivity shakeActivity) {
        this.f1250a = shakeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        i iVar;
        i iVar2;
        iVar = this.f1250a.g;
        if (iVar.b()) {
            iVar2 = this.f1250a.g;
            if (!iVar2.c()) {
                this.f1250a.c();
            }
        }
    }
}
