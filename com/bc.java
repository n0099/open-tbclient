package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb gvT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.gvT = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.gvT.mShareDialog != null) {
            this.gvT.mShareDialog = null;
        }
    }
}
