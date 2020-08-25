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
/* loaded from: classes2.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private float currentY;
    private final int expandDis;
    private long fjg;
    private boolean isExpanding;
    private final Context mContext;
    private View mExpandView;
    private b mGp;
    public a mGq;
    private boolean mGr;
    private Runnable mGs;
    private int mGt;
    private Handler mHandler;
    private long mIntervalTime;
    private int mOriginalHeight;
    private final Scroller mScroller;
    private float startY;
    private final int touchSlop;

    /* loaded from: classes2.dex */
    public interface a {
        void onExpandingDegree(float f);

        void onNotExpanding();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.mGr = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isExpanding = false;
        this.mIntervalTime = 0L;
        this.fjg = 0L;
        this.mHandler = new Handler();
        this.mGr = false;
        this.mGs = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.mOriginalHeight > 0) {
                    BdExpandListView.this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.mExpandView.getWidth(), BdExpandListView.this.mOriginalHeight));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.mGt = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.expandDis = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.mExpandView = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGr) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.mExpandView == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.currentY = motionEvent.getY();
            switch (action) {
                case 0:
                    this.mIntervalTime = System.currentTimeMillis() - this.fjg;
                    this.fjg = System.currentTimeMillis();
                    this.isExpanding = false;
                    setClickEventEnabled(true);
                    if (this.mOriginalHeight == 0) {
                        this.mOriginalHeight = this.mExpandView.getHeight();
                    }
                    int height = this.mExpandView.getHeight();
                    this.startY = this.currentY;
                    this.mGp = new b(0, height, 0, this.expandDis + height);
                    break;
                case 1:
                case 3:
                    if (this.isExpanding) {
                        setClickEventEnabled(false);
                        scrollCallback();
                        this.isExpanding = false;
                    } else if (this.mGq != null) {
                        this.mGq.onNotExpanding();
                    }
                    this.mHandler.removeCallbacks(this.mGs);
                    this.mHandler.postDelayed(this.mGs, 200L);
                    break;
                case 2:
                    float f = this.currentY - this.startY;
                    if (this.mExpandView.getParent() == this && this.mGp != null && this.mExpandView.isShown() && this.mExpandView.getTop() >= 0 && Math.abs(f) >= this.touchSlop && this.mIntervalTime > 400) {
                        int scrollY = this.mGp.getScrollY(this.currentY - this.startY);
                        if (scrollY > this.mGp.startY && scrollY <= this.mGp.endY) {
                            this.isExpanding = true;
                            setClickEventEnabled(false);
                            this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), scrollY));
                            controllTheStaticProgress(scrollY - this.mGp.startY);
                            break;
                        } else if (scrollY <= this.mGp.startY) {
                            this.isExpanding = false;
                            break;
                        } else if (scrollY > this.mGp.endY) {
                            this.isExpanding = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.isExpanding = false;
                            break;
                        }
                    } else {
                        this.isExpanding = false;
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
        if (this.isExpanding) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isExpanding) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollCallback() {
        if (this.mGp != null) {
            if (this.mExpandView.getHeight() >= this.mGp.endY - (this.expandDis / 2)) {
                doRefresh();
            } else if (this.mGq != null) {
                this.mGq.onNotExpanding();
            }
            this.mScroller.startScroll(0, this.mExpandView.getHeight(), 0, this.mGp.startY - this.mExpandView.getHeight(), 200);
            invalidate();
        }
    }

    public void doRefresh() {
        if (this.mGq != null) {
            this.mGq.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.mGq = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.mGr) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.mExpandView != null && !this.isExpanding) {
            this.isExpanding = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.expandDis, 0, -this.expandDis, 200);
            doRefresh();
            invalidate();
            this.mHandler.removeCallbacks(this.mGs);
            this.mHandler.postDelayed(this.mGs, 200L);
            this.isExpanding = false;
        }
    }

    private int getOriginalHeight() {
        if (this.mOriginalHeight <= 0) {
            this.mOriginalHeight = this.mExpandView.getHeight();
        }
        return this.mOriginalHeight;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mGr) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.mGt - currY) > this.touchSlop * 2) {
                this.mGt = currY;
                this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void controllTheStaticProgress(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.expandDis);
        if (this.mGq != null) {
            this.mGq.onExpandingDegree(f2);
        }
    }

    /* loaded from: classes2.dex */
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

        public int getScrollY(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
