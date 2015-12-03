package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class bd implements q.a {
    final /* synthetic */ ax cLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ax axVar) {
        this.cLg = axVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity anL;
        bg bgVar;
        boolean z2;
        PersonFriendActivity anL2;
        int i;
        int i2;
        anL = this.cLg.anL();
        if (anL != null) {
            this.cLg.pageNum = 0;
            this.cLg.cLb = true;
            bgVar = this.cLg.cKX;
            z2 = this.cLg.mIsHost;
            anL2 = this.cLg.anL();
            String uid = anL2.getUid();
            i = this.cLg.pageNum;
            i2 = this.cLg.cLd;
            bgVar.a(z2, uid, i, i2);
        }
    }
}
