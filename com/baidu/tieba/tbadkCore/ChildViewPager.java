package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.baidu.tbadk.widget.TbViewPager;
/* loaded from: classes.dex */
public class ChildViewPager extends TbViewPager {
    private PointF coo;
    private PointF cop;
    private c coq;
    private int cor;

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coo = new PointF();
        this.cop = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.coo = new PointF();
        this.cop = new PointF();
        init();
    }

    private void init() {
        this.cor = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cop.x = motionEvent.getX();
        this.cop.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.coo.x = motionEvent.getX();
            this.coo.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.cop.x - this.coo.x);
            int abs2 = (int) Math.abs(this.cop.y - this.coo.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.cor || abs2 > this.cor) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.coo.x - this.cop.x) + Math.abs(this.coo.y - this.cop.y) < getResources().getDimensionPixelSize(com.baidu.tieba.o.ds6)) {
                eX(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void eX(int i) {
        if (this.coq != null) {
            this.coq.eX(i);
        }
    }

    public void setOnSingleTouchListener(c cVar) {
        this.coq = cVar;
    }
}
