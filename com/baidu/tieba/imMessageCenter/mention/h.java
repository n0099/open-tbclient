package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements NoNetworkView.a {
    final /* synthetic */ g dgK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dgK = gVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        this.dgK.gc(z);
    }
}
