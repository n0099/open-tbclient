package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements NoNetworkView.a {
    final /* synthetic */ au dlq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(au auVar) {
        this.dlq = auVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        this.dlq.gr(z);
    }
}
