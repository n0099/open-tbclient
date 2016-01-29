package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ad implements NoNetworkView.a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        boolean z2;
        cm cmVar;
        z2 = this.cNq.cMt;
        if (!z2 && z) {
            cmVar = this.cNq.cMF;
            if (cmVar.apU()) {
                return;
            }
            this.cNq.aiX();
        }
    }
}
