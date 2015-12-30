package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AddFriendActivity addFriendActivity) {
        this.ccU = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        AddFriendActivity addFriendActivity = this.ccU;
        inputMethodManager = this.ccU.byv;
        editText = this.ccU.ccP;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
