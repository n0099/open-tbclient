package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p dcA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.dcA = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.dcA.dcw;
        if (view2 != null) {
            view3 = this.dcA.dcw;
            if (view3.getVisibility() == 0) {
                this.dcA.asX();
                return;
            }
        }
        inviteFriendListActivity = this.dcA.dcm;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.dcA.cWP;
        com.baidu.adp.lib.util.k.a(pageActivity, editText);
        inviteFriendListActivity2 = this.dcA.dcm;
        inviteFriendListActivity2.finish();
    }
}
