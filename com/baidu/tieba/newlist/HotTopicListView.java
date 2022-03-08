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
import c.a.q0.f0.g;
import c.a.q0.f0.h;
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
import com.baidu.tieba.R;
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
/* loaded from: classes6.dex */
public class HotTopicListView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static int C;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.r.l0.q.b A;
    public Runnable B;

    /* renamed from: e  reason: collision with root package name */
    public int f44899e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f44900f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.r2.b f44901g;

    /* renamed from: h  reason: collision with root package name */
    public View f44902h;

    /* renamed from: i  reason: collision with root package name */
    public NavigationBar f44903i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f44904j;
    public LottieSlideLoadingLayout k;
    public AppBarLayout l;
    public View m;
    public ImageView n;
    public ImageView o;
    public View p;
    public BdTypeRecyclerView q;
    public c.a.r0.r2.c.a r;
    public ViewGroup s;
    public PbListView t;
    public g u;
    public h v;
    public boolean w;
    public ValueAnimator x;
    public boolean y;
    public AppBarLayout.OnOffsetChangedListener z;

    /* loaded from: classes6.dex */
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
                if (this.a.k != null) {
                    this.a.k.setEnableSlideLoading(i2 == 0);
                }
                if (i2 + HotTopicListView.C < 0) {
                    this.a.f44902h.setVisibility(0);
                    this.a.f44903i.setCenterTextTitle(this.a.f44903i.getContext().getString(R.string.hot_topic_rank_list_head));
                    return;
                }
                this.a.f44902h.setVisibility(8);
                this.a.f44903i.setCenterTextTitle(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.q0.r.l0.q.b {
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

        @Override // c.a.q0.r.l0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.q0.r.l0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicListView f44905e;

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
            this.f44905e = hotTopicListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f44905e.w) {
                this.f44905e.resetPullRefreshingView();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicListView f44906e;

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
            this.f44906e = hotTopicListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f44906e.s.getHeight() > this.f44906e.q.getHeight()) {
                    ((AppBarLayout.LayoutParams) this.f44906e.m.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) this.f44906e.m.getLayoutParams()).setScrollFlags(13);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicListView f44907e;

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
            this.f44907e = hotTopicListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A() && this.f44907e.f44901g != null) {
                this.f44907e.f44901g.loadData();
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
        C = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListView(TbPageContext<?> tbPageContext, c.a.r0.r2.b bVar, Bundle bundle) {
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
        this.f44899e = 3;
        this.w = false;
        this.y = false;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        this.f44900f = tbPageContext;
        this.f44901g = bVar;
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
        gVar.dettachView(this.f44904j);
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.v == null) {
            return;
        }
        this.m.setVisibility(0);
        this.v.dettachView(this.f44904j);
        this.v = null;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.B, 5000L);
            this.w = true;
            this.f44901g.loadData();
        }
    }

    public final void l(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_list_layout, (ViewGroup) this, true);
            this.f44902h = findViewById(R.id.topBgView);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
            this.f44903i = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.p = findViewById(R.id.header_round_corner_layout);
            this.m = findViewById(R.id.headerContainerLayout);
            this.n = (ImageView) findViewById(R.id.bgContainer);
            this.o = (ImageView) findViewById(R.id.bgImage);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(R.id.contentLayout);
            this.k = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.addLoadingListener(this.A);
            this.k.addSyncHeightView(this.m);
            this.k.bringLoadViewToFront();
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
            this.l = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.z);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.recyclerView);
            this.q = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.q.setFadingEdgeLength(0);
            this.q.setOverScrollMode(2);
            this.q.setPadding(0, n.f(getContext(), R.dimen.tbds16), 0, n.f(getContext(), R.dimen.tbds16));
            this.r = new c.a.r0.r2.c.a(this.f44900f, this.q);
            this.s = (ViewGroup) findViewById(R.id.contentContainer);
            View findViewById = findViewById(R.id.statusBarViewHolder);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            findViewById.setLayoutParams(layoutParams);
            this.f44904j = (ViewGroup) findViewById(R.id.contentRootLayout);
            PbListView pbListView = new PbListView(this.f44900f.getPageActivity());
            this.t = pbListView;
            pbListView.a();
            this.t.p(R.color.CAM_X0205);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.y) {
            return;
        }
        this.y = true;
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f44903i.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.f44903i.getCenterText(), (int) R.color.CAM_X0101);
        c.a.r0.r2.b bVar = this.f44901g;
        if (bVar instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) bVar);
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f44899e) {
            return;
        }
        SkinManager.setBackgroundColor(this.f44902h, R.color.pic_huati_toplist_base_color);
        SkinManager.setImageResource(this.n, R.drawable.pic_huati_toplist_base);
        SkinManager.setImageResource(this.o, R.drawable.pic_huati_toplist_upper);
        c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.p);
        d2.m(1);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0201);
        PbListView pbListView = this.t;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.t.p(R.color.CAM_X0205);
        }
        this.r.b();
        this.f44899e = skinType;
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
            this.k.endLoading();
        }
    }

    public void setData(@NonNull List<c.a.d.o.e.n> list) {
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
                this.u = new g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            }
            this.u.attachView(this.f44904j, false);
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
                this.v.k(this.f44900f.getResources().getDimensionPixelSize(R.dimen.ds360));
                this.v.attachView(this.f44904j, z);
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
            this.t.D(getResources().getString(R.string.really_great));
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
