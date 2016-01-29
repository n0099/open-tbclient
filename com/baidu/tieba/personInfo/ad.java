package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ad implements NoNetworkView.a {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(f fVar) {
        this.diG = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        bf bfVar;
        bf bfVar2;
        com.baidu.tbadk.f.f fVar;
        bf bfVar3;
        com.baidu.tbadk.f.h hVar;
        if (z) {
            bfVar = this.diG.dbl;
            if (bfVar != null) {
                bfVar2 = this.diG.dbl;
                if (!bfVar2.getIsSelf()) {
                    fVar = this.diG.dig;
                    if (fVar == null) {
                        hVar = this.diG.refreshView;
                        if (hVar == null) {
                            return;
                        }
                    }
                    bfVar3 = this.diG.dbl;
                    bfVar3.avF();
                }
            }
        }
    }
}
