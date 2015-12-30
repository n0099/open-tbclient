package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class bd implements r.a {
    final /* synthetic */ ax cPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ax axVar) {
        this.cPw = axVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity aoW;
        bg bgVar;
        boolean z2;
        PersonFriendActivity aoW2;
        int i;
        int i2;
        aoW = this.cPw.aoW();
        if (aoW != null) {
            this.cPw.pageNum = 0;
            this.cPw.cPr = true;
            bgVar = this.cPw.cPn;
            z2 = this.cPw.mIsHost;
            aoW2 = this.cPw.aoW();
            String uid = aoW2.getUid();
            i = this.cPw.pageNum;
            i2 = this.cPw.cPt;
            bgVar.a(z2, uid, i, i2);
        }
    }
}
