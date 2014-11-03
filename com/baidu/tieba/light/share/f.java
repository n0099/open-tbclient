package com.baidu.tieba.light.share;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ LightappGameShare blY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LightappGameShare lightappGameShare) {
        this.blY = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.blY.aIl;
        if (dVar != null) {
            dVar2 = this.blY.aIl;
            dVar2.dismiss();
        }
    }
}
