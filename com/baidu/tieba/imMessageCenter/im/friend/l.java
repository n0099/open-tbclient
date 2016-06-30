package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k dcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dcf = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dcf.dce;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dcf.dce;
            inviteFriendListActivity2.finish();
        }
    }
}
