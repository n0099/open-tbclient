package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb eXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.eXY = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.eXY.mShareDialog != null) {
            this.eXY.mShareDialog = null;
        }
    }
}
