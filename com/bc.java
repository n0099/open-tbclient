package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb fIO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.fIO = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.fIO.mShareDialog != null) {
            this.fIO.mShareDialog = null;
        }
    }
}
