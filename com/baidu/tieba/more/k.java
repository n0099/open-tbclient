package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class k implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f2095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f2095a = jVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f2095a.f2094a.DeinitWaitingDialog();
    }
}
