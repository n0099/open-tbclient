package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l implements Runnable {
    final /* synthetic */ k dfk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dfk = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dfk.dfj;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dfk.dfj;
            inviteFriendListActivity2.finish();
        }
    }
}
