package com.baidu.tieba.light.share;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ LightappGameShare byr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LightappGameShare lightappGameShare) {
        this.byr = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.byr.aQg;
        if (dVar != null) {
            dVar2 = this.byr.aQg;
            dVar2.dismiss();
        }
    }
}
