package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb edK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.edK = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.edK.mShareDialog != null) {
            this.edK.mShareDialog = null;
        }
    }
}
