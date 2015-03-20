package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bsV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bsV = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.bsV.bsS;
        if (view2 != null) {
            view3 = this.bsV.bsS;
            if (view3.getVisibility() == 0) {
                this.bsV.Vy();
                return;
            }
        }
        inviteFriendListActivity = this.bsV.bsI;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.bsV.mEditText;
        com.baidu.adp.lib.util.n.c(pageActivity, editText);
        inviteFriendListActivity2 = this.bsV.bsI;
        inviteFriendListActivity2.finish();
    }
}
