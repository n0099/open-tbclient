package com.baidu.wallet.home.ui.widget.inner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes5.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public Runnable A;

    /* renamed from: a  reason: collision with root package name */
    public final a f24390a;

    /* renamed from: b  reason: collision with root package name */
    public GestureDetector f24391b;

    /* renamed from: c  reason: collision with root package name */
    public int f24392c;

    /* renamed from: d  reason: collision with root package name */
    public List<Queue<View>> f24393d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24394e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f24395f;

    /* renamed from: g  reason: collision with root package name */
    public View f24396g;

    /* renamed from: h  reason: collision with root package name */
    public int f24397h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f24398i;
    public Integer j;
    public int k;
    public int l;
    public int m;
    public ListAdapter mAdapter;
    public int mCurrentX;
    public Scroller mFlingTracker;
    public int mNextX;
    public int n;
    public d o;
    public int p;
    public boolean q;
    public OnScrollStateChangedListener r;
    public OnScrollStateChangedListener.ScrollState s;
    public EdgeEffectCompat t;
    public EdgeEffectCompat u;
    public int v;
    public boolean w;
    public boolean x;
    public View.OnClickListener y;
    public DataSetObserver z;

    /* loaded from: classes5.dex */
    public interface OnScrollStateChangedListener {

        /* loaded from: classes5.dex */
        public enum ScrollState {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }

        void a(ScrollState scrollState);
    }

    /* loaded from: classes5.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return HorizontalListView.this.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            HorizontalListView.this.f();
            int c2 = HorizontalListView.this.c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (c2 < 0 || HorizontalListView.this.w) {
                return;
            }
            View childAt = HorizontalListView.this.getChildAt(c2);
            AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.getOnItemLongClickListener();
            if (onItemLongClickListener != null) {
                int i2 = HorizontalListView.this.l + c2;
                HorizontalListView horizontalListView = HorizontalListView.this;
                if (onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i2, horizontalListView.mAdapter.getItemId(i2))) {
                    HorizontalListView.this.performHapticFeedback(0);
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            HorizontalListView.this.a(Boolean.TRUE);
            HorizontalListView.this.setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListView.this.f();
            HorizontalListView horizontalListView = HorizontalListView.this;
            horizontalListView.mNextX += (int) f2;
            horizontalListView.i(Math.round(f2));
            HorizontalListView.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HorizontalListView.this.f();
            AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.getOnItemClickListener();
            int c2 = HorizontalListView.this.c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (c2 >= 0 && !HorizontalListView.this.w) {
                View childAt = HorizontalListView.this.getChildAt(c2);
                int i2 = HorizontalListView.this.l + c2;
                if (onItemClickListener != null) {
                    HorizontalListView horizontalListView = HorizontalListView.this;
                    onItemClickListener.onItemClick(horizontalListView, childAt, i2, horizontalListView.mAdapter.getItemId(i2));
                    return true;
                }
            }
            if (HorizontalListView.this.y == null || HorizontalListView.this.w) {
                return false;
            }
            HorizontalListView.this.y.onClick(HorizontalListView.this);
            return false;
        }
    }

    @TargetApi(11)
    /* loaded from: classes5.dex */
    public static final class b {
        static {
            if (Build.VERSION.SDK_INT < 11) {
                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
            }
        }

        public static void a(Scroller scroller, float f2) {
            if (scroller != null) {
                scroller.setFriction(f2);
            }
        }
    }

    @TargetApi(14)
    /* loaded from: classes5.dex */
    public static final class c {
        static {
            if (Build.VERSION.SDK_INT < 14) {
                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
            }
        }

        public static float a(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlingTracker = new Scroller(getContext());
        this.f24390a = new a();
        this.f24393d = new ArrayList();
        this.f24394e = false;
        this.f24395f = new Rect();
        this.f24396g = null;
        this.f24397h = 0;
        this.f24398i = null;
        this.j = null;
        this.k = Integer.MAX_VALUE;
        this.o = null;
        this.p = 0;
        this.q = false;
        this.r = null;
        this.s = OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE;
        this.w = false;
        this.x = false;
        this.z = new DataSetObserver() { // from class: com.baidu.wallet.home.ui.widget.inner.HorizontalListView.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                HorizontalListView.this.f24394e = true;
                HorizontalListView.this.q = false;
                HorizontalListView.this.f();
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                HorizontalListView.this.q = false;
                HorizontalListView.this.f();
                HorizontalListView.this.c();
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }
        };
        this.A = new Runnable() { // from class: com.baidu.wallet.home.ui.widget.inner.HorizontalListView.3
            @Override // java.lang.Runnable
            public void run() {
                HorizontalListView.this.requestLayout();
            }
        };
        this.t = new EdgeEffectCompat(context);
        this.u = new EdgeEffectCompat(context);
        this.f24391b = new GestureDetector(context, this.f24390a);
        a();
        b();
        setWillNotDraw(false);
        b.a(this.mFlingTracker, 0.009f);
    }

    private View g(int i2) {
        int i3 = this.l;
        if (i2 < i3 || i2 > this.m) {
            return null;
        }
        return getChildAt(i2 - i3);
    }

    private View getLeftmostChild() {
        return getChildAt(0);
    }

    private int getRenderHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getRenderWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private View getRightmostChild() {
        return getChildAt(getChildCount() - 1);
    }

    private boolean h(int i2) {
        return i2 == this.mAdapter.getCount() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i2) {
        if (this.t == null || this.u == null) {
            return;
        }
        int i3 = this.mCurrentX + i2;
        Scroller scroller = this.mFlingTracker;
        if (scroller == null || scroller.isFinished()) {
            if (i3 < 0) {
                this.t.onPull(Math.abs(i2) / getRenderWidth());
                if (this.u.isFinished()) {
                    return;
                }
                this.u.onRelease();
            } else if (i3 > this.k) {
                this.u.onPull(Math.abs(i2) / getRenderWidth());
                if (this.t.isFinished()) {
                    return;
                }
                this.t.onRelease();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentScrollState(OnScrollStateChangedListener.ScrollState scrollState) {
        OnScrollStateChangedListener onScrollStateChangedListener;
        if (this.s != scrollState && (onScrollStateChangedListener = this.r) != null) {
            onScrollStateChangedListener.a(scrollState);
        }
        this.s = scrollState;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        a(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return this.l;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return this.m;
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i2 = this.mCurrentX;
        if (i2 == 0) {
            return 0.0f;
        }
        if (i2 < horizontalFadingEdgeLength) {
            return i2 / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i2 = this.mCurrentX;
        int i3 = this.k;
        if (i2 == i3) {
            return 0.0f;
        }
        if (i3 - i2 < horizontalFadingEdgeLength) {
            return (i3 - i2) / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return g(this.n);
    }

    public boolean onDown(MotionEvent motionEvent) {
        int c2;
        this.w = !this.mFlingTracker.isFinished();
        this.mFlingTracker.forceFinished(true);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        f();
        if (!this.w && (c2 = c((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
            View childAt = getChildAt(c2);
            this.f24396g = childAt;
            if (childAt != null) {
                childAt.setPressed(true);
                refreshDrawableState();
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.mFlingTracker.fling(this.mNextX, 0, (int) (-f2), 0, 0, this.k, 0, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.mAdapter == null) {
            return;
        }
        invalidate();
        if (this.f24394e) {
            int i6 = this.mCurrentX;
            b();
            removeAllViewsInLayout();
            this.mNextX = i6;
            this.f24394e = false;
        }
        Integer num = this.j;
        if (num != null) {
            this.mNextX = num.intValue();
            this.j = null;
        }
        if (this.mFlingTracker.computeScrollOffset()) {
            this.mNextX = this.mFlingTracker.getCurrX();
        }
        int i7 = this.mNextX;
        if (i7 < 0) {
            this.mNextX = 0;
            if (this.t.isFinished()) {
                this.t.onAbsorb((int) d());
            }
            this.mFlingTracker.forceFinished(true);
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        } else {
            int i8 = this.k;
            if (i7 > i8) {
                this.mNextX = i8;
                if (this.u.isFinished()) {
                    this.u.onAbsorb((int) d());
                }
                this.mFlingTracker.forceFinished(true);
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
        }
        int i9 = this.mCurrentX - this.mNextX;
        e(i9);
        d(i9);
        f(i9);
        this.mCurrentX = this.mNextX;
        if (e()) {
            onLayout(z, i2, i3, i4, i5);
        } else if (this.mFlingTracker.isFinished()) {
            if (this.s == OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING) {
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
        } else {
            ViewCompat.postOnAnimation(this, this.A);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.v = i3;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.j = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.mCurrentX);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            Scroller scroller = this.mFlingTracker;
            if (scroller == null || scroller.isFinished()) {
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
            a(Boolean.FALSE);
            g();
        } else if (motionEvent.getAction() == 3) {
            f();
            g();
            a(Boolean.FALSE);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollTo(int i2) {
        Scroller scroller = this.mFlingTracker;
        int i3 = this.mNextX;
        scroller.startScroll(i3, 0, i2 - i3, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
    }

    public void setDivider(Drawable drawable) {
        this.f24398i = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int i2) {
        this.f24397h = i2;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        this.r = onScrollStateChangedListener;
    }

    public void setRunningOutOfDataListener(d dVar, int i2) {
        this.o = dVar;
        this.p = i2;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i2) {
        this.n = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        removeAllViewsInLayout();
        requestLayout();
    }

    private float d() {
        if (Build.VERSION.SDK_INT >= 14) {
            return c.a(this.mFlingTracker);
        }
        return 30.0f;
    }

    private boolean e() {
        View rightmostChild;
        if (h(this.m) && (rightmostChild = getRightmostChild()) != null) {
            int i2 = this.k;
            int right = (this.mCurrentX + (rightmostChild.getRight() - getPaddingLeft())) - getRenderWidth();
            this.k = right;
            if (right < 0) {
                this.k = 0;
            }
            if (this.k != i2) {
                return true;
            }
        }
        return false;
    }

    private void f(int i2) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i3 = this.f24392c + i2;
            this.f24392c = i3;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                int paddingLeft = getPaddingLeft() + i3;
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                i3 += childAt.getMeasuredWidth() + this.f24397h;
            }
        }
    }

    private void h() {
        ListAdapter listAdapter;
        if (this.o == null || (listAdapter = this.mAdapter) == null || listAdapter.getCount() - (this.m + 1) >= this.p || this.q) {
            return;
        }
        this.q = true;
        this.o.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.z);
        }
        if (listAdapter != null) {
            this.q = false;
            this.mAdapter = listAdapter;
            listAdapter.registerDataSetObserver(this.z);
            a(this.mAdapter.getViewTypeCount());
        }
        c();
    }

    private void b() {
        this.l = -1;
        this.m = -1;
        this.f24392c = 0;
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.k = Integer.MAX_VALUE;
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
    }

    private void g() {
        EdgeEffectCompat edgeEffectCompat = this.t;
        if (edgeEffectCompat != null) {
            edgeEffectCompat.onRelease();
        }
        EdgeEffectCompat edgeEffectCompat2 = this.u;
        if (edgeEffectCompat2 != null) {
            edgeEffectCompat2.onRelease();
        }
    }

    private void d(int i2) {
        View rightmostChild = getRightmostChild();
        a(rightmostChild != null ? rightmostChild.getRight() : 0, i2);
        View leftmostChild = getLeftmostChild();
        b(leftmostChild != null ? leftmostChild.getLeft() : 0, i2);
    }

    private boolean c(int i2) {
        return i2 < this.f24393d.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i2, int i3) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).getHitRect(this.f24395f);
            if (this.f24395f.contains(i2, i3)) {
                return i4;
            }
        }
        return -1;
    }

    private void a() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.home.ui.widget.inner.HorizontalListView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return HorizontalListView.this.f24391b.onTouchEvent(motionEvent);
            }
        });
    }

    private void e(int i2) {
        View leftmostChild = getLeftmostChild();
        while (leftmostChild != null && leftmostChild.getRight() + i2 <= 0) {
            this.f24392c += h(this.l) ? leftmostChild.getMeasuredWidth() : this.f24397h + leftmostChild.getMeasuredWidth();
            a(this.l, leftmostChild);
            removeViewInLayout(leftmostChild);
            this.l++;
            leftmostChild = getLeftmostChild();
        }
        View rightmostChild = getRightmostChild();
        while (rightmostChild != null && rightmostChild.getLeft() + i2 >= getWidth()) {
            a(this.m, rightmostChild);
            removeViewInLayout(rightmostChild);
            this.m--;
            rightmostChild = getRightmostChild();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        if (this.x != bool.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.x = bool.booleanValue();
                    return;
                }
            }
        }
    }

    private View b(int i2) {
        int itemViewType = this.mAdapter.getItemViewType(i2);
        if (c(itemViewType)) {
            return this.f24393d.get(itemViewType).poll();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        View view = this.f24396g;
        if (view != null) {
            view.setPressed(false);
            refreshDrawableState();
            this.f24396g = null;
        }
    }

    private ViewGroup.LayoutParams b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
    }

    private boolean i() {
        ListAdapter listAdapter = this.mAdapter;
        return (listAdapter == null || listAdapter.isEmpty() || this.k <= 0) ? false : true;
    }

    private void a(int i2) {
        this.f24393d.clear();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f24393d.add(new LinkedList());
        }
    }

    private void b(int i2, int i3) {
        int i4;
        while ((i2 + i3) - this.f24397h > 0 && (i4 = this.l) >= 1) {
            int i5 = i4 - 1;
            this.l = i5;
            View view = this.mAdapter.getView(i5, b(i5), this);
            a(view, 0);
            i2 -= this.l == 0 ? view.getMeasuredWidth() : this.f24397h + view.getMeasuredWidth();
            this.f24392c -= i2 + i3 == 0 ? view.getMeasuredWidth() : view.getMeasuredWidth() + this.f24397h;
        }
    }

    private void a(int i2, View view) {
        int itemViewType = this.mAdapter.getItemViewType(i2);
        if (c(itemViewType)) {
            this.f24393d.get(itemViewType).offer(view);
        }
    }

    private void a(View view, int i2) {
        addViewInLayout(view, i2, b(view), true);
        a(view);
    }

    private void b(Canvas canvas) {
        int childCount = getChildCount();
        Rect rect = this.f24395f;
        rect.top = getPaddingTop();
        Rect rect2 = this.f24395f;
        rect2.bottom = rect2.top + getRenderHeight();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (i2 != childCount - 1 || !h(this.m)) {
                View childAt = getChildAt(i2);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.f24397h;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i2 == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
    }

    private void a(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams b2 = b(view);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.v, getPaddingTop() + getPaddingBottom(), b2.height);
        int i2 = b2.width;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void a(int i2, int i3) {
        while (i2 + i3 + this.f24397h < getWidth() && this.m + 1 < this.mAdapter.getCount()) {
            int i4 = this.m + 1;
            this.m = i4;
            if (this.l < 0) {
                this.l = i4;
            }
            ListAdapter listAdapter = this.mAdapter;
            int i5 = this.m;
            View view = listAdapter.getView(i5, b(i5), this);
            a(view, -1);
            i2 += (this.m == 0 ? 0 : this.f24397h) + view.getMeasuredWidth();
            h();
        }
    }

    private void a(Canvas canvas) {
        EdgeEffectCompat edgeEffectCompat = this.t;
        if (edgeEffectCompat != null && !edgeEffectCompat.isFinished() && i()) {
            int save = canvas.save();
            int height = getHeight();
            canvas.rotate(-90.0f, 0.0f, 0.0f);
            canvas.translate((-height) + getPaddingBottom(), 0.0f);
            this.t.setSize(getRenderHeight(), getRenderWidth());
            if (this.t.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save);
            return;
        }
        EdgeEffectCompat edgeEffectCompat2 = this.u;
        if (edgeEffectCompat2 == null || edgeEffectCompat2.isFinished() || !i()) {
            return;
        }
        int save2 = canvas.save();
        int width = getWidth();
        canvas.rotate(90.0f, 0.0f, 0.0f);
        canvas.translate(getPaddingTop(), -width);
        this.u.setSize(getRenderHeight(), getRenderWidth());
        if (this.u.draw(canvas)) {
            invalidate();
        }
        canvas.restoreToCount(save2);
    }

    private void a(Canvas canvas, Rect rect) {
        Drawable drawable = this.f24398i;
        if (drawable != null) {
            drawable.setBounds(rect);
            this.f24398i.draw(canvas);
        }
    }
}
