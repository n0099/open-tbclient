package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity brI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AddFriendActivity addFriendActivity) {
        this.brI = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.brI.brD;
        if (editText != null) {
            editText2 = this.brI.brD;
            editText2.setText("");
        }
    }
}
