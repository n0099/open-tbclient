package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.x;
/* loaded from: classes.dex */
class bb implements x.a {
    final /* synthetic */ av cjG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(av avVar) {
        this.cjG = avVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity agq;
        be beVar;
        boolean z2;
        PersonFriendActivity agq2;
        int i;
        int i2;
        agq = this.cjG.agq();
        if (agq != null) {
            this.cjG.pageNum = 0;
            this.cjG.cjB = true;
            beVar = this.cjG.cjx;
            z2 = this.cjG.mIsHost;
            agq2 = this.cjG.agq();
            String uid = agq2.getUid();
            i = this.cjG.pageNum;
            i2 = this.cjG.cjD;
            beVar.a(z2, uid, i, i2);
        }
    }
}
