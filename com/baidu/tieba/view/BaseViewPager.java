package com.baidu.tieba.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class BaseViewPager extends ViewPager implements GestureDetector.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    private GestureDetector f1477a;
    private a b;
    private a c;

    public BaseViewPager(Context context) {
        super(context);
        this.f1477a = null;
        this.b = null;
        this.c = null;
        g();
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1477a = null;
        this.b = null;
        this.c = null;
        g();
    }

    public void setOnFlipOutListener(a aVar) {
        this.b = aVar;
    }

    public void setOnScrollOutListener(a aVar) {
        this.c = aVar;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1477a == null || getAdapter() == null || getAdapter().getCount() == 0 || (getCurrentItem() != 0 && getAdapter().getCount() != getCurrentItem() + 1)) {
            return super.onTouchEvent(motionEvent);
        }
        this.f1477a.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    private void g() {
        this.f1477a = new GestureDetector(this);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.b != null) {
            if (f < 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.b.b_(0);
                return true;
            } else if (f > 0.0f && getCurrentItem() == 0) {
                this.b.b_(1);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.c != null) {
            if (f > 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.c.b_(0);
                return true;
            } else if (f < 0.0f && getCurrentItem() == 0) {
                this.c.b_(1);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
