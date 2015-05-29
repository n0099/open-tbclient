package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnFocusChangeListener {
    final /* synthetic */ AddFriendActivity brI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AddFriendActivity addFriendActivity) {
        this.brI = addFriendActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        if (z) {
            AddFriendActivity addFriendActivity = this.brI;
            inputMethodManager2 = this.brI.aXu;
            editText2 = this.brI.brD;
            addFriendActivity.ShowSoftKeyPad(inputMethodManager2, editText2);
            return;
        }
        AddFriendActivity addFriendActivity2 = this.brI;
        inputMethodManager = this.brI.aXu;
        editText = this.brI.brD;
        addFriendActivity2.HidenSoftKeyPad(inputMethodManager, editText);
    }
}
