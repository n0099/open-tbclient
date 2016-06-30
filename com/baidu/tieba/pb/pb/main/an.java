package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class an implements NoNetworkView.a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aD(boolean z) {
        boolean z2;
        dg dgVar;
        z2 = this.dPF.dOz;
        if (!z2 && z) {
            dgVar = this.dPF.dOf;
            if (!dgVar.aFQ()) {
                this.dPF.OQ();
            }
        }
        this.dPF.setNetRefreshViewEmotionDefMarginTop();
    }
}
