package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.a.a;
        accountActivity.DeinitWaitingDialog();
    }
}
