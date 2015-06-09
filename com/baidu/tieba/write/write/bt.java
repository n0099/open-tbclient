package com.baidu.tieba.write.write;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
class bt extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ WriteActivity cCQ;

    private bt(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bt(WriteActivity writeActivity, bt btVar) {
        this(writeActivity);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (WriteActivity.h(this.cCQ).anL()) {
            WriteActivity.h(this.cCQ).aa(this.cCQ.getCurrentFocus());
            return true;
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
