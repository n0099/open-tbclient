package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.gi5;
import com.baidu.tieba.pi5;
import com.baidu.tieba.rh5;
import com.baidu.tieba.sh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class rg5<Q extends rh5, P extends sh5> implements vh5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public final View b;
    public final ki5 c;
    public final ai5 d;
    public final th5<Q, P> e;
    public final yh5<Q, P> f;
    public wh5<P> g;
    public final View.OnClickListener h;
    public final mq4 i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg5 a;

        public a(rg5 rg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                hi5.b(" ----NetRefreshView----");
                this.a.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends mq4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg5 a;

        public b(rg5 rg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg5Var;
        }

        @Override // com.baidu.tieba.mq4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                hi5.b(" ----onActivityDestroyed---- ");
                this.a.i();
            }
        }

        @Override // com.baidu.tieba.mq4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                hi5.b(" ----onActivityPaused---- ");
                this.a.j();
            }
        }

        @Override // com.baidu.tieba.mq4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                hi5.b(" ----onActivityResumed---- ");
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c<Q extends rh5, P extends sh5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup A;
        public TbPageContext a;
        public Q b;
        public P c;
        public int d;
        public int e;
        public String f;
        public gi5.d g;
        public gi5.b h;
        public gi5.a i;
        public ci5 j;
        public ci5 k;
        public ci5 l;
        public String m;
        public boolean n;
        public boolean o;
        public boolean p;
        public mi5 q;
        public li5 r;
        public gi5.c s;
        public List<kn> t;
        public List<kn> u;
        public lq4<vr4> v;
        public ih5 w;
        public int x;
        public ki5 y;
        public View z;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.p = false;
        }

        public final void a() {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b != null && (tbPageContext = this.a) != null && tbPageContext.getPageActivity() != null) {
                this.b.a(this.a.getPageActivity().getIntent());
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.o) {
                NavigationBar navigationBar = new NavigationBar(this.a.getPageActivity());
                if (this.n) {
                    navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                }
                navigationBar.setCenterTextTitle(this.m);
                this.z = navigationBar;
            }
        }

        public c b(List<kn> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                this.p = true;
                this.t = list;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c c(mi5 mi5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mi5Var)) == null) {
                this.p = true;
                this.q = mi5Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c d(lq4<vr4> lq4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lq4Var)) == null) {
                this.p = true;
                this.v = lq4Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public rg5 e(ViewGroup viewGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
                this.A = viewGroup;
                this.a = (TbPageContext) x9.a(viewGroup.getContext());
                a();
                g();
                f();
                return new rg5(this, null);
            }
            return (rg5) invokeL.objValue;
        }

        public final void h(pi5 pi5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, pi5Var) == null) && !ListUtils.isEmpty(this.u)) {
                pi5Var.z(this.u);
            }
        }

        public c i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public c j(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c k(@NonNull Q q) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, q)) == null) {
                this.b = q;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c l(@NonNull P p) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, p)) == null) {
                this.c = p;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.p && this.q != null && this.r != null) {
                    pi5.f fVar = new pi5.f();
                    fVar.i(this.q);
                    fVar.f(this.r);
                    fVar.b(this.s);
                    fVar.a(this.t);
                    fVar.g(this.v);
                    fVar.e(this.x);
                    fVar.h(this.w);
                    pi5 c = fVar.c(this.a);
                    h(c);
                    this.y = c;
                } else if (this.p && this.q != null) {
                    pi5.f fVar2 = new pi5.f();
                    fVar2.i(this.q);
                    fVar2.b(this.s);
                    fVar2.a(this.t);
                    fVar2.g(this.v);
                    fVar2.e(this.x);
                    fVar2.h(this.w);
                    pi5 c2 = fVar2.c(this.a);
                    h(c2);
                    this.y = c2;
                } else if (this.p) {
                    pi5.f fVar3 = new pi5.f();
                    fVar3.b(this.s);
                    fVar3.a(this.t);
                    fVar3.g(this.v);
                    fVar3.e(this.x);
                    fVar3.h(this.w);
                    pi5 c3 = fVar3.c(this.a);
                    h(c3);
                    this.y = c3;
                }
            }
        }
    }

    public rg5(c<Q, P> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.i = new b(this);
        this.a = cVar.a;
        uh5 uh5Var = new uh5(cVar.d, cVar.e, cVar.f, cVar.b, cVar.c);
        this.e = uh5Var;
        this.f = new yh5<>(cVar.a, uh5Var, this);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getPageActivity());
        View view2 = cVar.z;
        this.b = view2;
        if (view2 != null) {
            view2.setId(2184);
            this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            relativeLayout.addView(this.b);
        }
        ki5 ki5Var = cVar.y;
        this.c = ki5Var;
        if (ki5Var != null) {
            ki5Var.j(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, 2184);
            this.c.getView().setLayoutParams(layoutParams);
            this.c.b(relativeLayout);
        }
        cVar.A.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        gi5.d dVar = cVar.g;
        dVar = dVar == null ? new gi5.d() : dVar;
        gi5.b bVar = cVar.h;
        bVar = bVar == null ? new gi5.b() : bVar;
        gi5.a aVar = cVar.i;
        aVar = aVar == null ? new gi5.a() : aVar;
        View.OnClickListener onClickListener = this.h;
        bVar.h = onClickListener;
        aVar.h = onClickListener;
        gi5 gi5Var = new gi5();
        gi5Var.b = aVar;
        gi5Var.c = bVar;
        gi5Var.a = dVar;
        this.d = new bi5(this.c, relativeLayout, gi5Var);
        ci5 ci5Var = cVar.j;
        ci5Var = ci5Var == null ? new fi5(this.a) : ci5Var;
        ci5 ci5Var2 = cVar.k;
        ci5Var2 = ci5Var2 == null ? new ei5(this.a) : ci5Var2;
        ci5 ci5Var3 = cVar.l;
        ci5Var3 = ci5Var3 == null ? new di5(this.a) : ci5Var3;
        this.d.c(ViewType.LOADING, ci5Var);
        this.d.c(ViewType.ERROR, ci5Var2);
        this.d.c(ViewType.EMPTY, ci5Var3);
        m();
    }

    public /* synthetic */ rg5(c cVar, a aVar) {
        this(cVar);
    }

    @Override // com.baidu.tieba.vh5
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            hi5.b(" ----onError---- ");
            wh5<P> wh5Var = this.g;
            if (wh5Var != null) {
                wh5Var.onError(i, str);
            }
            ki5 ki5Var = this.c;
            if (ki5Var != null) {
                ki5Var.a(d());
            } else {
                q(str);
            }
        }
    }

    public void b(qg5 qg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qg5Var) == null) {
            this.f.b(qg5Var);
        }
    }

    public boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            return this.f.i(z);
        }
        return invokeZ.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            ai5 ai5Var = this.d;
            if (ai5Var != null) {
                ai5Var.onChangeSkinType(i);
            }
            ki5 ki5Var = this.c;
            if (ki5Var != null) {
                ki5Var.onChangeSkinType(i);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            yh5<Q, P> yh5Var = this.f;
            if (yh5Var != null) {
                yh5Var.s(bdUniqueId);
            }
            ki5 ki5Var = this.c;
            if (ki5Var != null) {
                ki5Var.i(bdUniqueId);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            hi5.b(" ----showEmpty---- ");
            this.d.a(ViewType.EMPTY, str);
            t(ViewType.EMPTY);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            hi5.b(" ----showError---- ");
            this.d.a(ViewType.ERROR, str);
            t(ViewType.ERROR);
        }
    }

    public final void t(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, viewType) == null) {
            this.d.b(viewType);
        }
    }

    public Q c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f.f();
        }
        return (Q) invokeV.objValue;
    }

    public P d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f.g();
        }
        return (P) invokeV.objValue;
    }

    public LoadType e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            lh5 c2 = c().c();
            if (c2 != null) {
                return c2.b;
            }
            return LoadType.REFRESH;
        }
        return (LoadType) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f.j();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ai5 ai5Var = this.d;
            if (ai5Var != null) {
                ai5Var.onDestroy();
            }
            yh5<Q, P> yh5Var = this.f;
            if (yh5Var != null) {
                yh5Var.k();
            }
            ki5 ki5Var = this.c;
            if (ki5Var != null) {
                ki5Var.e();
            }
            u();
        }
    }

    public void j() {
        ki5 ki5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (ki5Var = this.c) != null) {
            ki5Var.f();
        }
    }

    public void k() {
        ki5 ki5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (ki5Var = this.c) != null) {
            ki5Var.g();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ki5 ki5Var = this.c;
            if (ki5Var != null) {
                ki5Var.h();
                return;
            }
            r();
            f(true);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            hi5.b(" ----showLoading---- ");
            t(ViewType.LOADING);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            hi5.b(" ----showContent---- ");
            t(ViewType.CONTENT);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vh5
    /* renamed from: l */
    public void onSuccess(P p) {
        nh5 nh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, p) == null) {
            hi5.b(" ----onSuccess---- ");
            wh5<P> wh5Var = this.g;
            if (wh5Var != null) {
                wh5Var.onSuccess(p);
            }
            ki5 ki5Var = this.c;
            if (ki5Var != null) {
                nh5Var = ki5Var.a(p);
            } else {
                s();
                nh5Var = new nh5();
            }
            wh5<P> wh5Var2 = this.g;
            if (wh5Var2 != null) {
                wh5Var2.a(nh5Var);
            }
        }
    }
}
