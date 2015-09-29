package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class bc implements p.a {
    final /* synthetic */ aw cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(aw awVar) {
        this.cqf = awVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity aiG;
        bf bfVar;
        boolean z2;
        PersonFriendActivity aiG2;
        int i;
        int i2;
        aiG = this.cqf.aiG();
        if (aiG != null) {
            this.cqf.pageNum = 0;
            this.cqf.cqa = true;
            bfVar = this.cqf.cpW;
            z2 = this.cqf.mIsHost;
            aiG2 = this.cqf.aiG();
            String uid = aiG2.getUid();
            i = this.cqf.pageNum;
            i2 = this.cqf.cqc;
            bfVar.a(z2, uid, i, i2);
        }
    }
}
