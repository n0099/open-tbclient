package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity ddp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AddFriendActivity addFriendActivity) {
        this.ddp = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.ddp.ddj;
        if (editText != null) {
            editText2 = this.ddp.ddj;
            editText2.setText("");
        }
    }
}
