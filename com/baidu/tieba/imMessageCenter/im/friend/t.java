package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p dsB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.dsB = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.dsB.dsw;
        textView.setVisibility(8);
        view2 = this.dsB.dsy;
        view2.setVisibility(8);
        view3 = this.dsB.dsx;
        view3.setVisibility(0);
        editText = this.dsB.dmQ;
        editText.requestFocus();
        inviteFriendListActivity = this.dsB.dso;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.dsB.dmQ;
        com.baidu.adp.lib.util.k.c(pageActivity, editText2);
    }
}
