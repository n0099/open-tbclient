package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.a.a.DeinitWaitingDialog();
    }
}
