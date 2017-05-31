package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class as implements NoNetworkView.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        boolean z2;
        PbModel pbModel;
        z2 = this.enc.ely;
        if (!z2 && z) {
            pbModel = this.enc.ele;
            if (!pbModel.aKS()) {
                this.enc.Tq();
            }
        }
        this.enc.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.enc.getApplicationContext(), w.f.ds200));
    }
}
