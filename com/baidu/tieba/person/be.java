package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class be implements t.b {
    final /* synthetic */ ay dwQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ay ayVar) {
        this.dwQ = ayVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aG(boolean z) {
        PersonFriendActivity aBU;
        bh bhVar;
        boolean z2;
        PersonFriendActivity aBU2;
        int i;
        int i2;
        aBU = this.dwQ.aBU();
        if (aBU != null) {
            this.dwQ.pageNum = 0;
            this.dwQ.dwL = true;
            bhVar = this.dwQ.dwI;
            z2 = this.dwQ.bIW;
            aBU2 = this.dwQ.aBU();
            String uid = aBU2.getUid();
            i = this.dwQ.pageNum;
            i2 = this.dwQ.dwN;
            bhVar.a(z2, uid, i, i2);
        }
    }
}
