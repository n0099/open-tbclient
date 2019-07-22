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
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View MM;
    private int MN;
    private float MO;
    private boolean MQ;
    private final int MS;
    private final int MT;
    private long cQN;
    private b jGl;
    public a jGm;
    private long jGn;
    private boolean jGo;
    private Runnable jGp;
    private int jGq;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void nY();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.jGo = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MQ = false;
        this.jGn = 0L;
        this.cQN = 0L;
        this.mHandler = new Handler();
        this.jGo = false;
        this.jGp = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.MN > 0) {
                    BdExpandListView.this.MM.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.MM.getWidth(), BdExpandListView.this.MN));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.jGq = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.MS = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandListView);
        this.MT = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.MM = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.jGo) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.MM == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.MO = motionEvent.getY();
            switch (action) {
                case 0:
                    this.jGn = System.currentTimeMillis() - this.cQN;
                    this.cQN = System.currentTimeMillis();
                    this.MQ = false;
                    setClickEventEnabled(true);
                    if (this.MN == 0) {
                        this.MN = this.MM.getHeight();
                    }
                    int height = this.MM.getHeight();
                    this.startY = this.MO;
                    this.jGl = new b(0, height, 0, this.MT + height);
                    break;
                case 1:
                case 3:
                    if (this.MQ) {
                        setClickEventEnabled(false);
                        nW();
                        this.MQ = false;
                    } else if (this.jGm != null) {
                        this.jGm.nY();
                    }
                    this.mHandler.removeCallbacks(this.jGp);
                    this.mHandler.postDelayed(this.jGp, 200L);
                    break;
                case 2:
                    float f = this.MO - this.startY;
                    if (this.MM.getParent() == this && this.jGl != null && this.MM.isShown() && this.MM.getTop() >= 0 && Math.abs(f) >= this.MS && this.jGn > 400) {
                        int O = this.jGl.O(this.MO - this.startY);
                        if (O > this.jGl.startY && O <= this.jGl.MW) {
                            this.MQ = true;
                            setClickEventEnabled(false);
                            this.MM.setLayoutParams(new AbsListView.LayoutParams(this.MM.getWidth(), O));
                            M(O - this.jGl.startY);
                            break;
                        } else if (O <= this.jGl.startY) {
                            this.MQ = false;
                            break;
                        } else if (O > this.jGl.MW) {
                            this.MQ = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.MQ = false;
                            break;
                        }
                    } else {
                        this.MQ = false;
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
        if (this.MQ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MQ) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nW() {
        if (this.jGl != null) {
            if (this.MM.getHeight() >= this.jGl.MW - (this.MT / 2)) {
                nX();
            } else if (this.jGm != null) {
                this.jGm.nY();
            }
            this.mScroller.startScroll(0, this.MM.getHeight(), 0, this.jGl.startY - this.MM.getHeight(), 200);
            invalidate();
        }
    }

    public void nX() {
        if (this.jGm != null) {
            this.jGm.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.jGm = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.jGo) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.MM != null && !this.MQ) {
            this.MQ = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.MT, 0, -this.MT, 200);
            nX();
            invalidate();
            this.mHandler.removeCallbacks(this.jGp);
            this.mHandler.postDelayed(this.jGp, 200L);
            this.MQ = false;
        }
    }

    private int getOriginalHeight() {
        if (this.MN <= 0) {
            this.MN = this.MM.getHeight();
        }
        return this.MN;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.jGo) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.jGq - currY) > this.MS * 2) {
                this.jGq = currY;
                this.MM.setLayoutParams(new AbsListView.LayoutParams(this.MM.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.MT);
        if (this.jGm != null) {
            this.jGm.N(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int MW;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.MW = i4;
        }

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
