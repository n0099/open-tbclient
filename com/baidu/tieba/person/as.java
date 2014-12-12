package com.baidu.tieba.person;
/* loaded from: classes.dex */
class as implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ am bGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(am amVar) {
        this.bGm = amVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity aas;
        aw awVar;
        boolean z2;
        PersonFriendActivity aas2;
        int i;
        int i2;
        aas = this.bGm.aas();
        if (aas != null) {
            this.bGm.pageNum = 0;
            this.bGm.bGi = true;
            awVar = this.bGm.bGe;
            z2 = this.bGm.mIsHost;
            aas2 = this.bGm.aas();
            String uid = aas2.getUid();
            i = this.bGm.pageNum;
            i2 = this.bGm.resNum;
            awVar.a(z2, uid, i, i2);
        }
    }
}
