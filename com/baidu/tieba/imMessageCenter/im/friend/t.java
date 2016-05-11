package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p cxj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.cxj = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.cxj.cxf;
        textView.setVisibility(8);
        view2 = this.cxj.cxh;
        view2.setVisibility(8);
        view3 = this.cxj.cxg;
        view3.setVisibility(0);
        editText = this.cxj.crz;
        editText.requestFocus();
        inviteFriendListActivity = this.cxj.cwX;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.cxj.crz;
        com.baidu.adp.lib.util.k.b(pageActivity, editText2);
    }
}
