package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ao implements NoNetworkView.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        boolean z2;
        PbModel pbModel;
        z2 = this.ehy.efZ;
        if (!z2 && z) {
            pbModel = this.ehy.efE;
            if (!pbModel.aJY()) {
                this.ehy.aum();
            }
        }
        this.ehy.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.ehy.getApplicationContext(), w.f.ds200));
    }
}
