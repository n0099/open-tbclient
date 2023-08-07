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
public class wn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public on9 a;
    public ln9 b;
    public tn9 c;
    public un9 d;
    public pn9 e;
    public sn9 f;
    public nn9 g;
    public qn9 h;
    public rn9 i;
    public BdTypeListView j;
    public mn9 k;
    public vn9 l;
    public List<lm> m;

    public wn9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new on9(tbPageContext, ko9.b);
            this.b = new ln9(tbPageContext, eo9.f);
            this.c = new tn9(tbPageContext, qo9.b);
            this.d = new un9(tbPageContext, ro9.c);
            this.e = new pn9(tbPageContext, go9.b);
            this.f = new sn9(tbPageContext, ho9.b);
            this.k = new mn9(tbPageContext, io9.c);
            this.h = new qn9(tbPageContext, mo9.b);
            this.i = new rn9(tbPageContext, no9.b);
            this.g = new nn9(tbPageContext, jo9.p);
            this.l = new vn9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        vn9 vn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (vn9Var = this.l) != null) {
            vn9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vn9 vn9Var = this.l;
            if (vn9Var != null) {
                vn9Var.onPause();
            }
            tn9 tn9Var = this.c;
            if (tn9Var != null) {
                tn9Var.onPause();
            }
        }
    }

    public void f() {
        vn9 vn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (vn9Var = this.l) != null) {
            vn9Var.onResume();
        }
    }

    public void g() {
        qn9 qn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (qn9Var = this.h) != null) {
            qn9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            vn9 vn9Var = this.l;
            if (vn9Var != null) {
                vn9Var.u(z);
            }
            mn9 mn9Var = this.k;
            if (mn9Var != null) {
                mn9Var.x(z);
            }
            sn9 sn9Var = this.f;
            if (sn9Var != null) {
                sn9Var.u(z);
            }
            tn9 tn9Var = this.c;
            if (tn9Var != null) {
                tn9Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        mn9 mn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (mn9Var = this.k) != null) {
            mn9Var.u(z);
        }
    }
}
