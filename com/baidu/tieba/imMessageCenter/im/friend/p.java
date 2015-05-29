package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity bvA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(InviteFriendListActivity inviteFriendListActivity) {
        this.bvA = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ac acVar;
        ac acVar2;
        acVar = this.bvA.bvu;
        if (acVar != null) {
            acVar2 = this.bvA.bvu;
            acVar2.cancelLoadData();
        }
    }
}
