package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.clJ = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.clJ.clF;
        textView.setVisibility(8);
        view2 = this.clJ.clH;
        view2.setVisibility(8);
        view3 = this.clJ.clG;
        view3.setVisibility(0);
        editText = this.clJ.cfX;
        editText.requestFocus();
        inviteFriendListActivity = this.clJ.clx;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.clJ.cfX;
        com.baidu.adp.lib.util.k.d(pageActivity, editText2);
    }
}
