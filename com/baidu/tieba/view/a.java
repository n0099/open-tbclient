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
    private View auR;
    private int auS;
    private float auT;
    private float auU;
    private boolean auW;
    private final int auZ;
    private final int ava;
    private Runnable hyA;
    private int hyB;
    private b hyv;
    public InterfaceC0167a hyw;
    private long hyx;
    private long hyy;
    private boolean hyz;
    private Handler mHandler;
    private final Scroller mScroller;

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0167a {
        void L(float f);

        void onRefresh();

        void su();
    }

    public void setStarForum(boolean z) {
        this.hyz = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hyz) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.auR == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.auU = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hyx = System.currentTimeMillis() - this.hyy;
                    this.hyy = System.currentTimeMillis();
                    this.auW = false;
                    setClickEventEnabled(true);
                    if (this.auS == 0) {
                        this.auS = this.auR.getHeight();
                    }
                    int height = this.auR.getHeight();
                    this.auT = this.auU;
                    this.hyv = new b(0, height, 0, this.ava + height);
                    break;
                case 1:
                case 3:
                    if (this.auW) {
                        setClickEventEnabled(false);
                        ss();
                        this.auW = false;
                    } else if (this.hyw != null) {
                        this.hyw.su();
                    }
                    this.mHandler.removeCallbacks(this.hyA);
                    this.mHandler.postDelayed(this.hyA, 200L);
                    break;
                case 2:
                    float f = this.auU - this.auT;
                    if (this.auR.getParent() == this && this.hyv != null && this.auR.isShown() && this.auR.getTop() >= 0 && Math.abs(f) >= this.auZ && this.hyx > 400) {
                        int M = this.hyv.M(this.auU - this.auT);
                        if (M > this.hyv.startY && M <= this.hyv.endY) {
                            this.auW = true;
                            setClickEventEnabled(false);
                            this.auR.setLayoutParams(new AbsListView.LayoutParams(this.auR.getWidth(), M));
                            K(M - this.hyv.startY);
                            break;
                        } else if (M <= this.hyv.startY) {
                            this.auW = false;
                            break;
                        } else if (M > this.hyv.endY) {
                            this.auW = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.auW = false;
                            break;
                        }
                    } else {
                        this.auW = false;
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
        if (this.auW) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auW) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ss() {
        if (this.hyv != null) {
            if (this.auR.getHeight() >= this.hyv.endY - (this.ava / 2)) {
                st();
            } else if (this.hyw != null) {
                this.hyw.su();
            }
            this.mScroller.startScroll(0, this.auR.getHeight(), 0, this.hyv.startY - this.auR.getHeight(), 200);
            invalidate();
        }
    }

    public void st() {
        if (this.hyw != null) {
            this.hyw.onRefresh();
        }
    }

    public void setPersonListRefreshListener(InterfaceC0167a interfaceC0167a) {
        this.hyw = interfaceC0167a;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hyz) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.auR != null && !this.auW) {
            this.auW = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.ava, 0, -this.ava, 200);
            st();
            invalidate();
            this.mHandler.removeCallbacks(this.hyA);
            this.mHandler.postDelayed(this.hyA, 200L);
            this.auW = false;
        }
    }

    private int getOriginalHeight() {
        if (this.auS <= 0) {
            this.auS = this.auR.getHeight();
        }
        return this.auS;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hyz) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hyB - currY) > this.auZ * 2) {
                this.hyB = currY;
                this.auR.setLayoutParams(new AbsListView.LayoutParams(this.auR.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void K(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.ava);
        if (this.hyw != null) {
            this.hyw.L(f2);
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
