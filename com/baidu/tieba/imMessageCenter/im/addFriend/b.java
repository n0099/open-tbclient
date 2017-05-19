package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity ddp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AddFriendActivity addFriendActivity) {
        this.ddp = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        AddFriendActivity addFriendActivity = this.ddp;
        inputMethodManager = this.ddp.ciK;
        editText = this.ddp.ddj;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
