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
public class tt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lt9 a;
    public it9 b;
    public qt9 c;
    public rt9 d;
    public mt9 e;
    public pt9 f;
    public kt9 g;
    public nt9 h;
    public ot9 i;
    public BdTypeListView j;
    public jt9 k;
    public st9 l;
    public List<pm> m;

    public tt9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new lt9(tbPageContext, hu9.b);
            this.b = new it9(tbPageContext, bu9.f);
            this.c = new qt9(tbPageContext, nu9.b);
            this.d = new rt9(tbPageContext, ou9.b);
            this.e = new mt9(tbPageContext, du9.b);
            this.f = new pt9(tbPageContext, eu9.b);
            this.k = new jt9(tbPageContext, fu9.c);
            this.h = new nt9(tbPageContext, ju9.b);
            this.i = new ot9(tbPageContext, ku9.b);
            this.g = new kt9(tbPageContext, gu9.p);
            this.l = new st9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof tm)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        st9 st9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (st9Var = this.l) != null) {
            st9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            st9 st9Var = this.l;
            if (st9Var != null) {
                st9Var.onPause();
            }
            qt9 qt9Var = this.c;
            if (qt9Var != null) {
                qt9Var.onPause();
            }
        }
    }

    public void f() {
        st9 st9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (st9Var = this.l) != null) {
            st9Var.onResume();
        }
    }

    public void g() {
        nt9 nt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (nt9Var = this.h) != null) {
            nt9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            st9 st9Var = this.l;
            if (st9Var != null) {
                st9Var.u(z);
            }
            jt9 jt9Var = this.k;
            if (jt9Var != null) {
                jt9Var.x(z);
            }
            pt9 pt9Var = this.f;
            if (pt9Var != null) {
                pt9Var.u(z);
            }
            qt9 qt9Var = this.c;
            if (qt9Var != null) {
                qt9Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        jt9 jt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (jt9Var = this.k) != null) {
            jt9Var.u(z);
        }
    }
}
