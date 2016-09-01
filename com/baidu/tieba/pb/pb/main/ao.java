package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ao implements NoNetworkView.a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aH(boolean z) {
        boolean z2;
        dh dhVar;
        z2 = this.eob.emR;
        if (!z2 && z) {
            dhVar = this.eob.emx;
            if (!dhVar.aNS()) {
                this.eob.Ug();
            }
        }
        this.eob.setNetRefreshViewEmotionDefMarginTop();
    }
}
