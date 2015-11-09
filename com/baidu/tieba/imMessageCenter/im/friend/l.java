package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k bNL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bNL = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.bNL.bNK;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.bNL.bNK;
            inviteFriendListActivity2.finish();
        }
    }
}
