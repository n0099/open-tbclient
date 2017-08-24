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
    private View Ji;
    private int Jj;
    private float Jk;
    private float Jl;
    private boolean Jn;
    private final int Jq;
    private final int Jr;
    private long gdM;
    private b gxh;
    public a gxi;
    private long gxj;
    private boolean gxk;
    private boolean gxl;
    private Runnable gxm;
    private int gxn;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void lh();

        void li();
    }

    public void setStarForum(boolean z) {
        this.gxl = z;
    }

    public boolean bsf() {
        return this.gxl;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Jn = false;
        this.gxj = 0L;
        this.gdM = 0L;
        this.mHandler = new Handler();
        this.gxk = false;
        this.gxl = false;
        this.gxm = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Jj > 0) {
                    BdExpandListView.this.Ji.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Ji.getWidth(), BdExpandListView.this.Jj));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gxn = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Jq = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.Jr = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Ji = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gxl) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Ji == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Jl = motionEvent.getY();
            switch (action) {
                case 0:
                    this.gxj = System.currentTimeMillis() - this.gdM;
                    this.gdM = System.currentTimeMillis();
                    this.Jn = false;
                    setClickEventEnabled(true);
                    if (this.Jj == 0) {
                        this.Jj = this.Ji.getHeight();
                    }
                    int height = this.Ji.getHeight();
                    this.Jk = this.Jl;
                    this.gxh = new b(0, height, 0, this.Jr + height);
                    break;
                case 1:
                case 3:
                    if (this.Jn) {
                        setClickEventEnabled(false);
                        lf();
                        this.Jn = false;
                    } else if (this.gxi != null) {
                        this.gxi.lh();
                    }
                    this.mHandler.removeCallbacks(this.gxm);
                    this.mHandler.postDelayed(this.gxm, 200L);
                    break;
                case 2:
                    float f = this.Jl - this.Jk;
                    if (this.Ji.getParent() == this && this.gxh != null && this.Ji.isShown() && this.Ji.getTop() >= 0 && Math.abs(f) >= this.Jq && this.gxj > 400) {
                        int H = this.gxh.H(this.Jl - this.Jk);
                        if (H > this.gxh.Jv && H <= this.gxh.Jx) {
                            this.Jn = true;
                            setClickEventEnabled(false);
                            this.Ji.setLayoutParams(new AbsListView.LayoutParams(this.Ji.getWidth(), H));
                            F(H - this.gxh.Jv);
                            break;
                        } else if (H <= this.gxh.Jv) {
                            this.Jn = false;
                            break;
                        } else if (H > this.gxh.Jx) {
                            this.Jn = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Jn = false;
                            break;
                        }
                    } else {
                        this.Jn = false;
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
        if (this.Jn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jn) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lf() {
        if (this.gxh != null) {
            if (this.Ji.getHeight() >= this.gxh.Jx - (this.Jr / 2)) {
                lg();
            } else if (this.gxi != null) {
                this.gxi.lh();
            }
            this.mScroller.startScroll(0, this.Ji.getHeight(), 0, this.gxh.Jv - this.Ji.getHeight(), 200);
            invalidate();
        }
    }

    public void lg() {
        if (this.gxi != null) {
            this.gxi.li();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gxi = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gxl) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Ji != null && !this.Jn) {
            this.Jn = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Jr, 0, -this.Jr, 200);
            lg();
            invalidate();
            this.mHandler.removeCallbacks(this.gxm);
            this.mHandler.postDelayed(this.gxm, 200L);
            this.Jn = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Jj <= 0) {
            this.Jj = this.Ji.getHeight();
        }
        return this.Jj;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.gxl) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gxn - currY) > this.Jq * 2) {
                this.gxn = currY;
                this.Ji.setLayoutParams(new AbsListView.LayoutParams(this.Ji.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Jr);
        if (this.gxi != null) {
            this.gxi.G(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Ju;
        public int Jv;
        public int Jw;
        public int Jx;

        public b(int i, int i2, int i3, int i4) {
            this.Ju = i;
            this.Jv = i2;
            this.Jw = i3;
            this.Jx = i4;
        }

        public int H(float f) {
            return (int) (this.Jv + (f / 2.5f));
        }
    }
}
