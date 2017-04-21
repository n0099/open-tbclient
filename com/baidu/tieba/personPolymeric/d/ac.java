package com.baidu.tieba.personPolymeric.d;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements BdPersonListView.a {
    final /* synthetic */ z eJz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.eJz = zVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void le() {
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        if (com.baidu.adp.lib.util.i.hk()) {
            aVar = this.eJz.fMh;
            aVar.resetData();
            aVar2 = this.eJz.fMh;
            aVar2.Ol();
            ((t) this.eJz.fMf).lc();
            return;
        }
        ((t) this.eJz.fMf).aet();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void ld() {
        ((t) this.eJz.fMf).aet();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void G(float f) {
        ((t) this.eJz.fMf).F(f);
    }
}
