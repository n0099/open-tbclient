package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o implements NoNetworkView.a {
    final /* synthetic */ l dmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.dmu = lVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        this.dmu.gp(z);
    }
}
