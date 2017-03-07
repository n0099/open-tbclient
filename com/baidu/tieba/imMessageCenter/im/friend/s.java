package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p dkK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.dkK = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.dkK.dkG;
        if (view2 != null) {
            view3 = this.dkK.dkG;
            if (view3.getVisibility() == 0) {
                this.dkK.auQ();
                return;
            }
        }
        inviteFriendListActivity = this.dkK.dkx;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.dkK.dgY;
        com.baidu.adp.lib.util.k.b(pageActivity, editText);
        inviteFriendListActivity2 = this.dkK.dkx;
        inviteFriendListActivity2.finish();
    }
}
