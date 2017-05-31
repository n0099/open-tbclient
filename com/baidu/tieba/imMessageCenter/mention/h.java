package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements NoNetworkView.a {
    final /* synthetic */ g dmg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dmg = gVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        this.dmg.gp(z);
    }
}
