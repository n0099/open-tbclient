package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p bOe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.bOe = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.bOe.bOa;
        textView.setVisibility(8);
        view2 = this.bOe.bOc;
        view2.setVisibility(8);
        view3 = this.bOe.bOb;
        view3.setVisibility(0);
        editText = this.bOe.bIr;
        editText.requestFocus();
        inviteFriendListActivity = this.bOe.bNR;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.bOe.bIr;
        com.baidu.adp.lib.util.k.d(pageActivity, editText2);
    }
}
