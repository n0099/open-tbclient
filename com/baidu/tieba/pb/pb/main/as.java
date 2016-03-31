package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class as implements NoNetworkView.a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        boolean z2;
        df dfVar;
        z2 = this.dht.dgn;
        if (!z2 && z) {
            dfVar = this.dht.dfV;
            if (dfVar.axj()) {
                return;
            }
            this.dht.amr();
        }
    }
}
