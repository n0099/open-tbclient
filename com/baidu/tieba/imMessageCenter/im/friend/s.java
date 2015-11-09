package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p bOe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.bOe = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.bOe.bOb;
        if (view2 != null) {
            view3 = this.bOe.bOb;
            if (view3.getVisibility() == 0) {
                this.bOe.ZJ();
                return;
            }
        }
        inviteFriendListActivity = this.bOe.bNR;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.bOe.bIr;
        com.baidu.adp.lib.util.k.c(pageActivity, editText);
        inviteFriendListActivity2 = this.bOe.bNR;
        inviteFriendListActivity2.finish();
    }
}
