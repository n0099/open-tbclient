package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class bd implements r.a {
    final /* synthetic */ ax cYT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ax axVar) {
        this.cYT = axVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        PersonFriendActivity atP;
        bg bgVar;
        boolean z2;
        PersonFriendActivity atP2;
        int i;
        int i2;
        atP = this.cYT.atP();
        if (atP != null) {
            this.cYT.pageNum = 0;
            this.cYT.cYO = true;
            bgVar = this.cYT.cYK;
            z2 = this.cYT.bDs;
            atP2 = this.cYT.atP();
            String uid = atP2.getUid();
            i = this.cYT.pageNum;
            i2 = this.cYT.cYQ;
            bgVar.a(z2, uid, i, i2);
        }
    }
}
