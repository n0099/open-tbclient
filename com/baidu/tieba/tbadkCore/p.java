package com.baidu.tieba.tbadkCore;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ FrsOfficalBanner cpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsOfficalBanner frsOfficalBanner) {
        this.cpc = frsOfficalBanner;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.cpc.afa;
        if (bVar != null) {
            bVar2 = this.cpc.afa;
            bVar2.xK();
        }
    }
}
