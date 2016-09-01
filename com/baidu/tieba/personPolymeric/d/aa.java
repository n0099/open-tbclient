package com.baidu.tieba.personPolymeric.d;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements BdPersonListView.a {
    final /* synthetic */ x eJO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.eJO = xVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void kj() {
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        if (com.baidu.adp.lib.util.i.gm()) {
            aVar = this.eJO.fWo;
            aVar.resetData();
            aVar2 = this.eJO.fWo;
            aVar2.Rt();
            ((t) this.eJO.fWm).kh();
            return;
        }
        ((t) this.eJO.fWm).afa();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void ki() {
        ((t) this.eJO.fWm).afa();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void G(float f) {
        ((t) this.eJO.fWm).F(f);
    }
}
