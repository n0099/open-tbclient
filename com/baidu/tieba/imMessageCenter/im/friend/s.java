package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p bKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.bKt = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.bKt.bKq;
        if (view2 != null) {
            view3 = this.bKt.bKq;
            if (view3.getVisibility() == 0) {
                this.bKt.YK();
                return;
            }
        }
        inviteFriendListActivity = this.bKt.bKg;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.bKt.bEI;
        com.baidu.adp.lib.util.k.c(pageActivity, editText);
        inviteFriendListActivity2 = this.bKt.bKg;
        inviteFriendListActivity2.finish();
    }
}
