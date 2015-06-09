package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ t bvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bvW = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.bvW.bvS;
        textView.setVisibility(8);
        view2 = this.bvW.bvU;
        view2.setVisibility(8);
        view3 = this.bvW.bvT;
        view3.setVisibility(0);
        editText = this.bvW.mEditText;
        editText.requestFocus();
        inviteFriendListActivity = this.bvW.bvJ;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.bvW.mEditText;
        com.baidu.adp.lib.util.n.d(pageActivity, editText2);
    }
}
