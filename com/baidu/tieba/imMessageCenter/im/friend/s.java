package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p cdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.cdh = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.cdh.cde;
        if (view2 != null) {
            view3 = this.cdh.cde;
            if (view3.getVisibility() == 0) {
                this.cdh.acP();
                return;
            }
        }
        inviteFriendListActivity = this.cdh.ccV;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.cdh.bXx;
        com.baidu.adp.lib.util.k.c(pageActivity, editText);
        inviteFriendListActivity2 = this.cdh.ccV;
        inviteFriendListActivity2.finish();
    }
}
