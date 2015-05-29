package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m bvB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bvB = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bvB.bvA;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bvB.bvA;
            inviteFriendListActivity2.finish();
        }
    }
}
