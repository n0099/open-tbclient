package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ t bsV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bsV = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.bsV.bsR;
        textView.setVisibility(8);
        view2 = this.bsV.bsT;
        view2.setVisibility(8);
        view3 = this.bsV.bsS;
        view3.setVisibility(0);
        editText = this.bsV.mEditText;
        editText.requestFocus();
        inviteFriendListActivity = this.bsV.bsI;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.bsV.mEditText;
        com.baidu.adp.lib.util.n.d(pageActivity, editText2);
    }
}
