package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Scroller;
import com.baidu.tieba.R;
import d.b.i0.c3.k0.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class DragHorizonScrollView extends ViewGroup implements d, d.b.i0.c3.k0.c, View.OnLongClickListener {
    public boolean A;
    public View B;
    public int C;
    public boolean D;
    public ArrayList<View> E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public Runnable K;

    /* renamed from: e  reason: collision with root package name */
    public BaseAdapter f21352e;

    /* renamed from: f  reason: collision with root package name */
    public View f21353f;

    /* renamed from: g  reason: collision with root package name */
    public int f21354g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c3.k0.a f21355h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public int n;
    public Scroller o;
    public Scroller p;
    public Rect q;
    public VelocityTracker r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public c w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            if (DragHorizonScrollView.this.i == 0) {
                DragHorizonScrollView.this.p.forceFinished(true);
                return;
            }
            Scroller scroller = DragHorizonScrollView.this.p;
            boolean computeScrollOffset = scroller.computeScrollOffset();
            int currX = scroller.getCurrX();
            int i = DragHorizonScrollView.this.C - currX;
            if (i > 0) {
                max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
            } else {
                max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
            }
            DragHorizonScrollView.this.w(-max);
            if (computeScrollOffset) {
                DragHorizonScrollView.this.C = currX;
                DragHorizonScrollView.this.post(this);
                return;
            }
            DragHorizonScrollView.this.p.forceFinished(true);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DragHorizonScrollView.this.F = false;
            int childCount = DragHorizonScrollView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (DragHorizonScrollView.this.getChildAt(i) != null) {
                    DragHorizonScrollView.this.getChildAt(i).clearAnimation();
                }
            }
            if (DragHorizonScrollView.this.o()) {
                if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.p()) {
                    DragHorizonScrollView dragHorizonScrollView = DragHorizonScrollView.this;
                    dragHorizonScrollView.scrollTo(dragHorizonScrollView.p(), 0);
                }
            } else {
                DragHorizonScrollView.this.scrollTo(0, 0);
            }
            if (DragHorizonScrollView.this.G) {
                DragHorizonScrollView.this.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.q = new Rect();
        this.z = 10;
        this.E = new ArrayList<>();
        this.I = false;
        this.J = true;
        this.K = new a();
        r(context);
    }

    public final void A(int i, int i2) {
        if (i == i2) {
            return;
        }
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(i2);
        if (childAt == null || childAt2 == null) {
            return;
        }
        if (i < i2) {
            detachViewFromParent(i);
            int i3 = -childAt.getMeasuredWidth();
            int left = childAt2.getLeft() - childAt.getLeft();
            while (i < i2) {
                View childAt3 = getChildAt(i);
                if (childAt3 != null) {
                    childAt3.offsetLeftAndRight(i3);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-i3, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setFillAfter(true);
                    childAt3.startAnimation(translateAnimation);
                }
                i++;
            }
            attachViewToParent(childAt, i2, childAt.getLayoutParams());
            childAt.offsetLeftAndRight(left);
            return;
        }
        detachViewFromParent(i);
        int measuredWidth = childAt.getMeasuredWidth();
        int left2 = childAt2.getLeft() - childAt.getLeft();
        for (int i4 = i2; i4 < i; i4++) {
            View childAt4 = getChildAt(i4);
            if (childAt4 != null) {
                childAt4.offsetLeftAndRight(measuredWidth);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(-measuredWidth, 0.0f, 0.0f, 0.0f);
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                childAt4.startAnimation(translateAnimation2);
            }
        }
        attachViewToParent(childAt, i2, childAt.getLayoutParams());
        childAt.offsetLeftAndRight(left2);
    }

    @Override // d.b.i0.c3.k0.d
    public void a(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.f21354g && (childAt = getChildAt(i)) != this.B) {
                childAt.getHitRect(this.q);
                if (this.q.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.f21354g;
                    A(i2, i);
                    z(i2, i);
                    this.f21354g = i;
                    return;
                }
            }
        }
    }

    @Override // d.b.i0.c3.k0.d
    public void b() {
        if (this.u) {
            return;
        }
        this.u = true;
        int scrollX = getScrollX();
        this.o.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
        invalidate();
    }

    @Override // d.b.i0.c3.k0.d
    public void c() {
        if (!this.o.isFinished()) {
            this.o.forceFinished(true);
        }
        this.u = false;
        this.v = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        d.b.i0.c3.k0.a aVar;
        if (this.o.computeScrollOffset()) {
            scrollTo(this.o.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.u || this.v) && (aVar = this.f21355h) != null) {
                aVar.i();
                return;
            }
            return;
        }
        this.u = false;
        this.v = false;
    }

    @Override // d.b.i0.c3.k0.d
    public void d() {
        if (this.v) {
            return;
        }
        this.v = true;
        int p = p();
        int scrollX = getScrollX();
        int scrollX2 = p - getScrollX();
        this.o.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
        invalidate();
    }

    @Override // d.b.i0.c3.k0.d
    public void e() {
        y();
    }

    public BaseAdapter getAdapter() {
        return this.f21352e;
    }

    public int getMaxItemNum() {
        return this.z;
    }

    public final boolean o() {
        return this.l > getMeasuredWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (o()) {
            if (this.r == null) {
                this.r = VelocityTracker.obtain();
            }
            this.r.addMovement(motionEvent);
            float x = motionEvent.getX();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int abs = (int) Math.abs(x - this.m);
                        this.m = x;
                        if (abs > this.n) {
                            if (getParent() != null) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            return true;
                        }
                        return false;
                    } else if (action != 3) {
                        return false;
                    }
                }
                VelocityTracker velocityTracker = this.r;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.r = null;
                    return false;
                }
                return false;
            }
            this.m = x;
            if (this.p.isFinished()) {
                return false;
            }
            removeCallbacks(this.K);
            this.p.forceFinished(true);
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.B) {
                this.E.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.x;
        if (this.I) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds32);
            if (this.i > 0) {
                View v = v(0);
                t(v, this.j, this.k);
                paddingLeft = ((getMeasuredWidth() - v.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.B != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.x * 2)) + this.y) / 3;
                ViewGroup.LayoutParams layoutParams = this.B.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.B.setLayoutParams(layoutParams);
                t(this.B, this.j, this.k);
                paddingLeft = ((getMeasuredWidth() - this.B.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        for (int i6 = 0; i6 < this.i; i6++) {
            View v2 = v(i6);
            if (v2 != null && v2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = v2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    v2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(v2, -1, layoutParams2, true);
                t(v2, this.j, this.k);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = v2.getMeasuredWidth() + paddingLeft;
                v2.layout(paddingLeft, paddingTop, measuredWidth2, v2.getMeasuredHeight() + paddingTop);
                v2.setDrawingCacheEnabled(false);
                paddingLeft = measuredWidth2;
            }
        }
        if (this.B != null) {
            if (this.J) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.x * 2)) + this.y) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.B.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.B.setLayoutParams(layoutParams3);
            }
            t(this.B, this.j, this.k);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.B.getMeasuredWidth() + paddingLeft;
            this.B.layout(paddingLeft, paddingTop2, measuredWidth4, this.B.getMeasuredHeight() + paddingTop2);
            if (this.i == this.z) {
                paddingLeft = measuredWidth4 - this.B.getMeasuredWidth();
                this.D = false;
            } else {
                View view = this.B;
                addViewInLayout(view, -1, view.getLayoutParams(), true);
                this.D = true;
                paddingLeft = measuredWidth4;
            }
        }
        this.l = (paddingLeft + this.x) - this.y;
        if (this.A || z) {
            scrollTo(0, 0);
            scrollBy(p(), 0);
            this.A = false;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.H) {
            return true;
        }
        this.H = true;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.f21355h.h(view, null);
        this.f21353f = view;
        this.f21354g = indexOfChild(view);
        return true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        BaseAdapter baseAdapter = this.f21352e;
        int count = baseAdapter == null ? 0 : baseAdapter.getCount();
        this.i = count;
        int min = Math.min(this.z, count);
        this.i = min;
        if (min <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View v = v(0);
            t(v, i, i2);
            i4 = v.getMeasuredWidth();
            i3 = v.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        if (mode2 == 0) {
            size2 = getPaddingTop() + getPaddingBottom() + i3;
        }
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] u = u(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                size = ViewGroup.resolveSize(u[0], i);
                this.G = true;
            }
            if (mode2 == Integer.MIN_VALUE) {
                size2 = ViewGroup.resolveSize(u[1], i2);
            }
        }
        setMeasuredDimension(size, size2);
        this.j = i;
        this.k = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && o()) {
            if (this.r == null) {
                this.r = VelocityTracker.obtain();
            }
            this.r.addMovement(motionEvent);
            int action = motionEvent.getAction();
            float x = motionEvent.getX();
            if (action == 0) {
                if (!this.p.isFinished()) {
                    removeCallbacks(this.K);
                    this.p.forceFinished(true);
                }
                this.m = x;
            } else if (action == 1) {
                VelocityTracker velocityTracker = this.r;
                velocityTracker.computeCurrentVelocity(1000, this.t);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (Math.abs(xVelocity) > this.s) {
                    removeCallbacks(this.K);
                    int i = -xVelocity;
                    int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                    this.C = i2;
                    this.p.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                    post(this.K);
                }
                VelocityTracker velocityTracker2 = this.r;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.r = null;
                }
            } else if (action == 2) {
                this.m = x;
                w((int) (this.m - x));
            }
            return true;
        }
        return true;
    }

    public final int p() {
        if (o()) {
            return this.l - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    public int q(View view) {
        this.F = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.D) {
            this.l -= measuredWidth;
        } else {
            View view2 = this.B;
            if (view2 != null) {
                addViewInLayout(view2, -1, view2.getLayoutParams(), true);
                this.l += this.B.getMeasuredWidth();
            }
            this.l -= measuredWidth;
            this.D = true;
        }
        this.i--;
        removeViewInLayout(view);
        this.E.add(view);
        int childCount = getChildCount();
        if (childCount > 1) {
            for (int i = indexOfChild; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    childAt.offsetLeftAndRight(-measuredWidth);
                    TranslateAnimation translateAnimation = new TranslateAnimation(measuredWidth, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(500L);
                    translateAnimation.setFillAfter(true);
                    childAt.startAnimation(translateAnimation);
                }
            }
        }
        int scrollX = getScrollX();
        if (!o()) {
            this.o.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
            postInvalidate();
        } else if (scrollX > p()) {
            this.o.startScroll(scrollX, 0, p() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new b(), 500L);
        return indexOfChild;
    }

    public final void r(Context context) {
        this.f21353f = null;
        this.f21354g = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.n = viewConfiguration.getScaledTouchSlop();
        this.s = viewConfiguration.getScaledMinimumFlingVelocity();
        this.t = viewConfiguration.getScaledMaximumFlingVelocity();
        this.o = new Scroller(context, new LinearInterpolator());
        this.p = new Scroller(context);
        this.x = getResources().getDimensionPixelSize(R.dimen.ds66);
        this.y = getResources().getDimensionPixelSize(R.dimen.ds32);
    }

    public boolean s() {
        return this.F;
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        this.f21352e = baseAdapter;
        this.o.forceFinished(true);
        this.p.forceFinished(true);
        if (!this.A && z) {
            this.A = z;
        }
        requestLayout();
    }

    public void setAddView(View view) {
        this.B = view;
    }

    public void setCenterStart(boolean z) {
        this.I = z;
    }

    @Override // d.b.i0.c3.k0.c
    public void setDragController(d.b.i0.c3.k0.a aVar) {
        this.f21355h = aVar;
    }

    public void setMaxItemNum(int i) {
        this.z = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.J = z;
    }

    public void setOnSwapDataListener(c cVar) {
        this.w = cVar;
    }

    public void setPadding(int i) {
        this.y = i;
    }

    public void setStartEndSpace(int i) {
        this.x = i;
    }

    public final void t(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    public final int[] u(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.f21352e == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.i - 1;
        }
        while (i <= i2) {
            View v = v(i);
            if (v.getVisibility() != 8) {
                t(v, i3, i4);
                paddingLeft += v.getMeasuredWidth();
                paddingTop = Math.max(v.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingLeft;
        iArr[1] = paddingTop;
        return iArr;
    }

    public final View v(int i) {
        View remove = this.E.size() > 0 ? this.E.remove(0) : null;
        View view = this.f21352e.getView(i, remove, this);
        if (view != remove) {
            this.E.add(remove);
        }
        if (view != null) {
            view.setOnLongClickListener(this);
        }
        return view;
    }

    public final void w(int i) {
        scrollBy(x(i), 0);
        invalidate();
    }

    public final int x(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        return z ? i2 > p() ? p() - scrollX : i : i2 < 0 ? -scrollX : i;
    }

    public final void y() {
        removeCallbacks(this.K);
        this.o.forceFinished(true);
        this.p.forceFinished(true);
        View view = this.f21353f;
        if (view != null) {
            view.setVisibility(0);
            this.f21353f = null;
        }
        this.f21354g = -1;
        this.u = false;
        this.v = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.H = false;
    }

    public final void z(int i, int i2) {
        c cVar = this.w;
        if (cVar != null) {
            cVar.a(i, i2);
        }
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = new Rect();
        this.z = 10;
        this.E = new ArrayList<>();
        this.I = false;
        this.J = true;
        this.K = new a();
        r(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = new Rect();
        this.z = 10;
        this.E = new ArrayList<>();
        this.I = false;
        this.J = true;
        this.K = new a();
        r(context);
    }
}
