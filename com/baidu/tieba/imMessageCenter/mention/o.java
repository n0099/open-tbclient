package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements NoNetworkView.a {
    final /* synthetic */ l djK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.djK = lVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        this.djK.gA(z);
    }
}
