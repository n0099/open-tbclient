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
    private PointF cGA;
    private PointF cGB;
    private a cGC;
    private int cGD;

    /* loaded from: classes.dex */
    public interface a {
        void fk(int i);
    }

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGA = new PointF();
        this.cGB = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.cGA = new PointF();
        this.cGB = new PointF();
        init();
    }

    private void init() {
        this.cGD = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cGB.x = motionEvent.getX();
        this.cGB.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.cGA.x = motionEvent.getX();
            this.cGA.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            setPressed(true);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.cGB.x - this.cGA.x);
            int abs2 = (int) Math.abs(this.cGB.y - this.cGA.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.cGD || abs2 > this.cGD) {
                setPressed(false);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.cGA.x - this.cGB.x) + Math.abs(this.cGA.y - this.cGB.y) < getResources().getDimensionPixelSize(i.d.ds6)) {
                fk(getCurrentItem());
            }
            setPressed(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void fk(int i) {
        if (this.cGC != null) {
            this.cGC.fk(i);
        }
    }

    public void setOnSingleTouchListener(a aVar) {
        this.cGC = aVar;
    }
}
