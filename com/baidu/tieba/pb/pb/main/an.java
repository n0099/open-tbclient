package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class an implements NoNetworkView.a {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        boolean z2;
        PbModel pbModel;
        z2 = this.elO.eku;
        if (!z2 && z) {
            pbModel = this.elO.ejZ;
            if (!pbModel.aLz()) {
                this.elO.aww();
            }
        }
        this.elO.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.elO.getApplicationContext(), w.f.ds200));
    }
}
