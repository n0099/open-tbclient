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
    private final int LB;
    private final int LC;
    private View Lt;
    private int Lu;
    private float Lv;
    private float Lw;
    private boolean Ly;
    private long hiL;
    private b hjk;
    public a hjl;
    private long hjm;
    private boolean hjn;
    private Runnable hjo;
    private int hjp;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void nm();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.hjn = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ly = false;
        this.hjm = 0L;
        this.hiL = 0L;
        this.mHandler = new Handler();
        this.hjn = false;
        this.hjo = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Lu > 0) {
                    BdExpandListView.this.Lt.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Lt.getWidth(), BdExpandListView.this.Lu));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.hjp = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.LB = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandListView);
        this.LC = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Lt = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hjn) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Lt == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Lw = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hjm = System.currentTimeMillis() - this.hiL;
                    this.hiL = System.currentTimeMillis();
                    this.Ly = false;
                    setClickEventEnabled(true);
                    if (this.Lu == 0) {
                        this.Lu = this.Lt.getHeight();
                    }
                    int height = this.Lt.getHeight();
                    this.Lv = this.Lw;
                    this.hjk = new b(0, height, 0, this.LC + height);
                    break;
                case 1:
                case 3:
                    if (this.Ly) {
                        setClickEventEnabled(false);
                        nk();
                        this.Ly = false;
                    } else if (this.hjl != null) {
                        this.hjl.nm();
                    }
                    this.mHandler.removeCallbacks(this.hjo);
                    this.mHandler.postDelayed(this.hjo, 200L);
                    break;
                case 2:
                    float f = this.Lw - this.Lv;
                    if (this.Lt.getParent() == this && this.hjk != null && this.Lt.isShown() && this.Lt.getTop() >= 0 && Math.abs(f) >= this.LB && this.hjm > 400) {
                        int O = this.hjk.O(this.Lw - this.Lv);
                        if (O > this.hjk.startY && O <= this.hjk.endY) {
                            this.Ly = true;
                            setClickEventEnabled(false);
                            this.Lt.setLayoutParams(new AbsListView.LayoutParams(this.Lt.getWidth(), O));
                            M(O - this.hjk.startY);
                            break;
                        } else if (O <= this.hjk.startY) {
                            this.Ly = false;
                            break;
                        } else if (O > this.hjk.endY) {
                            this.Ly = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Ly = false;
                            break;
                        }
                    } else {
                        this.Ly = false;
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
        if (this.Ly) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ly) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nk() {
        if (this.hjk != null) {
            if (this.Lt.getHeight() >= this.hjk.endY - (this.LC / 2)) {
                nl();
            } else if (this.hjl != null) {
                this.hjl.nm();
            }
            this.mScroller.startScroll(0, this.Lt.getHeight(), 0, this.hjk.startY - this.Lt.getHeight(), 200);
            invalidate();
        }
    }

    public void nl() {
        if (this.hjl != null) {
            this.hjl.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hjl = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hjn) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Lt != null && !this.Ly) {
            this.Ly = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.LC, 0, -this.LC, 200);
            nl();
            invalidate();
            this.mHandler.removeCallbacks(this.hjo);
            this.mHandler.postDelayed(this.hjo, 200L);
            this.Ly = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Lu <= 0) {
            this.Lu = this.Lt.getHeight();
        }
        return this.Lu;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hjn) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hjp - currY) > this.LB * 2) {
                this.hjp = currY;
                this.Lt.setLayoutParams(new AbsListView.LayoutParams(this.Lt.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.LC);
        if (this.hjl != null) {
            this.hjl.N(f2);
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
