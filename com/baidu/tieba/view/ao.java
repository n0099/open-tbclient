package com.baidu.tieba.view;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnTouchListener {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.a = anVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.a.dismiss();
            return false;
        }
        return false;
    }
}
