package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ InviteFriendListActivity dsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(InviteFriendListActivity inviteFriendListActivity) {
        this.dsz = inviteFriendListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        y yVar;
        y yVar2;
        yVar = this.dsz.dst;
        if (yVar != null) {
            yVar2 = this.dsz.dst;
            yVar2.cancelLoadData();
        }
    }
}
