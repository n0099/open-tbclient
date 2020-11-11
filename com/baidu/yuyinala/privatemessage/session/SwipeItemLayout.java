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
    private boolean mInLayout;
    private Mode oGf;
    private View oGg;
    private int oGh;
    private a oGi;
    private int scrollOffset;

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
        this.oGf = Mode.RESET;
        this.scrollOffset = 0;
        this.oGi = new a(context);
    }

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public void close() {
        if (this.scrollOffset != 0) {
            if (this.oGf == Mode.FLING) {
                this.oGi.abort();
            }
            this.oGi.dR(this.scrollOffset, 0);
        }
    }

    private void eio() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams == null || !(layoutParams instanceof LayoutParams)) {
                throw new IllegalStateException("缺少layout参数");
            }
            if (((LayoutParams) layoutParams).oGj == 1) {
                this.oGg = childAt;
            }
        }
        if (this.oGg == null) {
            throw new IllegalStateException("main item不能为空");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        eio();
        LayoutParams layoutParams = (LayoutParams) this.oGg.getLayoutParams();
        measureChildWithMargins(this.oGg, i, getPaddingLeft() + getPaddingRight(), i2, getPaddingTop() + getPaddingBottom());
        setMeasuredDimension(this.oGg.getMeasuredWidth() + getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, this.oGg.getMeasuredHeight() + getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.oGg.getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).oGj != 1) {
                measureChildWithMargins(childAt, makeMeasureSpec, 0, makeMeasureSpec2, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        eio();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) this.oGg.getLayoutParams();
        this.oGg.layout(paddingLeft + layoutParams.leftMargin, layoutParams.topMargin + paddingTop, (getWidth() - paddingRight) - layoutParams.rightMargin, (getHeight() - paddingBottom) - layoutParams.bottomMargin);
        int right = this.oGg.getRight() + layoutParams.rightMargin;
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
            if (layoutParams2.oGj != 1) {
                int i9 = i7 + layoutParams2.leftMargin;
                int i10 = layoutParams2.topMargin + paddingTop;
                childAt.layout(i9, i10, childAt.getMeasuredWidth() + i9 + layoutParams2.rightMargin, childAt.getMeasuredHeight() + i10 + layoutParams2.bottomMargin);
                i7 = childAt.getRight() + layoutParams2.rightMargin;
                i6 += layoutParams2.rightMargin + layoutParams2.leftMargin + childAt.getMeasuredWidth();
            }
            i5 = i8 + 1;
        }
        this.oGh = i6;
        this.scrollOffset = this.scrollOffset < (-this.oGh) / 2 ? -this.oGh : 0;
        offsetChildrenLeftAndRight(this.scrollOffset);
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
        removeCallbacks(this.oGi);
        this.oGf = Mode.RESET;
        this.scrollOffset = 0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                View e = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e != null && e == this.oGg && this.scrollOffset != 0) {
                    return true;
                }
                break;
            case 1:
                View e2 = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e2 != null && e2 == this.oGg && this.oGf == Mode.CLICK && this.scrollOffset != 0) {
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
                if (e != null && e == this.oGg && this.scrollOffset != 0) {
                    return true;
                }
                break;
            case 1:
                View e2 = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e2 != null && e2 == this.oGg && this.oGf == Mode.CLICK && this.scrollOffset != 0) {
                    close();
                    return true;
                }
                break;
        }
        return false;
    }

    void setTouchMode(Mode mode) {
        if (mode != this.oGf) {
            if (this.oGf == Mode.FLING) {
                removeCallbacks(this.oGi);
            }
            this.oGf = mode;
        }
    }

    public Mode getTouchMode() {
        return this.oGf;
    }

    boolean Ob(int i) {
        boolean z = true;
        if (i != 0) {
            int i2 = this.scrollOffset + i;
            if ((i <= 0 || i2 <= 0) && (i >= 0 || i2 >= (-this.oGh))) {
                z = false;
            } else {
                i2 = Math.max(Math.min(i2, 0), -this.oGh);
            }
            offsetChildrenLeftAndRight(i2 - this.scrollOffset);
            this.scrollOffset = i2;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        private Scroller fAj;
        private int minVelocity;
        private boolean oGk = false;

        a(Context context) {
            this.fAj = new Scroller(context, SwipeItemLayout.sInterpolator);
            this.minVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        }

        void dR(int i, int i2) {
            if (i != i2) {
                Log.e("scroll - startX - endX", "" + i + " " + i2);
                SwipeItemLayout.this.setTouchMode(Mode.FLING);
                this.oGk = false;
                this.fAj.startScroll(i, 0, i2 - i, 0, 400);
                ViewCompat.postOnAnimation(SwipeItemLayout.this, this);
            }
        }

        void abort() {
            if (!this.oGk) {
                this.oGk = true;
                if (!this.fAj.isFinished()) {
                    this.fAj.abortAnimation();
                    SwipeItemLayout.this.removeCallbacks(this);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.e("abort", Boolean.toString(this.oGk));
            if (!this.oGk) {
                boolean computeScrollOffset = this.fAj.computeScrollOffset();
                int currX = this.fAj.getCurrX();
                Log.e("curX", "" + currX);
                boolean z = false;
                if (currX != SwipeItemLayout.this.scrollOffset) {
                    z = SwipeItemLayout.this.Ob(currX - SwipeItemLayout.this.scrollOffset);
                }
                if (computeScrollOffset && !z) {
                    ViewCompat.postOnAnimation(SwipeItemLayout.this, this);
                    return;
                }
                SwipeItemLayout.this.removeCallbacks(this);
                if (!this.fAj.isFinished()) {
                    this.fAj.abortAnimation();
                }
                SwipeItemLayout.this.setTouchMode(Mode.RESET);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: eip */
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
        public int oGj;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.oGj = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwipeItemLayout);
            this.oGj = obtainStyledAttributes.getInt(a.j.SwipeItemLayout_layout_itemType, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.oGj = -1;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.oGj = -1;
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
