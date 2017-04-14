package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p djj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.djj = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.djj.djf;
        if (view2 != null) {
            view3 = this.djj.djf;
            if (view3.getVisibility() == 0) {
                this.djj.auJ();
                return;
            }
        }
        inviteFriendListActivity = this.djj.diW;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.djj.dfv;
        com.baidu.adp.lib.util.k.b(pageActivity, editText);
        inviteFriendListActivity2 = this.djj.diW;
        inviteFriendListActivity2.finish();
    }
}
