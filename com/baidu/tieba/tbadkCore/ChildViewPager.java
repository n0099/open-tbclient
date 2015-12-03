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
    private PointF dwM;
    private PointF dwN;
    private a dwO;
    private int dwP;
    private boolean dwQ;

    /* loaded from: classes.dex */
    public interface a {
        void mn(int i);
    }

    public ChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwM = new PointF();
        this.dwN = new PointF();
        init();
    }

    public ChildViewPager(Context context) {
        super(context);
        this.dwM = new PointF();
        this.dwN = new PointF();
        init();
    }

    private void init() {
        this.dwP = new ViewConfiguration().getScaledTouchSlop();
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dwN.x = motionEvent.getX();
        this.dwN.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.dwM.x = motionEvent.getX();
            this.dwM.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            this.dwQ = true;
            postDelayed(new c(this), 500L);
        }
        if (motionEvent.getAction() == 2) {
            int abs = (int) Math.abs(this.dwN.x - this.dwM.x);
            int abs2 = (int) Math.abs(this.dwN.y - this.dwM.y);
            if (abs > abs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (abs > this.dwP || abs2 > this.dwP) {
                setPressed(false);
            }
            this.dwQ = false;
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs(this.dwM.x - this.dwN.x) + Math.abs(this.dwM.y - this.dwN.y) < getResources().getDimensionPixelSize(n.d.ds6)) {
                mn(getCurrentItem());
            }
            setPressed(false);
            this.dwQ = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void mn(int i) {
        if (this.dwO != null) {
            this.dwO.mn(i);
        }
    }

    public void setOnSingleTouchListener(a aVar) {
        this.dwO = aVar;
    }
}
