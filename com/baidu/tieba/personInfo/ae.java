package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ae implements NoNetworkView.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aF(boolean z) {
        bg bgVar;
        bg bgVar2;
        com.baidu.tbadk.f.f fVar;
        bg bgVar3;
        com.baidu.tbadk.f.h hVar;
        if (z) {
            bgVar = this.this$0.dyP;
            if (bgVar != null) {
                bgVar2 = this.this$0.dyP;
                if (!bgVar2.getIsSelf()) {
                    fVar = this.this$0.cFC;
                    if (fVar == null) {
                        hVar = this.this$0.refreshView;
                        if (hVar == null) {
                            return;
                        }
                    }
                    bgVar3 = this.this$0.dyP;
                    bgVar3.aDF();
                }
            }
        }
    }
}
