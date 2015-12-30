package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class aa implements NoNetworkView.a {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        boolean z2;
        cf cfVar;
        z2 = this.cFS.cFa;
        if (!z2 && z) {
            cfVar = this.cFS.cFl;
            if (cfVar.alR()) {
                return;
            }
            this.cFS.alw();
        }
    }
}
