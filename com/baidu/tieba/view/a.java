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
    private View auE;
    private int auF;
    private float auG;
    private float auH;
    private boolean auJ;
    private final int auM;
    private final int auN;
    private b hAm;
    public InterfaceC0250a hAn;
    private long hAo;
    private long hAp;
    private boolean hAq;
    private Runnable hAr;
    private int hAs;
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
        this.hAq = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hAq) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.auE == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.auH = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hAo = System.currentTimeMillis() - this.hAp;
                    this.hAp = System.currentTimeMillis();
                    this.auJ = false;
                    setClickEventEnabled(true);
                    if (this.auF == 0) {
                        this.auF = this.auE.getHeight();
                    }
                    int height = this.auE.getHeight();
                    this.auG = this.auH;
                    this.hAm = new b(0, height, 0, this.auN + height);
                    break;
                case 1:
                case 3:
                    if (this.auJ) {
                        setClickEventEnabled(false);
                        sq();
                        this.auJ = false;
                    } else if (this.hAn != null) {
                        this.hAn.ss();
                    }
                    this.mHandler.removeCallbacks(this.hAr);
                    this.mHandler.postDelayed(this.hAr, 200L);
                    break;
                case 2:
                    float f = this.auH - this.auG;
                    if (this.auE.getParent() == this && this.hAm != null && this.auE.isShown() && this.auE.getTop() >= 0 && Math.abs(f) >= this.auM && this.hAo > 400) {
                        int Q = this.hAm.Q(this.auH - this.auG);
                        if (Q > this.hAm.startY && Q <= this.hAm.endY) {
                            this.auJ = true;
                            setClickEventEnabled(false);
                            this.auE.setLayoutParams(new AbsListView.LayoutParams(this.auE.getWidth(), Q));
                            O(Q - this.hAm.startY);
                            break;
                        } else if (Q <= this.hAm.startY) {
                            this.auJ = false;
                            break;
                        } else if (Q > this.hAm.endY) {
                            this.auJ = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.auJ = false;
                            break;
                        }
                    } else {
                        this.auJ = false;
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
        if (this.auJ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auJ) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sq() {
        if (this.hAm != null) {
            if (this.auE.getHeight() >= this.hAm.endY - (this.auN / 2)) {
                sr();
            } else if (this.hAn != null) {
                this.hAn.ss();
            }
            this.mScroller.startScroll(0, this.auE.getHeight(), 0, this.hAm.startY - this.auE.getHeight(), 200);
            invalidate();
        }
    }

    public void sr() {
        if (this.hAn != null) {
            this.hAn.onRefresh();
        }
    }

    public void setPersonListRefreshListener(InterfaceC0250a interfaceC0250a) {
        this.hAn = interfaceC0250a;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hAq) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.auE != null && !this.auJ) {
            this.auJ = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.auN, 0, -this.auN, 200);
            sr();
            invalidate();
            this.mHandler.removeCallbacks(this.hAr);
            this.mHandler.postDelayed(this.hAr, 200L);
            this.auJ = false;
        }
    }

    private int getOriginalHeight() {
        if (this.auF <= 0) {
            this.auF = this.auE.getHeight();
        }
        return this.auF;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hAq) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hAs - currY) > this.auM * 2) {
                this.hAs = currY;
                this.auE.setLayoutParams(new AbsListView.LayoutParams(this.auE.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void O(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.auN);
        if (this.hAn != null) {
            this.hAn.P(f2);
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
