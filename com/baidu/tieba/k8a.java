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
public class k8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c8a a;
    public z7a b;
    public h8a c;
    public i8a d;
    public d8a e;
    public g8a f;
    public b8a g;
    public e8a h;
    public f8a i;
    public BdTypeListView j;
    public a8a k;
    public j8a l;
    public List<ci> m;

    public k8a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new c8a(tbPageContext, y8a.b);
            this.b = new z7a(tbPageContext, s8a.f);
            this.c = new h8a(tbPageContext, e9a.b);
            this.d = new i8a(tbPageContext, f9a.b);
            this.e = new d8a(tbPageContext, u8a.b);
            this.f = new g8a(tbPageContext, v8a.b);
            this.k = new a8a(tbPageContext, w8a.b);
            this.h = new e8a(tbPageContext, a9a.b);
            this.i = new f8a(tbPageContext, b9a.b);
            this.g = new b8a(tbPageContext, x8a.p);
            this.l = new j8a(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        j8a j8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (j8aVar = this.l) != null) {
            j8aVar.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j8a j8aVar = this.l;
            if (j8aVar != null) {
                j8aVar.onPause();
            }
            h8a h8aVar = this.c;
            if (h8aVar != null) {
                h8aVar.onPause();
            }
        }
    }

    public void f() {
        j8a j8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (j8aVar = this.l) != null) {
            j8aVar.onResume();
        }
    }

    public void g() {
        e8a e8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (e8aVar = this.h) != null) {
            e8aVar.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            j8a j8aVar = this.l;
            if (j8aVar != null) {
                j8aVar.x(z);
            }
            a8a a8aVar = this.k;
            if (a8aVar != null) {
                a8aVar.x(z);
            }
            g8a g8aVar = this.f;
            if (g8aVar != null) {
                g8aVar.x(z);
            }
            h8a h8aVar = this.c;
            if (h8aVar != null) {
                h8aVar.x(z);
            }
        }
    }
}
