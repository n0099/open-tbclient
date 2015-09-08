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
    private PointF cOW;
    private PointF cOX;
    private a cOY;
    private int cOZ;
    private boolean cPa;

    /* loaded from: classes.dex */
    public interface a {
        void fx(int i);
    }

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cOW = new PointF();
        this.cOX = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.cOW = new PointF();
        this.cOX = new PointF();
        init();
    }

    private void init() {
        this.cOZ = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cOX.x = motionEvent.getX();
        this.cOX.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.cOW.x = motionEvent.getX();
            this.cOW.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            this.cPa = true;
            postDelayed(new c(this), 500L);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.cOX.x - this.cOW.x);
            int abs2 = (int) Math.abs(this.cOX.y - this.cOW.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.cOZ || abs2 > this.cOZ) {
                setPressed(false);
            }
            this.cPa = false;
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.cOW.x - this.cOX.x) + Math.abs(this.cOW.y - this.cOX.y) < getResources().getDimensionPixelSize(i.d.ds6)) {
                fx(getCurrentItem());
            }
            setPressed(false);
            this.cPa = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void fx(int i) {
        if (this.cOY != null) {
            this.cOY.fx(i);
        }
    }

    public void setOnSingleTouchListener(a aVar) {
        this.cOY = aVar;
    }
}
