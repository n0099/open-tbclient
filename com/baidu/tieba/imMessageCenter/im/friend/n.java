package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity bNp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(InviteFriendListActivity inviteFriendListActivity) {
        this.bNp = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        y yVar;
        y yVar2;
        yVar = this.bNp.bNj;
        if (yVar != null) {
            yVar2 = this.bNp.bNj;
            yVar2.cancelLoadData();
        }
    }
}
