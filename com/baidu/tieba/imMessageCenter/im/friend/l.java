package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k bNf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bNf = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bNf.bNe;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bNf.bNe;
            inviteFriendListActivity2.finish();
        }
    }
}
