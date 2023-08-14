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
public class xn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pn9 a;
    public mn9 b;
    public un9 c;
    public vn9 d;
    public qn9 e;
    public tn9 f;
    public on9 g;
    public rn9 h;
    public sn9 i;
    public BdTypeListView j;
    public nn9 k;
    public wn9 l;
    public List<lm> m;

    public xn9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new pn9(tbPageContext, lo9.b);
            this.b = new mn9(tbPageContext, fo9.f);
            this.c = new un9(tbPageContext, ro9.b);
            this.d = new vn9(tbPageContext, so9.c);
            this.e = new qn9(tbPageContext, ho9.b);
            this.f = new tn9(tbPageContext, io9.b);
            this.k = new nn9(tbPageContext, jo9.c);
            this.h = new rn9(tbPageContext, no9.b);
            this.i = new sn9(tbPageContext, oo9.b);
            this.g = new on9(tbPageContext, ko9.p);
            this.l = new wn9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof pm)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        wn9 wn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (wn9Var = this.l) != null) {
            wn9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wn9 wn9Var = this.l;
            if (wn9Var != null) {
                wn9Var.onPause();
            }
            un9 un9Var = this.c;
            if (un9Var != null) {
                un9Var.onPause();
            }
        }
    }

    public void f() {
        wn9 wn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (wn9Var = this.l) != null) {
            wn9Var.onResume();
        }
    }

    public void g() {
        rn9 rn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (rn9Var = this.h) != null) {
            rn9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            wn9 wn9Var = this.l;
            if (wn9Var != null) {
                wn9Var.u(z);
            }
            nn9 nn9Var = this.k;
            if (nn9Var != null) {
                nn9Var.x(z);
            }
            tn9 tn9Var = this.f;
            if (tn9Var != null) {
                tn9Var.u(z);
            }
            un9 un9Var = this.c;
            if (un9Var != null) {
                un9Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        nn9 nn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (nn9Var = this.k) != null) {
            nn9Var.u(z);
        }
    }
}
