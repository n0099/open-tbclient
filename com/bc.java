package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb glW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.glW = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.glW.mShareDialog != null) {
            this.glW.mShareDialog = null;
        }
    }
}
