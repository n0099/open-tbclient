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
    private final int LA;
    private View Lr;
    private int Ls;
    private float Lt;
    private float Lu;
    private boolean Lw;
    private final int Lz;
    private long bgZ;
    private boolean hoA;
    private Runnable hoB;
    private int hoC;
    private b hox;
    public a hoy;
    private long hoz;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void no();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.hoA = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lw = false;
        this.hoz = 0L;
        this.bgZ = 0L;
        this.mHandler = new Handler();
        this.hoA = false;
        this.hoB = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Ls > 0) {
                    BdExpandListView.this.Lr.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Lr.getWidth(), BdExpandListView.this.Ls));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.hoC = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Lz = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.LA = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Lr = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoA) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Lr == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Lu = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hoz = System.currentTimeMillis() - this.bgZ;
                    this.bgZ = System.currentTimeMillis();
                    this.Lw = false;
                    setClickEventEnabled(true);
                    if (this.Ls == 0) {
                        this.Ls = this.Lr.getHeight();
                    }
                    int height = this.Lr.getHeight();
                    this.Lt = this.Lu;
                    this.hox = new b(0, height, 0, this.LA + height);
                    break;
                case 1:
                case 3:
                    if (this.Lw) {
                        setClickEventEnabled(false);
                        nm();
                        this.Lw = false;
                    } else if (this.hoy != null) {
                        this.hoy.no();
                    }
                    this.mHandler.removeCallbacks(this.hoB);
                    this.mHandler.postDelayed(this.hoB, 200L);
                    break;
                case 2:
                    float f = this.Lu - this.Lt;
                    if (this.Lr.getParent() == this && this.hox != null && this.Lr.isShown() && this.Lr.getTop() >= 0 && Math.abs(f) >= this.Lz && this.hoz > 400) {
                        int O = this.hox.O(this.Lu - this.Lt);
                        if (O > this.hox.startY && O <= this.hox.endY) {
                            this.Lw = true;
                            setClickEventEnabled(false);
                            this.Lr.setLayoutParams(new AbsListView.LayoutParams(this.Lr.getWidth(), O));
                            M(O - this.hox.startY);
                            break;
                        } else if (O <= this.hox.startY) {
                            this.Lw = false;
                            break;
                        } else if (O > this.hox.endY) {
                            this.Lw = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Lw = false;
                            break;
                        }
                    } else {
                        this.Lw = false;
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
        if (this.Lw) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Lw) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nm() {
        if (this.hox != null) {
            if (this.Lr.getHeight() >= this.hox.endY - (this.LA / 2)) {
                nn();
            } else if (this.hoy != null) {
                this.hoy.no();
            }
            this.mScroller.startScroll(0, this.Lr.getHeight(), 0, this.hox.startY - this.Lr.getHeight(), 200);
            invalidate();
        }
    }

    public void nn() {
        if (this.hoy != null) {
            this.hoy.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hoy = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hoA) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Lr != null && !this.Lw) {
            this.Lw = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.LA, 0, -this.LA, 200);
            nn();
            invalidate();
            this.mHandler.removeCallbacks(this.hoB);
            this.mHandler.postDelayed(this.hoB, 200L);
            this.Lw = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Ls <= 0) {
            this.Ls = this.Lr.getHeight();
        }
        return this.Ls;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hoA) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hoC - currY) > this.Lz * 2) {
                this.hoC = currY;
                this.Lr.setLayoutParams(new AbsListView.LayoutParams(this.Lr.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.LA);
        if (this.hoy != null) {
            this.hoy.N(f2);
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
