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
    private boolean MA;
    private final int MC;
    private final int MD;
    private View Mw;
    private int Mx;
    private float My;
    private long cPr;
    private b jAc;
    public a jAd;
    private long jAe;
    private boolean jAf;
    private Runnable jAg;
    private int jAh;
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
        this.jAf = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MA = false;
        this.jAe = 0L;
        this.cPr = 0L;
        this.mHandler = new Handler();
        this.jAf = false;
        this.jAg = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Mx > 0) {
                    BdExpandListView.this.Mw.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Mw.getWidth(), BdExpandListView.this.Mx));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.jAh = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.MC = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandListView);
        this.MD = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Mw = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.jAf) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Mw == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.My = motionEvent.getY();
            switch (action) {
                case 0:
                    this.jAe = System.currentTimeMillis() - this.cPr;
                    this.cPr = System.currentTimeMillis();
                    this.MA = false;
                    setClickEventEnabled(true);
                    if (this.Mx == 0) {
                        this.Mx = this.Mw.getHeight();
                    }
                    int height = this.Mw.getHeight();
                    this.startY = this.My;
                    this.jAc = new b(0, height, 0, this.MD + height);
                    break;
                case 1:
                case 3:
                    if (this.MA) {
                        setClickEventEnabled(false);
                        nD();
                        this.MA = false;
                    } else if (this.jAd != null) {
                        this.jAd.nF();
                    }
                    this.mHandler.removeCallbacks(this.jAg);
                    this.mHandler.postDelayed(this.jAg, 200L);
                    break;
                case 2:
                    float f = this.My - this.startY;
                    if (this.Mw.getParent() == this && this.jAc != null && this.Mw.isShown() && this.Mw.getTop() >= 0 && Math.abs(f) >= this.MC && this.jAe > 400) {
                        int O = this.jAc.O(this.My - this.startY);
                        if (O > this.jAc.startY && O <= this.jAc.endY) {
                            this.MA = true;
                            setClickEventEnabled(false);
                            this.Mw.setLayoutParams(new AbsListView.LayoutParams(this.Mw.getWidth(), O));
                            M(O - this.jAc.startY);
                            break;
                        } else if (O <= this.jAc.startY) {
                            this.MA = false;
                            break;
                        } else if (O > this.jAc.endY) {
                            this.MA = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.MA = false;
                            break;
                        }
                    } else {
                        this.MA = false;
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
        if (this.MA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MA) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nD() {
        if (this.jAc != null) {
            if (this.Mw.getHeight() >= this.jAc.endY - (this.MD / 2)) {
                nE();
            } else if (this.jAd != null) {
                this.jAd.nF();
            }
            this.mScroller.startScroll(0, this.Mw.getHeight(), 0, this.jAc.startY - this.Mw.getHeight(), 200);
            invalidate();
        }
    }

    public void nE() {
        if (this.jAd != null) {
            this.jAd.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.jAd = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.jAf) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Mw != null && !this.MA) {
            this.MA = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.MD, 0, -this.MD, 200);
            nE();
            invalidate();
            this.mHandler.removeCallbacks(this.jAg);
            this.mHandler.postDelayed(this.jAg, 200L);
            this.MA = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Mx <= 0) {
            this.Mx = this.Mw.getHeight();
        }
        return this.Mx;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.jAf) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.jAh - currY) > this.MC * 2) {
                this.jAh = currY;
                this.Mw.setLayoutParams(new AbsListView.LayoutParams(this.Mw.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.MD);
        if (this.jAd != null) {
            this.jAd.N(f2);
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
