package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class k implements DialogInterface.OnCancelListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.a.a;
        accountActivity.DeinitWaitingDialog();
    }
}
