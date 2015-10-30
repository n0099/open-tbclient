package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb dwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.dwc = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dwc.mShareDialog != null) {
            this.dwc.mShareDialog = null;
        }
    }
}
