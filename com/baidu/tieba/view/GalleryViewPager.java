package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class GalleryViewPager extends BaseViewPager {

    /* renamed from: a  reason: collision with root package name */
    private PointF f1828a;
    private j b;
    private j c;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public void setCurrentView(j jVar) {
        this.b = jVar;
    }

    public j getCurrentView() {
        return this.b;
    }

    private float[] a(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.f1828a.x, pointF.y - this.f1828a.y};
            case 0:
                this.f1828a = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tieba.view.BaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.b != null) {
                this.b.a();
            }
        }
        if (this.b == null) {
            return onTouchEvent(motionEvent);
        }
        float[] a2 = a(motionEvent);
        if (this.b.b()) {
            return super.onTouchEvent(motionEvent);
        }
        if (a2 != null && this.b.h() && a2[0] < 0.0f) {
            com.baidu.tieba.util.aq.a(getClass().getName(), "onTouchEvent", "right");
            return super.onTouchEvent(motionEvent);
        } else if (a2 != null && this.b.i() && a2[0] > 0.0f) {
            com.baidu.tieba.util.aq.a(getClass().getName(), "onTouchEvent", "left");
            return super.onTouchEvent(motionEvent);
        } else if (a2 == null) {
            if (this.b.i() || this.b.h()) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        } else {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onInterceptTouchEvent(motionEvent);
        }
        float[] a2 = a(motionEvent);
        if (this.b == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.b.b()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a2 != null && this.b.h() && a2[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a2 != null && this.b.i() && a2[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a2 == null) {
            if (this.b.i() || this.b.h()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(j jVar) {
        this.c = jVar;
    }

    public j getSelectedView() {
        return this.c;
    }
}
