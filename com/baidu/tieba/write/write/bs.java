package com.baidu.tieba.write.write;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
class bs extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ WriteActivity cyc;

    private bs(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bs(WriteActivity writeActivity, bs bsVar) {
        this(writeActivity);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (WriteActivity.h(this.cyc).alJ()) {
            WriteActivity.h(this.cyc).Z(this.cyc.getCurrentFocus());
            return true;
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
