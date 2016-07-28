package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb gbQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.gbQ = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.gbQ.mShareDialog != null) {
            this.gbQ.mShareDialog = null;
        }
    }
}
