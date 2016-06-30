package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb fQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.fQd = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.fQd.mShareDialog != null) {
            this.fQd.mShareDialog = null;
        }
    }
}
