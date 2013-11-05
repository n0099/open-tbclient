package com.baidu.tieba.kn.shake;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class e implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeActivity f1811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ShakeActivity shakeActivity) {
        this.f1811a = shakeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        i iVar;
        i iVar2;
        iVar = this.f1811a.g;
        if (iVar.b()) {
            iVar2 = this.f1811a.g;
            if (!iVar2.c()) {
                this.f1811a.c();
            }
        }
    }
}
