package com.baidu.tieba.tbadkCore;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ FrsOfficalBanner bUs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsOfficalBanner frsOfficalBanner) {
        this.bUs = frsOfficalBanner;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.bUs.TP;
        if (bVar != null) {
            bVar2 = this.bUs.TP;
            bVar2.tE();
        }
    }
}
