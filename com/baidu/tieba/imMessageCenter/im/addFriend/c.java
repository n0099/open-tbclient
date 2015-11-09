package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity bJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AddFriendActivity addFriendActivity) {
        this.bJP = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.bJP.bJK;
        if (editText != null) {
            editText2 = this.bJP.bJK;
            editText2.setText("");
        }
    }
}
