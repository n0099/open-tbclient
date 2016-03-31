package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements NoNetworkView.a {
    final /* synthetic */ z cxE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.cxE = zVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        com.baidu.tbadk.mvc.f.a.a ky = this.cxE.ky(this.cxE.getCurrentTabIndex());
        if (ky != null) {
            ky.bF(z);
        }
    }
}
