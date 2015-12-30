package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class ab implements NoNetworkView.a {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(d dVar) {
        this.cWV = dVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        bb bbVar;
        bb bbVar2;
        com.baidu.tbadk.f.f fVar;
        bb bbVar3;
        com.baidu.tbadk.f.h hVar;
        if (z) {
            bbVar = this.cWV.cRx;
            if (bbVar != null) {
                bbVar2 = this.cWV.cRx;
                if (!bbVar2.getIsSelf()) {
                    fVar = this.cWV.cWx;
                    if (fVar == null) {
                        hVar = this.cWV.refreshView;
                        if (hVar == null) {
                            return;
                        }
                    }
                    bbVar3 = this.cWV.cRx;
                    bbVar3.aqu();
                }
            }
        }
    }
}
