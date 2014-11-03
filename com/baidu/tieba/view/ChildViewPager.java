package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class ChildViewPager extends ViewPager {
    private PointF bQQ;
    private PointF bQR;
    private d bQS;
    private int bQT;

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQQ = new PointF();
        this.bQR = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.bQQ = new PointF();
        this.bQR = new PointF();
        init();
    }

    private void init() {
        this.bQT = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bQR.x = motionEvent.getX();
        this.bQR.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bQQ.x = motionEvent.getX();
            this.bQQ.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.bQR.x - this.bQQ.x);
            int abs2 = (int) Math.abs(this.bQR.y - this.bQQ.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.bQT || abs2 > this.bQT) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.bQQ.x - this.bQR.x) + Math.abs(this.bQQ.y - this.bQR.y) < getResources().getDimensionPixelSize(com.baidu.tieba.t.ds6)) {
                eK(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void eK(int i) {
        if (this.bQS != null) {
            this.bQS.eK(i);
        }
    }

    public void setOnSingleTouchListener(d dVar) {
        this.bQS = dVar;
    }
}
