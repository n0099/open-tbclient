package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class an implements NoNetworkView.a {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aG(boolean z) {
        boolean z2;
        dh dhVar;
        z2 = this.ebT.eaM;
        if (!z2 && z) {
            dhVar = this.ebT.eas;
            if (!dhVar.aJb()) {
                this.ebT.Pu();
            }
        }
        this.ebT.setNetRefreshViewEmotionDefMarginTop();
    }
}
