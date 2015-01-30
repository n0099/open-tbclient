package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class ChildViewPager extends ViewPager {
    private PointF bTv;
    private PointF bTw;
    private c bTx;
    private int bTy;

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTv = new PointF();
        this.bTw = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.bTv = new PointF();
        this.bTw = new PointF();
        init();
    }

    private void init() {
        this.bTy = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bTw.x = motionEvent.getX();
        this.bTw.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bTv.x = motionEvent.getX();
            this.bTv.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.bTw.x - this.bTv.x);
            int abs2 = (int) Math.abs(this.bTw.y - this.bTv.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.bTy || abs2 > this.bTy) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.bTv.x - this.bTw.x) + Math.abs(this.bTv.y - this.bTw.y) < getResources().getDimensionPixelSize(com.baidu.tieba.u.ds6)) {
                eO(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void eO(int i) {
        if (this.bTx != null) {
            this.bTx.eO(i);
        }
    }

    public void setOnSingleTouchListener(c cVar) {
        this.bTx = cVar;
    }
}
