package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.baidu.tbadk.widget.TbViewPager;
/* loaded from: classes.dex */
public class ChildViewPager extends TbViewPager {
    private PointF con;
    private PointF coo;
    private c cop;
    private int coq;

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.con = new PointF();
        this.coo = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.con = new PointF();
        this.coo = new PointF();
        init();
    }

    private void init() {
        this.coq = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.coo.x = motionEvent.getX();
        this.coo.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.con.x = motionEvent.getX();
            this.con.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.coo.x - this.con.x);
            int abs2 = (int) Math.abs(this.coo.y - this.con.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.coq || abs2 > this.coq) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.con.x - this.coo.x) + Math.abs(this.con.y - this.coo.y) < getResources().getDimensionPixelSize(com.baidu.tieba.o.ds6)) {
                eX(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void eX(int i) {
        if (this.cop != null) {
            this.cop.eX(i);
        }
    }

    public void setOnSingleTouchListener(c cVar) {
        this.cop = cVar;
    }
}
