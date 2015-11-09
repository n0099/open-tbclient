package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class x implements NoNetworkView.a {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        boolean z2;
        ca caVar;
        z2 = this.cjN.ciY;
        if (!z2 && z) {
            caVar = this.cjN.cjj;
            if (caVar.agr()) {
                return;
            }
            this.cjN.afX();
        }
    }
}
