package com.baidu.tieba.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
final class ac extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ w a;

    private ac(w wVar) {
        this.a = wVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(w wVar, byte b) {
        this(wVar);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (w.i(this.a) == 1 || w.i(this.a) == 2) {
            return false;
        }
        w.a(this.a, 2);
        if (w.j(this.a) > w.k(this.a)) {
            w.a(this.a, w.k(this.a));
            w.b(this.a, w.j(this.a));
            w.l(this.a);
            w.m(this.a);
            return true;
        }
        w.a(this.a, w.k(this.a) * 2.0f);
        w.a(this.a, true, (int) motionEvent.getX(), (int) motionEvent.getY());
        w.m(this.a);
        return true;
    }
}
