package com.baidu.tieba.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements NoNetworkView.a {
    final /* synthetic */ n cao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.cao = nVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        com.baidu.tbadk.mvc.f.a.a iu = this.cao.iu(this.cao.getCurrentTabIndex());
        if (iu != null) {
            iu.bn(z);
        }
    }
}
