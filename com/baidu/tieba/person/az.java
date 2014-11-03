package com.baidu.tieba.person;
/* loaded from: classes.dex */
class az implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ at bCN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(at atVar) {
        this.bCN = atVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        PersonFriendActivity aab;
        bd bdVar;
        boolean z2;
        PersonFriendActivity aab2;
        int i;
        int i2;
        aab = this.bCN.aab();
        if (aab != null) {
            this.bCN.pageNum = 0;
            this.bCN.bCI = true;
            bdVar = this.bCN.bCE;
            z2 = this.bCN.mIsHost;
            aab2 = this.bCN.aab();
            String uid = aab2.getUid();
            i = this.bCN.pageNum;
            i2 = this.bCN.bCK;
            bdVar.a(z2, uid, i, i2);
        }
    }
}
