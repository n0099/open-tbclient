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
/* loaded from: classes7.dex */
public class BdPersonListView extends BdTypeListView {
    private float currentX;
    private float currentY;
    private final int expandDis;
    private boolean isExpanding;
    public a jfA;
    private boolean jfB;
    private boolean jfC;
    private boolean jfD;
    private final Scroller jfw;
    private View jfx;
    private b jfy;
    private b jfz;
    private final Context mContext;
    private View mExpandView;
    private final Scroller mScroller;
    private float startX;
    private float startY;
    private final int touchSlop;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf};

    /* loaded from: classes7.dex */
    public interface a {
        void onExpandingDegree(float f);

        void onNotExpanding();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isExpanding = false;
        this.jfB = true;
        this.jfC = false;
        this.jfD = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.jfw = new Scroller(this.mContext);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.expandDis = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setNeedConsumeTouchEvent(boolean z) {
        this.jfD = z;
    }

    public void setExpandView(View view) {
        this.mExpandView = view;
    }

    public void setOuterExpandView(View view) {
        this.jfx = view;
    }

    public View getOuterExpandView() {
        return this.jfx;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mExpandView == null || !this.jfB) {
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
                    this.jfy = new b(0, height, 0, this.expandDis + height);
                    int height2 = this.jfx.getHeight();
                    this.jfz = new b(0, height2, 0, this.expandDis + height2);
                    break;
                case 1:
                case 3:
                    if (this.isExpanding) {
                        scrollCallback();
                        if (this.jfC) {
                            return true;
                        }
                    } else {
                        this.jfA.onNotExpanding();
                        break;
                    }
                    break;
                case 2:
                    float f = this.currentX - this.startX;
                    float f2 = this.currentY - this.startY;
                    this.startX = this.currentX;
                    if (this.mExpandView.getParent() == this && this.jfy != null && this.mExpandView.isShown() && this.mExpandView.getTop() >= 0 && Math.abs(f2) >= this.touchSlop && Math.abs(f) < this.touchSlop) {
                        int scrollY = this.jfy.getScrollY(this.currentY - this.startY);
                        if (scrollY > this.jfy.startY && scrollY <= this.jfy.endY) {
                            this.isExpanding = true;
                            this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), scrollY));
                            if (this.jfx != null) {
                                int scrollY2 = this.jfz.getScrollY(this.currentY - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.jfx.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = scrollY2;
                                    this.jfx.setLayoutParams(layoutParams);
                                }
                            }
                            controllTheStaticProgress(scrollY - this.jfy.startY);
                            break;
                        } else if (scrollY <= this.jfy.startY) {
                            this.isExpanding = false;
                            break;
                        } else if (scrollY > this.jfy.endY) {
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
        if (!this.isExpanding || this.jfD) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    private void scrollCallback() {
        if (this.jfy != null) {
            if (this.mExpandView.getHeight() >= this.jfy.endY - (this.expandDis / 2)) {
                doRefresh();
            } else {
                this.jfA.onNotExpanding();
            }
            this.mScroller.startScroll(0, this.mExpandView.getHeight(), 0, this.jfy.startY - this.mExpandView.getHeight(), 200);
            this.jfw.startScroll(0, this.jfx.getHeight(), 0, this.jfz.startY - this.jfx.getHeight(), 200);
            invalidate();
            this.isExpanding = false;
        }
    }

    public void doRefresh() {
        if (this.jfA != null) {
            this.jfA.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.jfA = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.jfw.computeScrollOffset()) {
            int currY = this.jfw.getCurrY();
            if (this.jfx != null && (layoutParams = this.jfx.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.jfx.setLayoutParams(layoutParams);
            }
        }
    }

    private void controllTheStaticProgress(float f) {
        this.jfA.onExpandingDegree(360.0f - ((f * 360.0f) / this.expandDis));
    }

    /* loaded from: classes7.dex */
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
