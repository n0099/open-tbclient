package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p dcA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.dcA = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.dcA.dcv;
        textView.setVisibility(8);
        view2 = this.dcA.dcx;
        view2.setVisibility(8);
        view3 = this.dcA.dcw;
        view3.setVisibility(0);
        editText = this.dcA.cWP;
        editText.requestFocus();
        inviteFriendListActivity = this.dcA.dcm;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.dcA.cWP;
        com.baidu.adp.lib.util.k.b(pageActivity, editText2);
    }
}
