package com.baidu.tieba.view;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
public class a extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View auM;
    private int auN;
    private float auO;
    private float auP;
    private boolean auR;
    private final int auU;
    private final int auV;
    private b hAb;
    public InterfaceC0249a hAc;
    private long hAd;
    private long hAe;
    private boolean hAf;
    private Runnable hAg;
    private int hAh;
    private Handler mHandler;
    private final Scroller mScroller;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0249a {
        void P(float f);

        void onRefresh();

        void ss();
    }

    public void setStarForum(boolean z) {
        this.hAf = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hAf) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.auM == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.auP = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hAd = System.currentTimeMillis() - this.hAe;
                    this.hAe = System.currentTimeMillis();
                    this.auR = false;
                    setClickEventEnabled(true);
                    if (this.auN == 0) {
                        this.auN = this.auM.getHeight();
                    }
                    int height = this.auM.getHeight();
                    this.auO = this.auP;
                    this.hAb = new b(0, height, 0, this.auV + height);
                    break;
                case 1:
                case 3:
                    if (this.auR) {
                        setClickEventEnabled(false);
                        sq();
                        this.auR = false;
                    } else if (this.hAc != null) {
                        this.hAc.ss();
                    }
                    this.mHandler.removeCallbacks(this.hAg);
                    this.mHandler.postDelayed(this.hAg, 200L);
                    break;
                case 2:
                    float f = this.auP - this.auO;
                    if (this.auM.getParent() == this && this.hAb != null && this.auM.isShown() && this.auM.getTop() >= 0 && Math.abs(f) >= this.auU && this.hAd > 400) {
                        int Q = this.hAb.Q(this.auP - this.auO);
                        if (Q > this.hAb.startY && Q <= this.hAb.endY) {
                            this.auR = true;
                            setClickEventEnabled(false);
                            this.auM.setLayoutParams(new AbsListView.LayoutParams(this.auM.getWidth(), Q));
                            O(Q - this.hAb.startY);
                            break;
                        } else if (Q <= this.hAb.startY) {
                            this.auR = false;
                            break;
                        } else if (Q > this.hAb.endY) {
                            this.auR = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.auR = false;
                            break;
                        }
                    } else {
                        this.auR = false;
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
        if (this.auR) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auR) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sq() {
        if (this.hAb != null) {
            if (this.auM.getHeight() >= this.hAb.endY - (this.auV / 2)) {
                sr();
            } else if (this.hAc != null) {
                this.hAc.ss();
            }
            this.mScroller.startScroll(0, this.auM.getHeight(), 0, this.hAb.startY - this.auM.getHeight(), 200);
            invalidate();
        }
    }

    public void sr() {
        if (this.hAc != null) {
            this.hAc.onRefresh();
        }
    }

    public void setPersonListRefreshListener(InterfaceC0249a interfaceC0249a) {
        this.hAc = interfaceC0249a;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hAf) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.auM != null && !this.auR) {
            this.auR = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.auV, 0, -this.auV, 200);
            sr();
            invalidate();
            this.mHandler.removeCallbacks(this.hAg);
            this.mHandler.postDelayed(this.hAg, 200L);
            this.auR = false;
        }
    }

    private int getOriginalHeight() {
        if (this.auN <= 0) {
            this.auN = this.auM.getHeight();
        }
        return this.auN;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hAf) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hAh - currY) > this.auU * 2) {
                this.hAh = currY;
                this.auM.setLayoutParams(new AbsListView.LayoutParams(this.auM.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void O(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.auV);
        if (this.hAc != null) {
            this.hAc.P(f2);
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

        public int Q(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
