package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class y implements NoNetworkView.a {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        boolean z2;
        cc ccVar;
        z2 = this.cCm.cBv;
        if (!z2 && z) {
            ccVar = this.cCm.cBG;
            if (ccVar.akK()) {
                return;
            }
            this.cCm.akp();
        }
    }
}
