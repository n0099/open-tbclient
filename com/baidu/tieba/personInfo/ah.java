package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ah implements NoNetworkView.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aD(boolean z) {
        bp bpVar;
        bp bpVar2;
        com.baidu.tbadk.g.f fVar;
        bp bpVar3;
        com.baidu.tbadk.g.h hVar;
        if (z) {
            bpVar = this.this$0.eht;
            if (bpVar != null) {
                bpVar2 = this.this$0.eht;
                if (!bpVar2.getIsSelf()) {
                    fVar = this.this$0.cok;
                    if (fVar == null) {
                        hVar = this.this$0.refreshView;
                        if (hVar == null) {
                            return;
                        }
                    }
                    bpVar3 = this.this$0.eht;
                    bpVar3.aMD();
                }
            }
        }
    }
}
