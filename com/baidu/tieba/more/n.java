package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class n implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f2097a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f2097a = mVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f2097a.f2096a.DeinitWaitingDialog();
    }
}
