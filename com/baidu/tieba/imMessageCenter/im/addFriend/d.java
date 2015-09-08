package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity bGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AddFriendActivity addFriendActivity) {
        this.bGe = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        AddFriendActivity addFriendActivity = this.bGe;
        inputMethodManager = this.bGe.blP;
        editText = this.bGe.bFZ;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        editText2 = this.bGe.bFZ;
        this.bGe.ge(editText2.getText().toString());
    }
}
