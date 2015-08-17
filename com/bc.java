package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb daF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.daF = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.daF.mShareDialog != null) {
            this.daF.mShareDialog = null;
        }
    }
}
