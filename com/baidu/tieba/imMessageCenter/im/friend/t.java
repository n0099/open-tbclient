package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p dfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.dfx = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.dfx.dfs;
        textView.setVisibility(8);
        view2 = this.dfx.dfu;
        view2.setVisibility(8);
        view3 = this.dfx.dft;
        view3.setVisibility(0);
        editText = this.dfx.cZK;
        editText.requestFocus();
        inviteFriendListActivity = this.dfx.dfk;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.dfx.cZK;
        com.baidu.adp.lib.util.k.c(pageActivity, editText2);
    }
}
