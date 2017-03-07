package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements NoNetworkView.a {
    final /* synthetic */ g dlQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dlQ = gVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        this.dlQ.gr(z);
    }
}
