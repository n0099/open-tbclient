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
    private View Ie;
    private int If;
    private float Ig;
    private float Ih;
    private boolean Ij;
    private final int Im;
    private final int In;
    private b fHs;
    public a fHt;
    private long fHu;
    private long fHv;
    private boolean fHw;
    private boolean fHx;
    private Runnable fHy;
    private int fHz;
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
        this.fHx = z;
    }

    public boolean bgF() {
        return this.fHx;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ij = false;
        this.fHu = 0L;
        this.fHv = 0L;
        this.mHandler = new Handler();
        this.fHw = false;
        this.fHx = false;
        this.fHy = new com.baidu.tieba.view.b(this);
        this.fHz = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Im = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.ExpandListView);
        this.In = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Ie = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fHx) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Ie == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Ih = motionEvent.getY();
            switch (action) {
                case 0:
                    this.fHu = System.currentTimeMillis() - this.fHv;
                    this.fHv = System.currentTimeMillis();
                    this.Ij = false;
                    setClickEventEnabled(true);
                    if (this.If == 0) {
                        this.If = this.Ie.getHeight();
                    }
                    int height = this.Ie.getHeight();
                    this.Ig = this.Ih;
                    this.fHs = new b(0, height, 0, this.In + height);
                    break;
                case 1:
                case 3:
                    if (this.Ij) {
                        setClickEventEnabled(false);
                        kW();
                        this.Ij = false;
                    } else if (this.fHt != null) {
                        this.fHt.kY();
                    }
                    this.mHandler.removeCallbacks(this.fHy);
                    this.mHandler.postDelayed(this.fHy, 200L);
                    break;
                case 2:
                    float f = this.Ih - this.Ig;
                    if (this.Ie.getParent() == this && this.fHs != null && this.Ie.isShown() && this.Ie.getTop() >= 0 && Math.abs(f) >= this.Im && this.fHu > 400) {
                        int H = this.fHs.H(this.Ih - this.Ig);
                        if (H > this.fHs.Ir && H <= this.fHs.It) {
                            this.Ij = true;
                            setClickEventEnabled(false);
                            this.Ie.setLayoutParams(new AbsListView.LayoutParams(this.Ie.getWidth(), H));
                            F(H - this.fHs.Ir);
                            break;
                        } else if (H <= this.fHs.Ir) {
                            this.Ij = false;
                            break;
                        } else if (H > this.fHs.It) {
                            this.Ij = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Ij = false;
                            break;
                        }
                    } else {
                        this.Ij = false;
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
        if (this.Ij) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ij) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kW() {
        if (this.fHs != null) {
            if (this.Ie.getHeight() >= this.fHs.It - (this.In / 2)) {
                kX();
            } else if (this.fHt != null) {
                this.fHt.kY();
            }
            this.mScroller.startScroll(0, this.Ie.getHeight(), 0, this.fHs.Ir - this.Ie.getHeight(), 200);
            invalidate();
        }
    }

    public void kX() {
        if (this.fHt != null) {
            this.fHt.kZ();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fHt = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.fHx) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Ie != null && !this.Ij) {
            this.Ij = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.In, 0, -this.In, 200);
            kX();
            invalidate();
            this.mHandler.removeCallbacks(this.fHy);
            this.mHandler.postDelayed(this.fHy, 200L);
            this.Ij = false;
        }
    }

    private int getOriginalHeight() {
        if (this.If <= 0) {
            this.If = this.Ie.getHeight();
        }
        return this.If;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.fHx) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.fHz - currY) > this.Im * 2) {
                this.fHz = currY;
                this.Ie.setLayoutParams(new AbsListView.LayoutParams(this.Ie.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.In);
        if (this.fHt != null) {
            this.fHt.G(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Iq;
        public int Ir;
        public int Is;
        public int It;

        public b(int i, int i2, int i3, int i4) {
            this.Iq = i;
            this.Ir = i2;
            this.Is = i3;
            this.It = i4;
        }

        public int H(float f) {
            return (int) (this.Ir + (f / 2.5f));
        }
    }
}
