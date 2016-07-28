package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements NoNetworkView.a {
    final /* synthetic */ z dgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.dgV = zVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aG(boolean z) {
        for (int i = 0; i < 3; i++) {
            com.baidu.tbadk.mvc.f.a.a lL = this.dgV.lL(i);
            if (lL != null) {
                lL.bN(z);
            }
        }
    }
}
