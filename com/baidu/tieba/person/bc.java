package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class bc implements p.a {
    final /* synthetic */ aw crM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(aw awVar) {
        this.crM = awVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity aji;
        bf bfVar;
        boolean z2;
        PersonFriendActivity aji2;
        int i;
        int i2;
        aji = this.crM.aji();
        if (aji != null) {
            this.crM.pageNum = 0;
            this.crM.crH = true;
            bfVar = this.crM.crD;
            z2 = this.crM.mIsHost;
            aji2 = this.crM.aji();
            String uid = aji2.getUid();
            i = this.crM.pageNum;
            i2 = this.crM.crJ;
            bfVar.a(z2, uid, i, i2);
        }
    }
}
