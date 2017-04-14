package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnFocusChangeListener {
    final /* synthetic */ AddFriendActivity dgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AddFriendActivity addFriendActivity) {
        this.dgX = addFriendActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        if (z) {
            AddFriendActivity addFriendActivity = this.dgX;
            inputMethodManager2 = this.dgX.cjw;
            editText2 = this.dgX.dgR;
            addFriendActivity.ShowSoftKeyPad(inputMethodManager2, editText2);
            return;
        }
        AddFriendActivity addFriendActivity2 = this.dgX;
        inputMethodManager = this.dgX.cjw;
        editText = this.dgX.dgR;
        addFriendActivity2.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
