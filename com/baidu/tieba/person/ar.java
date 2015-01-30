package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ar implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ al bHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(al alVar) {
        this.bHX = alVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity aaX;
        av avVar;
        boolean z2;
        PersonFriendActivity aaX2;
        int i;
        int i2;
        aaX = this.bHX.aaX();
        if (aaX != null) {
            this.bHX.pageNum = 0;
            this.bHX.bHT = true;
            avVar = this.bHX.bHP;
            z2 = this.bHX.mIsHost;
            aaX2 = this.bHX.aaX();
            String uid = aaX2.getUid();
            i = this.bHX.pageNum;
            i2 = this.bHX.resNum;
            avVar.a(z2, uid, i, i2);
        }
    }
}
