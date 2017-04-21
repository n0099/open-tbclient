package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p dlA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.dlA = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.dlA.dlv;
        textView.setVisibility(8);
        view2 = this.dlA.dlx;
        view2.setVisibility(8);
        view3 = this.dlA.dlw;
        view3.setVisibility(0);
        editText = this.dlA.dhM;
        editText.requestFocus();
        inviteFriendListActivity = this.dlA.dln;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.dlA.dhM;
        com.baidu.adp.lib.util.k.c(pageActivity, editText2);
    }
}
