package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public final class e extends ViewPager {
    PointF a;
    PointF b;
    f c;

    public e(Context context) {
        super(context);
        this.a = new PointF();
        this.b = new PointF();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.b.x = motionEvent.getX();
        this.b.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.a.x = motionEvent.getX();
            this.a.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (motionEvent.getAction() == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (motionEvent.getAction() != 1 || Math.abs(this.a.x - this.b.x) + Math.abs(this.a.y - this.b.y) >= 3.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.c != null) {
            this.c.a();
            return true;
        }
        return true;
    }

    public final void setOnSingleTouchListener(f fVar) {
        this.c = fVar;
    }
}
