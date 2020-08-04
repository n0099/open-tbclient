package com.baidu.tieba.person.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class BdPersonListView extends BdTypeListView {
    private float currentX;
    private float currentY;
    private final int expandDis;
    private boolean isExpanding;
    private final Scroller kOf;
    private View kOg;
    private b kOh;
    private b kOi;
    public a kOj;
    private boolean kOk;
    private boolean kOl;
    private boolean kOm;
    private final Context mContext;
    private View mExpandView;
    private final Scroller mScroller;
    private float startX;
    private float startY;
    private final int touchSlop;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min};

    /* loaded from: classes16.dex */
    public interface a {
        void onExpandingDegree(float f);

        void onNotExpanding();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isExpanding = false;
        this.kOk = true;
        this.kOl = false;
        this.kOm = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.kOf = new Scroller(this.mContext);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.expandDis = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setNeedConsumeTouchEvent(boolean z) {
        this.kOm = z;
    }

    public void setExpandView(View view) {
        this.mExpandView = view;
    }

    public void setOuterExpandView(View view) {
        this.kOg = view;
    }

    public View getOuterExpandView() {
        return this.kOg;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mExpandView == null || !this.kOk) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.currentY = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.mExpandView.getHeight();
                    this.startY = this.currentY;
                    this.startX = this.currentX;
                    this.kOh = new b(0, height, 0, this.expandDis + height);
                    int height2 = this.kOg.getHeight();
                    this.kOi = new b(0, height2, 0, this.expandDis + height2);
                    break;
                case 1:
                case 3:
                    if (this.isExpanding) {
                        scrollCallback();
                        if (this.kOl) {
                            return true;
                        }
                    } else {
                        this.kOj.onNotExpanding();
                        break;
                    }
                    break;
                case 2:
                    float f = this.currentX - this.startX;
                    float f2 = this.currentY - this.startY;
                    this.startX = this.currentX;
                    if (this.mExpandView.getParent() == this && this.kOh != null && this.mExpandView.isShown() && this.mExpandView.getTop() >= 0 && Math.abs(f2) >= this.touchSlop && Math.abs(f) < this.touchSlop) {
                        int scrollY = this.kOh.getScrollY(this.currentY - this.startY);
                        if (scrollY > this.kOh.startY && scrollY <= this.kOh.endY) {
                            this.isExpanding = true;
                            this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), scrollY));
                            if (this.kOg != null) {
                                int scrollY2 = this.kOi.getScrollY(this.currentY - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.kOg.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = scrollY2;
                                    this.kOg.setLayoutParams(layoutParams);
                                }
                            }
                            controllTheStaticProgress(scrollY - this.kOh.startY);
                            break;
                        } else if (scrollY <= this.kOh.startY) {
                            this.isExpanding = false;
                            break;
                        } else if (scrollY > this.kOh.endY) {
                            this.isExpanding = true;
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

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isExpanding) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isExpanding || this.kOm) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    private void scrollCallback() {
        if (this.kOh != null) {
            if (this.mExpandView.getHeight() >= this.kOh.endY - (this.expandDis / 2)) {
                doRefresh();
            } else {
                this.kOj.onNotExpanding();
            }
            this.mScroller.startScroll(0, this.mExpandView.getHeight(), 0, this.kOh.startY - this.mExpandView.getHeight(), 200);
            this.kOf.startScroll(0, this.kOg.getHeight(), 0, this.kOi.startY - this.kOg.getHeight(), 200);
            invalidate();
            this.isExpanding = false;
        }
    }

    public void doRefresh() {
        if (this.kOj != null) {
            this.kOj.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.kOj = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.kOf.computeScrollOffset()) {
            int currY = this.kOf.getCurrY();
            if (this.kOg != null && (layoutParams = this.kOg.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.kOg.setLayoutParams(layoutParams);
            }
        }
    }

    private void controllTheStaticProgress(float f) {
        this.kOj.onExpandingDegree(360.0f - ((f * 360.0f) / this.expandDis));
    }

    /* loaded from: classes16.dex */
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
