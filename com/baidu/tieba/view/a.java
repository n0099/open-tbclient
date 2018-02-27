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
    private View auD;
    private int auE;
    private float auF;
    private float auG;
    private boolean auI;
    private final int auL;
    private final int auM;
    private b hzO;
    public InterfaceC0250a hzP;
    private long hzQ;
    private long hzR;
    private boolean hzS;
    private Runnable hzT;
    private int hzU;
    private Handler mHandler;
    private final Scroller mScroller;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0250a {
        void P(float f);

        void onRefresh();

        void ss();
    }

    public void setStarForum(boolean z) {
        this.hzS = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hzS) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.auD == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.auG = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hzQ = System.currentTimeMillis() - this.hzR;
                    this.hzR = System.currentTimeMillis();
                    this.auI = false;
                    setClickEventEnabled(true);
                    if (this.auE == 0) {
                        this.auE = this.auD.getHeight();
                    }
                    int height = this.auD.getHeight();
                    this.auF = this.auG;
                    this.hzO = new b(0, height, 0, this.auM + height);
                    break;
                case 1:
                case 3:
                    if (this.auI) {
                        setClickEventEnabled(false);
                        sq();
                        this.auI = false;
                    } else if (this.hzP != null) {
                        this.hzP.ss();
                    }
                    this.mHandler.removeCallbacks(this.hzT);
                    this.mHandler.postDelayed(this.hzT, 200L);
                    break;
                case 2:
                    float f = this.auG - this.auF;
                    if (this.auD.getParent() == this && this.hzO != null && this.auD.isShown() && this.auD.getTop() >= 0 && Math.abs(f) >= this.auL && this.hzQ > 400) {
                        int Q = this.hzO.Q(this.auG - this.auF);
                        if (Q > this.hzO.startY && Q <= this.hzO.endY) {
                            this.auI = true;
                            setClickEventEnabled(false);
                            this.auD.setLayoutParams(new AbsListView.LayoutParams(this.auD.getWidth(), Q));
                            O(Q - this.hzO.startY);
                            break;
                        } else if (Q <= this.hzO.startY) {
                            this.auI = false;
                            break;
                        } else if (Q > this.hzO.endY) {
                            this.auI = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.auI = false;
                            break;
                        }
                    } else {
                        this.auI = false;
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
        if (this.auI) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auI) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sq() {
        if (this.hzO != null) {
            if (this.auD.getHeight() >= this.hzO.endY - (this.auM / 2)) {
                sr();
            } else if (this.hzP != null) {
                this.hzP.ss();
            }
            this.mScroller.startScroll(0, this.auD.getHeight(), 0, this.hzO.startY - this.auD.getHeight(), 200);
            invalidate();
        }
    }

    public void sr() {
        if (this.hzP != null) {
            this.hzP.onRefresh();
        }
    }

    public void setPersonListRefreshListener(InterfaceC0250a interfaceC0250a) {
        this.hzP = interfaceC0250a;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hzS) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.auD != null && !this.auI) {
            this.auI = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.auM, 0, -this.auM, 200);
            sr();
            invalidate();
            this.mHandler.removeCallbacks(this.hzT);
            this.mHandler.postDelayed(this.hzT, 200L);
            this.auI = false;
        }
    }

    private int getOriginalHeight() {
        if (this.auE <= 0) {
            this.auE = this.auD.getHeight();
        }
        return this.auE;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hzS) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hzU - currY) > this.auL * 2) {
                this.hzU = currY;
                this.auD.setLayoutParams(new AbsListView.LayoutParams(this.auD.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void O(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.auM);
        if (this.hzP != null) {
            this.hzP.P(f2);
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
