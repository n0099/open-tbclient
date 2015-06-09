package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m bvC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bvC = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bvC.bvB;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bvC.bvB;
            inviteFriendListActivity2.finish();
        }
    }
}
