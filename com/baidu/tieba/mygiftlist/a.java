package com.baidu.tieba.mygiftlist;

import com.baidu.tbadk.core.view.u;
/* loaded from: classes.dex */
class a implements u {
    final /* synthetic */ MyGiftListActivity bsZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MyGiftListActivity myGiftListActivity) {
        this.bsZ = myGiftListActivity;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        j jVar;
        j jVar2;
        if (z) {
            jVar = this.bsZ.bsT;
            jVar.dR(false);
            jVar2 = this.bsZ.bsT;
            jVar2.LoadData();
        }
    }
}
