package com.baidu.yuyinala.privatemessage.session;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class SwipeItemLayout extends ViewGroup {
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.baidu.yuyinala.privatemessage.session.SwipeItemLayout.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int eYk;
    private boolean mInLayout;
    private Mode oWR;
    private View oWS;
    private int oWT;
    private a oWU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum Mode {
        RESET,
        DRAG,
        FLING,
        CLICK
    }

    public SwipeItemLayout(Context context) {
        this(context, null);
    }

    public SwipeItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInLayout = false;
        this.oWR = Mode.RESET;
        this.eYk = 0;
        this.oWU = new a(context);
    }

    public int getScrollOffset() {
        return this.eYk;
    }

    public void close() {
        if (this.eYk != 0) {
            if (this.oWR == Mode.FLING) {
                this.oWU.abort();
            }
            this.oWU.dX(this.eYk, 0);
        }
    }

    private void eoc() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams == null || !(layoutParams instanceof LayoutParams)) {
                throw new IllegalStateException("缺少layout参数");
            }
            if (((LayoutParams) layoutParams).oWV == 1) {
                this.oWS = childAt;
            }
        }
        if (this.oWS == null) {
            throw new IllegalStateException("main item不能为空");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        eoc();
        LayoutParams layoutParams = (LayoutParams) this.oWS.getLayoutParams();
        measureChildWithMargins(this.oWS, i, getPaddingLeft() + getPaddingRight(), i2, getPaddingTop() + getPaddingBottom());
        setMeasuredDimension(this.oWS.getMeasuredWidth() + getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, this.oWS.getMeasuredHeight() + getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.oWS.getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).oWV != 1) {
                measureChildWithMargins(childAt, makeMeasureSpec, 0, makeMeasureSpec2, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        eoc();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) this.oWS.getLayoutParams();
        this.oWS.layout(paddingLeft + layoutParams.leftMargin, layoutParams.topMargin + paddingTop, (getWidth() - paddingRight) - layoutParams.rightMargin, (getHeight() - paddingBottom) - layoutParams.bottomMargin);
        int right = this.oWS.getRight() + layoutParams.rightMargin;
        int i5 = 0;
        int i6 = 0;
        int i7 = right;
        while (true) {
            int i8 = i5;
            if (i8 >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i8);
            LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams2.oWV != 1) {
                int i9 = i7 + layoutParams2.leftMargin;
                int i10 = layoutParams2.topMargin + paddingTop;
                childAt.layout(i9, i10, childAt.getMeasuredWidth() + i9 + layoutParams2.rightMargin, childAt.getMeasuredHeight() + i10 + layoutParams2.bottomMargin);
                i7 = childAt.getRight() + layoutParams2.rightMargin;
                i6 += layoutParams2.rightMargin + layoutParams2.leftMargin + childAt.getMeasuredWidth();
            }
            i5 = i8 + 1;
        }
        this.oWT = i6;
        this.eYk = this.eYk < (-this.oWT) / 2 ? -this.oWT : 0;
        offsetChildrenLeftAndRight(this.eYk);
        this.mInLayout = false;
    }

    void offsetChildrenLeftAndRight(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.oWU);
        this.oWR = Mode.RESET;
        this.eYk = 0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                View e = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e != null && e == this.oWS && this.eYk != 0) {
                    return true;
                }
                break;
            case 1:
                View e2 = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e2 != null && e2 == this.oWS && this.oWR == Mode.CLICK && this.eYk != 0) {
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                View e = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e != null && e == this.oWS && this.eYk != 0) {
                    return true;
                }
                break;
            case 1:
                View e2 = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e2 != null && e2 == this.oWS && this.oWR == Mode.CLICK && this.eYk != 0) {
                    close();
                    return true;
                }
                break;
        }
        return false;
    }

    void setTouchMode(Mode mode) {
        if (mode != this.oWR) {
            if (this.oWR == Mode.FLING) {
                removeCallbacks(this.oWU);
            }
            this.oWR = mode;
        }
    }

    public Mode getTouchMode() {
        return this.oWR;
    }

    boolean PC(int i) {
        boolean z = true;
        if (i != 0) {
            int i2 = this.eYk + i;
            if ((i <= 0 || i2 <= 0) && (i >= 0 || i2 >= (-this.oWT))) {
                z = false;
            } else {
                i2 = Math.max(Math.min(i2, 0), -this.oWT);
            }
            offsetChildrenLeftAndRight(i2 - this.eYk);
            this.eYk = i2;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        private Scroller fHz;
        private int minVelocity;
        private boolean oWW = false;

        a(Context context) {
            this.fHz = new Scroller(context, SwipeItemLayout.sInterpolator);
            this.minVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        }

        void dX(int i, int i2) {
            if (i != i2) {
                Log.e("scroll - startX - endX", "" + i + " " + i2);
                SwipeItemLayout.this.setTouchMode(Mode.FLING);
                this.oWW = false;
                this.fHz.startScroll(i, 0, i2 - i, 0, 400);
                ViewCompat.postOnAnimation(SwipeItemLayout.this, this);
            }
        }

        void abort() {
            if (!this.oWW) {
                this.oWW = true;
                if (!this.fHz.isFinished()) {
                    this.fHz.abortAnimation();
                    SwipeItemLayout.this.removeCallbacks(this);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.e("abort", Boolean.toString(this.oWW));
            if (!this.oWW) {
                boolean computeScrollOffset = this.fHz.computeScrollOffset();
                int currX = this.fHz.getCurrX();
                Log.e("curX", "" + currX);
                boolean z = false;
                if (currX != SwipeItemLayout.this.eYk) {
                    z = SwipeItemLayout.this.PC(currX - SwipeItemLayout.this.eYk);
                }
                if (computeScrollOffset && !z) {
                    ViewCompat.postOnAnimation(SwipeItemLayout.this, this);
                    return;
                }
                SwipeItemLayout.this.removeCallbacks(this);
                if (!this.fHz.isFinished()) {
                    this.fHz.abortAnimation();
                }
                SwipeItemLayout.this.setTouchMode(Mode.RESET);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: eod */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: f */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? (LayoutParams) layoutParams : new LayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: j */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int oWV;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.oWV = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwipeItemLayout);
            this.oWV = obtainStyledAttributes.getInt(a.j.SwipeItemLayout_layout_itemType, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.oWV = -1;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.oWV = -1;
        }
    }

    static View e(ViewGroup viewGroup, int i, int i2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
