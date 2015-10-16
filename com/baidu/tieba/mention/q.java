package com.baidu.tieba.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements NoNetworkView.a {
    final /* synthetic */ n caz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.caz = nVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        com.baidu.tbadk.mvc.f.a.a iu = this.caz.iu(this.caz.getCurrentTabIndex());
        if (iu != null) {
            iu.bn(z);
        }
    }
}
