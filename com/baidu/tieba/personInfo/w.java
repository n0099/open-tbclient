package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class w implements NoNetworkView.a {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(d dVar) {
        this.cSn = dVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        aw awVar;
        aw awVar2;
        com.baidu.tbadk.f.f fVar;
        aw awVar3;
        com.baidu.tbadk.f.h hVar;
        if (z) {
            awVar = this.cSn.cMT;
            if (awVar != null) {
                awVar2 = this.cSn.cMT;
                if (!awVar2.getIsSelf()) {
                    fVar = this.cSn.cRU;
                    if (fVar == null) {
                        hVar = this.cSn.refreshView;
                        if (hVar == null) {
                            return;
                        }
                    }
                    awVar3 = this.cSn.cMT;
                    awVar3.aph();
                }
            }
        }
    }
}
