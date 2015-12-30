package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity cgO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(InviteFriendListActivity inviteFriendListActivity) {
        this.cgO = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        y yVar;
        y yVar2;
        yVar = this.cgO.cgI;
        if (yVar != null) {
            yVar2 = this.cgO.cgI;
            yVar2.cancelLoadData();
        }
    }
}
