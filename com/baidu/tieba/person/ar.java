package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ar implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ al bHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(al alVar) {
        this.bHW = alVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity aaS;
        av avVar;
        boolean z2;
        PersonFriendActivity aaS2;
        int i;
        int i2;
        aaS = this.bHW.aaS();
        if (aaS != null) {
            this.bHW.pageNum = 0;
            this.bHW.bHS = true;
            avVar = this.bHW.bHO;
            z2 = this.bHW.mIsHost;
            aaS2 = this.bHW.aaS();
            String uid = aaS2.getUid();
            i = this.bHW.pageNum;
            i2 = this.bHW.resNum;
            avVar.a(z2, uid, i, i2);
        }
    }
}
