package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity dkq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(InviteFriendListActivity inviteFriendListActivity) {
        this.dkq = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        y yVar;
        y yVar2;
        yVar = this.dkq.dkk;
        if (yVar != null) {
            yVar2 = this.dkq.dkk;
            yVar2.cancelLoadData();
        }
    }
}
