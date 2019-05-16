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
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private boolean MB;
    private final int MD;
    private final int ME;
    private View Mx;
    private int My;
    private float Mz;
    private long cPq;
    private long jAa;
    private boolean jAb;
    private Runnable jAc;
    private int jAd;
    private b jzY;
    public a jzZ;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void nF();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.jAb = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MB = false;
        this.jAa = 0L;
        this.cPq = 0L;
        this.mHandler = new Handler();
        this.jAb = false;
        this.jAc = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.My > 0) {
                    BdExpandListView.this.Mx.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Mx.getWidth(), BdExpandListView.this.My));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.jAd = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.MD = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandListView);
        this.ME = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Mx = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.jAb) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Mx == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Mz = motionEvent.getY();
            switch (action) {
                case 0:
                    this.jAa = System.currentTimeMillis() - this.cPq;
                    this.cPq = System.currentTimeMillis();
                    this.MB = false;
                    setClickEventEnabled(true);
                    if (this.My == 0) {
                        this.My = this.Mx.getHeight();
                    }
                    int height = this.Mx.getHeight();
                    this.startY = this.Mz;
                    this.jzY = new b(0, height, 0, this.ME + height);
                    break;
                case 1:
                case 3:
                    if (this.MB) {
                        setClickEventEnabled(false);
                        nD();
                        this.MB = false;
                    } else if (this.jzZ != null) {
                        this.jzZ.nF();
                    }
                    this.mHandler.removeCallbacks(this.jAc);
                    this.mHandler.postDelayed(this.jAc, 200L);
                    break;
                case 2:
                    float f = this.Mz - this.startY;
                    if (this.Mx.getParent() == this && this.jzY != null && this.Mx.isShown() && this.Mx.getTop() >= 0 && Math.abs(f) >= this.MD && this.jAa > 400) {
                        int O = this.jzY.O(this.Mz - this.startY);
                        if (O > this.jzY.startY && O <= this.jzY.endY) {
                            this.MB = true;
                            setClickEventEnabled(false);
                            this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), O));
                            M(O - this.jzY.startY);
                            break;
                        } else if (O <= this.jzY.startY) {
                            this.MB = false;
                            break;
                        } else if (O > this.jzY.endY) {
                            this.MB = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.MB = false;
                            break;
                        }
                    } else {
                        this.MB = false;
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
        if (this.MB) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MB) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nD() {
        if (this.jzY != null) {
            if (this.Mx.getHeight() >= this.jzY.endY - (this.ME / 2)) {
                nE();
            } else if (this.jzZ != null) {
                this.jzZ.nF();
            }
            this.mScroller.startScroll(0, this.Mx.getHeight(), 0, this.jzY.startY - this.Mx.getHeight(), 200);
            invalidate();
        }
    }

    public void nE() {
        if (this.jzZ != null) {
            this.jzZ.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.jzZ = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.jAb) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Mx != null && !this.MB) {
            this.MB = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.ME, 0, -this.ME, 200);
            nE();
            invalidate();
            this.mHandler.removeCallbacks(this.jAc);
            this.mHandler.postDelayed(this.jAc, 200L);
            this.MB = false;
        }
    }

    private int getOriginalHeight() {
        if (this.My <= 0) {
            this.My = this.Mx.getHeight();
        }
        return this.My;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.jAb) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.jAd - currY) > this.MD * 2) {
                this.jAd = currY;
                this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.ME);
        if (this.jzZ != null) {
            this.jzZ.N(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int endX;
        public int endY;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.endY = i4;
        }

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
