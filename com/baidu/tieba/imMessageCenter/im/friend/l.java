package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k dfd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dfd = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dfd.dfc;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dfd.dfc;
            inviteFriendListActivity2.finish();
        }
    }
}
