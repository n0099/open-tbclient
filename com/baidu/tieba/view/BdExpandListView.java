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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    private int bqq;
    private b fAK;
    public a fAL;
    private long fAM;
    private long fAN;
    private boolean fAO;
    private boolean fAP;
    private Runnable fAQ;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;
    private final int yA;
    private final int yB;
    private View ys;
    private int yt;
    private float yu;
    private float yv;
    private boolean yx;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void jo();

        void jp();

        void k(float f);
    }

    public void setStarForum(boolean z) {
        this.fAP = z;
    }

    public boolean bjn() {
        return this.fAP;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yx = false;
        this.fAM = 0L;
        this.fAN = 0L;
        this.mHandler = new Handler();
        this.fAO = false;
        this.fAP = false;
        this.fAQ = new com.baidu.tieba.view.b(this);
        this.bqq = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.yA = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ExpandListView);
        this.yB = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.ys = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fAP) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.ys == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.yv = motionEvent.getY();
            switch (action) {
                case 0:
                    this.fAM = System.currentTimeMillis() - this.fAN;
                    this.fAN = System.currentTimeMillis();
                    this.yx = false;
                    setClickEventEnabled(true);
                    if (this.yt == 0) {
                        this.yt = this.ys.getHeight();
                    }
                    int height = this.ys.getHeight();
                    this.yu = this.yv;
                    this.fAK = new b(0, height, 0, this.yB + height);
                    break;
                case 1:
                case 3:
                    if (this.yx) {
                        setClickEventEnabled(false);
                        jm();
                        this.yx = false;
                    } else if (this.fAL != null) {
                        this.fAL.jo();
                    }
                    this.mHandler.removeCallbacks(this.fAQ);
                    this.mHandler.postDelayed(this.fAQ, 200L);
                    break;
                case 2:
                    float f = this.yv - this.yu;
                    if (this.ys.getParent() == this && this.fAK != null && this.ys.isShown() && this.ys.getTop() >= 0 && Math.abs(f) >= this.yA && this.fAM > 400) {
                        int l = this.fAK.l(this.yv - this.yu);
                        if (l > this.fAK.startY && l <= this.fAK.yE) {
                            this.yx = true;
                            setClickEventEnabled(false);
                            this.ys.setLayoutParams(new AbsListView.LayoutParams(this.ys.getWidth(), l));
                            j(l - this.fAK.startY);
                            break;
                        } else if (l <= this.fAK.startY) {
                            this.yx = false;
                            break;
                        } else if (l > this.fAK.yE) {
                            this.yx = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.yx = false;
                            break;
                        }
                    } else {
                        this.yx = false;
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
        if (this.yx) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.yx) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jm() {
        if (this.fAK != null) {
            if (this.ys.getHeight() >= this.fAK.yE - (this.yB / 2)) {
                jn();
            } else if (this.fAL != null) {
                this.fAL.jo();
            }
            this.mScroller.startScroll(0, this.ys.getHeight(), 0, this.fAK.startY - this.ys.getHeight(), 200);
            invalidate();
        }
    }

    public void jn() {
        if (this.fAL != null) {
            this.fAL.jp();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fAL = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void jB() {
        if (this.fAP) {
            super.jB();
            jn();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.ys != null && !this.yx) {
            this.yx = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.yB, 0, -this.yB, 200);
            jn();
            invalidate();
            this.mHandler.removeCallbacks(this.fAQ);
            this.mHandler.postDelayed(this.fAQ, 200L);
            this.yx = false;
        }
    }

    private int getOriginalHeight() {
        if (this.yt <= 0) {
            this.yt = this.ys.getHeight();
        }
        return this.yt;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.fAP) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.bqq - currY) > this.yA * 2) {
                this.bqq = currY;
                this.ys.setLayoutParams(new AbsListView.LayoutParams(this.ys.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void j(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.yB);
        if (this.fAL != null) {
            this.fAL.k(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int endX;
        public int startX;
        public int startY;
        public int yE;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.yE = i4;
        }

        public int l(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
