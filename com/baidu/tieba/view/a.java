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
    private View auO;
    private int auP;
    private float auQ;
    private float auR;
    private boolean auT;
    private final int auW;
    private final int auX;
    private b hyb;
    public InterfaceC0166a hyc;
    private long hyd;
    private long hye;
    private boolean hyf;
    private Runnable hyg;
    private int hyh;
    private Handler mHandler;
    private final Scroller mScroller;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0166a {
        void L(float f);

        void onRefresh();

        void st();
    }

    public void setStarForum(boolean z) {
        this.hyf = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hyf) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.auO == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.auR = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hyd = System.currentTimeMillis() - this.hye;
                    this.hye = System.currentTimeMillis();
                    this.auT = false;
                    setClickEventEnabled(true);
                    if (this.auP == 0) {
                        this.auP = this.auO.getHeight();
                    }
                    int height = this.auO.getHeight();
                    this.auQ = this.auR;
                    this.hyb = new b(0, height, 0, this.auX + height);
                    break;
                case 1:
                case 3:
                    if (this.auT) {
                        setClickEventEnabled(false);
                        sr();
                        this.auT = false;
                    } else if (this.hyc != null) {
                        this.hyc.st();
                    }
                    this.mHandler.removeCallbacks(this.hyg);
                    this.mHandler.postDelayed(this.hyg, 200L);
                    break;
                case 2:
                    float f = this.auR - this.auQ;
                    if (this.auO.getParent() == this && this.hyb != null && this.auO.isShown() && this.auO.getTop() >= 0 && Math.abs(f) >= this.auW && this.hyd > 400) {
                        int M = this.hyb.M(this.auR - this.auQ);
                        if (M > this.hyb.startY && M <= this.hyb.endY) {
                            this.auT = true;
                            setClickEventEnabled(false);
                            this.auO.setLayoutParams(new AbsListView.LayoutParams(this.auO.getWidth(), M));
                            K(M - this.hyb.startY);
                            break;
                        } else if (M <= this.hyb.startY) {
                            this.auT = false;
                            break;
                        } else if (M > this.hyb.endY) {
                            this.auT = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.auT = false;
                            break;
                        }
                    } else {
                        this.auT = false;
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
        if (this.auT) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auT) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sr() {
        if (this.hyb != null) {
            if (this.auO.getHeight() >= this.hyb.endY - (this.auX / 2)) {
                ss();
            } else if (this.hyc != null) {
                this.hyc.st();
            }
            this.mScroller.startScroll(0, this.auO.getHeight(), 0, this.hyb.startY - this.auO.getHeight(), 200);
            invalidate();
        }
    }

    public void ss() {
        if (this.hyc != null) {
            this.hyc.onRefresh();
        }
    }

    public void setPersonListRefreshListener(InterfaceC0166a interfaceC0166a) {
        this.hyc = interfaceC0166a;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hyf) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.auO != null && !this.auT) {
            this.auT = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.auX, 0, -this.auX, 200);
            ss();
            invalidate();
            this.mHandler.removeCallbacks(this.hyg);
            this.mHandler.postDelayed(this.hyg, 200L);
            this.auT = false;
        }
    }

    private int getOriginalHeight() {
        if (this.auP <= 0) {
            this.auP = this.auO.getHeight();
        }
        return this.auP;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hyf) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hyh - currY) > this.auW * 2) {
                this.hyh = currY;
                this.auO.setLayoutParams(new AbsListView.LayoutParams(this.auO.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void K(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.auX);
        if (this.hyc != null) {
            this.hyc.L(f2);
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

        public int M(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
