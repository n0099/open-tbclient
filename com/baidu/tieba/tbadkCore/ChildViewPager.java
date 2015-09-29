package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.baidu.tbadk.widget.TbViewPager;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ChildViewPager extends TbViewPager {
    private PointF cWn;
    private PointF cWo;
    private a cWp;
    private int cWq;
    private boolean cWr;

    /* loaded from: classes.dex */
    public interface a {
        void fC(int i);
    }

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWn = new PointF();
        this.cWo = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.cWn = new PointF();
        this.cWo = new PointF();
        init();
    }

    private void init() {
        this.cWq = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cWo.x = motionEvent.getX();
        this.cWo.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.cWn.x = motionEvent.getX();
            this.cWn.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            this.cWr = true;
            postDelayed(new c(this), 500L);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.cWo.x - this.cWn.x);
            int abs2 = (int) Math.abs(this.cWo.y - this.cWn.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.cWq || abs2 > this.cWq) {
                setPressed(false);
            }
            this.cWr = false;
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.cWn.x - this.cWo.x) + Math.abs(this.cWn.y - this.cWo.y) < getResources().getDimensionPixelSize(i.d.ds6)) {
                fC(getCurrentItem());
            }
            setPressed(false);
            this.cWr = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void fC(int i) {
        if (this.cWp != null) {
            this.cWp.fC(i);
        }
    }

    public void setOnSingleTouchListener(a aVar) {
        this.cWp = aVar;
    }
}
