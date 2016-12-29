package com.baidu.tieba.personPolymeric.d;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements BdPersonListView.a {
    final /* synthetic */ x evO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.evO = xVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void kj() {
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        if (com.baidu.adp.lib.util.i.gm()) {
            aVar = this.evO.fuG;
            aVar.resetData();
            aVar2 = this.evO.fuG;
            aVar2.Tj();
            ((t) this.evO.fuE).kh();
            return;
        }
        ((t) this.evO.fuE).abt();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void ki() {
        ((t) this.evO.fuE).abt();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void G(float f) {
        ((t) this.evO.fuE).F(f);
    }
}
