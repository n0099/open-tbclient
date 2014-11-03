package com.baidu.tieba.mygiftlist;

import com.baidu.adp.widget.ListView.aa;
/* loaded from: classes.dex */
class d implements aa {
    final /* synthetic */ MyGiftListActivity bto;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MyGiftListActivity myGiftListActivity) {
        this.bto = myGiftListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        j jVar;
        k kVar;
        j jVar2;
        j jVar3;
        k kVar2;
        jVar = this.bto.bth;
        if (jVar.isHasMore()) {
            jVar2 = this.bto.bth;
            jVar2.dR(true);
            jVar3 = this.bto.bth;
            jVar3.LoadData();
            kVar2 = this.bto.bti;
            kVar2.VM().setVisibility(0);
            return;
        }
        kVar = this.bto.bti;
        kVar.VM().setVisibility(8);
    }
}
