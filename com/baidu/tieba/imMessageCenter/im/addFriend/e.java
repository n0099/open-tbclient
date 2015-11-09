package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnFocusChangeListener {
    final /* synthetic */ AddFriendActivity bJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AddFriendActivity addFriendActivity) {
        this.bJP = addFriendActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        if (z) {
            AddFriendActivity addFriendActivity = this.bJP;
            inputMethodManager2 = this.bJP.bnb;
            editText2 = this.bJP.bJK;
            addFriendActivity.ShowSoftKeyPad(inputMethodManager2, editText2);
            return;
        }
        AddFriendActivity addFriendActivity2 = this.bJP;
        inputMethodManager = this.bJP.bnb;
        editText = this.bJP.bJK;
        addFriendActivity2.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
