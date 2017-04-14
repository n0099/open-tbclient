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
import com.baidu.tieba.w;
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
    private b fJb;
    public a fJc;
    private long fJd;
    private long fJe;
    private boolean fJf;
    private boolean fJg;
    private Runnable fJh;
    private int fJi;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void lc();

        void ld();
    }

    public void setStarForum(boolean z) {
        this.fJg = z;
    }

    public boolean bhq() {
        return this.fJg;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HK = false;
        this.fJd = 0L;
        this.fJe = 0L;
        this.mHandler = new Handler();
        this.fJf = false;
        this.fJg = false;
        this.fJh = new com.baidu.tieba.view.b(this);
        this.fJi = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HN = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.ExpandListView);
        this.HO = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HF = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fJg) {
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
                    this.fJd = System.currentTimeMillis() - this.fJe;
                    this.fJe = System.currentTimeMillis();
                    this.HK = false;
                    setClickEventEnabled(true);
                    if (this.HG == 0) {
                        this.HG = this.HF.getHeight();
                    }
                    int height = this.HF.getHeight();
                    this.HH = this.HI;
                    this.fJb = new b(0, height, 0, this.HO + height);
                    break;
                case 1:
                case 3:
                    if (this.HK) {
                        setClickEventEnabled(false);
                        la();
                        this.HK = false;
                    } else if (this.fJc != null) {
                        this.fJc.lc();
                    }
                    this.mHandler.removeCallbacks(this.fJh);
                    this.mHandler.postDelayed(this.fJh, 200L);
                    break;
                case 2:
                    float f = this.HI - this.HH;
                    if (this.HF.getParent() == this && this.fJb != null && this.HF.isShown() && this.HF.getTop() >= 0 && Math.abs(f) >= this.HN && this.fJd > 400) {
                        int H = this.fJb.H(this.HI - this.HH);
                        if (H > this.fJb.HS && H <= this.fJb.HU) {
                            this.HK = true;
                            setClickEventEnabled(false);
                            this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), H));
                            F(H - this.fJb.HS);
                            break;
                        } else if (H <= this.fJb.HS) {
                            this.HK = false;
                            break;
                        } else if (H > this.fJb.HU) {
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

    public void la() {
        if (this.fJb != null) {
            if (this.HF.getHeight() >= this.fJb.HU - (this.HO / 2)) {
                lb();
            } else if (this.fJc != null) {
                this.fJc.lc();
            }
            this.mScroller.startScroll(0, this.HF.getHeight(), 0, this.fJb.HS - this.HF.getHeight(), 200);
            invalidate();
        }
    }

    public void lb() {
        if (this.fJc != null) {
            this.fJc.ld();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fJc = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.fJg) {
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
            lb();
            invalidate();
            this.mHandler.removeCallbacks(this.fJh);
            this.mHandler.postDelayed(this.fJh, 200L);
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
        if (this.fJg) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.fJi - currY) > this.HN * 2) {
                this.fJi = currY;
                this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.HO);
        if (this.fJc != null) {
            this.fJc.G(f2);
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
