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
    private int bGW;
    private b gfb;
    public a gfc;
    private long gfd;
    private long gfe;
    private boolean gff;
    private boolean gfg;
    private Runnable gfh;
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
        this.gfg = z;
    }

    public boolean blo() {
        return this.gfg;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bn = false;
        this.gfd = 0L;
        this.gfe = 0L;
        this.mHandler = new Handler();
        this.gff = false;
        this.gfg = false;
        this.gfh = new com.baidu.tieba.view.b(this);
        this.bGW = 0;
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
        if (this.gfg) {
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
                    this.gfd = System.currentTimeMillis() - this.gfe;
                    this.gfe = System.currentTimeMillis();
                    this.Bn = false;
                    setClickEventEnabled(true);
                    if (this.Bj == 0) {
                        this.Bj = this.Bi.getHeight();
                    }
                    int height = this.Bi.getHeight();
                    this.Bk = this.Bl;
                    this.gfb = new b(0, height, 0, this.Br + height);
                    break;
                case 1:
                case 3:
                    if (this.Bn) {
                        setClickEventEnabled(false);
                        kg();
                        this.Bn = false;
                    } else if (this.gfc != null) {
                        this.gfc.ki();
                    }
                    this.mHandler.removeCallbacks(this.gfh);
                    this.mHandler.postDelayed(this.gfh, 200L);
                    break;
                case 2:
                    float f = this.Bl - this.Bk;
                    if (this.Bi.getParent() == this && this.gfb != null && this.Bi.isShown() && this.Bi.getTop() >= 0 && Math.abs(f) >= this.Bq && this.gfd > 400) {
                        int H = this.gfb.H(this.Bl - this.Bk);
                        if (H > this.gfb.startY && H <= this.gfb.Bu) {
                            this.Bn = true;
                            setClickEventEnabled(false);
                            this.Bi.setLayoutParams(new AbsListView.LayoutParams(this.Bi.getWidth(), H));
                            F(H - this.gfb.startY);
                            break;
                        } else if (H <= this.gfb.startY) {
                            this.Bn = false;
                            break;
                        } else if (H > this.gfb.Bu) {
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
        if (this.gfb != null) {
            if (this.Bi.getHeight() >= this.gfb.Bu - (this.Br / 2)) {
                kh();
            } else if (this.gfc != null) {
                this.gfc.ki();
            }
            this.mScroller.startScroll(0, this.Bi.getHeight(), 0, this.gfb.startY - this.Bi.getHeight(), 200);
            invalidate();
        }
    }

    public void kh() {
        if (this.gfc != null) {
            this.gfc.kj();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gfc = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void kv() {
        if (this.gfg) {
            super.kv();
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
            this.mHandler.removeCallbacks(this.gfh);
            this.mHandler.postDelayed(this.gfh, 200L);
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
        if (this.gfg) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.bGW - currY) > this.Bq * 2) {
                this.bGW = currY;
                this.Bi.setLayoutParams(new AbsListView.LayoutParams(this.Bi.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Br);
        if (this.gfc != null) {
            this.gfc.G(f2);
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
