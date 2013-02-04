package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class x implements DialogInterface.OnCancelListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
