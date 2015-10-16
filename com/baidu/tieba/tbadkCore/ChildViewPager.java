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
    private PointF cWM;
    private PointF cWN;
    private a cWO;
    private int cWP;
    private boolean cWQ;

    /* loaded from: classes.dex */
    public interface a {
        void fC(int i);
    }

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWM = new PointF();
        this.cWN = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.cWM = new PointF();
        this.cWN = new PointF();
        init();
    }

    private void init() {
        this.cWP = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cWN.x = motionEvent.getX();
        this.cWN.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.cWM.x = motionEvent.getX();
            this.cWM.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            this.cWQ = true;
            postDelayed(new c(this), 500L);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.cWN.x - this.cWM.x);
            int abs2 = (int) Math.abs(this.cWN.y - this.cWM.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.cWP || abs2 > this.cWP) {
                setPressed(false);
            }
            this.cWQ = false;
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.cWM.x - this.cWN.x) + Math.abs(this.cWM.y - this.cWN.y) < getResources().getDimensionPixelSize(i.d.ds6)) {
                fC(getCurrentItem());
            }
            setPressed(false);
            this.cWQ = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void fC(int i) {
        if (this.cWO != null) {
            this.cWO.fC(i);
        }
    }

    public void setOnSingleTouchListener(a aVar) {
        this.cWO = aVar;
    }
}
