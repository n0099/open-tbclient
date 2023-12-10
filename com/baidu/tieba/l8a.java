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
public class l8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d8a a;
    public a8a b;
    public i8a c;
    public j8a d;
    public e8a e;
    public h8a f;
    public c8a g;
    public f8a h;
    public g8a i;
    public BdTypeListView j;
    public b8a k;
    public k8a l;
    public List<ci> m;

    public l8a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new d8a(tbPageContext, z8a.b);
            this.b = new a8a(tbPageContext, t8a.f);
            this.c = new i8a(tbPageContext, f9a.b);
            this.d = new j8a(tbPageContext, g9a.b);
            this.e = new e8a(tbPageContext, v8a.b);
            this.f = new h8a(tbPageContext, w8a.b);
            this.k = new b8a(tbPageContext, x8a.b);
            this.h = new f8a(tbPageContext, b9a.b);
            this.i = new g8a(tbPageContext, c9a.b);
            this.g = new c8a(tbPageContext, y8a.p);
            this.l = new k8a(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof gi)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        k8a k8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (k8aVar = this.l) != null) {
            k8aVar.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            k8a k8aVar = this.l;
            if (k8aVar != null) {
                k8aVar.onPause();
            }
            i8a i8aVar = this.c;
            if (i8aVar != null) {
                i8aVar.onPause();
            }
        }
    }

    public void f() {
        k8a k8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (k8aVar = this.l) != null) {
            k8aVar.onResume();
        }
    }

    public void g() {
        f8a f8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (f8aVar = this.h) != null) {
            f8aVar.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            k8a k8aVar = this.l;
            if (k8aVar != null) {
                k8aVar.x(z);
            }
            b8a b8aVar = this.k;
            if (b8aVar != null) {
                b8aVar.x(z);
            }
            h8a h8aVar = this.f;
            if (h8aVar != null) {
                h8aVar.x(z);
            }
            i8a i8aVar = this.c;
            if (i8aVar != null) {
                i8aVar.x(z);
            }
        }
    }
}
