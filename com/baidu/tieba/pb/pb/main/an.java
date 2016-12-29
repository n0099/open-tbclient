package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class an implements NoNetworkView.a {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        boolean z2;
        dc dcVar;
        z2 = this.eah.dYU;
        if (!z2 && z) {
            dcVar = this.eah.dYA;
            if (!dcVar.aKq()) {
                this.eah.avT();
            }
        }
        this.eah.setNetRefreshViewEmotionDefMarginTop();
    }
}
