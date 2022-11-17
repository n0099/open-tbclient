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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.d05;
import com.baidu.tieba.ja5;
import com.baidu.tieba.ka5;
import com.baidu.tieba.ov7;
import com.baidu.tieba.pv7;
import com.baidu.tieba.qw4;
import com.baidu.tieba.xn;
import com.baidu.tieba.yi;
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
/* loaded from: classes5.dex */
public class HotTopicListView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static int y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public ov7 c;
    public View d;
    public NavigationBar e;
    public ViewGroup f;
    public LottieSlideLoadingLayout g;
    public AppBarLayout h;
    public View i;
    public ImageView j;
    public ImageView k;
    public View l;
    public BdTypeRecyclerView m;
    public pv7 n;
    public ViewGroup o;
    public PbListView p;
    public ja5 q;
    public ka5 r;
    public boolean s;
    public ValueAnimator t;
    public boolean u;
    public AppBarLayout.OnOffsetChangedListener v;
    public d05 w;
    public Runnable x;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicListView;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                if (this.a.g != null) {
                    LottieSlideLoadingLayout lottieSlideLoadingLayout = this.a.g;
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    lottieSlideLoadingLayout.setEnableSlideLoading(z);
                }
                if (i + HotTopicListView.y < 0) {
                    this.a.d.setVisibility(0);
                    if (UbsABTestHelper.isNewHomeHotTopicTab()) {
                        this.a.e.setCenterTextTitle(this.a.e.getContext().getString(R.string.obfuscated_res_0x7f0f097b));
                        return;
                    } else {
                        this.a.e.setCenterTextTitle(this.a.e.getContext().getString(R.string.obfuscated_res_0x7f0f08ba));
                        return;
                    }
                }
                this.a.d.setVisibility(8);
                this.a.e.setCenterTextTitle(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicListView a;

        @Override // com.baidu.tieba.d05
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(HotTopicListView hotTopicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicListView;
        }

        @Override // com.baidu.tieba.d05
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.l();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicListView a;

        public c(HotTopicListView hotTopicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.s) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicListView a;

        public d(HotTopicListView hotTopicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.o.getHeight() > this.a.m.getHeight()) {
                    ((AppBarLayout.LayoutParams) this.a.i.getLayoutParams()).setScrollFlags(0);
                } else {
                    ((AppBarLayout.LayoutParams) this.a.i.getLayoutParams()).setScrollFlags(13);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicListView a;

        public e(HotTopicListView hotTopicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately() && this.a.c != null) {
                this.a.c.a();
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
        y = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ah.a().postDelayed(this.x, 5000L);
            this.s = true;
            this.c.a();
        }
    }

    public void m() {
        ja5 ja5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ja5Var = this.q) != null) {
            ja5Var.dettachView(this.f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.r != null) {
            this.i.setVisibility(0);
            this.r.dettachView(this.f);
            this.r = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            k();
            super.onDetachedFromWindow();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.s = false;
            this.g.o();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.m.setNextPage(this.p);
            this.p.f();
            this.p.N(0);
            this.p.E(getResources().getString(R.string.obfuscated_res_0x7f0f0fd4));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.s) {
            r();
            ah.a().removeCallbacks(this.x);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListView(TbPageContext<?> tbPageContext, ov7 ov7Var, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ov7Var, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.s = false;
        this.u = false;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
        this.b = tbPageContext;
        this.c = ov7Var;
        o(bundle);
        q();
    }

    public void setData(@NonNull List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.n.c(list);
            this.m.post(new d(this));
            p();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            n();
            if (this.s) {
                r();
            }
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.t.removeAllListeners();
                this.t.removeAllUpdateListeners();
                this.t = null;
            }
            ah.a().removeCallbacks(this.x);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.q == null) {
                this.q = new ja5(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b2));
            }
            this.q.attachView(this.f, false);
        }
    }

    public final void o(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d003b, (ViewGroup) this, true);
            this.d = findViewById(R.id.obfuscated_res_0x7f0922d2);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0925ea);
            this.e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.l = findViewById(R.id.obfuscated_res_0x7f090d7f);
            this.i = findViewById(R.id.obfuscated_res_0x7f090d73);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f09038c);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f09038e);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(R.id.obfuscated_res_0x7f0906fd);
            this.g = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.j(this.w);
            this.g.l(this.i);
            this.g.n();
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.obfuscated_res_0x7f0902a0);
            this.h = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.v);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f091c06);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.m.setFadingEdgeLength(0);
            this.m.setOverScrollMode(2);
            this.m.setPadding(0, yi.g(getContext(), R.dimen.tbds16), 0, yi.g(getContext(), R.dimen.tbds16));
            this.n = new pv7(this.b, this.m);
            this.o = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0906fc);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091fdc);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            findViewById.setLayoutParams(layoutParams);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0906ff);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.p = pbListView;
            pbListView.a();
            this.p.q(R.color.CAM_X0205);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.u) {
            this.u = true;
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f0926cf), R.drawable.obfuscated_res_0x7f08062e, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.e.getCenterText(), (int) R.color.CAM_X0101);
            ov7 ov7Var = this.c;
            if (ov7Var instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) ov7Var);
            }
        }
    }

    public void q() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        if (UbsABTestHelper.isNewHomeHotTopicTab()) {
            SkinManager.setBackgroundColor(this.d, R.color.obfuscated_res_0x7f060905);
            SkinManager.setImageResource(this.j, R.drawable.obfuscated_res_0x7f080f90);
            SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f080f92);
        } else {
            SkinManager.setBackgroundColor(this.d, R.color.obfuscated_res_0x7f060904);
            SkinManager.setImageResource(this.j, R.drawable.obfuscated_res_0x7f080f8f);
            SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f080f91);
        }
        qw4 d2 = qw4.d(this.l);
        d2.m(1);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0201);
        PbListView pbListView = this.p;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.p.q(R.color.CAM_X0205);
        }
        this.n.b();
        this.a = skinType;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            ka5 ka5Var = this.r;
            if (ka5Var != null && ka5Var.isViewAttached()) {
                return;
            }
            if (this.r == null) {
                this.r = new ka5(getContext(), new e(this));
            }
            this.i.setVisibility(8);
            this.r.k(this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702aa));
            this.r.attachView(this.f, z);
            this.r.p();
        }
    }
}
