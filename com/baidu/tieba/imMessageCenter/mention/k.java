package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements NoNetworkView.a {
    final /* synthetic */ j dck;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dck = jVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        this.dck.gx(z);
    }
}
