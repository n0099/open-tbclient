package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class ChildViewPager extends ViewPager {
    private PointF bTu;
    private PointF bTv;
    private c bTw;
    private int bTx;

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTu = new PointF();
        this.bTv = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.bTu = new PointF();
        this.bTv = new PointF();
        init();
    }

    private void init() {
        this.bTx = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bTv.x = motionEvent.getX();
        this.bTv.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bTu.x = motionEvent.getX();
            this.bTu.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.bTv.x - this.bTu.x);
            int abs2 = (int) Math.abs(this.bTv.y - this.bTu.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.bTx || abs2 > this.bTx) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.bTu.x - this.bTv.x) + Math.abs(this.bTu.y - this.bTv.y) < getResources().getDimensionPixelSize(com.baidu.tieba.u.ds6)) {
                eO(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void eO(int i) {
        if (this.bTw != null) {
            this.bTw.eO(i);
        }
    }

    public void setOnSingleTouchListener(c cVar) {
        this.bTw = cVar;
    }
}
