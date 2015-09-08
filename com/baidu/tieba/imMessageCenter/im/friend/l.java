package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k bKa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bKa = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bKa.bJZ;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bKa.bJZ;
            inviteFriendListActivity2.finish();
        }
    }
}
