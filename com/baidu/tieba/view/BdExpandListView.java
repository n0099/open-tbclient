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
    private View HF;
    private int HG;
    private float HH;
    private float HI;
    private boolean HK;
    private final int HN;
    private final int HO;
    private long gaI;
    private b gue;
    public a guf;
    private long gug;
    private boolean guh;
    private boolean gui;
    private Runnable guj;
    private int guk;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void kY();

        void kZ();
    }

    public void setStarForum(boolean z) {
        this.gui = z;
    }

    public boolean brx() {
        return this.gui;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HK = false;
        this.gug = 0L;
        this.gaI = 0L;
        this.mHandler = new Handler();
        this.guh = false;
        this.gui = false;
        this.guj = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.HG > 0) {
                    BdExpandListView.this.HF.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.HF.getWidth(), BdExpandListView.this.HG));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.guk = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HN = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.HO = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HF = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gui) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.HF == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.HI = motionEvent.getY();
            switch (action) {
                case 0:
                    this.gug = System.currentTimeMillis() - this.gaI;
                    this.gaI = System.currentTimeMillis();
                    this.HK = false;
                    setClickEventEnabled(true);
                    if (this.HG == 0) {
                        this.HG = this.HF.getHeight();
                    }
                    int height = this.HF.getHeight();
                    this.HH = this.HI;
                    this.gue = new b(0, height, 0, this.HO + height);
                    break;
                case 1:
                case 3:
                    if (this.HK) {
                        setClickEventEnabled(false);
                        kW();
                        this.HK = false;
                    } else if (this.guf != null) {
                        this.guf.kY();
                    }
                    this.mHandler.removeCallbacks(this.guj);
                    this.mHandler.postDelayed(this.guj, 200L);
                    break;
                case 2:
                    float f = this.HI - this.HH;
                    if (this.HF.getParent() == this && this.gue != null && this.HF.isShown() && this.HF.getTop() >= 0 && Math.abs(f) >= this.HN && this.gug > 400) {
                        int H = this.gue.H(this.HI - this.HH);
                        if (H > this.gue.HS && H <= this.gue.HU) {
                            this.HK = true;
                            setClickEventEnabled(false);
                            this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), H));
                            F(H - this.gue.HS);
                            break;
                        } else if (H <= this.gue.HS) {
                            this.HK = false;
                            break;
                        } else if (H > this.gue.HU) {
                            this.HK = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.HK = false;
                            break;
                        }
                    } else {
                        this.HK = false;
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
        if (this.HK) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HK) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kW() {
        if (this.gue != null) {
            if (this.HF.getHeight() >= this.gue.HU - (this.HO / 2)) {
                kX();
            } else if (this.guf != null) {
                this.guf.kY();
            }
            this.mScroller.startScroll(0, this.HF.getHeight(), 0, this.gue.HS - this.HF.getHeight(), 200);
            invalidate();
        }
    }

    public void kX() {
        if (this.guf != null) {
            this.guf.kZ();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.guf = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gui) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.HF != null && !this.HK) {
            this.HK = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.HO, 0, -this.HO, 200);
            kX();
            invalidate();
            this.mHandler.removeCallbacks(this.guj);
            this.mHandler.postDelayed(this.guj, 200L);
            this.HK = false;
        }
    }

    private int getOriginalHeight() {
        if (this.HG <= 0) {
            this.HG = this.HF.getHeight();
        }
        return this.HG;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.gui) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.guk - currY) > this.HN * 2) {
                this.guk = currY;
                this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.HO);
        if (this.guf != null) {
            this.guf.G(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HR;
        public int HS;
        public int HT;
        public int HU;

        public b(int i, int i2, int i3, int i4) {
            this.HR = i;
            this.HS = i2;
            this.HT = i3;
            this.HU = i4;
        }

        public int H(float f) {
            return (int) (this.HS + (f / 2.5f));
        }
    }
}
