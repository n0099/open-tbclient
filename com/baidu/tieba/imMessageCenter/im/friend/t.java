package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p dfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.dfE = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.dfE.dfz;
        textView.setVisibility(8);
        view2 = this.dfE.dfB;
        view2.setVisibility(8);
        view3 = this.dfE.dfA;
        view3.setVisibility(0);
        editText = this.dfE.dbN;
        editText.requestFocus();
        inviteFriendListActivity = this.dfE.dfr;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.dfE.dbN;
        com.baidu.adp.lib.util.k.c(pageActivity, editText2);
    }
}
