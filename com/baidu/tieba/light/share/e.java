package com.baidu.tieba.light.share;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ LightappGameShare bqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LightappGameShare lightappGameShare) {
        this.bqN = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.bqN.aIX;
        if (dVar != null) {
            dVar2 = this.bqN.aIX;
            dVar2.dismiss();
        }
    }
}
