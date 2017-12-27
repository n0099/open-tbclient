package com.baidu.tieba.pb.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class c implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnTouchListener {
    private a fDe;
    private View fDf;
    private GestureDetector mGestureDetector = new GestureDetector(TbadkCoreApplication.getInst(), this);

    /* loaded from: classes.dex */
    public interface a {
        boolean c(View view, MotionEvent motionEvent);

        boolean d(View view, MotionEvent motionEvent);

        boolean e(View view, MotionEvent motionEvent);
    }

    public c(a aVar) {
        this.fDe = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.fDf = view;
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
        if (this.fDe != null) {
            return this.fDe.c(this.fDf, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        if (this.fDe != null) {
            return this.fDe.d(this.fDf, motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.fDe != null) {
            return this.fDe.e(this.fDf, motionEvent);
        }
        return false;
    }

    public void cm(View view) {
        this.fDf = view;
    }
}
