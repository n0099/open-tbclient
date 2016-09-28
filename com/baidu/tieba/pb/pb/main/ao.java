package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ao implements NoNetworkView.a {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aH(boolean z) {
        boolean z2;
        dh dhVar;
        z2 = this.eqa.eoP;
        if (!z2 && z) {
            dhVar = this.eqa.eov;
            if (!dhVar.aOA()) {
                this.eqa.Uz();
            }
        }
        this.eqa.setNetRefreshViewEmotionDefMarginTop();
    }
}
