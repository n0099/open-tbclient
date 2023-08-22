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
import com.baidu.tieba.hv5;
import com.baidu.tieba.ju5;
import com.baidu.tieba.ku5;
import com.baidu.tieba.yu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class jt5<Q extends ju5, P extends ku5> implements nu5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public final View b;
    public final cv5 c;
    public final su5 d;
    public final lu5<Q, P> e;
    public final qu5<Q, P> f;
    public ou5<P> g;
    public final View.OnClickListener h;
    public final sz4 i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt5 a;

        public a(jt5 jt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                zu5.b(" ----NetRefreshView----");
                this.a.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends sz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt5 a;

        public b(jt5 jt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt5Var;
        }

        @Override // com.baidu.tieba.sz4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                zu5.b(" ----onActivityDestroyed---- ");
                this.a.i();
            }
        }

        @Override // com.baidu.tieba.sz4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                zu5.b(" ----onActivityPaused---- ");
                this.a.j();
            }
        }

        @Override // com.baidu.tieba.sz4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                zu5.b(" ----onActivityResumed---- ");
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c<Q extends ju5, P extends ku5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup A;
        public TbPageContext a;
        public Q b;
        public P c;
        public int d;
        public int e;
        public String f;
        public yu5.d g;
        public yu5.b h;
        public yu5.a i;
        public uu5 j;
        public uu5 k;
        public uu5 l;
        public String m;
        public boolean n;
        public boolean o;
        public boolean p;
        public ev5 q;
        public dv5 r;
        public yu5.c s;
        public List<om> t;
        public List<om> u;
        public rz4<w05> v;
        public au5 w;
        public int x;
        public cv5 y;
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

        public c b(List<om> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                this.p = true;
                this.t = list;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c c(ev5 ev5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ev5Var)) == null) {
                this.p = true;
                this.q = ev5Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c d(rz4<w05> rz4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rz4Var)) == null) {
                this.p = true;
                this.v = rz4Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public jt5 e(ViewGroup viewGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
                this.A = viewGroup;
                this.a = (TbPageContext) l9.a(viewGroup.getContext());
                a();
                g();
                f();
                return new jt5(this, null);
            }
            return (jt5) invokeL.objValue;
        }

        public final void h(hv5 hv5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, hv5Var) == null) && !ListUtils.isEmpty(this.u)) {
                hv5Var.y(this.u);
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
                    hv5.f fVar = new hv5.f();
                    fVar.i(this.q);
                    fVar.f(this.r);
                    fVar.b(this.s);
                    fVar.a(this.t);
                    fVar.g(this.v);
                    fVar.e(this.x);
                    fVar.h(this.w);
                    hv5 c = fVar.c(this.a);
                    h(c);
                    this.y = c;
                } else if (this.p && this.q != null) {
                    hv5.f fVar2 = new hv5.f();
                    fVar2.i(this.q);
                    fVar2.b(this.s);
                    fVar2.a(this.t);
                    fVar2.g(this.v);
                    fVar2.e(this.x);
                    fVar2.h(this.w);
                    hv5 c2 = fVar2.c(this.a);
                    h(c2);
                    this.y = c2;
                } else if (this.p) {
                    hv5.f fVar3 = new hv5.f();
                    fVar3.b(this.s);
                    fVar3.a(this.t);
                    fVar3.g(this.v);
                    fVar3.e(this.x);
                    fVar3.h(this.w);
                    hv5 c3 = fVar3.c(this.a);
                    h(c3);
                    this.y = c3;
                }
            }
        }
    }

    public jt5(c<Q, P> cVar) {
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
        mu5 mu5Var = new mu5(cVar.d, cVar.e, cVar.f, cVar.b, cVar.c);
        this.e = mu5Var;
        this.f = new qu5<>(cVar.a, mu5Var, this);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getPageActivity());
        View view2 = cVar.z;
        this.b = view2;
        if (view2 != null) {
            view2.setId(2184);
            this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            relativeLayout.addView(this.b);
        }
        cv5 cv5Var = cVar.y;
        this.c = cv5Var;
        if (cv5Var != null) {
            cv5Var.i(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, 2184);
            this.c.getView().setLayoutParams(layoutParams);
            this.c.a(relativeLayout);
        }
        cVar.A.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        yu5.d dVar = cVar.g;
        dVar = dVar == null ? new yu5.d() : dVar;
        yu5.b bVar = cVar.h;
        bVar = bVar == null ? new yu5.b() : bVar;
        yu5.a aVar = cVar.i;
        aVar = aVar == null ? new yu5.a() : aVar;
        View.OnClickListener onClickListener = this.h;
        bVar.h = onClickListener;
        aVar.h = onClickListener;
        yu5 yu5Var = new yu5();
        yu5Var.b = aVar;
        yu5Var.c = bVar;
        yu5Var.a = dVar;
        this.d = new tu5(this.c, relativeLayout, yu5Var);
        uu5 uu5Var = cVar.j;
        uu5Var = uu5Var == null ? new xu5(this.a) : uu5Var;
        uu5 uu5Var2 = cVar.k;
        uu5Var2 = uu5Var2 == null ? new wu5(this.a) : uu5Var2;
        uu5 uu5Var3 = cVar.l;
        uu5Var3 = uu5Var3 == null ? new vu5(this.a) : uu5Var3;
        this.d.c(ViewType.LOADING, uu5Var);
        this.d.c(ViewType.ERROR, uu5Var2);
        this.d.c(ViewType.EMPTY, uu5Var3);
        m();
    }

    public /* synthetic */ jt5(c cVar, a aVar) {
        this(cVar);
    }

    @Override // com.baidu.tieba.nu5
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            zu5.b(" ----onError---- ");
            ou5<P> ou5Var = this.g;
            if (ou5Var != null) {
                ou5Var.onError(i, str);
            }
            cv5 cv5Var = this.c;
            if (cv5Var != null) {
                cv5Var.onBindDataToView(d());
            } else {
                q(str);
            }
        }
    }

    public void b(it5 it5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, it5Var) == null) {
            this.f.b(it5Var);
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
            su5 su5Var = this.d;
            if (su5Var != null) {
                su5Var.onChangeSkinType(i);
            }
            cv5 cv5Var = this.c;
            if (cv5Var != null) {
                cv5Var.onChangeSkinType(i);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            qu5<Q, P> qu5Var = this.f;
            if (qu5Var != null) {
                qu5Var.s(bdUniqueId);
            }
            cv5 cv5Var = this.c;
            if (cv5Var != null) {
                cv5Var.h(bdUniqueId);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            zu5.b(" ----showEmpty---- ");
            this.d.a(ViewType.EMPTY, str);
            t(ViewType.EMPTY);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            zu5.b(" ----showError---- ");
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
            du5 c2 = c().c();
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
            su5 su5Var = this.d;
            if (su5Var != null) {
                su5Var.onDestroy();
            }
            qu5<Q, P> qu5Var = this.f;
            if (qu5Var != null) {
                qu5Var.k();
            }
            cv5 cv5Var = this.c;
            if (cv5Var != null) {
                cv5Var.d();
            }
            u();
        }
    }

    public void j() {
        cv5 cv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (cv5Var = this.c) != null) {
            cv5Var.e();
        }
    }

    public void k() {
        cv5 cv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (cv5Var = this.c) != null) {
            cv5Var.f();
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
            cv5 cv5Var = this.c;
            if (cv5Var != null) {
                cv5Var.g();
                return;
            }
            r();
            f(true);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            zu5.b(" ----showLoading---- ");
            t(ViewType.LOADING);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            zu5.b(" ----showContent---- ");
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
    @Override // com.baidu.tieba.nu5
    /* renamed from: l */
    public void onSuccess(P p) {
        fu5 fu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, p) == null) {
            zu5.b(" ----onSuccess---- ");
            ou5<P> ou5Var = this.g;
            if (ou5Var != null) {
                ou5Var.onSuccess(p);
            }
            cv5 cv5Var = this.c;
            if (cv5Var != null) {
                fu5Var = cv5Var.onBindDataToView(p);
            } else {
                s();
                fu5Var = new fu5();
            }
            ou5<P> ou5Var2 = this.g;
            if (ou5Var2 != null) {
                ou5Var2.a(fu5Var);
            }
        }
    }
}
