package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ao implements NoNetworkView.a {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        boolean z2;
        dj djVar;
        z2 = this.evL.euz;
        if (!z2 && z) {
            djVar = this.evL.euf;
            if (!djVar.aQt()) {
                this.evL.VB();
            }
        }
        this.evL.setNetRefreshViewEmotionDefMarginTop();
    }
}
