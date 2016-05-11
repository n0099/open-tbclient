package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k cwQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cwQ = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.cwQ.cwP;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.cwQ.cwP;
            inviteFriendListActivity2.finish();
        }
    }
}
