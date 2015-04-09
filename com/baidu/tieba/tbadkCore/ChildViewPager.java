package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class ChildViewPager extends ViewPager {
    private PointF ckn;
    private PointF cko;
    private c ckp;
    private int ckq;

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckn = new PointF();
        this.cko = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.ckn = new PointF();
        this.cko = new PointF();
        init();
    }

    private void init() {
        this.ckq = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cko.x = motionEvent.getX();
        this.cko.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.ckn.x = motionEvent.getX();
            this.ckn.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.cko.x - this.ckn.x);
            int abs2 = (int) Math.abs(this.cko.y - this.ckn.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.ckq || abs2 > this.ckq) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.ckn.x - this.cko.x) + Math.abs(this.ckn.y - this.cko.y) < getResources().getDimensionPixelSize(com.baidu.tieba.t.ds6)) {
                eJ(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void eJ(int i) {
        if (this.ckp != null) {
            this.ckp.eJ(i);
        }
    }

    public void setOnSingleTouchListener(c cVar) {
        this.ckp = cVar;
    }
}
