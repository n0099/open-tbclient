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
public class le9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public de9 a;
    public ae9 b;
    public ie9 c;
    public je9 d;
    public ee9 e;
    public he9 f;
    public ce9 g;
    public fe9 h;
    public ge9 i;
    public BdTypeListView j;
    public be9 k;
    public ke9 l;
    public List<jn> m;

    public le9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new de9(tbPageContext, ze9.b);
            this.b = new ae9(tbPageContext, te9.f);
            this.c = new ie9(tbPageContext, ff9.b);
            this.d = new je9(tbPageContext, gf9.c);
            this.e = new ee9(tbPageContext, ve9.b);
            this.f = new he9(tbPageContext, we9.b);
            this.k = new be9(tbPageContext, xe9.c);
            this.h = new fe9(tbPageContext, bf9.b);
            this.i = new ge9(tbPageContext, cf9.b);
            this.g = new ce9(tbPageContext, ye9.p);
            this.l = new ke9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof nn)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        ke9 ke9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ke9Var = this.l) != null) {
            ke9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ke9 ke9Var = this.l;
            if (ke9Var != null) {
                ke9Var.onPause();
            }
            ie9 ie9Var = this.c;
            if (ie9Var != null) {
                ie9Var.onPause();
            }
        }
    }

    public void f() {
        ke9 ke9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ke9Var = this.l) != null) {
            ke9Var.onResume();
        }
    }

    public void g() {
        fe9 fe9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (fe9Var = this.h) != null) {
            fe9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            ke9 ke9Var = this.l;
            if (ke9Var != null) {
                ke9Var.u(z);
            }
            be9 be9Var = this.k;
            if (be9Var != null) {
                be9Var.x(z);
            }
            he9 he9Var = this.f;
            if (he9Var != null) {
                he9Var.u(z);
            }
            ie9 ie9Var = this.c;
            if (ie9Var != null) {
                ie9Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        be9 be9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (be9Var = this.k) != null) {
            be9Var.u(z);
        }
    }
}
