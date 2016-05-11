package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity csV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AddFriendActivity addFriendActivity) {
        this.csV = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        AddFriendActivity addFriendActivity = this.csV;
        inputMethodManager = this.csV.bHm;
        editText = this.csV.csQ;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
