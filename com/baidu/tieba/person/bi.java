package com.baidu.tieba.person;
/* loaded from: classes.dex */
class bi implements com.baidu.tbadk.core.view.aj {
    final /* synthetic */ bc bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bc bcVar) {
        this.bTa = bcVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity aez;
        bm bmVar;
        boolean z2;
        PersonFriendActivity aez2;
        int i;
        int i2;
        aez = this.bTa.aez();
        if (aez != null) {
            this.bTa.pageNum = 0;
            this.bTa.bSW = true;
            bmVar = this.bTa.bSS;
            z2 = this.bTa.mIsHost;
            aez2 = this.bTa.aez();
            String uid = aez2.getUid();
            i = this.bTa.pageNum;
            i2 = this.bTa.resNum;
            bmVar.a(z2, uid, i, i2);
        }
    }
}
