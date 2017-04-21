package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class an implements NoNetworkView.a {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        boolean z2;
        PbModel pbModel;
        z2 = this.emk.ekQ;
        if (!z2 && z) {
            pbModel = this.emk.ekv;
            if (!pbModel.aMJ()) {
                this.emk.axq();
            }
        }
        this.emk.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.emk.getApplicationContext(), w.f.ds200));
    }
}
