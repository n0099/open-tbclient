package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb fRh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.fRh = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.fRh.mShareDialog != null) {
            this.fRh.mShareDialog = null;
        }
    }
}
