package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb fkf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.fkf = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.fkf.mShareDialog != null) {
            this.fkf.mShareDialog = null;
        }
    }
}
