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
public class ri8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ji8 a;
    public gi8 b;
    public oi8 c;
    public pi8 d;
    public ki8 e;
    public ni8 f;
    public ii8 g;
    public li8 h;
    public mi8 i;
    public BdTypeListView j;
    public hi8 k;
    public qi8 l;
    public List<qn> m;

    public ri8(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new ji8(tbPageContext, fj8.b);
            this.b = new gi8(tbPageContext, zi8.f);
            this.c = new oi8(tbPageContext, lj8.b);
            this.d = new pi8(tbPageContext, mj8.c);
            this.e = new ki8(tbPageContext, bj8.b);
            this.f = new ni8(tbPageContext, cj8.b);
            this.k = new hi8(tbPageContext, dj8.c);
            this.h = new li8(tbPageContext, hj8.b);
            this.i = new mi8(tbPageContext, ij8.b);
            this.g = new ii8(tbPageContext, ej8.q);
            this.l = new qi8(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        qi8 qi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (qi8Var = this.l) != null) {
            qi8Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qi8 qi8Var = this.l;
            if (qi8Var != null) {
                qi8Var.onPause();
            }
            oi8 oi8Var = this.c;
            if (oi8Var != null) {
                oi8Var.onPause();
            }
        }
    }

    public void f() {
        qi8 qi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (qi8Var = this.l) != null) {
            qi8Var.onResume();
        }
    }

    public void g() {
        li8 li8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (li8Var = this.h) != null) {
            li8Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            qi8 qi8Var = this.l;
            if (qi8Var != null) {
                qi8Var.u(z);
            }
            hi8 hi8Var = this.k;
            if (hi8Var != null) {
                hi8Var.v(z);
            }
            ni8 ni8Var = this.f;
            if (ni8Var != null) {
                ni8Var.u(z);
            }
            oi8 oi8Var = this.c;
            if (oi8Var != null) {
                oi8Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        hi8 hi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (hi8Var = this.k) != null) {
            hi8Var.u(z);
        }
    }
}
