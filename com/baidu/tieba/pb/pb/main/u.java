package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class u implements NoNetworkView.a {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        boolean z2;
        bl blVar;
        z2 = this.ciz.chK;
        if (!z2 && z) {
            blVar = this.ciz.chV;
            if (blVar.afQ()) {
                return;
            }
            this.ciz.afx();
        }
    }
}
