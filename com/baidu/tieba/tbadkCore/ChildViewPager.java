package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class ChildViewPager extends ViewPager {
    private PointF cjX;
    private PointF cjY;
    private c cjZ;
    private int cka;

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjX = new PointF();
        this.cjY = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.cjX = new PointF();
        this.cjY = new PointF();
        init();
    }

    private void init() {
        this.cka = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cjY.x = motionEvent.getX();
        this.cjY.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.cjX.x = motionEvent.getX();
            this.cjX.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.cjY.x - this.cjX.x);
            int abs2 = (int) Math.abs(this.cjY.y - this.cjX.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.cka || abs2 > this.cka) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.cjX.x - this.cjY.x) + Math.abs(this.cjX.y - this.cjY.y) < getResources().getDimensionPixelSize(com.baidu.tieba.t.ds6)) {
                eJ(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void eJ(int i) {
        if (this.cjZ != null) {
            this.cjZ.eJ(i);
        }
    }

    public void setOnSingleTouchListener(c cVar) {
        this.cjZ = cVar;
    }
}
