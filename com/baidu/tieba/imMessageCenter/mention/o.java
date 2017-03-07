package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements NoNetworkView.a {
    final /* synthetic */ l dme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.dme = lVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        this.dme.gr(z);
    }
}
