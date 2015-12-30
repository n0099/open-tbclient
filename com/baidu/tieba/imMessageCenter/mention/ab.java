package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements NoNetworkView.a {
    final /* synthetic */ z ciC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.ciC = zVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        com.baidu.tbadk.mvc.f.a.a jv = this.ciC.jv(this.ciC.getCurrentTabIndex());
        if (jv != null) {
            jv.by(z);
        }
    }
}
