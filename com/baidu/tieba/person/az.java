package com.baidu.tieba.person;
/* loaded from: classes.dex */
class az implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ at bCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(at atVar) {
        this.bCz = atVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        PersonFriendActivity ZZ;
        bd bdVar;
        boolean z2;
        PersonFriendActivity ZZ2;
        int i;
        int i2;
        ZZ = this.bCz.ZZ();
        if (ZZ != null) {
            this.bCz.pageNum = 0;
            this.bCz.bCu = true;
            bdVar = this.bCz.bCq;
            z2 = this.bCz.mIsHost;
            ZZ2 = this.bCz.ZZ();
            String uid = ZZ2.getUid();
            i = this.bCz.pageNum;
            i2 = this.bCz.bCw;
            bdVar.a(z2, uid, i, i2);
        }
    }
}
