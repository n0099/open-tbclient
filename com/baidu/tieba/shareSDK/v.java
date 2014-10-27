package com.baidu.tieba.shareSDK;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnTouchListener {
    final /* synthetic */ o bJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.bJI = oVar;
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
