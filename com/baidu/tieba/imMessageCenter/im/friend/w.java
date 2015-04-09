package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t btl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.btl = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.btl.bti;
        if (view2 != null) {
            view3 = this.btl.bti;
            if (view3.getVisibility() == 0) {
                this.btl.VL();
                return;
            }
        }
        inviteFriendListActivity = this.btl.bsY;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.btl.mEditText;
        com.baidu.adp.lib.util.n.c(pageActivity, editText);
        inviteFriendListActivity2 = this.btl.bsY;
        inviteFriendListActivity2.finish();
    }
}
