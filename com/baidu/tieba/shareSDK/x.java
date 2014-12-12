package com.baidu.tieba.shareSDK;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class x implements View.OnTouchListener {
    final /* synthetic */ q bOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(q qVar) {
        this.bOn = qVar;
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
