package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity diy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AddFriendActivity addFriendActivity) {
        this.diy = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        AddFriendActivity addFriendActivity = this.diy;
        inputMethodManager = this.diy.ckW;
        editText = this.diy.dis;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
