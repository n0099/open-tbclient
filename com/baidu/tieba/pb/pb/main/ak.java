package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ak implements NoNetworkView.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aF(boolean z) {
        boolean z2;
        cw cwVar;
        z2 = this.djE.diA;
        if (!z2 && z) {
            cwVar = this.djE.dih;
            if (!cwVar.axG()) {
                this.djE.amA();
            }
        }
        this.djE.setNetRefreshViewEmotionDefMarginTop();
    }
}
