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
    private b gLK;
    public a gLL;
    private long gLM;
    private boolean gLN;
    private Runnable gLO;
    private int gLP;
    private long gjv;
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
        this.gLN = z;
    }

    public boolean btB() {
        return this.gLN;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GS = false;
        this.gLM = 0L;
        this.gjv = 0L;
        this.mHandler = new Handler();
        this.gLN = false;
        this.gLO = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.GO > 0) {
                    BdExpandListView.this.GN.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.GN.getWidth(), BdExpandListView.this.GO));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gLP = 0;
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
        if (this.gLN) {
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
                    this.gLM = System.currentTimeMillis() - this.gjv;
                    this.gjv = System.currentTimeMillis();
                    this.GS = false;
                    setClickEventEnabled(true);
                    if (this.GO == 0) {
                        this.GO = this.GN.getHeight();
                    }
                    int height = this.GN.getHeight();
                    this.GP = this.GQ;
                    this.gLK = new b(0, height, 0, this.GW + height);
                    break;
                case 1:
                case 3:
                    if (this.GS) {
                        setClickEventEnabled(false);
                        kT();
                        this.GS = false;
                    } else if (this.gLL != null) {
                        this.gLL.kV();
                    }
                    this.mHandler.removeCallbacks(this.gLO);
                    this.mHandler.postDelayed(this.gLO, 200L);
                    break;
                case 2:
                    float f = this.GQ - this.GP;
                    if (this.GN.getParent() == this && this.gLK != null && this.GN.isShown() && this.GN.getTop() >= 0 && Math.abs(f) >= this.GV && this.gLM > 400) {
                        int w = this.gLK.w(this.GQ - this.GP);
                        if (w > this.gLK.Ha && w <= this.gLK.Hc) {
                            this.GS = true;
                            setClickEventEnabled(false);
                            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), w));
                            u(w - this.gLK.Ha);
                            break;
                        } else if (w <= this.gLK.Ha) {
                            this.GS = false;
                            break;
                        } else if (w > this.gLK.Hc) {
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
        if (this.gLK != null) {
            if (this.GN.getHeight() >= this.gLK.Hc - (this.GW / 2)) {
                kU();
            } else if (this.gLL != null) {
                this.gLL.kV();
            }
            this.mScroller.startScroll(0, this.GN.getHeight(), 0, this.gLK.Ha - this.GN.getHeight(), 200);
            invalidate();
        }
    }

    public void kU() {
        if (this.gLL != null) {
            this.gLL.kW();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gLL = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gLN) {
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
            this.mHandler.removeCallbacks(this.gLO);
            this.mHandler.postDelayed(this.gLO, 200L);
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
        if (this.gLN) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gLP - currY) > this.GV * 2) {
                this.gLP = currY;
                this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void u(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.GW);
        if (this.gLL != null) {
            this.gLL.v(f2);
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
