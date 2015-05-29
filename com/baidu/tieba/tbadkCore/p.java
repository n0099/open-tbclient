package com.baidu.tieba.tbadkCore;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ FrsOfficalBanner cpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsOfficalBanner frsOfficalBanner) {
        this.cpb = frsOfficalBanner;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.cpb.afa;
        if (bVar != null) {
            bVar2 = this.cpb.afa;
            bVar2.xJ();
        }
    }
}
