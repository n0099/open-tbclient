package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l implements Runnable {
    final /* synthetic */ k dkE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dkE = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dkE.dkD;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dkE.dkD;
            inviteFriendListActivity2.finish();
        }
    }
}
