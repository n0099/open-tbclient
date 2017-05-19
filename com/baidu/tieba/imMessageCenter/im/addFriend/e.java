package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e implements View.OnFocusChangeListener {
    final /* synthetic */ AddFriendActivity ddp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AddFriendActivity addFriendActivity) {
        this.ddp = addFriendActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        if (z) {
            AddFriendActivity addFriendActivity = this.ddp;
            inputMethodManager2 = this.ddp.ciK;
            editText2 = this.ddp.ddj;
            addFriendActivity.ShowSoftKeyPad(inputMethodManager2, editText2);
            return;
        }
        AddFriendActivity addFriendActivity2 = this.ddp;
        inputMethodManager = this.ddp.ciK;
        editText = this.ddp.ddj;
        addFriendActivity2.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
