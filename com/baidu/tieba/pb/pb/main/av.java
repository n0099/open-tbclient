package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class av implements NoNetworkView.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        boolean z2;
        PbModel pbModel;
        z2 = this.ewh.euy;
        if (!z2 && z) {
            pbModel = this.ewh.eue;
            if (!pbModel.aOP()) {
                this.ewh.US();
            }
        }
        this.ewh.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.ewh.getApplicationContext(), w.f.ds200));
    }
}
