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
    private PointF cYi;
    private PointF cYj;
    private a cYk;
    private int cYl;
    private boolean cYm;

    /* loaded from: classes.dex */
    public interface a {
        void fK(int i);
    }

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYi = new PointF();
        this.cYj = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.cYi = new PointF();
        this.cYj = new PointF();
        init();
    }

    private void init() {
        this.cYl = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cYj.x = motionEvent.getX();
        this.cYj.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.cYi.x = motionEvent.getX();
            this.cYi.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            this.cYm = true;
            postDelayed(new c(this), 500L);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.cYj.x - this.cYi.x);
            int abs2 = (int) Math.abs(this.cYj.y - this.cYi.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.cYl || abs2 > this.cYl) {
                setPressed(false);
            }
            this.cYm = false;
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.cYi.x - this.cYj.x) + Math.abs(this.cYi.y - this.cYj.y) < getResources().getDimensionPixelSize(i.d.ds6)) {
                fK(getCurrentItem());
            }
            setPressed(false);
            this.cYm = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void fK(int i) {
        if (this.cYk != null) {
            this.cYk.fK(i);
        }
    }

    public void setOnSingleTouchListener(a aVar) {
        this.cYk = aVar;
    }
}
