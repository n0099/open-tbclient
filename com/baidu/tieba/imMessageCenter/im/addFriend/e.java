package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e implements View.OnFocusChangeListener {
    final /* synthetic */ AddFriendActivity dqH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AddFriendActivity addFriendActivity) {
        this.dqH = addFriendActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        if (z) {
            AddFriendActivity addFriendActivity = this.dqH;
            inputMethodManager2 = this.dqH.cwX;
            editText2 = this.dqH.dqB;
            addFriendActivity.ShowSoftKeyPad(inputMethodManager2, editText2);
            return;
        }
        AddFriendActivity addFriendActivity2 = this.dqH;
        inputMethodManager = this.dqH.cwX;
        editText = this.dqH.dqB;
        addFriendActivity2.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
