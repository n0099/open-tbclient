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
public class k3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c3a a;
    public z2a b;
    public h3a c;
    public i3a d;
    public d3a e;
    public g3a f;
    public b3a g;
    public e3a h;
    public f3a i;
    public BdTypeListView j;
    public a3a k;
    public j3a l;
    public List<bi> m;

    public k3a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new c3a(tbPageContext, y3a.b);
            this.b = new z2a(tbPageContext, s3a.f);
            this.c = new h3a(tbPageContext, e4a.b);
            this.d = new i3a(tbPageContext, f4a.b);
            this.e = new d3a(tbPageContext, u3a.b);
            this.f = new g3a(tbPageContext, v3a.b);
            this.k = new a3a(tbPageContext, w3a.b);
            this.h = new e3a(tbPageContext, a4a.b);
            this.i = new f3a(tbPageContext, b4a.b);
            this.g = new b3a(tbPageContext, x3a.p);
            this.l = new j3a(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        j3a j3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (j3aVar = this.l) != null) {
            j3aVar.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j3a j3aVar = this.l;
            if (j3aVar != null) {
                j3aVar.onPause();
            }
            h3a h3aVar = this.c;
            if (h3aVar != null) {
                h3aVar.onPause();
            }
        }
    }

    public void f() {
        j3a j3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (j3aVar = this.l) != null) {
            j3aVar.onResume();
        }
    }

    public void g() {
        e3a e3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (e3aVar = this.h) != null) {
            e3aVar.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            j3a j3aVar = this.l;
            if (j3aVar != null) {
                j3aVar.x(z);
            }
            a3a a3aVar = this.k;
            if (a3aVar != null) {
                a3aVar.x(z);
            }
            g3a g3aVar = this.f;
            if (g3aVar != null) {
                g3aVar.x(z);
            }
            h3a h3aVar = this.c;
            if (h3aVar != null) {
                h3aVar.x(z);
            }
        }
    }
}
