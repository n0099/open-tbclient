package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class u implements NoNetworkView.a {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        boolean z2;
        bk bkVar;
        z2 = this.cbo.caA;
        if (!z2 && z) {
            bkVar = this.cbo.caL;
            if (bkVar.adC()) {
                return;
            }
            this.cbo.adm();
        }
    }
}
