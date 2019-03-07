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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View OO;
    private int OP;
    private float OQ;
    private boolean OT;
    private final int OV;
    private final int OW;
    private long cHh;
    private b jhd;
    public a jhe;
    private long jhf;
    private boolean jhg;
    private Runnable jhh;
    private int jhi;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void oL();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.jhg = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OT = false;
        this.jhf = 0L;
        this.cHh = 0L;
        this.mHandler = new Handler();
        this.jhg = false;
        this.jhh = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.OP > 0) {
                    BdExpandListView.this.OO.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.OO.getWidth(), BdExpandListView.this.OP));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.jhi = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.OV = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.OW = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.OO = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.jhg) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.OO == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.OQ = motionEvent.getY();
            switch (action) {
                case 0:
                    this.jhf = System.currentTimeMillis() - this.cHh;
                    this.cHh = System.currentTimeMillis();
                    this.OT = false;
                    setClickEventEnabled(true);
                    if (this.OP == 0) {
                        this.OP = this.OO.getHeight();
                    }
                    int height = this.OO.getHeight();
                    this.startY = this.OQ;
                    this.jhd = new b(0, height, 0, this.OW + height);
                    break;
                case 1:
                case 3:
                    if (this.OT) {
                        setClickEventEnabled(false);
                        oJ();
                        this.OT = false;
                    } else if (this.jhe != null) {
                        this.jhe.oL();
                    }
                    this.mHandler.removeCallbacks(this.jhh);
                    this.mHandler.postDelayed(this.jhh, 200L);
                    break;
                case 2:
                    float f = this.OQ - this.startY;
                    if (this.OO.getParent() == this && this.jhd != null && this.OO.isShown() && this.OO.getTop() >= 0 && Math.abs(f) >= this.OV && this.jhf > 400) {
                        int O = this.jhd.O(this.OQ - this.startY);
                        if (O > this.jhd.startY && O <= this.jhd.endY) {
                            this.OT = true;
                            setClickEventEnabled(false);
                            this.OO.setLayoutParams(new AbsListView.LayoutParams(this.OO.getWidth(), O));
                            M(O - this.jhd.startY);
                            break;
                        } else if (O <= this.jhd.startY) {
                            this.OT = false;
                            break;
                        } else if (O > this.jhd.endY) {
                            this.OT = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.OT = false;
                            break;
                        }
                    } else {
                        this.OT = false;
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
        if (this.OT) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OT) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oJ() {
        if (this.jhd != null) {
            if (this.OO.getHeight() >= this.jhd.endY - (this.OW / 2)) {
                oK();
            } else if (this.jhe != null) {
                this.jhe.oL();
            }
            this.mScroller.startScroll(0, this.OO.getHeight(), 0, this.jhd.startY - this.OO.getHeight(), 200);
            invalidate();
        }
    }

    public void oK() {
        if (this.jhe != null) {
            this.jhe.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.jhe = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.jhg) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.OO != null && !this.OT) {
            this.OT = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.OW, 0, -this.OW, 200);
            oK();
            invalidate();
            this.mHandler.removeCallbacks(this.jhh);
            this.mHandler.postDelayed(this.jhh, 200L);
            this.OT = false;
        }
    }

    private int getOriginalHeight() {
        if (this.OP <= 0) {
            this.OP = this.OO.getHeight();
        }
        return this.OP;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.jhg) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.jhi - currY) > this.OV * 2) {
                this.jhi = currY;
                this.OO.setLayoutParams(new AbsListView.LayoutParams(this.OO.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.OW);
        if (this.jhe != null) {
            this.jhe.N(f2);
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
