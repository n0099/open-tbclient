package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb dwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.dwb = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dwb.mShareDialog != null) {
            this.dwb.mShareDialog = null;
        }
    }
}
