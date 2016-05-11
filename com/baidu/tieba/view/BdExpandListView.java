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
    private b eVY;
    public a eVZ;
    private long eWa;
    private long eWb;
    private Runnable eWc;
    private int eWd;
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
        this.eWa = 0L;
        this.eWb = 0L;
        this.mHandler = new Handler();
        this.eWc = new com.baidu.tieba.view.b(this);
        this.eWd = 0;
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
                    this.eWa = System.currentTimeMillis() - this.eWb;
                    this.eWb = System.currentTimeMillis();
                    this.yv = false;
                    setClickEventEnabled(true);
                    if (this.yr == 0) {
                        this.yr = this.yq.getHeight();
                    }
                    int height = this.yq.getHeight();
                    this.ys = this.yt;
                    this.eVY = new b(0, height, 0, this.yz + height);
                    break;
                case 1:
                case 3:
                    if (this.yv) {
                        setClickEventEnabled(false);
                        jj();
                        this.yv = false;
                    } else if (this.eVZ != null) {
                        this.eVZ.jl();
                    }
                    this.mHandler.removeCallbacks(this.eWc);
                    this.mHandler.postDelayed(this.eWc, 200L);
                    break;
                case 2:
                    float f = this.yt - this.ys;
                    if (this.yq.getParent() == this && this.eVY != null && this.yq.isShown() && this.yq.getTop() >= 0 && Math.abs(f) >= this.yy && this.eWa > 400) {
                        int l = this.eVY.l(this.yt - this.ys);
                        if (l > this.eVY.yD && l <= this.eVY.yF) {
                            this.yv = true;
                            setClickEventEnabled(false);
                            this.yq.setLayoutParams(new AbsListView.LayoutParams(this.yq.getWidth(), l));
                            j(l - this.eVY.yD);
                            break;
                        } else if (l <= this.eVY.yD) {
                            this.yv = false;
                            break;
                        } else if (l > this.eVY.yF) {
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
        if (this.eVY != null) {
            if (this.yq.getHeight() >= this.eVY.yF - (this.yz / 2)) {
                jk();
            } else if (this.eVZ != null) {
                this.eVZ.jl();
            }
            this.mScroller.startScroll(0, this.yq.getHeight(), 0, this.eVY.yD - this.yq.getHeight(), 200);
            invalidate();
        }
    }

    public void jk() {
        if (this.eVZ != null) {
            this.eVZ.jm();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eVZ = aVar;
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
            this.mHandler.removeCallbacks(this.eWc);
            this.mHandler.postDelayed(this.eWc, 200L);
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
            if (Math.abs(this.eWd - currY) > this.yy * 2) {
                this.eWd = currY;
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
        if (this.eVZ != null) {
            this.eVZ.k(f2);
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
