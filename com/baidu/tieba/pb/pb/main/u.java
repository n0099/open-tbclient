package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class u implements NoNetworkView.a {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        boolean z2;
        bk bkVar;
        z2 = this.ccj.cbv;
        if (!z2 && z) {
            bkVar = this.ccj.cbG;
            if (bkVar.adQ()) {
                return;
            }
            this.ccj.adz();
        }
    }
}
