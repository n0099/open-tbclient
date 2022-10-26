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
/* loaded from: classes5.dex */
public class s58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k58 a;
    public h58 b;
    public p58 c;
    public q58 d;
    public l58 e;
    public o58 f;
    public j58 g;
    public m58 h;
    public n58 i;
    public BdTypeListView j;
    public i58 k;
    public r58 l;
    public List m;

    public s58(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new k58(tbPageContext, f68.b);
            this.b = new h58(tbPageContext, z58.f);
            this.c = new p58(tbPageContext, l68.b);
            this.d = new q58(tbPageContext, m68.c);
            this.e = new l58(tbPageContext, b68.b);
            this.f = new o58(tbPageContext, c68.b);
            this.k = new i58(tbPageContext, d68.c);
            this.h = new m58(tbPageContext, h68.b);
            this.i = new n58(tbPageContext, i68.b);
            this.g = new j58(tbPageContext, e68.l);
            this.l = new r58(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof vn)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        r58 r58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (r58Var = this.l) != null) {
            r58Var.onDestroy();
        }
    }

    public void d() {
        r58 r58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (r58Var = this.l) != null) {
            r58Var.onPause();
        }
    }

    public void f() {
        r58 r58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (r58Var = this.l) != null) {
            r58Var.onResume();
        }
    }

    public void g() {
        m58 m58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (m58Var = this.h) != null) {
            m58Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            r58 r58Var = this.l;
            if (r58Var != null) {
                r58Var.u(z);
            }
            i58 i58Var = this.k;
            if (i58Var != null) {
                i58Var.v(z);
            }
        }
    }

    public void h(boolean z) {
        i58 i58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (i58Var = this.k) != null) {
            i58Var.u(z);
        }
    }
}
