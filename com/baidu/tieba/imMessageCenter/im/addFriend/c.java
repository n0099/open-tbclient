package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity bJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AddFriendActivity addFriendActivity) {
        this.bJu = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.bJu.bJp;
        if (editText != null) {
            editText2 = this.bJu.bJp;
            editText2.setText("");
        }
    }
}
