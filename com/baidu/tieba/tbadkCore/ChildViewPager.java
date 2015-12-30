package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.baidu.tbadk.widget.TbViewPager;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ChildViewPager extends TbViewPager {
    private PointF dEm;
    private PointF dEn;
    private a dEo;
    private int dEp;
    private boolean dEq;

    /* loaded from: classes.dex */
    public interface a {
        void mP(int i);
    }

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEm = new PointF();
        this.dEn = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.dEm = new PointF();
        this.dEn = new PointF();
        init();
    }

    private void init() {
        this.dEp = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dEn.x = motionEvent.getX();
        this.dEn.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.dEm.x = motionEvent.getX();
            this.dEm.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            this.dEq = true;
            postDelayed(new c(this), 500L);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.dEn.x - this.dEm.x);
            int abs2 = (int) Math.abs(this.dEn.y - this.dEm.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.dEp || abs2 > this.dEp) {
                setPressed(false);
            }
            this.dEq = false;
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.dEm.x - this.dEn.x) + Math.abs(this.dEm.y - this.dEn.y) < getResources().getDimensionPixelSize(n.e.ds6)) {
                mP(getCurrentItem());
            }
            setPressed(false);
            this.dEq = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void mP(int i) {
        if (this.dEo != null) {
            this.dEo.mP(i);
        }
    }

    public void setOnSingleTouchListener(a aVar) {
        this.dEo = aVar;
    }
}
