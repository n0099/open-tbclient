package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k dlh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dlh = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dlh.dlg;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dlh.dlg;
            inviteFriendListActivity2.finish();
        }
    }
}
