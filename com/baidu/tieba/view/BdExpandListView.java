package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View HH;
    private int HI;
    private float HJ;
    private float HK;
    private boolean HM;
    private final int HP;
    private final int HQ;
    private long fLA;
    private boolean fLB;
    private boolean fLC;
    private Runnable fLD;
    private int fLE;
    private b fLx;
    public a fLy;
    private long fLz;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void ld();

        void le();
    }

    public void setStarForum(boolean z) {
        this.fLC = z;
    }

    public boolean bir() {
        return this.fLC;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HM = false;
        this.fLz = 0L;
        this.fLA = 0L;
        this.mHandler = new Handler();
        this.fLB = false;
        this.fLC = false;
        this.fLD = new com.baidu.tieba.view.b(this);
        this.fLE = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HP = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.ExpandListView);
        this.HQ = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HH = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fLC) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.HH == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.HK = motionEvent.getY();
            switch (action) {
                case 0:
                    this.fLz = System.currentTimeMillis() - this.fLA;
                    this.fLA = System.currentTimeMillis();
                    this.HM = false;
                    setClickEventEnabled(true);
                    if (this.HI == 0) {
                        this.HI = this.HH.getHeight();
                    }
                    int height = this.HH.getHeight();
                    this.HJ = this.HK;
                    this.fLx = new b(0, height, 0, this.HQ + height);
                    break;
                case 1:
                case 3:
                    if (this.HM) {
                        setClickEventEnabled(false);
                        lb();
                        this.HM = false;
                    } else if (this.fLy != null) {
                        this.fLy.ld();
                    }
                    this.mHandler.removeCallbacks(this.fLD);
                    this.mHandler.postDelayed(this.fLD, 200L);
                    break;
                case 2:
                    float f = this.HK - this.HJ;
                    if (this.HH.getParent() == this && this.fLx != null && this.HH.isShown() && this.HH.getTop() >= 0 && Math.abs(f) >= this.HP && this.fLz > 400) {
                        int H = this.fLx.H(this.HK - this.HJ);
                        if (H > this.fLx.HU && H <= this.fLx.HW) {
                            this.HM = true;
                            setClickEventEnabled(false);
                            this.HH.setLayoutParams(new AbsListView.LayoutParams(this.HH.getWidth(), H));
                            F(H - this.fLx.HU);
                            break;
                        } else if (H <= this.fLx.HU) {
                            this.HM = false;
                            break;
                        } else if (H > this.fLx.HW) {
                            this.HM = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.HM = false;
                            break;
                        }
                    } else {
                        this.HM = false;
                        break;
                    }
                    break;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    private void setClickEventEnabled(boolean z) {
        setClickable(z);
        setLongClickable(z);
        setEnabled(z);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HM) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HM) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lb() {
        if (this.fLx != null) {
            if (this.HH.getHeight() >= this.fLx.HW - (this.HQ / 2)) {
                lc();
            } else if (this.fLy != null) {
                this.fLy.ld();
            }
            this.mScroller.startScroll(0, this.HH.getHeight(), 0, this.fLx.HU - this.HH.getHeight(), 200);
            invalidate();
        }
    }

    public void lc() {
        if (this.fLy != null) {
            this.fLy.le();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fLy = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.fLC) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.HH != null && !this.HM) {
            this.HM = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.HQ, 0, -this.HQ, 200);
            lc();
            invalidate();
            this.mHandler.removeCallbacks(this.fLD);
            this.mHandler.postDelayed(this.fLD, 200L);
            this.HM = false;
        }
    }

    private int getOriginalHeight() {
        if (this.HI <= 0) {
            this.HI = this.HH.getHeight();
        }
        return this.HI;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.fLC) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.fLE - currY) > this.HP * 2) {
                this.fLE = currY;
                this.HH.setLayoutParams(new AbsListView.LayoutParams(this.HH.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.HQ);
        if (this.fLy != null) {
            this.fLy.G(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HT;
        public int HU;
        public int HV;
        public int HW;

        public b(int i, int i2, int i3, int i4) {
            this.HT = i;
            this.HU = i2;
            this.HV = i3;
            this.HW = i4;
        }

        public int H(float f) {
            return (int) (this.HU + (f / 2.5f));
        }
    }
}
