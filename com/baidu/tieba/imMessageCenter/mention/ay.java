package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ay implements NoNetworkView.a {
    final /* synthetic */ av dhM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(av avVar) {
        this.dhM = avVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        this.dhM.gc(z);
    }
}
