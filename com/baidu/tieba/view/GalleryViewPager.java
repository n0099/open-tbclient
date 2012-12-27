package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class GalleryViewPager extends BaseViewPager {
    private PointF c;
    private f d;
    private f e;

    public GalleryViewPager(Context context) {
        super(context);
    }

    private float[] a(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.c.x, pointF.y - this.c.y};
            case 0:
                this.c = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    public f getCurrentView() {
        return this.d;
    }

    public f getSelectedView() {
        return this.e;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onInterceptTouchEvent(motionEvent);
        }
        float[] a = a(motionEvent);
        if (this.d != null && !this.d.b()) {
            if (a == null || !this.d.h() || a[0] >= 0.0f) {
                if (a == null || !this.d.i() || a[0] <= 0.0f) {
                    if (a == null) {
                        if (this.d.i() || this.d.h()) {
                            return super.onInterceptTouchEvent(motionEvent);
                        }
                        return false;
                    }
                    return false;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tieba.view.BaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.d != null) {
                this.d.a();
            }
        }
        if (this.d == null) {
            return onTouchEvent(motionEvent);
        }
        float[] a = a(motionEvent);
        if (this.d.b()) {
            return super.onTouchEvent(motionEvent);
        }
        if (a != null && this.d.h() && a[0] < 0.0f) {
            com.baidu.tieba.c.ae.a(getClass().getName(), "onTouchEvent", "right");
            return super.onTouchEvent(motionEvent);
        } else if (a != null && this.d.i() && a[0] > 0.0f) {
            com.baidu.tieba.c.ae.a(getClass().getName(), "onTouchEvent", "left");
            return super.onTouchEvent(motionEvent);
        } else if (a == null) {
            if (this.d.i() || this.d.h()) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        } else {
            return false;
        }
    }

    public void setCurrentView(f fVar) {
        this.d = fVar;
    }

    public void setSelectedView(f fVar) {
        this.e = fVar;
    }
}
