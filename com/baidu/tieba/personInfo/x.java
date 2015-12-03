package com.baidu.tieba.personInfo;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdPersonListView.a {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(d dVar) {
        this.cSn = dVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void nu() {
        az azVar;
        aw awVar;
        az azVar2;
        boolean z;
        az azVar3;
        if (!com.baidu.adp.lib.util.i.iP()) {
            azVar = this.cSn.cRH;
            azVar.hideProgress();
            return;
        }
        awVar = this.cSn.cMT;
        awVar.aph();
        azVar2 = this.cSn.cRH;
        if (azVar2.apz() != null) {
            azVar3 = this.cSn.cRH;
            azVar3.apz().ns();
        }
        z = this.cSn.mIsHost;
        if (z) {
            return;
        }
        this.cSn.aoF();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void nt() {
        az azVar;
        az azVar2;
        azVar = this.cSn.cRH;
        if (azVar.apz() != null) {
            azVar2 = this.cSn.cRH;
            azVar2.apz().hideProgress();
        }
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void k(float f) {
        az azVar;
        az azVar2;
        azVar = this.cSn.cRH;
        if (azVar.apz() != null) {
            azVar2 = this.cSn.cRH;
            azVar2.apz().j(f);
        }
    }
}
