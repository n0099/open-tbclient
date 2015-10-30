package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class bc implements p.a {
    final /* synthetic */ aw cqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(aw awVar) {
        this.cqq = awVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity aiC;
        bf bfVar;
        boolean z2;
        PersonFriendActivity aiC2;
        int i;
        int i2;
        aiC = this.cqq.aiC();
        if (aiC != null) {
            this.cqq.pageNum = 0;
            this.cqq.cql = true;
            bfVar = this.cqq.cqh;
            z2 = this.cqq.mIsHost;
            aiC2 = this.cqq.aiC();
            String uid = aiC2.getUid();
            i = this.cqq.pageNum;
            i2 = this.cqq.cqn;
            bfVar.a(z2, uid, i, i2);
        }
    }
}
