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
public class j3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b3a a;
    public y2a b;
    public g3a c;
    public h3a d;
    public c3a e;
    public f3a f;
    public a3a g;
    public d3a h;
    public e3a i;
    public BdTypeListView j;
    public z2a k;
    public i3a l;
    public List<bi> m;

    public j3a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new b3a(tbPageContext, x3a.b);
            this.b = new y2a(tbPageContext, r3a.f);
            this.c = new g3a(tbPageContext, d4a.b);
            this.d = new h3a(tbPageContext, e4a.b);
            this.e = new c3a(tbPageContext, t3a.b);
            this.f = new f3a(tbPageContext, u3a.b);
            this.k = new z2a(tbPageContext, v3a.b);
            this.h = new d3a(tbPageContext, z3a.b);
            this.i = new e3a(tbPageContext, a4a.b);
            this.g = new a3a(tbPageContext, w3a.p);
            this.l = new i3a(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof fi)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        i3a i3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (i3aVar = this.l) != null) {
            i3aVar.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i3a i3aVar = this.l;
            if (i3aVar != null) {
                i3aVar.onPause();
            }
            g3a g3aVar = this.c;
            if (g3aVar != null) {
                g3aVar.onPause();
            }
        }
    }

    public void f() {
        i3a i3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (i3aVar = this.l) != null) {
            i3aVar.onResume();
        }
    }

    public void g() {
        d3a d3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (d3aVar = this.h) != null) {
            d3aVar.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            i3a i3aVar = this.l;
            if (i3aVar != null) {
                i3aVar.x(z);
            }
            z2a z2aVar = this.k;
            if (z2aVar != null) {
                z2aVar.x(z);
            }
            f3a f3aVar = this.f;
            if (f3aVar != null) {
                f3aVar.x(z);
            }
            g3a g3aVar = this.c;
            if (g3aVar != null) {
                g3aVar.x(z);
            }
        }
    }
}
