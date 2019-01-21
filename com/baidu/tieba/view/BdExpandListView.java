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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private boolean OA;
    private final int OC;
    private final int OD;
    private View Ow;
    private int Ox;
    private float Oy;
    private long bvX;
    private b hQR;
    public a hQS;
    private long hQT;
    private boolean hQU;
    private Runnable hQV;
    private int hQW;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void oG();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.hQU = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OA = false;
        this.hQT = 0L;
        this.bvX = 0L;
        this.mHandler = new Handler();
        this.hQU = false;
        this.hQV = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Ox > 0) {
                    BdExpandListView.this.Ow.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Ow.getWidth(), BdExpandListView.this.Ox));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.hQW = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.OC = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandListView);
        this.OD = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Ow = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hQU) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Ow == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Oy = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hQT = System.currentTimeMillis() - this.bvX;
                    this.bvX = System.currentTimeMillis();
                    this.OA = false;
                    setClickEventEnabled(true);
                    if (this.Ox == 0) {
                        this.Ox = this.Ow.getHeight();
                    }
                    int height = this.Ow.getHeight();
                    this.startY = this.Oy;
                    this.hQR = new b(0, height, 0, this.OD + height);
                    break;
                case 1:
                case 3:
                    if (this.OA) {
                        setClickEventEnabled(false);
                        oE();
                        this.OA = false;
                    } else if (this.hQS != null) {
                        this.hQS.oG();
                    }
                    this.mHandler.removeCallbacks(this.hQV);
                    this.mHandler.postDelayed(this.hQV, 200L);
                    break;
                case 2:
                    float f = this.Oy - this.startY;
                    if (this.Ow.getParent() == this && this.hQR != null && this.Ow.isShown() && this.Ow.getTop() >= 0 && Math.abs(f) >= this.OC && this.hQT > 400) {
                        int O = this.hQR.O(this.Oy - this.startY);
                        if (O > this.hQR.startY && O <= this.hQR.endY) {
                            this.OA = true;
                            setClickEventEnabled(false);
                            this.Ow.setLayoutParams(new AbsListView.LayoutParams(this.Ow.getWidth(), O));
                            M(O - this.hQR.startY);
                            break;
                        } else if (O <= this.hQR.startY) {
                            this.OA = false;
                            break;
                        } else if (O > this.hQR.endY) {
                            this.OA = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.OA = false;
                            break;
                        }
                    } else {
                        this.OA = false;
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
        if (this.OA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OA) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oE() {
        if (this.hQR != null) {
            if (this.Ow.getHeight() >= this.hQR.endY - (this.OD / 2)) {
                oF();
            } else if (this.hQS != null) {
                this.hQS.oG();
            }
            this.mScroller.startScroll(0, this.Ow.getHeight(), 0, this.hQR.startY - this.Ow.getHeight(), 200);
            invalidate();
        }
    }

    public void oF() {
        if (this.hQS != null) {
            this.hQS.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hQS = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hQU) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Ow != null && !this.OA) {
            this.OA = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.OD, 0, -this.OD, 200);
            oF();
            invalidate();
            this.mHandler.removeCallbacks(this.hQV);
            this.mHandler.postDelayed(this.hQV, 200L);
            this.OA = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Ox <= 0) {
            this.Ox = this.Ow.getHeight();
        }
        return this.Ox;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hQU) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hQW - currY) > this.OC * 2) {
                this.hQW = currY;
                this.Ow.setLayoutParams(new AbsListView.LayoutParams(this.Ow.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.OD);
        if (this.hQS != null) {
            this.hQS.N(f2);
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

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
