package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k bNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bNq = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bNq.bNp;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bNq.bNp;
            inviteFriendListActivity2.finish();
        }
    }
}
