package com.baidu.tieba.imMessageCenter.im.friend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ k dxN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dxN = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        inviteFriendListActivity = this.dxN.dxM;
        if (!inviteFriendListActivity.isFinishing()) {
            inviteFriendListActivity2 = this.dxN.dxM;
            inviteFriendListActivity2.finish();
        }
    }
}
