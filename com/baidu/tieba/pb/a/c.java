package com.baidu.tieba.pb.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class c implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnTouchListener {
    private a eGR;
    private View eGS;
    private GestureDetector mGestureDetector = new GestureDetector(this);

    /* loaded from: classes.dex */
    public interface a {
        boolean a(View view, MotionEvent motionEvent);

        boolean b(View view, MotionEvent motionEvent);

        boolean c(View view, MotionEvent motionEvent);
    }

    public c(a aVar) {
        this.eGR = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.eGS = view;
        if (this.mGestureDetector != null) {
            return this.mGestureDetector.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.eGR != null) {
            return this.eGR.a(this.eGS, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        if (this.eGR != null) {
            return this.eGR.b(this.eGS, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.eGR != null) {
            return this.eGR.c(this.eGS, motionEvent);
        }
        return false;
    }

    public void aY(View view) {
        this.eGS = view;
    }
}
