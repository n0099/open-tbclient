package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class y implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
