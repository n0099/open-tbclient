package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb goi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.goi = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.goi.mShareDialog != null) {
            this.goi.mShareDialog = null;
        }
    }
}
