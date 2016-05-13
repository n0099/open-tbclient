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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    private b eVX;
    public a eVY;
    private long eVZ;
    private long eWa;
    private Runnable eWb;
    private int eWc;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;
    private View yq;
    private int yr;
    private float ys;
    private float yt;
    private boolean yv;
    private final int yy;
    private final int yz;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void jl();

        void jm();

        void k(float f);
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yv = false;
        this.eVZ = 0L;
        this.eWa = 0L;
        this.mHandler = new Handler();
        this.eWb = new com.baidu.tieba.view.b(this);
        this.eWc = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.yy = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ExpandListView);
        this.yz = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.yq = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.yq == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.yt = motionEvent.getY();
            switch (action) {
                case 0:
                    this.eVZ = System.currentTimeMillis() - this.eWa;
                    this.eWa = System.currentTimeMillis();
                    this.yv = false;
                    setClickEventEnabled(true);
                    if (this.yr == 0) {
                        this.yr = this.yq.getHeight();
                    }
                    int height = this.yq.getHeight();
                    this.ys = this.yt;
                    this.eVX = new b(0, height, 0, this.yz + height);
                    break;
                case 1:
                case 3:
                    if (this.yv) {
                        setClickEventEnabled(false);
                        jj();
                        this.yv = false;
                    } else if (this.eVY != null) {
                        this.eVY.jl();
                    }
                    this.mHandler.removeCallbacks(this.eWb);
                    this.mHandler.postDelayed(this.eWb, 200L);
                    break;
                case 2:
                    float f = this.yt - this.ys;
                    if (this.yq.getParent() == this && this.eVX != null && this.yq.isShown() && this.yq.getTop() >= 0 && Math.abs(f) >= this.yy && this.eVZ > 400) {
                        int l = this.eVX.l(this.yt - this.ys);
                        if (l > this.eVX.yD && l <= this.eVX.yF) {
                            this.yv = true;
                            setClickEventEnabled(false);
                            this.yq.setLayoutParams(new AbsListView.LayoutParams(this.yq.getWidth(), l));
                            j(l - this.eVX.yD);
                            break;
                        } else if (l <= this.eVX.yD) {
                            this.yv = false;
                            break;
                        } else if (l > this.eVX.yF) {
                            this.yv = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.yv = false;
                            break;
                        }
                    } else {
                        this.yv = false;
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
        if (this.yv) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.yv) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jj() {
        if (this.eVX != null) {
            if (this.yq.getHeight() >= this.eVX.yF - (this.yz / 2)) {
                jk();
            } else if (this.eVY != null) {
                this.eVY.jl();
            }
            this.mScroller.startScroll(0, this.yq.getHeight(), 0, this.eVX.yD - this.yq.getHeight(), 200);
            invalidate();
        }
    }

    public void jk() {
        if (this.eVY != null) {
            this.eVY.jm();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eVY = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void jy() {
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.yq != null && !this.yv) {
            this.yv = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.yz, 0, -this.yz, 200);
            jk();
            invalidate();
            this.mHandler.removeCallbacks(this.eWb);
            this.mHandler.postDelayed(this.eWb, 200L);
            this.yv = false;
        }
    }

    private int getOriginalHeight() {
        if (this.yr <= 0) {
            this.yr = this.yq.getHeight();
        }
        return this.yr;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.eWc - currY) > this.yy * 2) {
                this.eWc = currY;
                this.yq.setLayoutParams(new AbsListView.LayoutParams(this.yq.getWidth(), currY));
                return;
            }
            return;
        }
        scrollTo(0, 0);
        super.computeScroll();
    }

    private void j(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.yz);
        if (this.eVY != null) {
            this.eVY.k(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int yC;
        public int yD;
        public int yE;
        public int yF;

        public b(int i, int i2, int i3, int i4) {
            this.yC = i;
            this.yD = i2;
            this.yE = i3;
            this.yF = i4;
        }

        public int l(float f) {
            return (int) (this.yD + (f / 2.5f));
        }
    }
}
