package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnTouchListener {
    final /* synthetic */ AddFriendActivity cYl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AddFriendActivity addFriendActivity) {
        this.cYl = addFriendActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        EditText editText2;
        editText = this.cYl.cYg;
        if (editText.getParent() != null) {
            editText2 = this.cYl.cYg;
            editText2.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
        return false;
    }
}
