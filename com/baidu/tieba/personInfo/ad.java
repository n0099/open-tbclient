package com.baidu.tieba.personInfo;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements BdPersonListView.a {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(d dVar) {
        this.cWV = dVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void mS() {
        be beVar;
        bb bbVar;
        be beVar2;
        boolean z;
        be beVar3;
        if (!com.baidu.adp.lib.util.i.iQ()) {
            beVar = this.cWV.cWi;
            beVar.hideProgress();
            return;
        }
        bbVar = this.cWV.cRx;
        bbVar.aqu();
        beVar2 = this.cWV.cWi;
        if (beVar2.aqO() != null) {
            beVar3 = this.cWV.cWi;
            beVar3.aqO().mQ();
        }
        z = this.cWV.mIsHost;
        if (z) {
            return;
        }
        this.cWV.apP();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void mR() {
        be beVar;
        be beVar2;
        beVar = this.cWV.cWi;
        if (beVar.aqO() != null) {
            beVar2 = this.cWV.cWi;
            beVar2.aqO().hideProgress();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void k(float f) {
        be beVar;
        be beVar2;
        beVar = this.cWV.cWi;
        if (beVar.aqO() != null) {
            beVar2 = this.cWV.cWi;
            beVar2.aqO().j(f);
        }
    }
}
