package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l implements Runnable {
    final /* synthetic */ k dsA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dsA = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dsA.dsz;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dsA.dsz;
            inviteFriendListActivity2.finish();
        }
    }
}
