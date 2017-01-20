package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements NoNetworkView.a {
    final /* synthetic */ au dky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(au auVar) {
        this.dky = auVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        this.dky.gA(z);
    }
}
