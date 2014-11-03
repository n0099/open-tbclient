package com.baidu.tieba.mygiftlist;

import com.baidu.tbadk.core.view.u;
/* loaded from: classes.dex */
class a implements u {
    final /* synthetic */ MyGiftListActivity bto;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MyGiftListActivity myGiftListActivity) {
        this.bto = myGiftListActivity;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        j jVar;
        j jVar2;
        if (z) {
            jVar = this.bto.bth;
            jVar.dR(false);
            jVar2 = this.bto.bth;
            jVar2.LoadData();
        }
    }
}
