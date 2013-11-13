package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class ChildViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    PointF f2526a;
    PointF b;
    f c;

    public ChildViewPager(Context context) {
        super(context);
        this.f2526a = new PointF();
        this.b = new PointF();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.b.x = motionEvent.getX();
        this.b.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.f2526a.x = motionEvent.getX();
            this.f2526a.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (motionEvent.getAction() == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (motionEvent.getAction() != 1 || Math.abs(this.f2526a.x - this.b.x) + Math.abs(this.f2526a.y - this.b.y) >= 3.0f) {
            return super.onTouchEvent(motionEvent);
        }
        g();
        return true;
    }

    public void g() {
        if (this.c != null) {
            this.c.a();
        }
    }

    public void setOnSingleTouchListener(f fVar) {
        this.c = fVar;
    }
}
