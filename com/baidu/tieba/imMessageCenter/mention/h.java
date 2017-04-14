package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements NoNetworkView.a {
    final /* synthetic */ g dkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dkp = gVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        this.dkp.gr(z);
    }
}
