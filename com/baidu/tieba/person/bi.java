package com.baidu.tieba.person;
/* loaded from: classes.dex */
class bi implements com.baidu.tbadk.core.view.aj {
    final /* synthetic */ bc bSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bc bcVar) {
        this.bSZ = bcVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity aey;
        bm bmVar;
        boolean z2;
        PersonFriendActivity aey2;
        int i;
        int i2;
        aey = this.bSZ.aey();
        if (aey != null) {
            this.bSZ.pageNum = 0;
            this.bSZ.bSV = true;
            bmVar = this.bSZ.bSR;
            z2 = this.bSZ.mIsHost;
            aey2 = this.bSZ.aey();
            String uid = aey2.getUid();
            i = this.bSZ.pageNum;
            i2 = this.bSZ.resNum;
            bmVar.a(z2, uid, i, i2);
        }
    }
}
