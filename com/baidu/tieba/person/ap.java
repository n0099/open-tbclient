package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ap implements com.baidu.tbadk.core.view.ae {
    final /* synthetic */ aj bQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(aj ajVar) {
        this.bQu = ajVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity adq;
        at atVar;
        boolean z2;
        PersonFriendActivity adq2;
        int i;
        int i2;
        adq = this.bQu.adq();
        if (adq != null) {
            this.bQu.pageNum = 0;
            this.bQu.bQq = true;
            atVar = this.bQu.bQm;
            z2 = this.bQu.mIsHost;
            adq2 = this.bQu.adq();
            String uid = adq2.getUid();
            i = this.bQu.pageNum;
            i2 = this.bQu.resNum;
            atVar.a(z2, uid, i, i2);
        }
    }
}
