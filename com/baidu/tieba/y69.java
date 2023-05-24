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
public class y69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q69 a;
    public n69 b;
    public v69 c;
    public w69 d;
    public r69 e;
    public u69 f;
    public p69 g;
    public s69 h;
    public t69 i;
    public BdTypeListView j;
    public o69 k;
    public x69 l;
    public List<en> m;

    public y69(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new q69(tbPageContext, m79.b);
            this.b = new n69(tbPageContext, g79.f);
            this.c = new v69(tbPageContext, s79.b);
            this.d = new w69(tbPageContext, t79.c);
            this.e = new r69(tbPageContext, i79.b);
            this.f = new u69(tbPageContext, j79.b);
            this.k = new o69(tbPageContext, k79.c);
            this.h = new s69(tbPageContext, o79.b);
            this.i = new t69(tbPageContext, p79.b);
            this.g = new p69(tbPageContext, l79.q);
            this.l = new x69(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof in)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        x69 x69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (x69Var = this.l) != null) {
            x69Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            x69 x69Var = this.l;
            if (x69Var != null) {
                x69Var.onPause();
            }
            v69 v69Var = this.c;
            if (v69Var != null) {
                v69Var.onPause();
            }
        }
    }

    public void f() {
        x69 x69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (x69Var = this.l) != null) {
            x69Var.onResume();
        }
    }

    public void g() {
        s69 s69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (s69Var = this.h) != null) {
            s69Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            x69 x69Var = this.l;
            if (x69Var != null) {
                x69Var.u(z);
            }
            o69 o69Var = this.k;
            if (o69Var != null) {
                o69Var.x(z);
            }
            u69 u69Var = this.f;
            if (u69Var != null) {
                u69Var.u(z);
            }
            v69 v69Var = this.c;
            if (v69Var != null) {
                v69Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        o69 o69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (o69Var = this.k) != null) {
            o69Var.u(z);
        }
    }
}
