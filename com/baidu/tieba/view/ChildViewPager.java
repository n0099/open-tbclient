package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class ChildViewPager extends ViewPager {
    private PointF bQB;
    private PointF bQC;
    private d bQD;
    private int bQE;

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQB = new PointF();
        this.bQC = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.bQB = new PointF();
        this.bQC = new PointF();
        init();
    }

    private void init() {
        this.bQE = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bQC.x = motionEvent.getX();
        this.bQC.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bQB.x = motionEvent.getX();
            this.bQB.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.bQC.x - this.bQB.x);
            int abs2 = (int) Math.abs(this.bQC.y - this.bQB.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.bQE || abs2 > this.bQE) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.bQB.x - this.bQC.x) + Math.abs(this.bQB.y - this.bQC.y) < getResources().getDimensionPixelSize(com.baidu.tieba.t.ds6)) {
                eK(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void eK(int i) {
        if (this.bQD != null) {
            this.bQD.eK(i);
        }
    }

    public void setOnSingleTouchListener(d dVar) {
        this.bQD = dVar;
    }
}
