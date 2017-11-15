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
    private boolean GS;
    private final int GV;
    private final int GW;
    private b gMS;
    public a gMT;
    private long gMU;
    private boolean gMV;
    private Runnable gMW;
    private int gMX;
    private long gkx;
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
        this.gMV = z;
    }

    public boolean btN() {
        return this.gMV;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GS = false;
        this.gMU = 0L;
        this.gkx = 0L;
        this.mHandler = new Handler();
        this.gMV = false;
        this.gMW = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.GO > 0) {
                    BdExpandListView.this.GN.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.GN.getWidth(), BdExpandListView.this.GO));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gMX = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.GV = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.GW = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.GN = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gMV) {
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
                    this.gMU = System.currentTimeMillis() - this.gkx;
                    this.gkx = System.currentTimeMillis();
                    this.GS = false;
                    setClickEventEnabled(true);
                    if (this.GO == 0) {
                        this.GO = this.GN.getHeight();
                    }
                    int height = this.GN.getHeight();
                    this.GP = this.GQ;
                    this.gMS = new b(0, height, 0, this.GW + height);
                    break;
                case 1:
                case 3:
                    if (this.GS) {
                        setClickEventEnabled(false);
                        kT();
                        this.GS = false;
                    } else if (this.gMT != null) {
                        this.gMT.kV();
                    }
                    this.mHandler.removeCallbacks(this.gMW);
                    this.mHandler.postDelayed(this.gMW, 200L);
                    break;
                case 2:
                    float f = this.GQ - this.GP;
                    if (this.GN.getParent() == this && this.gMS != null && this.GN.isShown() && this.GN.getTop() >= 0 && Math.abs(f) >= this.GV && this.gMU > 400) {
                        int w = this.gMS.w(this.GQ - this.GP);
                        if (w > this.gMS.Ha && w <= this.gMS.Hc) {
                            this.GS = true;
                            setClickEventEnabled(false);
                            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), w));
                            u(w - this.gMS.Ha);
                            break;
                        } else if (w <= this.gMS.Ha) {
                            this.GS = false;
                            break;
                        } else if (w > this.gMS.Hc) {
                            this.GS = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.GS = false;
                            break;
                        }
                    } else {
                        this.GS = false;
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
        if (this.GS) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GS) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kT() {
        if (this.gMS != null) {
            if (this.GN.getHeight() >= this.gMS.Hc - (this.GW / 2)) {
                kU();
            } else if (this.gMT != null) {
                this.gMT.kV();
            }
            this.mScroller.startScroll(0, this.GN.getHeight(), 0, this.gMS.Ha - this.GN.getHeight(), 200);
            invalidate();
        }
    }

    public void kU() {
        if (this.gMT != null) {
            this.gMT.kW();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gMT = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gMV) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.GN != null && !this.GS) {
            this.GS = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.GW, 0, -this.GW, 200);
            kU();
            invalidate();
            this.mHandler.removeCallbacks(this.gMW);
            this.mHandler.postDelayed(this.gMW, 200L);
            this.GS = false;
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
        if (this.gMV) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gMX - currY) > this.GV * 2) {
                this.gMX = currY;
                this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void u(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.GW);
        if (this.gMT != null) {
            this.gMT.v(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int GZ;
        public int Ha;
        public int Hb;
        public int Hc;

        public b(int i, int i2, int i3, int i4) {
            this.GZ = i;
            this.Ha = i2;
            this.Hb = i3;
            this.Hc = i4;
        }

        public int w(float f) {
            return (int) (this.Ha + (f / 2.5f));
        }
    }
}
