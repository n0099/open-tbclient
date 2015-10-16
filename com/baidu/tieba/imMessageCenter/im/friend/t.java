package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.bNJ = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.bNJ.bNF;
        textView.setVisibility(8);
        view2 = this.bNJ.bNH;
        view2.setVisibility(8);
        view3 = this.bNJ.bNG;
        view3.setVisibility(0);
        editText = this.bNJ.bHW;
        editText.requestFocus();
        inviteFriendListActivity = this.bNJ.bNw;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.bNJ.bHW;
        com.baidu.adp.lib.util.k.d(pageActivity, editText2);
    }
}
