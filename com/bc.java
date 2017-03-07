package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnDismissListener {
    final /* synthetic */ bb gnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.gnw = bbVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.gnw.mShareDialog != null) {
            this.gnw.mShareDialog = null;
        }
    }
}
