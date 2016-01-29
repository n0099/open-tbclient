package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.clJ = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.clJ.clG;
        if (view2 != null) {
            view3 = this.clJ.clG;
            if (view3.getVisibility() == 0) {
                this.clJ.ahi();
                return;
            }
        }
        inviteFriendListActivity = this.clJ.clx;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.clJ.cfX;
        com.baidu.adp.lib.util.k.c(pageActivity, editText);
        inviteFriendListActivity2 = this.clJ.clx;
        inviteFriendListActivity2.finish();
    }
}
