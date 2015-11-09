package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb dxU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.dxU = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dxU.mShareDialog != null) {
            this.dxU.mShareDialog = null;
        }
    }
}
