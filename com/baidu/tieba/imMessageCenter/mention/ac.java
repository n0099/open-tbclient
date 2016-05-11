package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements NoNetworkView.a {
    final /* synthetic */ z cyD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.cyD = zVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aF(boolean z) {
        for (int i = 0; i < 3; i++) {
            com.baidu.tbadk.mvc.f.a.a ke = this.cyD.ke(i);
            if (ke != null) {
                ke.bL(z);
            }
        }
    }
}
