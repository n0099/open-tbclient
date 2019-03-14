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
    private long cHe;
    private b jhp;
    public a jhq;
    private long jhr;
    private boolean jhs;
    private Runnable jht;
    private int jhu;
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
        this.jhs = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OU = false;
        this.jhr = 0L;
        this.cHe = 0L;
        this.mHandler = new Handler();
        this.jhs = false;
        this.jht = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.OQ > 0) {
                    BdExpandListView.this.OP.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.OP.getWidth(), BdExpandListView.this.OQ));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.jhu = 0;
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
        if (this.jhs) {
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
                    this.jhr = System.currentTimeMillis() - this.cHe;
                    this.cHe = System.currentTimeMillis();
                    this.OU = false;
                    setClickEventEnabled(true);
                    if (this.OQ == 0) {
                        this.OQ = this.OP.getHeight();
                    }
                    int height = this.OP.getHeight();
                    this.startY = this.OR;
                    this.jhp = new b(0, height, 0, this.OX + height);
                    break;
                case 1:
                case 3:
                    if (this.OU) {
                        setClickEventEnabled(false);
                        oJ();
                        this.OU = false;
                    } else if (this.jhq != null) {
                        this.jhq.oL();
                    }
                    this.mHandler.removeCallbacks(this.jht);
                    this.mHandler.postDelayed(this.jht, 200L);
                    break;
                case 2:
                    float f = this.OR - this.startY;
                    if (this.OP.getParent() == this && this.jhp != null && this.OP.isShown() && this.OP.getTop() >= 0 && Math.abs(f) >= this.OW && this.jhr > 400) {
                        int O = this.jhp.O(this.OR - this.startY);
                        if (O > this.jhp.startY && O <= this.jhp.endY) {
                            this.OU = true;
                            setClickEventEnabled(false);
                            this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), O));
                            M(O - this.jhp.startY);
                            break;
                        } else if (O <= this.jhp.startY) {
                            this.OU = false;
                            break;
                        } else if (O > this.jhp.endY) {
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
        if (this.jhp != null) {
            if (this.OP.getHeight() >= this.jhp.endY - (this.OX / 2)) {
                oK();
            } else if (this.jhq != null) {
                this.jhq.oL();
            }
            this.mScroller.startScroll(0, this.OP.getHeight(), 0, this.jhp.startY - this.OP.getHeight(), 200);
            invalidate();
        }
    }

    public void oK() {
        if (this.jhq != null) {
            this.jhq.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.jhq = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.jhs) {
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
            this.mHandler.removeCallbacks(this.jht);
            this.mHandler.postDelayed(this.jht, 200L);
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
        if (this.jhs) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.jhu - currY) > this.OW * 2) {
                this.jhu = currY;
                this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.OX);
        if (this.jhq != null) {
            this.jhq.N(f2);
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
