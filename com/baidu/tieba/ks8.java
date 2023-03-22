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
public class ks8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cs8 a;
    public zr8 b;
    public hs8 c;
    public is8 d;
    public ds8 e;
    public gs8 f;
    public bs8 g;
    public es8 h;
    public fs8 i;
    public BdTypeListView j;
    public as8 k;
    public js8 l;
    public List<tm> m;

    public ks8(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new cs8(tbPageContext, ys8.b);
            this.b = new zr8(tbPageContext, ss8.f);
            this.c = new hs8(tbPageContext, et8.b);
            this.d = new is8(tbPageContext, ft8.c);
            this.e = new ds8(tbPageContext, us8.b);
            this.f = new gs8(tbPageContext, vs8.b);
            this.k = new as8(tbPageContext, ws8.c);
            this.h = new es8(tbPageContext, at8.b);
            this.i = new fs8(tbPageContext, bt8.b);
            this.g = new bs8(tbPageContext, xs8.q);
            this.l = new js8(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof xm)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        js8 js8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (js8Var = this.l) != null) {
            js8Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            js8 js8Var = this.l;
            if (js8Var != null) {
                js8Var.onPause();
            }
            hs8 hs8Var = this.c;
            if (hs8Var != null) {
                hs8Var.onPause();
            }
        }
    }

    public void f() {
        js8 js8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (js8Var = this.l) != null) {
            js8Var.onResume();
        }
    }

    public void g() {
        es8 es8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (es8Var = this.h) != null) {
            es8Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            js8 js8Var = this.l;
            if (js8Var != null) {
                js8Var.u(z);
            }
            as8 as8Var = this.k;
            if (as8Var != null) {
                as8Var.x(z);
            }
            gs8 gs8Var = this.f;
            if (gs8Var != null) {
                gs8Var.u(z);
            }
            hs8 hs8Var = this.c;
            if (hs8Var != null) {
                hs8Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        as8 as8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (as8Var = this.k) != null) {
            as8Var.u(z);
        }
    }
}
