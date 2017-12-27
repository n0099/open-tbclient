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
    private View auP;
    private int auQ;
    private float auR;
    private float auS;
    private boolean auU;
    private final int auX;
    private final int auY;
    private int hIA;
    private b hIu;
    public InterfaceC0167a hIv;
    private long hIw;
    private long hIx;
    private boolean hIy;
    private Runnable hIz;
    private Handler mHandler;
    private final Scroller mScroller;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0167a {
        void L(float f);

        void onRefresh();

        void st();
    }

    public void setStarForum(boolean z) {
        this.hIy = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hIy) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.auP == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.auS = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hIw = System.currentTimeMillis() - this.hIx;
                    this.hIx = System.currentTimeMillis();
                    this.auU = false;
                    setClickEventEnabled(true);
                    if (this.auQ == 0) {
                        this.auQ = this.auP.getHeight();
                    }
                    int height = this.auP.getHeight();
                    this.auR = this.auS;
                    this.hIu = new b(0, height, 0, this.auY + height);
                    break;
                case 1:
                case 3:
                    if (this.auU) {
                        setClickEventEnabled(false);
                        sr();
                        this.auU = false;
                    } else if (this.hIv != null) {
                        this.hIv.st();
                    }
                    this.mHandler.removeCallbacks(this.hIz);
                    this.mHandler.postDelayed(this.hIz, 200L);
                    break;
                case 2:
                    float f = this.auS - this.auR;
                    if (this.auP.getParent() == this && this.hIu != null && this.auP.isShown() && this.auP.getTop() >= 0 && Math.abs(f) >= this.auX && this.hIw > 400) {
                        int M = this.hIu.M(this.auS - this.auR);
                        if (M > this.hIu.startY && M <= this.hIu.endY) {
                            this.auU = true;
                            setClickEventEnabled(false);
                            this.auP.setLayoutParams(new AbsListView.LayoutParams(this.auP.getWidth(), M));
                            K(M - this.hIu.startY);
                            break;
                        } else if (M <= this.hIu.startY) {
                            this.auU = false;
                            break;
                        } else if (M > this.hIu.endY) {
                            this.auU = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.auU = false;
                            break;
                        }
                    } else {
                        this.auU = false;
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
        if (this.auU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auU) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sr() {
        if (this.hIu != null) {
            if (this.auP.getHeight() >= this.hIu.endY - (this.auY / 2)) {
                ss();
            } else if (this.hIv != null) {
                this.hIv.st();
            }
            this.mScroller.startScroll(0, this.auP.getHeight(), 0, this.hIu.startY - this.auP.getHeight(), 200);
            invalidate();
        }
    }

    public void ss() {
        if (this.hIv != null) {
            this.hIv.onRefresh();
        }
    }

    public void setPersonListRefreshListener(InterfaceC0167a interfaceC0167a) {
        this.hIv = interfaceC0167a;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hIy) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.auP != null && !this.auU) {
            this.auU = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.auY, 0, -this.auY, 200);
            ss();
            invalidate();
            this.mHandler.removeCallbacks(this.hIz);
            this.mHandler.postDelayed(this.hIz, 200L);
            this.auU = false;
        }
    }

    private int getOriginalHeight() {
        if (this.auQ <= 0) {
            this.auQ = this.auP.getHeight();
        }
        return this.auQ;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hIy) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hIA - currY) > this.auX * 2) {
                this.hIA = currY;
                this.auP.setLayoutParams(new AbsListView.LayoutParams(this.auP.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void K(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.auY);
        if (this.hIv != null) {
            this.hIv.L(f2);
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
