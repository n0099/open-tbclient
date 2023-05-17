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
public class x69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p69 a;
    public m69 b;
    public u69 c;
    public v69 d;
    public q69 e;
    public t69 f;
    public o69 g;
    public r69 h;
    public s69 i;
    public BdTypeListView j;
    public n69 k;
    public w69 l;
    public List<en> m;

    public x69(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new p69(tbPageContext, l79.b);
            this.b = new m69(tbPageContext, f79.f);
            this.c = new u69(tbPageContext, r79.b);
            this.d = new v69(tbPageContext, s79.c);
            this.e = new q69(tbPageContext, h79.b);
            this.f = new t69(tbPageContext, i79.b);
            this.k = new n69(tbPageContext, j79.c);
            this.h = new r69(tbPageContext, n79.b);
            this.i = new s69(tbPageContext, o79.b);
            this.g = new o69(tbPageContext, k79.q);
            this.l = new w69(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        w69 w69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (w69Var = this.l) != null) {
            w69Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            w69 w69Var = this.l;
            if (w69Var != null) {
                w69Var.onPause();
            }
            u69 u69Var = this.c;
            if (u69Var != null) {
                u69Var.onPause();
            }
        }
    }

    public void f() {
        w69 w69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (w69Var = this.l) != null) {
            w69Var.onResume();
        }
    }

    public void g() {
        r69 r69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (r69Var = this.h) != null) {
            r69Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            w69 w69Var = this.l;
            if (w69Var != null) {
                w69Var.u(z);
            }
            n69 n69Var = this.k;
            if (n69Var != null) {
                n69Var.x(z);
            }
            t69 t69Var = this.f;
            if (t69Var != null) {
                t69Var.u(z);
            }
            u69 u69Var = this.c;
            if (u69Var != null) {
                u69Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        n69 n69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (n69Var = this.k) != null) {
            n69Var.u(z);
        }
    }
}
