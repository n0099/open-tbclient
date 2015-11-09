package com.baidu.tieba.write.shareSDK;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ o doz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(o oVar) {
        this.doz = oVar;
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
