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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View GN;
    private int GO;
    private float GP;
    private float GQ;
    private boolean GT;
    private final int GW;
    private final int GX;
    private long gvV;
    private b has;
    public a hat;
    private long hau;
    private boolean hav;
    private Runnable haw;
    private int hax;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void kV();

        void kW();

        void v(float f);
    }

    public void setStarForum(boolean z) {
        this.hav = z;
    }

    public boolean bwc() {
        return this.hav;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GT = false;
        this.hau = 0L;
        this.gvV = 0L;
        this.mHandler = new Handler();
        this.hav = false;
        this.haw = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.GO > 0) {
                    BdExpandListView.this.GN.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.GN.getWidth(), BdExpandListView.this.GO));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.hax = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.GW = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.GX = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.GN = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hav) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.GN == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.GQ = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hau = System.currentTimeMillis() - this.gvV;
                    this.gvV = System.currentTimeMillis();
                    this.GT = false;
                    setClickEventEnabled(true);
                    if (this.GO == 0) {
                        this.GO = this.GN.getHeight();
                    }
                    int height = this.GN.getHeight();
                    this.GP = this.GQ;
                    this.has = new b(0, height, 0, this.GX + height);
                    break;
                case 1:
                case 3:
                    if (this.GT) {
                        setClickEventEnabled(false);
                        kT();
                        this.GT = false;
                    } else if (this.hat != null) {
                        this.hat.kV();
                    }
                    this.mHandler.removeCallbacks(this.haw);
                    this.mHandler.postDelayed(this.haw, 200L);
                    break;
                case 2:
                    float f = this.GQ - this.GP;
                    if (this.GN.getParent() == this && this.has != null && this.GN.isShown() && this.GN.getTop() >= 0 && Math.abs(f) >= this.GW && this.hau > 400) {
                        int w = this.has.w(this.GQ - this.GP);
                        if (w > this.has.startY && w <= this.has.Ha) {
                            this.GT = true;
                            setClickEventEnabled(false);
                            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), w));
                            u(w - this.has.startY);
                            break;
                        } else if (w <= this.has.startY) {
                            this.GT = false;
                            break;
                        } else if (w > this.has.Ha) {
                            this.GT = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.GT = false;
                            break;
                        }
                    } else {
                        this.GT = false;
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
        if (this.GT) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GT) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kT() {
        if (this.has != null) {
            if (this.GN.getHeight() >= this.has.Ha - (this.GX / 2)) {
                kU();
            } else if (this.hat != null) {
                this.hat.kV();
            }
            this.mScroller.startScroll(0, this.GN.getHeight(), 0, this.has.startY - this.GN.getHeight(), 200);
            invalidate();
        }
    }

    public void kU() {
        if (this.hat != null) {
            this.hat.kW();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hat = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hav) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.GN != null && !this.GT) {
            this.GT = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.GX, 0, -this.GX, 200);
            kU();
            invalidate();
            this.mHandler.removeCallbacks(this.haw);
            this.mHandler.postDelayed(this.haw, 200L);
            this.GT = false;
        }
    }

    private int getOriginalHeight() {
        if (this.GO <= 0) {
            this.GO = this.GN.getHeight();
        }
        return this.GO;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hav) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hax - currY) > this.GW * 2) {
                this.hax = currY;
                this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void u(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.GX);
        if (this.hat != null) {
            this.hat.v(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Ha;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.Ha = i4;
        }

        public int w(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
