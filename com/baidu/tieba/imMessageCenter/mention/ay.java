package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ay implements NoNetworkView.a {
    final /* synthetic */ av dni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(av avVar) {
        this.dni = avVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        this.dni.gp(z);
    }
}
