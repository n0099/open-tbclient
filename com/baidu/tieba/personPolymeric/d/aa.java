package com.baidu.tieba.personPolymeric.d;

import com.baidu.tieba.person.listview.BdPersonListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements BdPersonListView.a {
    final /* synthetic */ x eLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.eLR = xVar;
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void kj() {
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        if (com.baidu.adp.lib.util.i.gm()) {
            aVar = this.eLR.fYt;
            aVar.resetData();
            aVar2 = this.eLR.fYt;
            aVar2.RL();
            ((t) this.eLR.fYr).kh();
            return;
        }
        ((t) this.eLR.fYr).afo();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void ki() {
        ((t) this.eLR.fYr).afo();
    }

    @Override // com.baidu.tieba.person.listview.BdPersonListView.a
    public void G(float f) {
        ((t) this.eLR.fYr).F(f);
    }
}
