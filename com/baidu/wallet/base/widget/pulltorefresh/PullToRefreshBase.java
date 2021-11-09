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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
/* loaded from: classes10.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f57846a = 150;

    /* renamed from: b  reason: collision with root package name */
    public static final float f57847b = 2.5f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public float f57848c;

    /* renamed from: d  reason: collision with root package name */
    public OnRefreshListener<T> f57849d;

    /* renamed from: e  reason: collision with root package name */
    public int f57850e;

    /* renamed from: f  reason: collision with root package name */
    public int f57851f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57852g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57853h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57854i;
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

    /* loaded from: classes10.dex */
    public interface OnRefreshListener<V extends View> {
        void onPullDownToRefresh(PullToRefreshBase<V> pullToRefreshBase);

        void onPullUpToRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes10.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f57865a;

        /* renamed from: b  reason: collision with root package name */
        public final Interpolator f57866b;

        /* renamed from: c  reason: collision with root package name */
        public final int f57867c;

        /* renamed from: d  reason: collision with root package name */
        public final int f57868d;

        /* renamed from: e  reason: collision with root package name */
        public final long f57869e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57870f;

        /* renamed from: g  reason: collision with root package name */
        public long f57871g;

        /* renamed from: h  reason: collision with root package name */
        public int f57872h;

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f57869e <= 0) {
                    this.f57865a.a(0, this.f57867c);
                    return;
                }
                if (this.f57871g == -1) {
                    this.f57871g = System.currentTimeMillis();
                } else {
                    int round = this.f57868d - Math.round((this.f57868d - this.f57867c) * this.f57866b.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f57871g) * 1000) / this.f57869e, 1000L), 0L)) / 1000.0f));
                    this.f57872h = round;
                    this.f57865a.a(0, round);
                }
                if (!this.f57870f || this.f57867c == this.f57872h) {
                    return;
                }
                this.f57865a.postDelayed(this, 16L);
            }
        }

        public a(PullToRefreshBase pullToRefreshBase, int i2, int i3, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57865a = pullToRefreshBase;
            this.f57870f = true;
            this.f57871g = -1L;
            this.f57872h = -1;
            this.f57868d = i2;
            this.f57867c = i3;
            this.f57869e = j;
            this.f57866b = new DecelerateInterpolator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f57870f = false;
                this.f57865a.removeCallbacks(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57848c = -1.0f;
        this.f57852g = true;
        this.f57853h = false;
        this.f57854i = false;
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? getScrollY() : invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            this.j = z;
        }
    }

    public void addHeaderAndFooter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
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
    }

    public void addRefreshableView(Context context, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, t) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            this.q = frameLayout;
            frameLayout.addView(t, -1, -1);
            addView(this.q, new LinearLayout.LayoutParams(-1, 10));
        }
    }

    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet)) == null) ? new FooterLoadingLayout(context, attributeSet) : (LoadingLayout) invokeLL.objValue;
    }

    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, attributeSet)) == null) ? new HeaderLoadingLayout(context, attributeSet) : (LoadingLayout) invokeLL.objValue;
    }

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public void doPullRefreshing(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            postDelayed(new Runnable(this, z) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f57859a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PullToRefreshBase f57860b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57860b = this;
                    this.f57859a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int i2 = -this.f57860b.f57850e;
                        int i3 = this.f57859a ? 150 : 0;
                        this.f57860b.startRefreshing();
                        this.f57860b.a(i2, i3, 0L);
                    }
                }
            }, j);
        }
    }

    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mFooterLayout : (LoadingLayout) invokeV.objValue;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mHeaderLayout : (LoadingLayout) invokeV.objValue;
    }

    public T getRefreshableView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.o : (T) invokeV.objValue;
    }

    public long getSmoothScrollDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 150L;
        }
        return invokeV.longValue;
    }

    public boolean isPullLoadEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f57853h && this.mFooterLayout != null : invokeV.booleanValue;
    }

    public boolean isPullLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n == LoadingLayout.State.REFRESHING : invokeV.booleanValue;
    }

    public boolean isPullRefreshEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f57852g && this.mHeaderLayout != null : invokeV.booleanValue;
    }

    public boolean isPullRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.m == LoadingLayout.State.REFRESHING : invokeV.booleanValue;
    }

    public abstract boolean isReadyForPullDown();

    public abstract boolean isReadyForPullUp();

    public boolean isScrollLoadEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f57854i : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            boolean z = false;
            if (b()) {
                if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                    int action = motionEvent.getAction();
                    if (action != 3 && action != 1) {
                        if (action == 0 || !this.k) {
                            if (action == 0) {
                                this.f57848c = motionEvent.getY();
                                this.k = false;
                            } else if (action == 2) {
                                float y = motionEvent.getY() - this.f57848c;
                                this.mIsPullUp = y < 0.0f;
                                if (Math.abs(y) > this.l || isPullRefreshing() || isPullLoading()) {
                                    this.f57848c = motionEvent.getY();
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
        return invokeL.booleanValue;
    }

    public void onPullDownRefreshComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && isPullRefreshing()) {
            LoadingLayout.State state = LoadingLayout.State.RESET;
            this.m = state;
            onStateChanged(state, true);
            postDelayed(new Runnable(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PullToRefreshBase f57857a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57857a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f57857a.setInterceptTouchEventEnabled(true);
                        this.f57857a.mHeaderLayout.setState(LoadingLayout.State.RESET);
                    }
                }
            }, getSmoothScrollDuration());
            resetHeaderLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    public void onPullUpRefreshComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && isPullLoading()) {
            LoadingLayout.State state = LoadingLayout.State.RESET;
            this.n = state;
            onStateChanged(state, false);
            postDelayed(new Runnable(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PullToRefreshBase f57858a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57858a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f57858a.setInterceptTouchEventEnabled(true);
                        LoadingLayout footerLoadingLayout = this.f57858a.getFooterLoadingLayout();
                        if (footerLoadingLayout != null) {
                            footerLoadingLayout.setState(LoadingLayout.State.RESET);
                        }
                    }
                }
            }, getSmoothScrollDuration());
            resetFooterLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048596, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            a();
            refreshRefreshableViewSize(i2, i3);
            post(new Runnable(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PullToRefreshBase f57856a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i6 = newInitContext.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57856a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f57856a.requestLayout();
                    }
                }
            });
        }
    }

    public void onStateChanged(LoadingLayout.State state, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, state, z) == null) {
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float y = motionEvent.getY() - this.f57848c;
                        this.f57848c = motionEvent.getY();
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
                        if (this.f57852g && this.m == LoadingLayout.State.RELEASE_TO_REFRESH) {
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
            this.f57848c = motionEvent.getY();
            this.k = false;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void pullFooterLayout(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
                a(0, 0);
                return;
            }
            b(0, -((int) f2));
            if (this.mFooterLayout != null && this.f57851f != 0) {
                this.mFooterLayout.onPull(Math.abs(getScrollYValue()) / this.f57851f);
            }
            int abs = Math.abs(getScrollYValue());
            if (!isPullLoadEnabled() || isPullLoading()) {
                return;
            }
            if (abs > this.f57851f) {
                this.n = LoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.n = LoadingLayout.State.PULL_TO_REFRESH;
            }
            this.mFooterLayout.setState(this.n);
            onStateChanged(this.n, false);
        }
    }

    public void pullHeaderLayout(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
                a(0, 0);
            } else if (this.r <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.r) {
                b(0, -((int) f2));
                if (this.mHeaderLayout != null && this.f57850e != 0) {
                    this.mHeaderLayout.onPull(Math.abs(getScrollYValue()) / this.f57850e);
                }
                int abs = Math.abs(getScrollYValue());
                if (!isPullRefreshEnabled() || isPullRefreshing()) {
                    return;
                }
                if (abs > this.f57850e) {
                    this.m = LoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.m = LoadingLayout.State.PULL_TO_REFRESH;
                }
                this.mHeaderLayout.setState(this.m);
                onStateChanged(this.m, true);
            }
        }
    }

    public void refreshRefreshableViewSize(int i2, int i3) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) || (frameLayout = this.q) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        if (layoutParams.height != i3) {
            layoutParams.height = i3;
            this.q.requestLayout();
        }
    }

    public void resetFooterLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean isPullLoading = isPullLoading();
            if (isPullLoading && abs <= this.f57851f) {
                a(0);
            } else if (isPullLoading) {
                a(this.f57851f);
            } else {
                a(0);
            }
        }
    }

    public void resetHeaderLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean isPullRefreshing = isPullRefreshing();
            if (isPullRefreshing && abs <= this.f57850e) {
                a(0);
            } else if (isPullRefreshing) {
                a(-this.f57850e);
            } else {
                a(0);
            }
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, charSequence) == null) {
            LoadingLayout loadingLayout = this.mHeaderLayout;
            if (loadingLayout != null) {
                loadingLayout.setLastUpdatedLabel(charSequence);
            }
            LoadingLayout loadingLayout2 = this.mFooterLayout;
            if (loadingLayout2 != null) {
                loadingLayout2.setLastUpdatedLabel(charSequence);
            }
        }
    }

    public void setLoadingAnimationStyle(LoadingLayout.AnimationStyle animationStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, animationStyle) == null) {
            LoadingLayout loadingLayout = this.mHeaderLayout;
            if (loadingLayout instanceof HeaderLoadingLayout) {
                ((HeaderLoadingLayout) loadingLayout).a(animationStyle);
            }
        }
    }

    public void setMaxPullOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onRefreshListener) == null) {
            this.f57849d = onRefreshListener;
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (1 == i2) {
                super.setOrientation(i2);
                return;
            }
            throw new IllegalArgumentException("This class only supports VERTICAL orientation.");
        }
    }

    public void setPullLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f57853h = z;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f57852g = z;
        }
    }

    public void setScrollLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f57854i = z;
        }
    }

    public void showPullRefreshing(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            postDelayed(new Runnable(this, z) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f57861a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PullToRefreshBase f57862b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57862b = this;
                    this.f57861a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int i2 = -this.f57862b.f57850e;
                        int i3 = this.f57861a ? 150 : 0;
                        this.f57862b.a(false);
                        this.f57862b.a(i2, i3, 0L);
                    }
                }
            }, j);
        }
    }

    public void startLoading() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || isPullLoading()) {
            return;
        }
        LoadingLayout.State state = LoadingLayout.State.REFRESHING;
        this.n = state;
        onStateChanged(state, false);
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(LoadingLayout.State.REFRESHING);
        }
        if (this.f57849d != null) {
            postDelayed(new Runnable(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PullToRefreshBase f57864a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57864a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f57864a.f57849d.onPullUpToRefresh(this.f57864a);
                    }
                }
            }, getSmoothScrollDuration());
        }
    }

    public void startRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            a(true);
        }
    }

    private void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, this, i2, i3) == null) {
            scrollBy(i2, i3);
        }
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? this.j : invokeV.booleanValue;
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, context, attributeSet) == null) {
            setOrientation(1);
            this.l = ViewConfiguration.get(context).getScaledTouchSlop();
            this.mHeaderLayout = createHeaderLoadingLayout(context, attributeSet);
            this.mFooterLayout = createFooterLoadingLayout(context, attributeSet);
            T createRefreshableView = createRefreshableView(context, attributeSet);
            this.o = createRefreshableView;
            if (createRefreshableView != null) {
                addRefreshableView(context, createRefreshableView);
                addHeaderAndFooter(context);
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PullToRefreshBase f57855a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57855a = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f57855a.a();
                            this.f57855a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        }
                    }
                });
                return;
            }
            throw new NullPointerException("Refreshable view can not be null.");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57848c = -1.0f;
        this.f57852g = true;
        this.f57853h = false;
        this.f57854i = false;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
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
            this.f57850e = contentSize;
            this.f57851f = contentSize2;
            LoadingLayout loadingLayout3 = this.mHeaderLayout;
            int measuredHeight = loadingLayout3 != null ? loadingLayout3.getMeasuredHeight() : 0;
            LoadingLayout loadingLayout4 = this.mFooterLayout;
            int measuredHeight2 = loadingLayout4 != null ? loadingLayout4.getMeasuredHeight() : 0;
            if (measuredHeight2 == 0) {
                measuredHeight2 = this.f57851f;
            }
            int paddingLeft = getPaddingLeft();
            getPaddingTop();
            int paddingRight = getPaddingRight();
            getPaddingBottom();
            setPadding(paddingLeft, -measuredHeight, paddingRight, -measuredHeight2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65547, this, z) == null) || isPullRefreshing()) {
            return;
        }
        LoadingLayout.State state = LoadingLayout.State.REFRESHING;
        this.m = state;
        onStateChanged(state, true);
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(LoadingLayout.State.REFRESHING);
        }
        if (!z || this.f57849d == null) {
            return;
        }
        postDelayed(new Runnable(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PullToRefreshBase f57863a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57863a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f57863a.f57849d.onPullDownToRefresh(this.f57863a);
                }
            }
        }, getSmoothScrollDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3) == null) {
            scrollTo(i2, i3);
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            a(i2, getSmoothScrollDuration(), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            PullToRefreshBase<T>.a aVar = this.p;
            if (aVar != null) {
                aVar.a();
            }
            int scrollYValue = getScrollYValue();
            boolean z = scrollYValue != i2;
            if (z) {
                this.p = new a(scrollYValue, i2, j);
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
}
