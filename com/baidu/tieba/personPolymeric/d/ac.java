package com.baidu.tieba.personPolymeric.d;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements BdPersonListView.a {
    final /* synthetic */ z eFM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.eFM = zVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void kf() {
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        if (com.baidu.adp.lib.util.i.gk()) {
            aVar = this.eFM.fDB;
            aVar.resetData();
            aVar2 = this.eFM.fDB;
            aVar2.MR();
            ((t) this.eFM.fDz).kd();
            return;
        }
        ((t) this.eFM.fDz).acA();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void ke() {
        ((t) this.eFM.fDz).acA();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void G(float f) {
        ((t) this.eFM.fDz).F(f);
    }
}
