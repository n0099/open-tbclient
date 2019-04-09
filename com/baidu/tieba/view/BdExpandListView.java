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
    private View OP;
    private int OQ;
    private float OR;
    private boolean OU;
    private final int OW;
    private final int OX;
    private long cHh;
    private b jhe;
    public a jhf;
    private long jhg;
    private boolean jhh;
    private Runnable jhi;
    private int jhj;
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
        this.jhh = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OU = false;
        this.jhg = 0L;
        this.cHh = 0L;
        this.mHandler = new Handler();
        this.jhh = false;
        this.jhi = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.OQ > 0) {
                    BdExpandListView.this.OP.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.OP.getWidth(), BdExpandListView.this.OQ));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.jhj = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.OW = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.OX = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.OP = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.jhh) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.OP == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.OR = motionEvent.getY();
            switch (action) {
                case 0:
                    this.jhg = System.currentTimeMillis() - this.cHh;
                    this.cHh = System.currentTimeMillis();
                    this.OU = false;
                    setClickEventEnabled(true);
                    if (this.OQ == 0) {
                        this.OQ = this.OP.getHeight();
                    }
                    int height = this.OP.getHeight();
                    this.startY = this.OR;
                    this.jhe = new b(0, height, 0, this.OX + height);
                    break;
                case 1:
                case 3:
                    if (this.OU) {
                        setClickEventEnabled(false);
                        oJ();
                        this.OU = false;
                    } else if (this.jhf != null) {
                        this.jhf.oL();
                    }
                    this.mHandler.removeCallbacks(this.jhi);
                    this.mHandler.postDelayed(this.jhi, 200L);
                    break;
                case 2:
                    float f = this.OR - this.startY;
                    if (this.OP.getParent() == this && this.jhe != null && this.OP.isShown() && this.OP.getTop() >= 0 && Math.abs(f) >= this.OW && this.jhg > 400) {
                        int O = this.jhe.O(this.OR - this.startY);
                        if (O > this.jhe.startY && O <= this.jhe.endY) {
                            this.OU = true;
                            setClickEventEnabled(false);
                            this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), O));
                            M(O - this.jhe.startY);
                            break;
                        } else if (O <= this.jhe.startY) {
                            this.OU = false;
                            break;
                        } else if (O > this.jhe.endY) {
                            this.OU = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.OU = false;
                            break;
                        }
                    } else {
                        this.OU = false;
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
        if (this.OU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OU) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oJ() {
        if (this.jhe != null) {
            if (this.OP.getHeight() >= this.jhe.endY - (this.OX / 2)) {
                oK();
            } else if (this.jhf != null) {
                this.jhf.oL();
            }
            this.mScroller.startScroll(0, this.OP.getHeight(), 0, this.jhe.startY - this.OP.getHeight(), 200);
            invalidate();
        }
    }

    public void oK() {
        if (this.jhf != null) {
            this.jhf.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.jhf = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.jhh) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.OP != null && !this.OU) {
            this.OU = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.OX, 0, -this.OX, 200);
            oK();
            invalidate();
            this.mHandler.removeCallbacks(this.jhi);
            this.mHandler.postDelayed(this.jhi, 200L);
            this.OU = false;
        }
    }

    private int getOriginalHeight() {
        if (this.OQ <= 0) {
            this.OQ = this.OP.getHeight();
        }
        return this.OQ;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.jhh) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.jhj - currY) > this.OW * 2) {
                this.jhj = currY;
                this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.OX);
        if (this.jhf != null) {
            this.jhf.N(f2);
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
