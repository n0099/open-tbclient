package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class n implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1990a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f1990a = mVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1990a.f1989a.DeinitWaitingDialog();
    }
}
