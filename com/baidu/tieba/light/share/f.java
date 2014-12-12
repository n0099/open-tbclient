package com.baidu.tieba.light.share;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnDismissListener {
    final /* synthetic */ LightappGameShare bqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LightappGameShare lightappGameShare) {
        this.bqN = lightappGameShare;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        dVar = this.bqN.aIX;
        if (dVar != null) {
            this.bqN.aIX = null;
        }
        this.bqN.finish();
    }
}
