package com.baidu.tieba.nearby;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
class bb implements GestureDetector.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1151a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewNearbyActivity newNearbyActivity) {
        this.f1151a = newNearbyActivity;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent2.getY() - motionEvent.getY() > 0.0f) {
            this.f1151a.u();
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }
}
