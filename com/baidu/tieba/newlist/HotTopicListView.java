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
import com.baidu.tieba.hw4;
import com.baidu.tieba.m65;
import com.baidu.tieba.mr7;
import com.baidu.tieba.n65;
import com.baidu.tieba.nr7;
import com.baidu.tieba.os4;
import com.baidu.tieba.pi;
import com.baidu.tieba.pn;
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
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
    public mr7 c;
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
    public nr7 n;
    public ViewGroup o;
    public PbListView p;
    public m65 q;
    public n65 r;
    public boolean s;
    public ValueAnimator t;
    public boolean u;
    public AppBarLayout.OnOffsetChangedListener v;
    public hw4 w;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                if (this.a.g != null) {
                    this.a.g.setEnableSlideLoading(i == 0);
                }
                if (i + HotTopicListView.y < 0) {
                    this.a.d.setVisibility(0);
                    if (UbsABTestHelper.isNewHomeHotTopicTab()) {
                        this.a.e.setCenterTextTitle(this.a.e.getContext().getString(R.string.obfuscated_res_0x7f0f094d));
                        return;
                    } else {
                        this.a.e.setCenterTextTitle(this.a.e.getContext().getString(R.string.obfuscated_res_0x7f0f0890));
                        return;
                    }
                }
                this.a.d.setVisibility(8);
                this.a.e.setCenterTextTitle(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements hw4 {
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

        @Override // com.baidu.tieba.hw4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.hw4
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.l();
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && pi.A() && this.a.c != null) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListView(TbPageContext<?> tbPageContext, mr7 mr7Var, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, mr7Var, bundle};
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
        this.c = mr7Var;
        o(bundle);
        q();
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
            sg.a().removeCallbacks(this.x);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sg.a().postDelayed(this.x, 5000L);
            this.s = true;
            this.c.a();
        }
    }

    public void m() {
        m65 m65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (m65Var = this.q) == null) {
            return;
        }
        m65Var.dettachView(this.f);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.r == null) {
            return;
        }
        this.i.setVisibility(0);
        this.r.dettachView(this.f);
        this.r = null;
    }

    public final void o(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d003b, (ViewGroup) this, true);
            this.d = findViewById(R.id.obfuscated_res_0x7f092231);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09253d);
            this.e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.l = findViewById(R.id.obfuscated_res_0x7f090d37);
            this.i = findViewById(R.id.obfuscated_res_0x7f090d2b);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f090373);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f090375);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(R.id.obfuscated_res_0x7f0906cf);
            this.g = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.j(this.w);
            this.g.l(this.i);
            this.g.n();
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.obfuscated_res_0x7f090289);
            this.h = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.v);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f091b74);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.m.setFadingEdgeLength(0);
            this.m.setOverScrollMode(2);
            this.m.setPadding(0, ri.f(getContext(), R.dimen.tbds16), 0, ri.f(getContext(), R.dimen.tbds16));
            this.n = new nr7(this.b, this.m);
            this.o = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0906ce);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091f32);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            findViewById.setLayoutParams(layoutParams);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0906d1);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.p = pbListView;
            pbListView.a();
            this.p.p(R.color.CAM_X0205);
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

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.u) {
            return;
        }
        this.u = true;
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09261f), R.drawable.obfuscated_res_0x7f080613, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.e.getCenterText(), (int) R.color.CAM_X0101);
        mr7 mr7Var = this.c;
        if (mr7Var instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) mr7Var);
        }
    }

    public void q() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        if (UbsABTestHelper.isNewHomeHotTopicTab()) {
            SkinManager.setBackgroundColor(this.d, R.color.obfuscated_res_0x7f0608d8);
            SkinManager.setImageResource(this.j, R.drawable.obfuscated_res_0x7f080f27);
            SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f080f29);
        } else {
            SkinManager.setBackgroundColor(this.d, R.color.obfuscated_res_0x7f0608d7);
            SkinManager.setImageResource(this.j, R.drawable.obfuscated_res_0x7f080f26);
            SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f080f28);
        }
        os4 d2 = os4.d(this.l);
        d2.m(1);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0201);
        PbListView pbListView = this.p;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.p.p(R.color.CAM_X0205);
        }
        this.n.b();
        this.a = skinType;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.s = false;
            this.g.o();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.q == null) {
                this.q = new m65(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b2));
            }
            this.q.attachView(this.f, false);
        }
    }

    public void setData(@NonNull List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.n.c(list);
            this.m.post(new d(this));
            p();
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            n65 n65Var = this.r;
            if (n65Var == null || !n65Var.isViewAttached()) {
                if (this.r == null) {
                    this.r = new n65(getContext(), new e(this));
                }
                this.i.setVisibility(8);
                this.r.k(this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702aa));
                this.r.attachView(this.f, z);
                this.r.p();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.m.setNextPage(this.p);
            this.p.f();
            this.p.L(0);
            this.p.C(getResources().getString(R.string.obfuscated_res_0x7f0f0f83));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.s) {
            r();
            sg.a().removeCallbacks(this.x);
        }
    }
}
