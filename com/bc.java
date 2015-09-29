package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb dvB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.dvB = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dvB.mShareDialog != null) {
            this.dvB.mShareDialog = null;
        }
    }
}
