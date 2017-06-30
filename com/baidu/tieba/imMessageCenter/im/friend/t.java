package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p dsU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.dsU = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.dsU.dsP;
        textView.setVisibility(8);
        view2 = this.dsU.dsR;
        view2.setVisibility(8);
        view3 = this.dsU.dsQ;
        view3.setVisibility(0);
        editText = this.dsU.dpg;
        editText.requestFocus();
        inviteFriendListActivity = this.dsU.dsH;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.dsU.dpg;
        com.baidu.adp.lib.util.k.c(pageActivity, editText2);
    }
}
