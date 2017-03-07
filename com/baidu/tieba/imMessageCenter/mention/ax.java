package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements NoNetworkView.a {
    final /* synthetic */ au dmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(au auVar) {
        this.dmR = auVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        this.dmR.gr(z);
    }
}
