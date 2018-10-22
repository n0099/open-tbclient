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
    private View Ok;
    private int Ol;
    private float Om;
    private float On;
    private boolean Op;
    private final int Os;
    private final int Ot;
    private long bqU;
    private b hDD;
    public a hDE;
    private long hDF;
    private boolean hDG;
    private Runnable hDH;
    private int hDI;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void oF();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.hDG = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Op = false;
        this.hDF = 0L;
        this.bqU = 0L;
        this.mHandler = new Handler();
        this.hDG = false;
        this.hDH = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Ol > 0) {
                    BdExpandListView.this.Ok.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Ok.getWidth(), BdExpandListView.this.Ol));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.hDI = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Os = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandListView);
        this.Ot = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Ok = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hDG) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Ok == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.On = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hDF = System.currentTimeMillis() - this.bqU;
                    this.bqU = System.currentTimeMillis();
                    this.Op = false;
                    setClickEventEnabled(true);
                    if (this.Ol == 0) {
                        this.Ol = this.Ok.getHeight();
                    }
                    int height = this.Ok.getHeight();
                    this.Om = this.On;
                    this.hDD = new b(0, height, 0, this.Ot + height);
                    break;
                case 1:
                case 3:
                    if (this.Op) {
                        setClickEventEnabled(false);
                        oD();
                        this.Op = false;
                    } else if (this.hDE != null) {
                        this.hDE.oF();
                    }
                    this.mHandler.removeCallbacks(this.hDH);
                    this.mHandler.postDelayed(this.hDH, 200L);
                    break;
                case 2:
                    float f = this.On - this.Om;
                    if (this.Ok.getParent() == this && this.hDD != null && this.Ok.isShown() && this.Ok.getTop() >= 0 && Math.abs(f) >= this.Os && this.hDF > 400) {
                        int O = this.hDD.O(this.On - this.Om);
                        if (O > this.hDD.startY && O <= this.hDD.endY) {
                            this.Op = true;
                            setClickEventEnabled(false);
                            this.Ok.setLayoutParams(new AbsListView.LayoutParams(this.Ok.getWidth(), O));
                            M(O - this.hDD.startY);
                            break;
                        } else if (O <= this.hDD.startY) {
                            this.Op = false;
                            break;
                        } else if (O > this.hDD.endY) {
                            this.Op = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Op = false;
                            break;
                        }
                    } else {
                        this.Op = false;
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
        if (this.Op) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Op) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oD() {
        if (this.hDD != null) {
            if (this.Ok.getHeight() >= this.hDD.endY - (this.Ot / 2)) {
                oE();
            } else if (this.hDE != null) {
                this.hDE.oF();
            }
            this.mScroller.startScroll(0, this.Ok.getHeight(), 0, this.hDD.startY - this.Ok.getHeight(), 200);
            invalidate();
        }
    }

    public void oE() {
        if (this.hDE != null) {
            this.hDE.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hDE = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hDG) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Ok != null && !this.Op) {
            this.Op = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Ot, 0, -this.Ot, 200);
            oE();
            invalidate();
            this.mHandler.removeCallbacks(this.hDH);
            this.mHandler.postDelayed(this.hDH, 200L);
            this.Op = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Ol <= 0) {
            this.Ol = this.Ok.getHeight();
        }
        return this.Ol;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hDG) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hDI - currY) > this.Os * 2) {
                this.hDI = currY;
                this.Ok.setLayoutParams(new AbsListView.LayoutParams(this.Ok.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Ot);
        if (this.hDE != null) {
            this.hDE.N(f2);
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
