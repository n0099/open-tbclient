package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k dsh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dsh = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dsh.dsg;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dsh.dsg;
            inviteFriendListActivity2.finish();
        }
    }
}
