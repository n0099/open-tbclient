package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class u implements NoNetworkView.a {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        boolean z2;
        bl blVar;
        z2 = this.ciK.chV;
        if (!z2 && z) {
            blVar = this.ciK.cih;
            if (blVar.afM()) {
                return;
            }
            this.ciK.aft();
        }
    }
}
