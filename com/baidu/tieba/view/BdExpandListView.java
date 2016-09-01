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
import com.baidu.tieba.t;
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
    private int bDR;
    private b fVC;
    public a fVD;
    private long fVE;
    private long fVF;
    private boolean fVG;
    private boolean fVH;
    private Runnable fVI;
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
        this.fVH = z;
    }

    public boolean bqj() {
        return this.fVH;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bn = false;
        this.fVE = 0L;
        this.fVF = 0L;
        this.mHandler = new Handler();
        this.fVG = false;
        this.fVH = false;
        this.fVI = new com.baidu.tieba.view.b(this);
        this.bDR = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Bq = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.ExpandListView);
        this.Br = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Bi = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fVH) {
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
                    this.fVE = System.currentTimeMillis() - this.fVF;
                    this.fVF = System.currentTimeMillis();
                    this.Bn = false;
                    setClickEventEnabled(true);
                    if (this.Bj == 0) {
                        this.Bj = this.Bi.getHeight();
                    }
                    int height = this.Bi.getHeight();
                    this.Bk = this.Bl;
                    this.fVC = new b(0, height, 0, this.Br + height);
                    break;
                case 1:
                case 3:
                    if (this.Bn) {
                        setClickEventEnabled(false);
                        kg();
                        this.Bn = false;
                    } else if (this.fVD != null) {
                        this.fVD.ki();
                    }
                    this.mHandler.removeCallbacks(this.fVI);
                    this.mHandler.postDelayed(this.fVI, 200L);
                    break;
                case 2:
                    float f = this.Bl - this.Bk;
                    if (this.Bi.getParent() == this && this.fVC != null && this.Bi.isShown() && this.Bi.getTop() >= 0 && Math.abs(f) >= this.Bq && this.fVE > 400) {
                        int H = this.fVC.H(this.Bl - this.Bk);
                        if (H > this.fVC.startY && H <= this.fVC.Bu) {
                            this.Bn = true;
                            setClickEventEnabled(false);
                            this.Bi.setLayoutParams(new AbsListView.LayoutParams(this.Bi.getWidth(), H));
                            F(H - this.fVC.startY);
                            break;
                        } else if (H <= this.fVC.startY) {
                            this.Bn = false;
                            break;
                        } else if (H > this.fVC.Bu) {
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
        if (this.fVC != null) {
            if (this.Bi.getHeight() >= this.fVC.Bu - (this.Br / 2)) {
                kh();
            } else if (this.fVD != null) {
                this.fVD.ki();
            }
            this.mScroller.startScroll(0, this.Bi.getHeight(), 0, this.fVC.startY - this.Bi.getHeight(), 200);
            invalidate();
        }
    }

    public void kh() {
        if (this.fVD != null) {
            this.fVD.kj();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fVD = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void kv() {
        if (this.fVH) {
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
            this.mHandler.removeCallbacks(this.fVI);
            this.mHandler.postDelayed(this.fVI, 200L);
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
        if (this.fVH) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.bDR - currY) > this.Bq * 2) {
                this.bDR = currY;
                this.Bi.setLayoutParams(new AbsListView.LayoutParams(this.Bi.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Br);
        if (this.fVD != null) {
            this.fVD.G(f2);
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
