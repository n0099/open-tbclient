package com.baidu.tieba.light.share;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnDismissListener {
    final /* synthetic */ LightappGameShare blY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LightappGameShare lightappGameShare) {
        this.blY = lightappGameShare;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        dVar = this.blY.aIl;
        if (dVar != null) {
            this.blY.aIl = null;
        }
        this.blY.finish();
    }
}
