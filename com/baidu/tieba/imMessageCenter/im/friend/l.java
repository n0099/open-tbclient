package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k cvT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cvT = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.cvT.cvS;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.cvT.cvS;
            inviteFriendListActivity2.finish();
        }
    }
}
