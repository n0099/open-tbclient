package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p dsU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.dsU = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.dsU.dsQ;
        if (view2 != null) {
            view3 = this.dsU.dsQ;
            if (view3.getVisibility() == 0) {
                this.dsU.axi();
                return;
            }
        }
        inviteFriendListActivity = this.dsU.dsH;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.dsU.dpg;
        com.baidu.adp.lib.util.k.b(pageActivity, editText);
        inviteFriendListActivity2 = this.dsU.dsH;
        inviteFriendListActivity2.finish();
    }
}
