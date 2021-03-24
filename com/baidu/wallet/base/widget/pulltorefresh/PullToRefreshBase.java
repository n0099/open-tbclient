package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
/* loaded from: classes5.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final int f24108a = 150;

    /* renamed from: b  reason: collision with root package name */
    public static final float f24109b = 2.5f;

    /* renamed from: c  reason: collision with root package name */
    public float f24110c;

    /* renamed from: d  reason: collision with root package name */
    public OnRefreshListener<T> f24111d;

    /* renamed from: e  reason: collision with root package name */
    public int f24112e;

    /* renamed from: f  reason: collision with root package name */
    public int f24113f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24114g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24115h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public LoadingLayout.State m;
    public LoadingLayout mFooterLayout;
    public LoadingLayout mHeaderLayout;
    public boolean mIsPullUp;
    public LoadingLayout.State n;
    public T o;
    public PullToRefreshBase<T>.a p;
    public FrameLayout q;
    public int r;

    /* loaded from: classes5.dex */
    public interface OnRefreshListener<V extends View> {
        void onPullDownToRefresh(PullToRefreshBase<V> pullToRefreshBase);

        void onPullUpToRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes5.dex */
    public final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final Interpolator f24127b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24128c;

        /* renamed from: d  reason: collision with root package name */
        public final int f24129d;

        /* renamed from: e  reason: collision with root package name */
        public final long f24130e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f24131f;

        /* renamed from: g  reason: collision with root package name */
        public long f24132g;

        /* renamed from: h  reason: collision with root package name */
        public int f24133h;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f24130e <= 0) {
                PullToRefreshBase.this.a(0, this.f24128c);
                return;
            }
            if (this.f24132g == -1) {
                this.f24132g = System.currentTimeMillis();
            } else {
                int round = this.f24129d - Math.round((this.f24129d - this.f24128c) * this.f24127b.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f24132g) * 1000) / this.f24130e, 1000L), 0L)) / 1000.0f));
                this.f24133h = round;
                PullToRefreshBase.this.a(0, round);
            }
            if (!this.f24131f || this.f24128c == this.f24133h) {
                return;
            }
            PullToRefreshBase.this.postDelayed(this, 16L);
        }

        public a(int i, int i2, long j) {
            this.f24131f = true;
            this.f24132g = -1L;
            this.f24133h = -1;
            this.f24129d = i;
            this.f24128c = i2;
            this.f24130e = j;
            this.f24127b = new DecelerateInterpolator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f24131f = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.f24110c = -1.0f;
        this.f24114g = true;
        this.f24115h = false;
        this.i = false;
        this.j = true;
        this.k = false;
        LoadingLayout.State state = LoadingLayout.State.NONE;
        this.m = state;
        this.n = state;
        this.r = -1;
        this.mIsPullUp = false;
        a(context, (AttributeSet) null);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.j = z;
    }

    public void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.mHeaderLayout;
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout != null) {
            if (this == loadingLayout.getParent()) {
                removeView(loadingLayout);
            }
            addView(loadingLayout, 0, layoutParams);
        }
        if (loadingLayout2 != null) {
            if (this == loadingLayout2.getParent()) {
                removeView(loadingLayout2);
            }
            addView(loadingLayout2, -1, layoutParams);
        }
    }

    public void addRefreshableView(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.q = frameLayout;
        frameLayout.addView(t, -1, -1);
        addView(this.q, new LinearLayout.LayoutParams(-1, 10));
    }

    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context, attributeSet);
    }

    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        return new HeaderLoadingLayout(context, attributeSet);
    }

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public void doPullRefreshing(final boolean z, long j) {
        postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.5
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.f24112e;
                int i2 = z ? 150 : 0;
                PullToRefreshBase.this.startRefreshing();
                PullToRefreshBase.this.a(i, i2, 0L);
            }
        }, j);
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.mFooterLayout;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.mHeaderLayout;
    }

    public T getRefreshableView() {
        return this.o;
    }

    public long getSmoothScrollDuration() {
        return 150L;
    }

    public boolean isPullLoadEnabled() {
        return this.f24115h && this.mFooterLayout != null;
    }

    public boolean isPullLoading() {
        return this.n == LoadingLayout.State.REFRESHING;
    }

    public boolean isPullRefreshEnabled() {
        return this.f24114g && this.mHeaderLayout != null;
    }

    public boolean isPullRefreshing() {
        return this.m == LoadingLayout.State.REFRESHING;
    }

    public abstract boolean isReadyForPullDown();

    public abstract boolean isReadyForPullUp();

    public boolean isScrollLoadEnabled() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (b()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action != 3 && action != 1) {
                    if (action == 0 || !this.k) {
                        if (action == 0) {
                            this.f24110c = motionEvent.getY();
                            this.k = false;
                        } else if (action == 2) {
                            float y = motionEvent.getY() - this.f24110c;
                            this.mIsPullUp = y < 0.0f;
                            if (Math.abs(y) > this.l || isPullRefreshing() || isPullLoading()) {
                                this.f24110c = motionEvent.getY();
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                    this.k = z;
                                    if (z) {
                                        this.o.onTouchEvent(motionEvent);
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    this.k = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                                }
                            }
                        }
                        return this.k;
                    }
                    return true;
                }
                this.k = false;
                return false;
            }
            return false;
        }
        return false;
    }

    public void onPullDownRefreshComplete() {
        if (isPullRefreshing()) {
            LoadingLayout.State state = LoadingLayout.State.RESET;
            this.m = state;
            onStateChanged(state, true);
            postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                    PullToRefreshBase.this.mHeaderLayout.setState(LoadingLayout.State.RESET);
                }
            }, getSmoothScrollDuration());
            resetHeaderLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    public void onPullUpRefreshComplete() {
        if (isPullLoading()) {
            LoadingLayout.State state = LoadingLayout.State.RESET;
            this.n = state;
            onStateChanged(state, false);
            postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.4
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                    LoadingLayout footerLoadingLayout = PullToRefreshBase.this.getFooterLoadingLayout();
                    if (footerLoadingLayout != null) {
                        footerLoadingLayout.setState(LoadingLayout.State.RESET);
                    }
                }
            }, getSmoothScrollDuration());
            resetFooterLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    public void onStateChanged(LoadingLayout.State state, boolean z) {
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y = motionEvent.getY() - this.f24110c;
                    this.f24110c = motionEvent.getY();
                    if (isPullRefreshEnabled() && isReadyForPullDown()) {
                        pullHeaderLayout(y / 2.5f);
                    } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                        pullFooterLayout(y / 2.5f);
                    } else {
                        this.k = false;
                        return false;
                    }
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            if (this.k) {
                this.k = false;
                if (isReadyForPullDown()) {
                    if (this.f24114g && this.m == LoadingLayout.State.RELEASE_TO_REFRESH) {
                        startRefreshing();
                        z = true;
                    }
                    resetHeaderLayout();
                    return z;
                } else if (isReadyForPullUp()) {
                    if (isPullLoadEnabled() && this.n == LoadingLayout.State.RELEASE_TO_REFRESH) {
                        startLoading();
                        z = true;
                    }
                    resetFooterLayout();
                    return z;
                } else {
                    return false;
                }
            }
            return false;
        }
        this.f24110c = motionEvent.getY();
        this.k = false;
        return false;
    }

    public void pullFooterLayout(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
            a(0, 0);
            return;
        }
        b(0, -((int) f2));
        if (this.mFooterLayout != null && this.f24113f != 0) {
            this.mFooterLayout.onPull(Math.abs(getScrollYValue()) / this.f24113f);
        }
        int abs = Math.abs(getScrollYValue());
        if (!isPullLoadEnabled() || isPullLoading()) {
            return;
        }
        if (abs > this.f24113f) {
            this.n = LoadingLayout.State.RELEASE_TO_REFRESH;
        } else {
            this.n = LoadingLayout.State.PULL_TO_REFRESH;
        }
        this.mFooterLayout.setState(this.n);
        onStateChanged(this.n, false);
    }

    public void pullHeaderLayout(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
            a(0, 0);
        } else if (this.r <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.r) {
            b(0, -((int) f2));
            if (this.mHeaderLayout != null && this.f24112e != 0) {
                this.mHeaderLayout.onPull(Math.abs(getScrollYValue()) / this.f24112e);
            }
            int abs = Math.abs(getScrollYValue());
            if (!isPullRefreshEnabled() || isPullRefreshing()) {
                return;
            }
            if (abs > this.f24112e) {
                this.m = LoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.m = LoadingLayout.State.PULL_TO_REFRESH;
            }
            this.mHeaderLayout.setState(this.m);
            onStateChanged(this.m, true);
        }
    }

    public void refreshRefreshableViewSize(int i, int i2) {
        FrameLayout frameLayout = this.q;
        if (frameLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.q.requestLayout();
            }
        }
    }

    public void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.f24113f) {
            a(0);
        } else if (isPullLoading) {
            a(this.f24113f);
        } else {
            a(0);
        }
    }

    public void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.f24112e) {
            a(0);
        } else if (isPullRefreshing) {
            a(-this.f24112e);
        } else {
            a(0);
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setLastUpdatedLabel(charSequence);
        }
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setLastUpdatedLabel(charSequence);
        }
    }

    public void setLoadingAnimationStyle(LoadingLayout.AnimationStyle animationStyle) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout instanceof HeaderLoadingLayout) {
            ((HeaderLoadingLayout) loadingLayout).a(animationStyle);
        }
    }

    public void setMaxPullOffset(int i) {
        this.r = i;
    }

    public void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.f24111d = onRefreshListener;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (1 == i) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("This class only supports VERTICAL orientation.");
    }

    public void setPullLoadEnabled(boolean z) {
        this.f24115h = z;
    }

    public void setPullRefreshEnabled(boolean z) {
        this.f24114g = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.i = z;
    }

    public void showPullRefreshing(final boolean z, long j) {
        postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.6
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.f24112e;
                int i2 = z ? 150 : 0;
                PullToRefreshBase.this.a(false);
                PullToRefreshBase.this.a(i, i2, 0L);
            }
        }, j);
    }

    public void startLoading() {
        if (isPullLoading()) {
            return;
        }
        LoadingLayout.State state = LoadingLayout.State.REFRESHING;
        this.n = state;
        onStateChanged(state, false);
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(LoadingLayout.State.REFRESHING);
        }
        if (this.f24111d != null) {
            postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.8
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.f24111d.onPullUpToRefresh(PullToRefreshBase.this);
                }
            }, getSmoothScrollDuration());
        }
    }

    public void startRefreshing() {
        a(true);
    }

    private void b(int i, int i2) {
        scrollBy(i, i2);
    }

    private boolean b() {
        return this.j;
    }

    private void a(Context context, AttributeSet attributeSet) {
        setOrientation(1);
        this.l = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mHeaderLayout = createHeaderLoadingLayout(context, attributeSet);
        this.mFooterLayout = createFooterLoadingLayout(context, attributeSet);
        T createRefreshableView = createRefreshableView(context, attributeSet);
        this.o = createRefreshableView;
        if (createRefreshableView != null) {
            addRefreshableView(context, createRefreshableView);
            addHeaderAndFooter(context);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PullToRefreshBase.this.a();
                    PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
            return;
        }
        throw new NullPointerException("Refreshable view can not be null.");
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24110c = -1.0f;
        this.f24114g = true;
        this.f24115h = false;
        this.i = false;
        this.j = true;
        this.k = false;
        LoadingLayout.State state = LoadingLayout.State.NONE;
        this.m = state;
        this.n = state;
        this.r = -1;
        this.mIsPullUp = false;
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        int contentSize = loadingLayout != null ? loadingLayout.getContentSize() : 0;
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        int contentSize2 = loadingLayout2 != null ? loadingLayout2.getContentSize() : 0;
        if (contentSize < 0) {
            contentSize = 0;
        }
        if (contentSize2 < 0) {
            contentSize2 = 0;
        }
        this.f24112e = contentSize;
        this.f24113f = contentSize2;
        LoadingLayout loadingLayout3 = this.mHeaderLayout;
        int measuredHeight = loadingLayout3 != null ? loadingLayout3.getMeasuredHeight() : 0;
        LoadingLayout loadingLayout4 = this.mFooterLayout;
        int measuredHeight2 = loadingLayout4 != null ? loadingLayout4.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.f24113f;
        }
        int paddingLeft = getPaddingLeft();
        getPaddingTop();
        int paddingRight = getPaddingRight();
        getPaddingBottom();
        setPadding(paddingLeft, -measuredHeight, paddingRight, -measuredHeight2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (isPullRefreshing()) {
            return;
        }
        LoadingLayout.State state = LoadingLayout.State.REFRESHING;
        this.m = state;
        onStateChanged(state, true);
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(LoadingLayout.State.REFRESHING);
        }
        if (!z || this.f24111d == null) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.7
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.f24111d.onPullDownToRefresh(PullToRefreshBase.this);
            }
        }, getSmoothScrollDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        scrollTo(i, i2);
    }

    private void a(int i) {
        a(i, getSmoothScrollDuration(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, long j, long j2) {
        PullToRefreshBase<T>.a aVar = this.p;
        if (aVar != null) {
            aVar.a();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.p = new a(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.p, j2);
            } else {
                post(this.p);
            }
        }
    }
}
