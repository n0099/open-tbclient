package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements NoNetworkView.a {
    final /* synthetic */ z dsB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.dsB = zVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aH(boolean z) {
        for (int i = 0; i < 3; i++) {
            com.baidu.tbadk.mvc.f.a.a mo = this.dsB.mo(i);
            if (mo != null) {
                mo.bP(z);
            }
        }
    }
}
