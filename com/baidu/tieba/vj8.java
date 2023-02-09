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
/* loaded from: classes6.dex */
public class vj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nj8 a;
    public kj8 b;
    public sj8 c;
    public tj8 d;
    public oj8 e;
    public rj8 f;
    public mj8 g;
    public pj8 h;
    public qj8 i;
    public BdTypeListView j;
    public lj8 k;
    public uj8 l;
    public List<qn> m;

    public vj8(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new nj8(tbPageContext, jk8.b);
            this.b = new kj8(tbPageContext, dk8.f);
            this.c = new sj8(tbPageContext, pk8.b);
            this.d = new tj8(tbPageContext, qk8.c);
            this.e = new oj8(tbPageContext, fk8.b);
            this.f = new rj8(tbPageContext, gk8.b);
            this.k = new lj8(tbPageContext, hk8.c);
            this.h = new pj8(tbPageContext, lk8.b);
            this.i = new qj8(tbPageContext, mk8.b);
            this.g = new mj8(tbPageContext, ik8.q);
            this.l = new uj8(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
            bdTypeListView.a(this.m);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof un)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        uj8 uj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (uj8Var = this.l) != null) {
            uj8Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            uj8 uj8Var = this.l;
            if (uj8Var != null) {
                uj8Var.onPause();
            }
            sj8 sj8Var = this.c;
            if (sj8Var != null) {
                sj8Var.onPause();
            }
        }
    }

    public void f() {
        uj8 uj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (uj8Var = this.l) != null) {
            uj8Var.onResume();
        }
    }

    public void g() {
        pj8 pj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (pj8Var = this.h) != null) {
            pj8Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            uj8 uj8Var = this.l;
            if (uj8Var != null) {
                uj8Var.u(z);
            }
            lj8 lj8Var = this.k;
            if (lj8Var != null) {
                lj8Var.v(z);
            }
            rj8 rj8Var = this.f;
            if (rj8Var != null) {
                rj8Var.u(z);
            }
            sj8 sj8Var = this.c;
            if (sj8Var != null) {
                sj8Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        lj8 lj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (lj8Var = this.k) != null) {
            lj8Var.u(z);
        }
    }
}
