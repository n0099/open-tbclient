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
    public a jAa;
    private long jAb;
    private boolean jAc;
    private Runnable jAd;
    private int jAe;
    private b jzZ;
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
        this.jAc = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MB = false;
        this.jAb = 0L;
        this.cPq = 0L;
        this.mHandler = new Handler();
        this.jAc = false;
        this.jAd = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.My > 0) {
                    BdExpandListView.this.Mx.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Mx.getWidth(), BdExpandListView.this.My));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.jAe = 0;
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
        if (this.jAc) {
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
                    this.jAb = System.currentTimeMillis() - this.cPq;
                    this.cPq = System.currentTimeMillis();
                    this.MB = false;
                    setClickEventEnabled(true);
                    if (this.My == 0) {
                        this.My = this.Mx.getHeight();
                    }
                    int height = this.Mx.getHeight();
                    this.startY = this.Mz;
                    this.jzZ = new b(0, height, 0, this.ME + height);
                    break;
                case 1:
                case 3:
                    if (this.MB) {
                        setClickEventEnabled(false);
                        nD();
                        this.MB = false;
                    } else if (this.jAa != null) {
                        this.jAa.nF();
                    }
                    this.mHandler.removeCallbacks(this.jAd);
                    this.mHandler.postDelayed(this.jAd, 200L);
                    break;
                case 2:
                    float f = this.Mz - this.startY;
                    if (this.Mx.getParent() == this && this.jzZ != null && this.Mx.isShown() && this.Mx.getTop() >= 0 && Math.abs(f) >= this.MD && this.jAb > 400) {
                        int O = this.jzZ.O(this.Mz - this.startY);
                        if (O > this.jzZ.startY && O <= this.jzZ.endY) {
                            this.MB = true;
                            setClickEventEnabled(false);
                            this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), O));
                            M(O - this.jzZ.startY);
                            break;
                        } else if (O <= this.jzZ.startY) {
                            this.MB = false;
                            break;
                        } else if (O > this.jzZ.endY) {
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
        if (this.jzZ != null) {
            if (this.Mx.getHeight() >= this.jzZ.endY - (this.ME / 2)) {
                nE();
            } else if (this.jAa != null) {
                this.jAa.nF();
            }
            this.mScroller.startScroll(0, this.Mx.getHeight(), 0, this.jzZ.startY - this.Mx.getHeight(), 200);
            invalidate();
        }
    }

    public void nE() {
        if (this.jAa != null) {
            this.jAa.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.jAa = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.jAc) {
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
            this.mHandler.removeCallbacks(this.jAd);
            this.mHandler.postDelayed(this.jAd, 200L);
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
        if (this.jAc) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.jAe - currY) > this.MD * 2) {
                this.jAe = currY;
                this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.ME);
        if (this.jAa != null) {
            this.jAa.N(f2);
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
