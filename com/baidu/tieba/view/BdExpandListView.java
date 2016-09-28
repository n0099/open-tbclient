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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View Bi;
    private int Bj;
    private float Bk;
    private float Bl;
    private boolean Bn;
    private final int Bq;
    private final int Br;
    private int bEc;
    private b fXH;
    public a fXI;
    private long fXJ;
    private long fXK;
    private boolean fXL;
    private boolean fXM;
    private Runnable fXN;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void ki();

        void kj();
    }

    public void setStarForum(boolean z) {
        this.fXM = z;
    }

    public boolean bqN() {
        return this.fXM;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bn = false;
        this.fXJ = 0L;
        this.fXK = 0L;
        this.mHandler = new Handler();
        this.fXL = false;
        this.fXM = false;
        this.fXN = new com.baidu.tieba.view.b(this);
        this.bEc = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Bq = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.ExpandListView);
        this.Br = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Bi = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fXM) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Bi == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Bl = motionEvent.getY();
            switch (action) {
                case 0:
                    this.fXJ = System.currentTimeMillis() - this.fXK;
                    this.fXK = System.currentTimeMillis();
                    this.Bn = false;
                    setClickEventEnabled(true);
                    if (this.Bj == 0) {
                        this.Bj = this.Bi.getHeight();
                    }
                    int height = this.Bi.getHeight();
                    this.Bk = this.Bl;
                    this.fXH = new b(0, height, 0, this.Br + height);
                    break;
                case 1:
                case 3:
                    if (this.Bn) {
                        setClickEventEnabled(false);
                        kg();
                        this.Bn = false;
                    } else if (this.fXI != null) {
                        this.fXI.ki();
                    }
                    this.mHandler.removeCallbacks(this.fXN);
                    this.mHandler.postDelayed(this.fXN, 200L);
                    break;
                case 2:
                    float f = this.Bl - this.Bk;
                    if (this.Bi.getParent() == this && this.fXH != null && this.Bi.isShown() && this.Bi.getTop() >= 0 && Math.abs(f) >= this.Bq && this.fXJ > 400) {
                        int H = this.fXH.H(this.Bl - this.Bk);
                        if (H > this.fXH.startY && H <= this.fXH.Bu) {
                            this.Bn = true;
                            setClickEventEnabled(false);
                            this.Bi.setLayoutParams(new AbsListView.LayoutParams(this.Bi.getWidth(), H));
                            F(H - this.fXH.startY);
                            break;
                        } else if (H <= this.fXH.startY) {
                            this.Bn = false;
                            break;
                        } else if (H > this.fXH.Bu) {
                            this.Bn = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Bn = false;
                            break;
                        }
                    } else {
                        this.Bn = false;
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
        if (this.Bn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Bn) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kg() {
        if (this.fXH != null) {
            if (this.Bi.getHeight() >= this.fXH.Bu - (this.Br / 2)) {
                kh();
            } else if (this.fXI != null) {
                this.fXI.ki();
            }
            this.mScroller.startScroll(0, this.Bi.getHeight(), 0, this.fXH.startY - this.Bi.getHeight(), 200);
            invalidate();
        }
    }

    public void kh() {
        if (this.fXI != null) {
            this.fXI.kj();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fXI = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void kv() {
        if (this.fXM) {
            super.kv();
            kh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Bi != null && !this.Bn) {
            this.Bn = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Br, 0, -this.Br, 200);
            kh();
            invalidate();
            this.mHandler.removeCallbacks(this.fXN);
            this.mHandler.postDelayed(this.fXN, 200L);
            this.Bn = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Bj <= 0) {
            this.Bj = this.Bi.getHeight();
        }
        return this.Bj;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.fXM) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.bEc - currY) > this.Bq * 2) {
                this.bEc = currY;
                this.Bi.setLayoutParams(new AbsListView.LayoutParams(this.Bi.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Br);
        if (this.fXI != null) {
            this.fXI.G(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Bu;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.Bu = i4;
        }

        public int H(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
