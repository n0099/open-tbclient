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
/* loaded from: classes7.dex */
public class ye8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qe8 a;
    public ne8 b;
    public ve8 c;
    public we8 d;
    public re8 e;
    public ue8 f;
    public pe8 g;
    public se8 h;
    public te8 i;
    public BdTypeListView j;
    public oe8 k;
    public xe8 l;
    public List<ln> m;

    public ye8(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new qe8(tbPageContext, lf8.b);
            this.b = new ne8(tbPageContext, ff8.f);
            this.c = new ve8(tbPageContext, rf8.b);
            this.d = new we8(tbPageContext, sf8.c);
            this.e = new re8(tbPageContext, hf8.b);
            this.f = new ue8(tbPageContext, if8.b);
            this.k = new oe8(tbPageContext, jf8.c);
            this.h = new se8(tbPageContext, nf8.b);
            this.i = new te8(tbPageContext, of8.b);
            this.g = new pe8(tbPageContext, kf8.l);
            this.l = new xe8(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof pn)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        xe8 xe8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (xe8Var = this.l) != null) {
            xe8Var.onDestroy();
        }
    }

    public void d() {
        xe8 xe8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (xe8Var = this.l) != null) {
            xe8Var.onPause();
        }
    }

    public void f() {
        xe8 xe8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (xe8Var = this.l) != null) {
            xe8Var.onResume();
        }
    }

    public void g() {
        se8 se8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (se8Var = this.h) != null) {
            se8Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            xe8 xe8Var = this.l;
            if (xe8Var != null) {
                xe8Var.u(z);
            }
            oe8 oe8Var = this.k;
            if (oe8Var != null) {
                oe8Var.v(z);
            }
            ue8 ue8Var = this.f;
            if (ue8Var != null) {
                ue8Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        oe8 oe8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (oe8Var = this.k) != null) {
            oe8Var.u(z);
        }
    }
}
