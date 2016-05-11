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
        PersonFriendActivity aBR;
        bh bhVar;
        boolean z2;
        PersonFriendActivity aBR2;
        int i;
        int i2;
        aBR = this.dwQ.aBR();
        if (aBR != null) {
            this.dwQ.pageNum = 0;
            this.dwQ.dwL = true;
            bhVar = this.dwQ.dwI;
            z2 = this.dwQ.bIW;
            aBR2 = this.dwQ.aBR();
            String uid = aBR2.getUid();
            i = this.dwQ.pageNum;
            i2 = this.dwQ.dwN;
            bhVar.a(z2, uid, i, i2);
        }
    }
}
