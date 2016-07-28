package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p dfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.dfx = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.dfx.dft;
        if (view2 != null) {
            view3 = this.dfx.dft;
            if (view3.getVisibility() == 0) {
                this.dfx.atJ();
                return;
            }
        }
        inviteFriendListActivity = this.dfx.dfk;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.dfx.cZK;
        com.baidu.adp.lib.util.k.b(pageActivity, editText);
        inviteFriendListActivity2 = this.dfx.dfk;
        inviteFriendListActivity2.finish();
    }
}
