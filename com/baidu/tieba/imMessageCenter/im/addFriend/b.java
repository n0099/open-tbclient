package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity cYl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AddFriendActivity addFriendActivity) {
        this.cYl = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        AddFriendActivity addFriendActivity = this.cYl;
        inputMethodManager = this.cYl.cfb;
        editText = this.cYl.cYg;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
