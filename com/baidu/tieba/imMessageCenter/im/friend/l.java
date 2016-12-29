package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k daM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.daM = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.daM.daL;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.daM.daL;
            inviteFriendListActivity2.finish();
        }
    }
}
