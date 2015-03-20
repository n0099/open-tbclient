package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity bsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(InviteFriendListActivity inviteFriendListActivity) {
        this.bsz = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ac acVar;
        ac acVar2;
        acVar = this.bsz.bst;
        if (acVar != null) {
            acVar2 = this.bsz.bst;
            acVar2.cancelLoadData();
        }
    }
}
