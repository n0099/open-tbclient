package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class an implements NoNetworkView.a {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        boolean z2;
        PbModel pbModel;
        z2 = this.ejU.eiA;
        if (!z2 && z) {
            pbModel = this.ejU.eif;
            if (!pbModel.aLI()) {
                this.ejU.awp();
            }
        }
        this.ejU.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.ejU.getApplicationContext(), w.f.ds200));
    }
}
