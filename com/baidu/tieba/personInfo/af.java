package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class af implements NoNetworkView.a {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(h hVar) {
        this.this$0 = hVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aG(boolean z) {
        bn bnVar;
        bn bnVar2;
        com.baidu.tbadk.g.f fVar;
        bn bnVar3;
        com.baidu.tbadk.g.h hVar;
        if (z) {
            bnVar = this.this$0.ers;
            if (bnVar != null) {
                bnVar2 = this.this$0.ers;
                if (!bnVar2.getIsSelf()) {
                    fVar = this.this$0.cqy;
                    if (fVar == null) {
                        hVar = this.this$0.refreshView;
                        if (hVar == null) {
                            return;
                        }
                    }
                    bnVar3 = this.this$0.ers;
                    bnVar3.aPI();
                }
            }
        }
    }
}
