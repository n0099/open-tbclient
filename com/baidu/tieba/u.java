package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.this$0.aHD.dismiss();
        this.this$0.mHandler.postDelayed(new v(this), 100L);
    }
}
