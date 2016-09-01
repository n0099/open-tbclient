package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k dqK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dqK = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dqK.dqJ;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dqK.dqJ;
            inviteFriendListActivity2.finish();
        }
    }
}
