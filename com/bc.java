package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb dWm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.dWm = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dWm.mShareDialog != null) {
            this.dWm.mShareDialog = null;
        }
    }
}
