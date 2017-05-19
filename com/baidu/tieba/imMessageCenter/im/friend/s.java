package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p dfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.dfE = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.dfE.dfA;
        if (view2 != null) {
            view3 = this.dfE.dfA;
            if (view3.getVisibility() == 0) {
                this.dfE.asF();
                return;
            }
        }
        inviteFriendListActivity = this.dfE.dfr;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.dfE.dbN;
        com.baidu.adp.lib.util.k.b(pageActivity, editText);
        inviteFriendListActivity2 = this.dfE.dfr;
        inviteFriendListActivity2.finish();
    }
}
