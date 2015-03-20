package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnTouchListener {
    final /* synthetic */ AtListActivity cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.cwI = atListActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText;
        if (motionEvent.getAction() == 0) {
            Activity pageActivity = this.cwI.getPageContext().getPageActivity();
            editText = this.cwI.mEditText;
            com.baidu.adp.lib.util.n.c(pageActivity, editText);
            return false;
        }
        return false;
    }
}
