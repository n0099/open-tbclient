package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k ccP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.ccP = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.ccP.ccO;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.ccP.ccO;
            inviteFriendListActivity2.finish();
        }
    }
}
