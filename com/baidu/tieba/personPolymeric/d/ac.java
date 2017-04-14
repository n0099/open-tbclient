package com.baidu.tieba.personPolymeric.d;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements BdPersonListView.a {
    final /* synthetic */ z eHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.eHj = zVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void ld() {
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        if (com.baidu.adp.lib.util.i.hj()) {
            aVar = this.eHj.fJL;
            aVar.resetData();
            aVar2 = this.eHj.fJL;
            aVar2.Oc();
            ((t) this.eHj.fJJ).lb();
            return;
        }
        ((t) this.eHj.fJJ).ads();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void lc() {
        ((t) this.eHj.fJJ).ads();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void G(float f) {
        ((t) this.eHj.fJJ).F(f);
    }
}
