package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ad implements NoNetworkView.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        bf bfVar;
        bf bfVar2;
        com.baidu.tbadk.f.f fVar;
        bf bfVar3;
        com.baidu.tbadk.f.h hVar;
        if (z) {
            bfVar = this.this$0.dvN;
            if (bfVar != null) {
                bfVar2 = this.this$0.dvN;
                if (!bfVar2.getIsSelf()) {
                    fVar = this.this$0.cFK;
                    if (fVar == null) {
                        hVar = this.this$0.refreshView;
                        if (hVar == null) {
                            return;
                        }
                    }
                    bfVar3 = this.this$0.dvN;
                    bfVar3.aDk();
                }
            }
        }
    }
}
