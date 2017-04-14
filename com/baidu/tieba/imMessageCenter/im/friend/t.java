package com.baidu.tieba.imMessageCenter.im.friend;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p djj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.djj = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        InviteFriendListActivity inviteFriendListActivity;
        EditText editText2;
        textView = this.djj.dje;
        textView.setVisibility(8);
        view2 = this.djj.djg;
        view2.setVisibility(8);
        view3 = this.djj.djf;
        view3.setVisibility(0);
        editText = this.djj.dfv;
        editText.requestFocus();
        inviteFriendListActivity = this.djj.diW;
        Activity pageActivity = inviteFriendListActivity.getPageContext().getPageActivity();
        editText2 = this.djj.dfv;
        com.baidu.adp.lib.util.k.c(pageActivity, editText2);
    }
}
