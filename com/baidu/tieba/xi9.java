package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.PersonVipCardData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class xi9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pi9 a;
    public mi9 b;
    public ui9 c;
    public vi9 d;
    public qi9 e;
    public ti9 f;
    public oi9 g;
    public ri9 h;
    public si9 i;
    public BdTypeListView j;
    public ni9 k;
    public wi9 l;
    public List<kn> m;

    public xi9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        this.j = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public final void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new pi9(tbPageContext, lj9.b);
            this.b = new mi9(tbPageContext, fj9.f);
            this.c = new ui9(tbPageContext, rj9.b);
            this.d = new vi9(tbPageContext, sj9.c);
            this.e = new qi9(tbPageContext, hj9.b);
            this.f = new ti9(tbPageContext, ij9.b);
            this.k = new ni9(tbPageContext, jj9.c);
            this.h = new ri9(tbPageContext, nj9.b);
            this.i = new si9(tbPageContext, oj9.b);
            this.g = new oi9(tbPageContext, kj9.p);
            this.l = new wi9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
            this.m.add(this.a);
            this.m.add(this.l);
            this.m.add(this.b);
            this.m.add(this.e);
            this.m.add(this.f);
            this.m.add(this.c);
            this.m.add(this.d);
            this.m.add(this.h);
            this.m.add(this.i);
            this.m.add(this.g);
            this.m.add(this.k);
            bdTypeListView.addAdapters(this.m);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof on)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        wi9 wi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (wi9Var = this.l) != null) {
            wi9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wi9 wi9Var = this.l;
            if (wi9Var != null) {
                wi9Var.onPause();
            }
            ui9 ui9Var = this.c;
            if (ui9Var != null) {
                ui9Var.onPause();
            }
        }
    }

    public void f() {
        wi9 wi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (wi9Var = this.l) != null) {
            wi9Var.onResume();
        }
    }

    public void g() {
        ri9 ri9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ri9Var = this.h) != null) {
            ri9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            wi9 wi9Var = this.l;
            if (wi9Var != null) {
                wi9Var.u(z);
            }
            ni9 ni9Var = this.k;
            if (ni9Var != null) {
                ni9Var.x(z);
            }
            ti9 ti9Var = this.f;
            if (ti9Var != null) {
                ti9Var.u(z);
            }
            ui9 ui9Var = this.c;
            if (ui9Var != null) {
                ui9Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        ni9 ni9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (ni9Var = this.k) != null) {
            ni9Var.u(z);
        }
    }
}
