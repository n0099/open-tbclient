package com.baidu.tieba.shareSDK;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ p bJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.bJX = pVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            return false;
        }
        return false;
    }
}
