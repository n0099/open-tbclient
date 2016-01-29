package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k clp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.clp = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.clp.clo;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.clp.clo;
            inviteFriendListActivity2.finish();
        }
    }
}
