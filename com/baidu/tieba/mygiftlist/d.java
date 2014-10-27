package com.baidu.tieba.mygiftlist;

import com.baidu.adp.widget.ListView.aa;
/* loaded from: classes.dex */
class d implements aa {
    final /* synthetic */ MyGiftListActivity bsZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MyGiftListActivity myGiftListActivity) {
        this.bsZ = myGiftListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        j jVar;
        k kVar;
        j jVar2;
        j jVar3;
        k kVar2;
        jVar = this.bsZ.bsT;
        if (jVar.isHasMore()) {
            jVar2 = this.bsZ.bsT;
            jVar2.dR(true);
            jVar3 = this.bsZ.bsT;
            jVar3.LoadData();
            kVar2 = this.bsZ.bsU;
            kVar2.VJ().setVisibility(0);
            return;
        }
        kVar = this.bsZ.bsU;
        kVar.VJ().setVisibility(8);
    }
}
