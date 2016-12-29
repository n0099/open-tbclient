package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements NoNetworkView.a {
    final /* synthetic */ bb ddm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bb bbVar) {
        this.ddm = bbVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        this.ddm.gx(z);
    }
}
