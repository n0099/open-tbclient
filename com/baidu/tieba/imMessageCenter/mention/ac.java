package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements NoNetworkView.a {
    final /* synthetic */ z dzD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.dzD = zVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        for (int i = 0; i < 3; i++) {
            com.baidu.tbadk.mvc.f.a.a mE = this.dzD.mE(i);
            if (mE != null) {
                mE.bS(z);
            }
        }
    }
}
