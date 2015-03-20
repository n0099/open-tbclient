package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m bsA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bsA = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bsA.bsz;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bsA.bsz;
            inviteFriendListActivity2.finish();
        }
    }
}
