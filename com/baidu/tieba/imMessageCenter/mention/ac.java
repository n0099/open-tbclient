package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements NoNetworkView.a {
    final /* synthetic */ z ddZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.ddZ = zVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aD(boolean z) {
        for (int i = 0; i < 3; i++) {
            com.baidu.tbadk.mvc.f.a.a lF = this.ddZ.lF(i);
            if (lF != null) {
                lF.bK(z);
            }
        }
    }
}
