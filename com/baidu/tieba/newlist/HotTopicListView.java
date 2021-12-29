package com.baidu.tieba.newlist;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.g0.g;
import c.a.s0.g0.h;
import c.a.t0.q1.f;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public class HotTopicListView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static int C;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.s.i0.q.b A;
    public Runnable B;

    /* renamed from: e  reason: collision with root package name */
    public int f48117e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f48118f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.p2.b f48119g;

    /* renamed from: h  reason: collision with root package name */
    public View f48120h;

    /* renamed from: i  reason: collision with root package name */
    public NavigationBar f48121i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f48122j;

    /* renamed from: k  reason: collision with root package name */
    public LottieSlideLoadingLayout f48123k;
    public AppBarLayout l;
    public View m;
    public ImageView n;
    public ImageView o;
    public View p;
    public BdTypeRecyclerView q;
    public c.a.t0.p2.c.a r;
    public ViewGroup s;
    public PbListView t;
    public g u;
    public h v;
    public boolean w;
    public ValueAnimator x;
    public boolean y;
    public AppBarLayout.OnOffsetChangedListener z;

    /* loaded from: classes12.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicListView a;

        public a(HotTopicListView hotTopicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicListView;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                if (this.a.f48123k != null) {
                    this.a.f48123k.setEnableSlideLoading(i2 == 0);
                }
                if (i2 + HotTopicListView.C < 0) {
                    this.a.f48120h.setVisibility(0);
                    this.a.f48121i.setCenterTextTitle(this.a.f48121i.getContext().getString(c.a.t0.q1.h.hot_topic_rank_list_head));
                    return;
                }
                this.a.f48120h.setVisibility(8);
                this.a.f48121i.setCenterTextTitle(null);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements c.a.s0.s.i0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicListView a;

        public b(HotTopicListView hotTopicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicListView;
        }

        @Override // c.a.s0.s.i0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.s0.s.i0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicListView f48124e;

        public c(HotTopicListView hotTopicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48124e = hotTopicListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f48124e.w) {
                this.f48124e.resetPullRefreshingView();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicListView f48125e;

        public d(HotTopicListView hotTopicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48125e = hotTopicListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48125e.s.getHeight() > this.f48125e.q.getHeight()) {
                    ((AppBarLayout.LayoutParams) this.f48125e.m.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) this.f48125e.m.getLayoutParams()).setScrollFlags(13);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicListView f48126e;

        public e(HotTopicListView hotTopicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48126e = hotTopicListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A() && this.f48126e.f48119g != null) {
                this.f48126e.f48119g.loadData();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(153650615, "Lcom/baidu/tieba/newlist/HotTopicListView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(153650615, "Lcom/baidu/tieba/newlist/HotTopicListView;");
                return;
            }
        }
        C = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.q1.c.tbds250);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListView(TbPageContext<?> tbPageContext, c.a.t0.p2.b bVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48117e = 3;
        this.w = false;
        this.y = false;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        this.f48118f = tbPageContext;
        this.f48119g = bVar;
        l(bundle);
        onChangeSkinType();
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hideLoadingView();
            hideNetRefreshView();
            if (this.w) {
                resetPullRefreshingView();
            }
            ValueAnimator valueAnimator = this.x;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.x.removeAllListeners();
                this.x.removeAllUpdateListeners();
                this.x = null;
            }
            c.a.d.f.m.e.a().removeCallbacks(this.B);
        }
    }

    public void hideLoadingView() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.u) == null) {
            return;
        }
        gVar.dettachView(this.f48122j);
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.v == null) {
            return;
        }
        this.m.setVisibility(0);
        this.v.dettachView(this.f48122j);
        this.v = null;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.B, 5000L);
            this.w = true;
            this.f48119g.loadData();
        }
    }

    public final void l(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(f.activity_hot_topic_list_layout, (ViewGroup) this, true);
            this.f48120h = findViewById(c.a.t0.q1.e.topBgView);
            NavigationBar navigationBar = (NavigationBar) findViewById(c.a.t0.q1.e.viewNavigationBar);
            this.f48121i = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.p = findViewById(c.a.t0.q1.e.header_round_corner_layout);
            this.m = findViewById(c.a.t0.q1.e.headerContainerLayout);
            this.n = (ImageView) findViewById(c.a.t0.q1.e.bgContainer);
            this.o = (ImageView) findViewById(c.a.t0.q1.e.bgImage);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(c.a.t0.q1.e.contentLayout);
            this.f48123k = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.addLoadingListener(this.A);
            this.f48123k.addSyncHeightView(this.m);
            this.f48123k.bringLoadViewToFront();
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(c.a.t0.q1.e.appBarLayout);
            this.l = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.z);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(c.a.t0.q1.e.recyclerView);
            this.q = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.q.setFadingEdgeLength(0);
            this.q.setOverScrollMode(2);
            this.q.setPadding(0, n.f(getContext(), c.a.t0.q1.c.tbds16), 0, n.f(getContext(), c.a.t0.q1.c.tbds16));
            this.r = new c.a.t0.p2.c.a(this.f48118f, this.q);
            this.s = (ViewGroup) findViewById(c.a.t0.q1.e.contentContainer);
            View findViewById = findViewById(c.a.t0.q1.e.statusBarViewHolder);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            findViewById.setLayoutParams(layoutParams);
            this.f48122j = (ViewGroup) findViewById(c.a.t0.q1.e.contentRootLayout);
            PbListView pbListView = new PbListView(this.f48118f.getPageActivity());
            this.t = pbListView;
            pbListView.a();
            this.t.p(c.a.t0.q1.b.CAM_X0205);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.y) {
            return;
        }
        this.y = true;
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f48121i.findViewById(c.a.t0.q1.e.widget_navi_back_button), c.a.t0.q1.d.ic_icon_pure_topbar_return40_svg, c.a.t0.q1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.f48121i.getCenterText(), c.a.t0.q1.b.CAM_X0101);
        c.a.t0.p2.b bVar = this.f48119g;
        if (bVar instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) bVar);
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f48117e) {
            return;
        }
        SkinManager.setBackgroundColor(this.f48120h, c.a.t0.q1.b.pic_huati_toplist_base_color);
        SkinManager.setImageResource(this.n, c.a.t0.q1.d.pic_huati_toplist_base);
        SkinManager.setImageResource(this.o, c.a.t0.q1.d.pic_huati_toplist_upper);
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.p);
        d2.m(1);
        d2.n(c.a.t0.q1.h.J_X14);
        d2.f(c.a.t0.q1.b.CAM_X0201);
        PbListView pbListView = this.t;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.t.p(c.a.t0.q1.b.CAM_X0205);
        }
        this.r.b();
        this.f48117e = skinType;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    public void resetPullRefreshingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.w = false;
            this.f48123k.endLoading();
        }
    }

    public void setData(@NonNull List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.r.c(list);
            this.q.post(new d(this));
            m();
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.u == null) {
                this.u = new g(getContext(), getContext().getResources().getDimensionPixelSize(c.a.t0.q1.c.ds386));
            }
            this.u.attachView(this.f48122j, false);
        }
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            h hVar = this.v;
            if (hVar == null || !hVar.isViewAttached()) {
                if (this.v == null) {
                    this.v = new h(getContext(), new e(this));
                }
                this.m.setVisibility(8);
                this.v.k(this.f48118f.getResources().getDimensionPixelSize(c.a.t0.q1.c.ds360));
                this.v.attachView(this.f48122j, z);
                this.v.p();
            }
        }
    }

    public void showNoMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.q.setNextPage(this.t);
            this.t.f();
            this.t.M(0);
            this.t.D(getResources().getString(c.a.t0.q1.h.really_great));
        }
    }

    public void stopPullRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.w) {
            resetPullRefreshingView();
            c.a.d.f.m.e.a().removeCallbacks(this.B);
        }
    }
}
