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
/* loaded from: classes22.dex */
public class BdPersonListView extends BdTypeListView {
    private float currentX;
    private float currentY;
    private final int expandDis;
    private boolean isExpanding;
    private final Scroller lUD;
    private View lUE;
    private b lUF;
    private b lUG;
    public a lUH;
    private boolean lUI;
    private boolean lUJ;
    private boolean lUK;
    private final Context mContext;
    private View mExpandView;
    private final Scroller mScroller;
    private float startX;
    private float startY;
    private final int touchSlop;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min};

    /* loaded from: classes22.dex */
    public interface a {
        void onExpandingDegree(float f);

        void onNotExpanding();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isExpanding = false;
        this.lUI = true;
        this.lUJ = false;
        this.lUK = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.lUD = new Scroller(this.mContext);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.expandDis = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setNeedConsumeTouchEvent(boolean z) {
        this.lUK = z;
    }

    public void setExpandView(View view) {
        this.mExpandView = view;
    }

    public void setOuterExpandView(View view) {
        this.lUE = view;
    }

    public View getOuterExpandView() {
        return this.lUE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mExpandView == null || !this.lUI) {
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
                    this.lUF = new b(0, height, 0, this.expandDis + height);
                    int height2 = this.lUE.getHeight();
                    this.lUG = new b(0, height2, 0, this.expandDis + height2);
                    break;
                case 1:
                case 3:
                    if (this.isExpanding) {
                        scrollCallback();
                        if (this.lUJ) {
                            return true;
                        }
                    } else {
                        this.lUH.onNotExpanding();
                        break;
                    }
                    break;
                case 2:
                    float f = this.currentX - this.startX;
                    float f2 = this.currentY - this.startY;
                    this.startX = this.currentX;
                    if (this.mExpandView.getParent() == this && this.lUF != null && this.mExpandView.isShown() && this.mExpandView.getTop() >= 0 && Math.abs(f2) >= this.touchSlop && Math.abs(f) < this.touchSlop) {
                        int scrollY = this.lUF.getScrollY(this.currentY - this.startY);
                        if (scrollY > this.lUF.startY && scrollY <= this.lUF.endY) {
                            this.isExpanding = true;
                            this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), scrollY));
                            if (this.lUE != null) {
                                int scrollY2 = this.lUG.getScrollY(this.currentY - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.lUE.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = scrollY2;
                                    this.lUE.setLayoutParams(layoutParams);
                                }
                            }
                            controllTheStaticProgress(scrollY - this.lUF.startY);
                            break;
                        } else if (scrollY <= this.lUF.startY) {
                            this.isExpanding = false;
                            break;
                        } else if (scrollY > this.lUF.endY) {
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
        if (!this.isExpanding || this.lUK) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    private void scrollCallback() {
        if (this.lUF != null) {
            if (this.mExpandView.getHeight() >= this.lUF.endY - (this.expandDis / 2)) {
                doRefresh();
            } else {
                this.lUH.onNotExpanding();
            }
            this.mScroller.startScroll(0, this.mExpandView.getHeight(), 0, this.lUF.startY - this.mExpandView.getHeight(), 200);
            this.lUD.startScroll(0, this.lUE.getHeight(), 0, this.lUG.startY - this.lUE.getHeight(), 200);
            invalidate();
            this.isExpanding = false;
        }
    }

    public void doRefresh() {
        if (this.lUH != null) {
            this.lUH.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.lUH = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.lUD.computeScrollOffset()) {
            int currY = this.lUD.getCurrY();
            if (this.lUE != null && (layoutParams = this.lUE.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.lUE.setLayoutParams(layoutParams);
            }
        }
    }

    private void controllTheStaticProgress(float f) {
        this.lUH.onExpandingDegree(360.0f - ((f * 360.0f) / this.expandDis));
    }

    /* loaded from: classes22.dex */
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
