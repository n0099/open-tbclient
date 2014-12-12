package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class ChildViewPager extends ViewPager {
    private PointF bRI;
    private PointF bRJ;
    private c bRK;
    private int bRL;

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRI = new PointF();
        this.bRJ = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.bRI = new PointF();
        this.bRJ = new PointF();
        init();
    }

    private void init() {
        this.bRL = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bRJ.x = motionEvent.getX();
        this.bRJ.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bRI.x = motionEvent.getX();
            this.bRI.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.bRJ.x - this.bRI.x);
            int abs2 = (int) Math.abs(this.bRJ.y - this.bRI.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.bRL || abs2 > this.bRL) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.bRI.x - this.bRJ.x) + Math.abs(this.bRI.y - this.bRJ.y) < getResources().getDimensionPixelSize(com.baidu.tieba.u.ds6)) {
                eI(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void eI(int i) {
        if (this.bRK != null) {
            this.bRK.eI(i);
        }
    }

    public void setOnSingleTouchListener(c cVar) {
        this.bRK = cVar;
    }
}
