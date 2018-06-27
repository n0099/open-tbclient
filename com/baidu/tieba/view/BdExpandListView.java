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
    private boolean LA;
    private final int LD;
    private final int LE;
    private View Lv;
    private int Lw;
    private float Lx;
    private float Ly;
    private long hmQ;
    private b hnp;
    public a hnq;
    private long hnr;
    private boolean hns;
    private Runnable hnt;
    private int hnu;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void nm();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.hns = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LA = false;
        this.hnr = 0L;
        this.hmQ = 0L;
        this.mHandler = new Handler();
        this.hns = false;
        this.hnt = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Lw > 0) {
                    BdExpandListView.this.Lv.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Lv.getWidth(), BdExpandListView.this.Lw));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.hnu = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.LD = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandListView);
        this.LE = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Lv = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hns) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Lv == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Ly = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hnr = System.currentTimeMillis() - this.hmQ;
                    this.hmQ = System.currentTimeMillis();
                    this.LA = false;
                    setClickEventEnabled(true);
                    if (this.Lw == 0) {
                        this.Lw = this.Lv.getHeight();
                    }
                    int height = this.Lv.getHeight();
                    this.Lx = this.Ly;
                    this.hnp = new b(0, height, 0, this.LE + height);
                    break;
                case 1:
                case 3:
                    if (this.LA) {
                        setClickEventEnabled(false);
                        nk();
                        this.LA = false;
                    } else if (this.hnq != null) {
                        this.hnq.nm();
                    }
                    this.mHandler.removeCallbacks(this.hnt);
                    this.mHandler.postDelayed(this.hnt, 200L);
                    break;
                case 2:
                    float f = this.Ly - this.Lx;
                    if (this.Lv.getParent() == this && this.hnp != null && this.Lv.isShown() && this.Lv.getTop() >= 0 && Math.abs(f) >= this.LD && this.hnr > 400) {
                        int O = this.hnp.O(this.Ly - this.Lx);
                        if (O > this.hnp.startY && O <= this.hnp.endY) {
                            this.LA = true;
                            setClickEventEnabled(false);
                            this.Lv.setLayoutParams(new AbsListView.LayoutParams(this.Lv.getWidth(), O));
                            M(O - this.hnp.startY);
                            break;
                        } else if (O <= this.hnp.startY) {
                            this.LA = false;
                            break;
                        } else if (O > this.hnp.endY) {
                            this.LA = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.LA = false;
                            break;
                        }
                    } else {
                        this.LA = false;
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
        if (this.LA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.LA) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nk() {
        if (this.hnp != null) {
            if (this.Lv.getHeight() >= this.hnp.endY - (this.LE / 2)) {
                nl();
            } else if (this.hnq != null) {
                this.hnq.nm();
            }
            this.mScroller.startScroll(0, this.Lv.getHeight(), 0, this.hnp.startY - this.Lv.getHeight(), 200);
            invalidate();
        }
    }

    public void nl() {
        if (this.hnq != null) {
            this.hnq.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hnq = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hns) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Lv != null && !this.LA) {
            this.LA = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.LE, 0, -this.LE, 200);
            nl();
            invalidate();
            this.mHandler.removeCallbacks(this.hnt);
            this.mHandler.postDelayed(this.hnt, 200L);
            this.LA = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Lw <= 0) {
            this.Lw = this.Lv.getHeight();
        }
        return this.Lw;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hns) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hnu - currY) > this.LD * 2) {
                this.hnu = currY;
                this.Lv.setLayoutParams(new AbsListView.LayoutParams(this.Lv.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.LE);
        if (this.hnq != null) {
            this.hnq.N(f2);
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
