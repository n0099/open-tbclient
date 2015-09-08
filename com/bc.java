package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb djG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.djG = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.djG.mShareDialog != null) {
            this.djG.mShareDialog = null;
        }
    }
}
