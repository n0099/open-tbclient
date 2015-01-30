package com.baidu.tieba.light.share;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ LightappGameShare bsl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LightappGameShare lightappGameShare) {
        this.bsl = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.bsl.aKh;
        if (dVar != null) {
            dVar2 = this.bsl.aKh;
            dVar2.dismiss();
        }
    }
}
