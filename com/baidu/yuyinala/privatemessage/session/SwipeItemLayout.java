package com.baidu.yuyinala.privatemessage.session;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class SwipeItemLayout extends ViewGroup {
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.baidu.yuyinala.privatemessage.session.SwipeItemLayout.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int fgQ;
    private boolean mInLayout;
    private Mode ple;
    private View plf;
    private int plg;
    private a plh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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
        this.ple = Mode.RESET;
        this.fgQ = 0;
        this.plh = new a(context);
    }

    public int getScrollOffset() {
        return this.fgQ;
    }

    public void open() {
        if (this.fgQ != (-this.plg)) {
            if (this.ple == Mode.FLING) {
                this.plh.abort();
            }
            this.plh.dT(this.fgQ, -this.plg);
        }
    }

    public void close() {
        if (this.fgQ != 0) {
            if (this.ple == Mode.FLING) {
                this.plh.abort();
            }
            this.plh.dT(this.fgQ, 0);
        }
    }

    void fling(int i) {
        this.plh.dU(this.fgQ, i);
    }

    void emX() {
        if (this.fgQ < (-ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
            open();
        } else {
            close();
        }
    }

    private void emY() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams == null || !(layoutParams instanceof LayoutParams)) {
                throw new IllegalStateException("缺少layout参数");
            }
            if (((LayoutParams) layoutParams).pli == 1) {
                this.plf = childAt;
            }
        }
        if (this.plf == null) {
            throw new IllegalStateException("main item不能为空");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        emY();
        LayoutParams layoutParams = (LayoutParams) this.plf.getLayoutParams();
        measureChildWithMargins(this.plf, i, getPaddingLeft() + getPaddingRight(), i2, getPaddingTop() + getPaddingBottom());
        setMeasuredDimension(this.plf.getMeasuredWidth() + getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, this.plf.getMeasuredHeight() + getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.plf.getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).pli != 1) {
                measureChildWithMargins(childAt, makeMeasureSpec, 0, makeMeasureSpec2, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        emY();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) this.plf.getLayoutParams();
        this.plf.layout(paddingLeft + layoutParams.leftMargin, layoutParams.topMargin + paddingTop, (getWidth() - paddingRight) - layoutParams.rightMargin, (getHeight() - paddingBottom) - layoutParams.bottomMargin);
        int i5 = 0;
        int right = this.plf.getRight() + layoutParams.rightMargin;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i7);
            LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams2.pli != 1) {
                int i8 = right + layoutParams2.leftMargin;
                int i9 = layoutParams2.topMargin + paddingTop;
                childAt.layout(i8, i9, childAt.getMeasuredWidth() + i8 + layoutParams2.rightMargin, childAt.getMeasuredHeight() + i9 + layoutParams2.bottomMargin);
                right = childAt.getRight() + layoutParams2.rightMargin;
                i5 += layoutParams2.rightMargin + layoutParams2.leftMargin + childAt.getMeasuredWidth();
            }
            i6 = i7 + 1;
        }
        this.plg = i5;
        this.fgQ = this.fgQ < (-this.plg) / 2 ? -this.plg : 0;
        offsetChildrenLeftAndRight(this.fgQ);
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
        removeCallbacks(this.plh);
        this.ple = Mode.RESET;
        this.fgQ = 0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                View e = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e != null && e == this.plf && this.fgQ != 0) {
                    return true;
                }
                break;
            case 1:
                View e2 = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e2 != null && e2 == this.plf && this.ple == Mode.CLICK && this.fgQ != 0) {
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
                if (e != null && e == this.plf && this.fgQ != 0) {
                    return true;
                }
                break;
            case 1:
                View e2 = e(this, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (e2 != null && e2 == this.plf && this.ple == Mode.CLICK && this.fgQ != 0) {
                    close();
                    return true;
                }
                break;
        }
        return false;
    }

    void setTouchMode(Mode mode) {
        if (mode != this.ple) {
            if (this.ple == Mode.FLING) {
                removeCallbacks(this.plh);
            }
            this.ple = mode;
        }
    }

    public Mode getTouchMode() {
        return this.ple;
    }

    boolean Oj(int i) {
        boolean z = true;
        if (i != 0) {
            int i2 = this.fgQ + i;
            if ((i <= 0 || i2 <= 0) && (i >= 0 || i2 >= (-this.plg))) {
                z = false;
            } else {
                i2 = Math.max(Math.min(i2, 0), -this.plg);
            }
            offsetChildrenLeftAndRight(i2 - this.fgQ);
            this.fgQ = i2;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private Scroller bWG;
        private int minVelocity;
        private boolean plq = false;

        a(Context context) {
            this.bWG = new Scroller(context, SwipeItemLayout.sInterpolator);
            this.minVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        }

        void dT(int i, int i2) {
            if (i != i2) {
                Log.e("scroll - startX - endX", "" + i + " " + i2);
                SwipeItemLayout.this.setTouchMode(Mode.FLING);
                this.plq = false;
                this.bWG.startScroll(i, 0, i2 - i, 0, 400);
                ViewCompat.postOnAnimation(SwipeItemLayout.this, this);
            }
        }

        void dU(int i, int i2) {
            Log.e("fling - startX", "" + i);
            if (i2 > this.minVelocity && i != 0) {
                dT(i, 0);
            } else if (i2 >= (-this.minVelocity) || i == (-SwipeItemLayout.this.plg)) {
                dT(i, i <= (-SwipeItemLayout.this.plg) / 2 ? -SwipeItemLayout.this.plg : 0);
            } else {
                dT(i, -SwipeItemLayout.this.plg);
            }
        }

        void abort() {
            if (!this.plq) {
                this.plq = true;
                if (!this.bWG.isFinished()) {
                    this.bWG.abortAnimation();
                    SwipeItemLayout.this.removeCallbacks(this);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.e("abort", Boolean.toString(this.plq));
            if (!this.plq) {
                boolean computeScrollOffset = this.bWG.computeScrollOffset();
                int currX = this.bWG.getCurrX();
                Log.e("curX", "" + currX);
                boolean z = false;
                if (currX != SwipeItemLayout.this.fgQ) {
                    z = SwipeItemLayout.this.Oj(currX - SwipeItemLayout.this.fgQ);
                }
                if (computeScrollOffset && !z) {
                    ViewCompat.postOnAnimation(SwipeItemLayout.this, this);
                    return;
                }
                SwipeItemLayout.this.removeCallbacks(this);
                if (!this.bWG.isFinished()) {
                    this.bWG.abortAnimation();
                }
                SwipeItemLayout.this.setTouchMode(Mode.RESET);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: emZ */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: h */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? (LayoutParams) layoutParams : new LayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: m */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    /* loaded from: classes10.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int pli;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.pli = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwipeItemLayout);
            this.pli = obtainStyledAttributes.getInt(a.j.SwipeItemLayout_layout_itemType, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.pli = -1;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.pli = -1;
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

    /* loaded from: classes10.dex */
    public static class OnSwipeItemTouchListener implements RecyclerView.OnItemTouchListener {
        private int activePointerId;
        private SwipeItemLayout plj;
        private float plk;
        private float pll;
        private int plm;
        private boolean pln;
        private boolean plo;
        private boolean plp;
        private int touchSlop;
        private VelocityTracker velocityTracker;

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            SwipeItemLayout swipeItemLayout;
            boolean z;
            boolean z2;
            boolean z3;
            ViewParent parent;
            boolean z4 = true;
            if (this.plo) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0 || !this.plp) {
                if (actionMasked == 0 || !(this.plj == null || this.pln)) {
                    if (this.velocityTracker == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    }
                    this.velocityTracker.addMovement(motionEvent);
                    switch (actionMasked) {
                        case 0:
                            this.plp = false;
                            this.pln = false;
                            this.activePointerId = motionEvent.getPointerId(0);
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            this.plk = x;
                            this.pll = y;
                            View e = SwipeItemLayout.e(recyclerView, (int) x, (int) y);
                            if (e == null || !(e instanceof SwipeItemLayout)) {
                                swipeItemLayout = null;
                                z = true;
                            } else {
                                swipeItemLayout = (SwipeItemLayout) e;
                                z = false;
                            }
                            if (!((z || (this.plj != null && this.plj == swipeItemLayout)) ? z : true) && this.plj != null) {
                                if (this.plj.getTouchMode() == Mode.FLING) {
                                    this.plj.setTouchMode(Mode.DRAG);
                                    z3 = true;
                                    z2 = true;
                                } else {
                                    this.plj.setTouchMode(Mode.CLICK);
                                    if (this.plj.getScrollOffset() != 0) {
                                        z3 = true;
                                        z2 = false;
                                    } else {
                                        z3 = false;
                                        z2 = false;
                                    }
                                }
                                if (z3 && (parent = recyclerView.getParent()) != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            } else if (this.plj != null && this.plj.getScrollOffset() != 0) {
                                this.plj.close();
                                this.plp = true;
                                return true;
                            } else {
                                this.plj = null;
                                if (swipeItemLayout != null) {
                                    this.plj = swipeItemLayout;
                                    this.plj.setTouchMode(Mode.CLICK);
                                }
                                z2 = false;
                            }
                            this.plo = true;
                            this.pln = recyclerView.onInterceptTouchEvent(motionEvent);
                            this.plo = false;
                            if (this.pln) {
                                if (this.plj == null || this.plj.getScrollOffset() == 0) {
                                    return false;
                                }
                                this.plj.close();
                                return false;
                            }
                            return z2;
                        case 1:
                            if (this.plj.getTouchMode() == Mode.DRAG) {
                                VelocityTracker velocityTracker = this.velocityTracker;
                                velocityTracker.computeCurrentVelocity(1000, this.plm);
                                this.plj.fling((int) velocityTracker.getXVelocity(this.activePointerId));
                            } else {
                                z4 = false;
                            }
                            cancel();
                            return z4;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                            if (findPointerIndex != -1) {
                                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                                int y2 = (int) (((int) motionEvent.getY(findPointerIndex)) + 0.5f);
                                int i = (int) (x2 - this.plk);
                                int abs = Math.abs(i);
                                int abs2 = Math.abs((int) (y2 - this.pll));
                                if (this.plj.getTouchMode() == Mode.CLICK) {
                                    if (abs > this.touchSlop && abs > abs2) {
                                        this.plj.setTouchMode(Mode.DRAG);
                                        ViewParent parent2 = recyclerView.getParent();
                                        if (this.plj.getScrollOffset() != 0 || i < 0) {
                                            parent2.requestDisallowInterceptTouchEvent(true);
                                        }
                                        i = i > 0 ? i - this.touchSlop : i + this.touchSlop;
                                    } else {
                                        this.plo = true;
                                        this.pln = recyclerView.onInterceptTouchEvent(motionEvent);
                                        this.plo = false;
                                        if (this.pln && this.plj.getScrollOffset() != 0) {
                                            this.plj.close();
                                        }
                                    }
                                }
                                if (this.plj.getTouchMode() == Mode.DRAG) {
                                    this.plk = x2;
                                    this.pll = y2;
                                    this.plj.Oj(i);
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        case 3:
                            this.plj.emX();
                            cancel();
                            return false;
                        case 4:
                        default:
                            return false;
                        case 5:
                            int actionIndex = motionEvent.getActionIndex();
                            this.activePointerId = motionEvent.getPointerId(actionIndex);
                            this.plk = motionEvent.getX(actionIndex);
                            this.pll = motionEvent.getY(actionIndex);
                            return false;
                        case 6:
                            int actionIndex2 = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionIndex2) == this.activePointerId) {
                                int i2 = actionIndex2 == 0 ? 1 : 0;
                                this.activePointerId = motionEvent.getPointerId(i2);
                                this.plk = motionEvent.getX(i2);
                                this.pll = motionEvent.getY(i2);
                                return false;
                            }
                            return false;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            if (!this.plp) {
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                this.velocityTracker.addMovement(motionEvent);
                switch (actionMasked) {
                    case 1:
                        if (this.plj != null && this.plj.getTouchMode() == Mode.DRAG) {
                            VelocityTracker velocityTracker = this.velocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, this.plm);
                            this.plj.fling((int) velocityTracker.getXVelocity(this.activePointerId));
                        }
                        cancel();
                        return;
                    case 2:
                        int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                        if (findPointerIndex != -1) {
                            float x = motionEvent.getX(findPointerIndex);
                            float y = (int) motionEvent.getY(findPointerIndex);
                            int i = (int) (x - this.plk);
                            if (this.plj != null && this.plj.getTouchMode() == Mode.DRAG) {
                                this.plk = x;
                                this.pll = y;
                                this.plj.Oj(i);
                                return;
                            }
                            return;
                        }
                        return;
                    case 3:
                        if (this.plj != null) {
                            this.plj.emX();
                        }
                        cancel();
                        return;
                    case 4:
                    default:
                        return;
                    case 5:
                        this.activePointerId = motionEvent.getPointerId(actionIndex);
                        this.plk = motionEvent.getX(actionIndex);
                        this.pll = motionEvent.getY(actionIndex);
                        return;
                    case 6:
                        if (motionEvent.getPointerId(actionIndex) == this.activePointerId) {
                            int i2 = actionIndex == 0 ? 1 : 0;
                            this.activePointerId = motionEvent.getPointerId(i2);
                            this.plk = motionEvent.getX(i2);
                            this.pll = motionEvent.getY(i2);
                            return;
                        }
                        return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        void cancel() {
            this.pln = false;
            this.activePointerId = -1;
            if (this.velocityTracker != null) {
                this.velocityTracker.recycle();
                this.velocityTracker = null;
            }
        }
    }
}
