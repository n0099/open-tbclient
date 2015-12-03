package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements NoNetworkView.a {
    final /* synthetic */ y ceA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.ceA = yVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        com.baidu.tbadk.mvc.f.a.a iW = this.ceA.iW(this.ceA.getCurrentTabIndex());
        if (iW != null) {
            iW.by(z);
        }
    }
}
