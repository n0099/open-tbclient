package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p dbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.dbf = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.dbf.dbb;
        if (view2 != null) {
            view3 = this.dbf.dbb;
            if (view3.getVisibility() == 0) {
                this.dbf.auo();
                return;
            }
        }
        inviteFriendListActivity = this.dbf.daS;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.dbf.cXt;
        com.baidu.adp.lib.util.k.b(pageActivity, editText);
        inviteFriendListActivity2 = this.dbf.daS;
        inviteFriendListActivity2.finish();
    }
}
