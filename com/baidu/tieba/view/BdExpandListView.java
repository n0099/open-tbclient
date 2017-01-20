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
    private View AR;
    private int AS;
    private float AT;
    private float AU;
    private boolean AW;
    private final int AZ;
    private final int Ba;
    private b fCR;
    public a fCS;
    private long fCT;
    private long fCU;
    private boolean fCV;
    private boolean fCW;
    private Runnable fCX;
    private int fCY;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void ke();

        void kf();
    }

    public void setStarForum(boolean z) {
        this.fCW = z;
    }

    public boolean bgS() {
        return this.fCW;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AW = false;
        this.fCT = 0L;
        this.fCU = 0L;
        this.mHandler = new Handler();
        this.fCV = false;
        this.fCW = false;
        this.fCX = new com.baidu.tieba.view.b(this);
        this.fCY = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.AZ = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.n.ExpandListView);
        this.Ba = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.AR = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fCW) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.AR == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.AU = motionEvent.getY();
            switch (action) {
                case 0:
                    this.fCT = System.currentTimeMillis() - this.fCU;
                    this.fCU = System.currentTimeMillis();
                    this.AW = false;
                    setClickEventEnabled(true);
                    if (this.AS == 0) {
                        this.AS = this.AR.getHeight();
                    }
                    int height = this.AR.getHeight();
                    this.AT = this.AU;
                    this.fCR = new b(0, height, 0, this.Ba + height);
                    break;
                case 1:
                case 3:
                    if (this.AW) {
                        setClickEventEnabled(false);
                        kc();
                        this.AW = false;
                    } else if (this.fCS != null) {
                        this.fCS.ke();
                    }
                    this.mHandler.removeCallbacks(this.fCX);
                    this.mHandler.postDelayed(this.fCX, 200L);
                    break;
                case 2:
                    float f = this.AU - this.AT;
                    if (this.AR.getParent() == this && this.fCR != null && this.AR.isShown() && this.AR.getTop() >= 0 && Math.abs(f) >= this.AZ && this.fCT > 400) {
                        int H = this.fCR.H(this.AU - this.AT);
                        if (H > this.fCR.Be && H <= this.fCR.Bg) {
                            this.AW = true;
                            setClickEventEnabled(false);
                            this.AR.setLayoutParams(new AbsListView.LayoutParams(this.AR.getWidth(), H));
                            F(H - this.fCR.Be);
                            break;
                        } else if (H <= this.fCR.Be) {
                            this.AW = false;
                            break;
                        } else if (H > this.fCR.Bg) {
                            this.AW = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.AW = false;
                            break;
                        }
                    } else {
                        this.AW = false;
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
        if (this.AW) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.AW) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kc() {
        if (this.fCR != null) {
            if (this.AR.getHeight() >= this.fCR.Bg - (this.Ba / 2)) {
                kd();
            } else if (this.fCS != null) {
                this.fCS.ke();
            }
            this.mScroller.startScroll(0, this.AR.getHeight(), 0, this.fCR.Be - this.AR.getHeight(), 200);
            invalidate();
        }
    }

    public void kd() {
        if (this.fCS != null) {
            this.fCS.kf();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fCS = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.fCW) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.AR != null && !this.AW) {
            this.AW = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Ba, 0, -this.Ba, 200);
            kd();
            invalidate();
            this.mHandler.removeCallbacks(this.fCX);
            this.mHandler.postDelayed(this.fCX, 200L);
            this.AW = false;
        }
    }

    private int getOriginalHeight() {
        if (this.AS <= 0) {
            this.AS = this.AR.getHeight();
        }
        return this.AS;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.fCW) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.fCY - currY) > this.AZ * 2) {
                this.fCY = currY;
                this.AR.setLayoutParams(new AbsListView.LayoutParams(this.AR.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Ba);
        if (this.fCS != null) {
            this.fCS.G(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Bd;
        public int Be;
        public int Bf;
        public int Bg;

        public b(int i, int i2, int i3, int i4) {
            this.Bd = i;
            this.Be = i2;
            this.Bf = i3;
            this.Bg = i4;
        }

        public int H(float f) {
            return (int) (this.Be + (f / 2.5f));
        }
    }
}
