package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k bJt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bJt = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bJt.bJs;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bJt.bJs;
            inviteFriendListActivity2.finish();
        }
    }
}
