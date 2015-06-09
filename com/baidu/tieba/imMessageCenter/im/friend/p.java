package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity bvB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(InviteFriendListActivity inviteFriendListActivity) {
        this.bvB = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ac acVar;
        ac acVar2;
        acVar = this.bvB.bvv;
        if (acVar != null) {
            acVar2 = this.bvB.bvv;
            acVar2.cancelLoadData();
        }
    }
}
