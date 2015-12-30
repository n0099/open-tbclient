package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k cgP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cgP = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.cgP.cgO;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.cgP.cgO;
            inviteFriendListActivity2.finish();
        }
    }
}
