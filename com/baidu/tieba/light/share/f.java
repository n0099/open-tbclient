package com.baidu.tieba.light.share;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnDismissListener {
    final /* synthetic */ LightappGameShare bsk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LightappGameShare lightappGameShare) {
        this.bsk = lightappGameShare;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        dVar = this.bsk.aKe;
        if (dVar != null) {
            this.bsk.aKe = null;
        }
        this.bsk.finish();
    }
}
