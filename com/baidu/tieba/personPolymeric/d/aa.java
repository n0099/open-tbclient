package com.baidu.tieba.personPolymeric.d;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements BdPersonListView.a {
    final /* synthetic */ x eSp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.eSp = xVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void kj() {
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        if (com.baidu.adp.lib.util.i.gm()) {
            aVar = this.eSp.gfO;
            aVar.resetData();
            aVar2 = this.eSp.gfO;
            aVar2.SN();
            ((t) this.eSp.gfM).kh();
            return;
        }
        ((t) this.eSp.gfM).agY();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void ki() {
        ((t) this.eSp.gfM).agY();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void G(float f) {
        ((t) this.eSp.gfM).F(f);
    }
}
