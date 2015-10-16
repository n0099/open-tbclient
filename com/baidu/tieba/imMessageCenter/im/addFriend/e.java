package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnFocusChangeListener {
    final /* synthetic */ AddFriendActivity bJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AddFriendActivity addFriendActivity) {
        this.bJu = addFriendActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        if (z) {
            AddFriendActivity addFriendActivity = this.bJu;
            inputMethodManager2 = this.bJu.bmx;
            editText2 = this.bJu.bJp;
            addFriendActivity.ShowSoftKeyPad(inputMethodManager2, editText2);
            return;
        }
        AddFriendActivity addFriendActivity2 = this.bJu;
        inputMethodManager = this.bJu.bmx;
        editText = this.bJu.bJp;
        addFriendActivity2.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
