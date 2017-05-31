package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p dkY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.dkY = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.dkY.dkU;
        if (view2 != null) {
            view3 = this.dkY.dkU;
            if (view3.getVisibility() == 0) {
                this.dkY.atA();
                return;
            }
        }
        inviteFriendListActivity = this.dkY.dkL;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.dkY.dhk;
        com.baidu.adp.lib.util.k.b(pageActivity, editText);
        inviteFriendListActivity2 = this.dkY.dkL;
        inviteFriendListActivity2.finish();
    }
}
