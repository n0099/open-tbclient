package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ap implements com.baidu.tbadk.core.view.ae {
    final /* synthetic */ aj bQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(aj ajVar) {
        this.bQe = ajVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        PersonFriendActivity adb;
        at atVar;
        boolean z2;
        PersonFriendActivity adb2;
        int i;
        int i2;
        adb = this.bQe.adb();
        if (adb != null) {
            this.bQe.pageNum = 0;
            this.bQe.bQa = true;
            atVar = this.bQe.bPW;
            z2 = this.bQe.mIsHost;
            adb2 = this.bQe.adb();
            String uid = adb2.getUid();
            i = this.bQe.pageNum;
            i2 = this.bQe.resNum;
            atVar.a(z2, uid, i, i2);
        }
    }
}
