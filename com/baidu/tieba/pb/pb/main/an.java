package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class an implements NoNetworkView.a {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        boolean z2;
        PbModel pbModel;
        z2 = this.eiV.ehC;
        if (!z2 && z) {
            pbModel = this.eiV.ehh;
            if (!pbModel.aMd()) {
                this.eiV.axa();
            }
        }
        this.eiV.setNetRefreshViewEmotionDefMarginTop();
    }
}
