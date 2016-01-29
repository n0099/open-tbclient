package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb eEf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.eEf = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.eEf.mShareDialog != null) {
            this.eEf.mShareDialog = null;
        }
    }
}
