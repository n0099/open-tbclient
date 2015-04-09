package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(InviteFriendListActivity inviteFriendListActivity) {
        this.bsP = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ac acVar;
        ac acVar2;
        acVar = this.bsP.bsJ;
        if (acVar != null) {
            acVar2 = this.bsP.bsJ;
            acVar2.cancelLoadData();
        }
    }
}
