package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k dkr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dkr = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dkr.dkq;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dkr.dkq;
            inviteFriendListActivity2.finish();
        }
    }
}
