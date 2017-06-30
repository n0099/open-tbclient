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
    private b fZK;
    public a fZL;
    private long fZM;
    private long fZN;
    private boolean fZO;
    private boolean fZP;
    private Runnable fZQ;
    private int fZR;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void la();

        void lb();
    }

    public void setStarForum(boolean z) {
        this.fZP = z;
    }

    public boolean blA() {
        return this.fZP;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HK = false;
        this.fZM = 0L;
        this.fZN = 0L;
        this.mHandler = new Handler();
        this.fZO = false;
        this.fZP = false;
        this.fZQ = new com.baidu.tieba.view.b(this);
        this.fZR = 0;
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
        if (this.fZP) {
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
                    this.fZM = System.currentTimeMillis() - this.fZN;
                    this.fZN = System.currentTimeMillis();
                    this.HK = false;
                    setClickEventEnabled(true);
                    if (this.HG == 0) {
                        this.HG = this.HF.getHeight();
                    }
                    int height = this.HF.getHeight();
                    this.HH = this.HI;
                    this.fZK = new b(0, height, 0, this.HO + height);
                    break;
                case 1:
                case 3:
                    if (this.HK) {
                        setClickEventEnabled(false);
                        kY();
                        this.HK = false;
                    } else if (this.fZL != null) {
                        this.fZL.la();
                    }
                    this.mHandler.removeCallbacks(this.fZQ);
                    this.mHandler.postDelayed(this.fZQ, 200L);
                    break;
                case 2:
                    float f = this.HI - this.HH;
                    if (this.HF.getParent() == this && this.fZK != null && this.HF.isShown() && this.HF.getTop() >= 0 && Math.abs(f) >= this.HN && this.fZM > 400) {
                        int H = this.fZK.H(this.HI - this.HH);
                        if (H > this.fZK.HS && H <= this.fZK.HU) {
                            this.HK = true;
                            setClickEventEnabled(false);
                            this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), H));
                            F(H - this.fZK.HS);
                            break;
                        } else if (H <= this.fZK.HS) {
                            this.HK = false;
                            break;
                        } else if (H > this.fZK.HU) {
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

    public void kY() {
        if (this.fZK != null) {
            if (this.HF.getHeight() >= this.fZK.HU - (this.HO / 2)) {
                kZ();
            } else if (this.fZL != null) {
                this.fZL.la();
            }
            this.mScroller.startScroll(0, this.HF.getHeight(), 0, this.fZK.HS - this.HF.getHeight(), 200);
            invalidate();
        }
    }

    public void kZ() {
        if (this.fZL != null) {
            this.fZL.lb();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fZL = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.fZP) {
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
            kZ();
            invalidate();
            this.mHandler.removeCallbacks(this.fZQ);
            this.mHandler.postDelayed(this.fZQ, 200L);
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
        if (this.fZP) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.fZR - currY) > this.HN * 2) {
                this.fZR = currY;
                this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.HO);
        if (this.fZL != null) {
            this.fZL.G(f2);
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
