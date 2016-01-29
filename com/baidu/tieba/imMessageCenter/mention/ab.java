package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements NoNetworkView.a {
    final /* synthetic */ z cnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.cnc = zVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        com.baidu.tbadk.mvc.f.a.a jS = this.cnc.jS(this.cnc.getCurrentTabIndex());
        if (jS != null) {
            jS.bA(z);
        }
    }
}
