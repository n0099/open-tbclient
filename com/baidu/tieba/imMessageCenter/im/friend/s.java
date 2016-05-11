package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p cxj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.cxj = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity2;
        View view3;
        view2 = this.cxj.cxg;
        if (view2 != null) {
            view3 = this.cxj.cxg;
            if (view3.getVisibility() == 0) {
                this.cxj.akI();
                return;
            }
        }
        inviteFriendListActivity = this.cxj.cwX;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText = this.cxj.crz;
        com.baidu.adp.lib.util.k.a(pageActivity, editText);
        inviteFriendListActivity2 = this.cxj.cwX;
        inviteFriendListActivity2.finish();
    }
}
