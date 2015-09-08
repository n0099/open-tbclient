package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.x;
/* loaded from: classes.dex */
class bb implements x.a {
    final /* synthetic */ av ckB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(av avVar) {
        this.ckB = avVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity agG;
        be beVar;
        boolean z2;
        PersonFriendActivity agG2;
        int i;
        int i2;
        agG = this.ckB.agG();
        if (agG != null) {
            this.ckB.pageNum = 0;
            this.ckB.ckw = true;
            beVar = this.ckB.cks;
            z2 = this.ckB.mIsHost;
            agG2 = this.ckB.agG();
            String uid = agG2.getUid();
            i = this.ckB.pageNum;
            i2 = this.ckB.cky;
            beVar.a(z2, uid, i, i2);
        }
    }
}
