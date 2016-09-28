package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p dsB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.dsB = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.dsB.dsx;
        if (view2 != null) {
            view3 = this.dsB.dsx;
            if (view3.getVisibility() == 0) {
                this.dsB.ayV();
                return;
            }
        }
        inviteFriendListActivity = this.dsB.dso;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.dsB.dmQ;
        com.baidu.adp.lib.util.k.b(pageActivity, editText);
        inviteFriendListActivity2 = this.dsB.dso;
        inviteFriendListActivity2.finish();
    }
}
