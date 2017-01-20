package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k dhZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dhZ = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dhZ.dhY;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dhZ.dhY;
            inviteFriendListActivity2.finish();
        }
    }
}
