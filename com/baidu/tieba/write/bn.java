package com.baidu.tieba.write;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
class bn extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ WriteActivity cgR;

    private bn(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bn(WriteActivity writeActivity, bn bnVar) {
        this(writeActivity);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (WriteActivity.g(this.cgR).afW()) {
            WriteActivity.g(this.cgR).W(this.cgR.getCurrentFocus());
            return true;
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
