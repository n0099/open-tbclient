package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.s;
/* loaded from: classes.dex */
class bd implements s.a {
    final /* synthetic */ ax dtv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ax axVar) {
        this.dtv = axVar;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        PersonFriendActivity aBv;
        bg bgVar;
        boolean z2;
        PersonFriendActivity aBv2;
        int i;
        int i2;
        aBv = this.dtv.aBv();
        if (aBv != null) {
            this.dtv.pageNum = 0;
            this.dtv.dtq = true;
            bgVar = this.dtv.dtm;
            z2 = this.dtv.bIP;
            aBv2 = this.dtv.aBv();
            String uid = aBv2.getUid();
            i = this.dtv.pageNum;
            i2 = this.dtv.dts;
            bgVar.a(z2, uid, i, i2);
        }
    }
}
