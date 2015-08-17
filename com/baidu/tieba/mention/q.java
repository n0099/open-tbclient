package com.baidu.tieba.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements NoNetworkView.a {
    final /* synthetic */ n bVW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.bVW = nVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        com.baidu.tbadk.mvc.f.a.a ib = this.bVW.ib(this.bVW.getCurrentTabIndex());
        if (ib != null) {
            ib.bi(z);
        }
    }
}
