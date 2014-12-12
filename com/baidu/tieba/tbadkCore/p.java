package com.baidu.tieba.tbadkCore;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ FrsOfficalBanner bSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsOfficalBanner frsOfficalBanner) {
        this.bSz = frsOfficalBanner;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.bSz.Tl;
        if (bVar != null) {
            bVar2 = this.bSz.Tl;
            bVar2.tn();
        }
    }
}
