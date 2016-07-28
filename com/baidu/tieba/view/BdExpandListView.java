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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private int bsE;
    private b fNI;
    public a fNJ;
    private long fNK;
    private long fNL;
    private boolean fNM;
    private boolean fNN;
    private Runnable fNO;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;
    private View yT;
    private int yU;
    private float yV;
    private float yW;
    private boolean yY;
    private final int zb;
    private final int zc;

    /* loaded from: classes.dex */
    public interface a {
        void jn();

        void jo();

        void u(float f);
    }

    public void setStarForum(boolean z) {
        this.fNN = z;
    }

    public boolean bmA() {
        return this.fNN;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yY = false;
        this.fNK = 0L;
        this.fNL = 0L;
        this.mHandler = new Handler();
        this.fNM = false;
        this.fNN = false;
        this.fNO = new com.baidu.tieba.view.b(this);
        this.bsE = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.zb = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.ExpandListView);
        this.zc = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.yT = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fNN) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.yT == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.yW = motionEvent.getY();
            switch (action) {
                case 0:
                    this.fNK = System.currentTimeMillis() - this.fNL;
                    this.fNL = System.currentTimeMillis();
                    this.yY = false;
                    setClickEventEnabled(true);
                    if (this.yU == 0) {
                        this.yU = this.yT.getHeight();
                    }
                    int height = this.yT.getHeight();
                    this.yV = this.yW;
                    this.fNI = new b(0, height, 0, this.zc + height);
                    break;
                case 1:
                case 3:
                    if (this.yY) {
                        setClickEventEnabled(false);
                        jl();
                        this.yY = false;
                    } else if (this.fNJ != null) {
                        this.fNJ.jn();
                    }
                    this.mHandler.removeCallbacks(this.fNO);
                    this.mHandler.postDelayed(this.fNO, 200L);
                    break;
                case 2:
                    float f = this.yW - this.yV;
                    if (this.yT.getParent() == this && this.fNI != null && this.yT.isShown() && this.yT.getTop() >= 0 && Math.abs(f) >= this.zb && this.fNK > 400) {
                        int v = this.fNI.v(this.yW - this.yV);
                        if (v > this.fNI.startY && v <= this.fNI.zf) {
                            this.yY = true;
                            setClickEventEnabled(false);
                            this.yT.setLayoutParams(new AbsListView.LayoutParams(this.yT.getWidth(), v));
                            t(v - this.fNI.startY);
                            break;
                        } else if (v <= this.fNI.startY) {
                            this.yY = false;
                            break;
                        } else if (v > this.fNI.zf) {
                            this.yY = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.yY = false;
                            break;
                        }
                    } else {
                        this.yY = false;
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
        if (this.yY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.yY) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jl() {
        if (this.fNI != null) {
            if (this.yT.getHeight() >= this.fNI.zf - (this.zc / 2)) {
                jm();
            } else if (this.fNJ != null) {
                this.fNJ.jn();
            }
            this.mScroller.startScroll(0, this.yT.getHeight(), 0, this.fNI.startY - this.yT.getHeight(), 200);
            invalidate();
        }
    }

    public void jm() {
        if (this.fNJ != null) {
            this.fNJ.jo();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fNJ = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void jA() {
        if (this.fNN) {
            super.jA();
            jm();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.yT != null && !this.yY) {
            this.yY = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.zc, 0, -this.zc, 200);
            jm();
            invalidate();
            this.mHandler.removeCallbacks(this.fNO);
            this.mHandler.postDelayed(this.fNO, 200L);
            this.yY = false;
        }
    }

    private int getOriginalHeight() {
        if (this.yU <= 0) {
            this.yU = this.yT.getHeight();
        }
        return this.yU;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.fNN) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.bsE - currY) > this.zb * 2) {
                this.bsE = currY;
                this.yT.setLayoutParams(new AbsListView.LayoutParams(this.yT.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void t(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.zc);
        if (this.fNJ != null) {
            this.fNJ.u(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int endX;
        public int startX;
        public int startY;
        public int zf;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.zf = i4;
        }

        public int v(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
