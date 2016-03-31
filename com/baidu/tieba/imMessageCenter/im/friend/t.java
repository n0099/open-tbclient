package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p cwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.cwm = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.cwm.cwi;
        textView.setVisibility(8);
        view2 = this.cwm.cwk;
        view2.setVisibility(8);
        view3 = this.cwm.cwj;
        view3.setVisibility(0);
        editText = this.cwm.cqC;
        editText.requestFocus();
        inviteFriendListActivity = this.cwm.cwa;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.cwm.cqC;
        com.baidu.adp.lib.util.k.d(pageActivity, editText2);
    }
}
