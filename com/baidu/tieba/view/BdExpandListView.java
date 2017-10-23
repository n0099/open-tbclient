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
    private final int HA;
    private final int HB;
    private View Hs;
    private int Ht;
    private float Hu;
    private float Hv;
    private boolean Hx;
    private b gBU;
    public a gBV;
    private long gBW;
    private boolean gBX;
    private boolean gBY;
    private Runnable gBZ;
    private int gCa;
    private long gaI;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void lb();

        void lc();

        void w(float f);
    }

    public void setStarForum(boolean z) {
        this.gBY = z;
    }

    public boolean bqv() {
        return this.gBY;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = false;
        this.gBW = 0L;
        this.gaI = 0L;
        this.mHandler = new Handler();
        this.gBX = false;
        this.gBY = false;
        this.gBZ = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Ht > 0) {
                    BdExpandListView.this.Hs.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Hs.getWidth(), BdExpandListView.this.Ht));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gCa = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HA = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.HB = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Hs = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gBY) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Hs == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Hv = motionEvent.getY();
            switch (action) {
                case 0:
                    this.gBW = System.currentTimeMillis() - this.gaI;
                    this.gaI = System.currentTimeMillis();
                    this.Hx = false;
                    setClickEventEnabled(true);
                    if (this.Ht == 0) {
                        this.Ht = this.Hs.getHeight();
                    }
                    int height = this.Hs.getHeight();
                    this.Hu = this.Hv;
                    this.gBU = new b(0, height, 0, this.HB + height);
                    break;
                case 1:
                case 3:
                    if (this.Hx) {
                        setClickEventEnabled(false);
                        kZ();
                        this.Hx = false;
                    } else if (this.gBV != null) {
                        this.gBV.lb();
                    }
                    this.mHandler.removeCallbacks(this.gBZ);
                    this.mHandler.postDelayed(this.gBZ, 200L);
                    break;
                case 2:
                    float f = this.Hv - this.Hu;
                    if (this.Hs.getParent() == this && this.gBU != null && this.Hs.isShown() && this.Hs.getTop() >= 0 && Math.abs(f) >= this.HA && this.gBW > 400) {
                        int x = this.gBU.x(this.Hv - this.Hu);
                        if (x > this.gBU.HF && x <= this.gBU.HH) {
                            this.Hx = true;
                            setClickEventEnabled(false);
                            this.Hs.setLayoutParams(new AbsListView.LayoutParams(this.Hs.getWidth(), x));
                            v(x - this.gBU.HF);
                            break;
                        } else if (x <= this.gBU.HF) {
                            this.Hx = false;
                            break;
                        } else if (x > this.gBU.HH) {
                            this.Hx = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Hx = false;
                            break;
                        }
                    } else {
                        this.Hx = false;
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
        if (this.Hx) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hx) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kZ() {
        if (this.gBU != null) {
            if (this.Hs.getHeight() >= this.gBU.HH - (this.HB / 2)) {
                la();
            } else if (this.gBV != null) {
                this.gBV.lb();
            }
            this.mScroller.startScroll(0, this.Hs.getHeight(), 0, this.gBU.HF - this.Hs.getHeight(), 200);
            invalidate();
        }
    }

    public void la() {
        if (this.gBV != null) {
            this.gBV.lc();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gBV = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gBY) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Hs != null && !this.Hx) {
            this.Hx = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.HB, 0, -this.HB, 200);
            la();
            invalidate();
            this.mHandler.removeCallbacks(this.gBZ);
            this.mHandler.postDelayed(this.gBZ, 200L);
            this.Hx = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Ht <= 0) {
            this.Ht = this.Hs.getHeight();
        }
        return this.Ht;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.gBY) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gCa - currY) > this.HA * 2) {
                this.gCa = currY;
                this.Hs.setLayoutParams(new AbsListView.LayoutParams(this.Hs.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void v(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.HB);
        if (this.gBV != null) {
            this.gBV.w(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HE;
        public int HF;
        public int HG;
        public int HH;

        public b(int i, int i2, int i3, int i4) {
            this.HE = i;
            this.HF = i2;
            this.HG = i3;
            this.HH = i4;
        }

        public int x(float f) {
            return (int) (this.HF + (f / 2.5f));
        }
    }
}
