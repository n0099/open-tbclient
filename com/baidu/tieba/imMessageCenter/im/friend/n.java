package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m bsQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bsQ = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bsQ.bsP;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bsQ.bsP;
            inviteFriendListActivity2.finish();
        }
    }
}
