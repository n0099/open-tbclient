package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements NoNetworkView.a {
    final /* synthetic */ l dmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.dmU = lVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        this.dmU.gB(z);
    }
}
