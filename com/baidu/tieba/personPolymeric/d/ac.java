package com.baidu.tieba.personPolymeric.d;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements BdPersonListView.a {
    final /* synthetic */ z eJo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.eJo = zVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void kZ() {
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        if (com.baidu.adp.lib.util.i.he()) {
            aVar = this.eJo.fIc;
            aVar.resetData();
            aVar2 = this.eJo.fIc;
            aVar2.NE();
            ((t) this.eJo.fIa).kX();
            return;
        }
        ((t) this.eJo.fIa).ady();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void kY() {
        ((t) this.eJo.fIa).ady();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void G(float f) {
        ((t) this.eJo.fIa).F(f);
    }
}
