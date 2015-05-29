package com.baidu.tieba.write.write;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
class bt extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ WriteActivity cCP;

    private bt(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bt(WriteActivity writeActivity, bt btVar) {
        this(writeActivity);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (WriteActivity.h(this.cCP).anK()) {
            WriteActivity.h(this.cCP).aa(this.cCP.getCurrentFocus());
            return true;
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
