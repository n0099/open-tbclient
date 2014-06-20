package com.baidu.tieba.img.view;

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
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private final int A;
    private int B;
    private boolean C;
    private ArrayList<View> D;
    private boolean E;
    private boolean F;
    private boolean G;
    private Runnable H;
    private final float a;
    private BaseAdapter b;
    private View c;
    private int d;
    private a e;
    private int f;
    private int g;
    private int h;
    private int i;
    private float j;
    private int k;
    private Scroller l;
    private Scroller m;
    private Rect n;
    private VelocityTracker o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private d t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private View y;
    private final int z;

    public DragHorizonScrollView(Context context) {
        super(context);
        this.a = 2.0f;
        this.n = new Rect();
        this.w = 10;
        this.z = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.A = 500;
        this.D = new ArrayList<>();
        this.H = new b(this);
        a(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 2.0f;
        this.n = new Rect();
        this.w = 10;
        this.z = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.A = 500;
        this.D = new ArrayList<>();
        this.H = new b(this);
        a(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 2.0f;
        this.n = new Rect();
        this.w = 10;
        this.z = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.A = 500;
        this.D = new ArrayList<>();
        this.H = new b(this);
        a(context);
    }

    private void a(Context context) {
        this.c = null;
        this.d = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.k = viewConfiguration.getScaledTouchSlop();
        this.p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = viewConfiguration.getScaledMaximumFlingVelocity();
        this.l = new Scroller(context, new LinearInterpolator());
        this.m = new Scroller(context);
        this.u = getResources().getDimensionPixelSize(t.editor_muti_image_upload_scrollview_paddingleft);
        this.v = getResources().getDimensionPixelSize(t.default_gap_24);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.f = this.b == null ? 0 : this.b.getCount();
        this.f = Math.min(this.w, this.f);
        if (this.f <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View a = a(0);
            a(a, i, i2);
            i4 = a.getMeasuredWidth();
            i3 = a.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] a2 = a(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(a2[0], i);
                this.F = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(a2[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.g = i;
        this.h = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.y) {
                this.D.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.u;
        for (int i6 = 0; i6 < this.f; i6++) {
            View a = a(i6);
            if (a.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = a.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                    a.setLayoutParams(layoutParams);
                }
                addViewInLayout(a, -1, layoutParams, true);
                a(a, this.g, this.h);
                int paddingTop = getPaddingTop();
                int measuredWidth = a.getMeasuredWidth() + paddingLeft;
                a.layout(paddingLeft, paddingTop, measuredWidth, a.getMeasuredHeight() + paddingTop);
                a.setDrawingCacheEnabled(false);
                paddingLeft = measuredWidth;
            }
        }
        if (this.y != null) {
            int measuredWidth2 = ((getMeasuredWidth() - (this.u * 2)) + this.v) / 3;
            ViewGroup.LayoutParams layoutParams2 = this.y.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(measuredWidth2, -1);
            }
            layoutParams2.width = measuredWidth2;
            layoutParams2.height = -1;
            this.y.setLayoutParams(layoutParams2);
            a(this.y, this.g, this.h);
            int paddingTop2 = getPaddingTop();
            int measuredWidth3 = this.y.getMeasuredWidth() + paddingLeft;
            this.y.layout(paddingLeft, paddingTop2, measuredWidth3, this.y.getMeasuredHeight() + paddingTop2);
            if (this.f == this.w) {
                paddingLeft = measuredWidth3 - this.y.getMeasuredWidth();
                this.C = false;
            } else {
                addViewInLayout(this.y, -1, this.y.getLayoutParams(), true);
                this.C = true;
                paddingLeft = measuredWidth3;
            }
        }
        this.i = (this.u + paddingLeft) - this.v;
        if (this.x || z) {
            scrollTo(0, 0);
            scrollBy(h(), 0);
            this.x = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.i > getMeasuredWidth();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2) {
        }
        if (g()) {
            if (this.o == null) {
                this.o = VelocityTracker.obtain();
            }
            this.o.addMovement(motionEvent);
            float x = motionEvent.getX();
            switch (action) {
                case 0:
                    this.j = x;
                    if (!this.m.isFinished()) {
                        removeCallbacks(this.H);
                        this.m.forceFinished(true);
                        z = false;
                        break;
                    }
                    z = false;
                    break;
                case 1:
                case 3:
                    if (this.o != null) {
                        this.o.recycle();
                        this.o = null;
                    }
                    z = false;
                    break;
                case 2:
                    int abs = (int) Math.abs(x - this.j);
                    this.j = x;
                    if (abs > this.k) {
                        if (getParent() != null) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            break;
                        }
                    }
                    z = false;
                    break;
                default:
                    z = false;
                    break;
            }
            return z;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && g()) {
            if (this.o == null) {
                this.o = VelocityTracker.obtain();
            }
            this.o.addMovement(motionEvent);
            int action = motionEvent.getAction();
            float x = motionEvent.getX();
            switch (action) {
                case 0:
                    if (!this.m.isFinished()) {
                        removeCallbacks(this.H);
                        this.m.forceFinished(true);
                    }
                    this.j = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.o;
                    velocityTracker.computeCurrentVelocity(1000, this.q);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.p) {
                        removeCallbacks(this.H);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.B = i2;
                        this.m.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.H);
                    }
                    if (this.o != null) {
                        this.o.recycle();
                        this.o = null;
                        break;
                    }
                    break;
                case 2:
                    this.j = x;
                    b((int) (this.j - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.b = baseAdapter;
        this.l.forceFinished(true);
        this.m.forceFinished(true);
        if (!this.x && z) {
            this.x = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.b;
    }

    private View a(int i) {
        View view = null;
        if (this.D.size() > 0) {
            view = this.D.remove(0);
        }
        View view2 = this.b.getView(i, view, this);
        if (view2 != view) {
            this.D.add(view);
        }
        view2.setOnLongClickListener(this);
        return view2;
    }

    private void a(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] a(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.b == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.f - 1;
        }
        while (i <= i2) {
            View a = a(i);
            if (a.getVisibility() != 8) {
                a(a, i3, i4);
                paddingRight += a.getMeasuredWidth();
                paddingTop = Math.max(a.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        if (g()) {
            return this.i - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        scrollBy(c(i), 0);
        invalidate();
    }

    private int c(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > h()) {
                i = h() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.G) {
            this.G = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.e.a(view, null);
            this.c = view;
            this.d = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.l.computeScrollOffset()) {
            scrollTo(this.l.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.r || this.s) && this.e != null) {
                this.e.b();
                return;
            }
            return;
        }
        this.r = false;
        this.s = false;
    }

    @Override // com.baidu.tieba.img.view.f
    public void setDragController(a aVar) {
        this.e = aVar;
    }

    @Override // com.baidu.tieba.img.view.g
    public void a(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.d && (childAt = getChildAt(i)) != this.y) {
                childAt.getHitRect(this.n);
                if (this.n.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.d;
                    b(i2, i);
                    a(i2, i);
                    this.d = i;
                    return;
                }
            }
        }
    }

    private void a(int i, int i2) {
        if (this.t != null) {
            this.t.a(i, i2);
        }
    }

    private void b(int i, int i2) {
        if (i != i2) {
            View childAt = getChildAt(i);
            View childAt2 = getChildAt(i2);
            if (i < i2) {
                detachViewFromParent(i);
                int i3 = -childAt.getMeasuredWidth();
                int left = childAt2.getLeft() - childAt.getLeft();
                while (i < i2) {
                    View childAt3 = getChildAt(i);
                    childAt3.offsetLeftAndRight(i3);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-i3, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setFillAfter(true);
                    childAt3.startAnimation(translateAnimation);
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
                childAt4.offsetLeftAndRight(measuredWidth);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(-measuredWidth, 0.0f, 0.0f, 0.0f);
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                childAt4.startAnimation(translateAnimation2);
            }
            attachViewToParent(childAt, i2, childAt.getLayoutParams());
            childAt.offsetLeftAndRight(left2);
        }
    }

    @Override // com.baidu.tieba.img.view.g
    public void a() {
        if (!this.r) {
            this.r = true;
            int scrollX = getScrollX();
            this.l.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.img.view.g
    public void b() {
        if (!this.s) {
            this.s = true;
            int h = h();
            int scrollX = getScrollX();
            int scrollX2 = h - getScrollX();
            this.l.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.img.view.g
    public void c() {
        if (!this.l.isFinished()) {
            this.l.forceFinished(true);
        }
        this.r = false;
        this.s = false;
    }

    @Override // com.baidu.tieba.img.view.g
    public void d() {
        i();
    }

    public void setOnSwapDataListener(d dVar) {
        this.t = dVar;
    }

    public void setMaxItemNum(int i) {
        this.w = i;
    }

    public int getMaxItemNum() {
        return this.w;
    }

    public void setAddView(View view) {
        this.y = view;
    }

    public int a(View view) {
        this.E = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.C) {
            this.i -= measuredWidth;
        } else {
            addViewInLayout(this.y, -1, this.y.getLayoutParams(), true);
            this.i -= measuredWidth;
            this.i += this.y.getMeasuredWidth();
            this.C = true;
        }
        this.f--;
        removeViewInLayout(view);
        this.D.add(view);
        int childCount = getChildCount();
        for (int i = indexOfChild; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.offsetLeftAndRight(-measuredWidth);
            TranslateAnimation translateAnimation = new TranslateAnimation(measuredWidth, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            childAt.startAnimation(translateAnimation);
        }
        int scrollX = getScrollX();
        if (!g()) {
            this.l.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
            postInvalidate();
        } else if (scrollX > h()) {
            this.l.startScroll(scrollX, 0, h() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean e() {
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    private void i() {
        removeCallbacks(this.H);
        this.l.forceFinished(true);
        this.m.forceFinished(true);
        if (this.c != null) {
            this.c.setVisibility(0);
            this.c = null;
        }
        this.d = -1;
        this.r = false;
        this.s = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.G = false;
    }

    public void f() {
        this.l.forceFinished(true);
        this.m.forceFinished(true);
        requestLayout();
    }
}
