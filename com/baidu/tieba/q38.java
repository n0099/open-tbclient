package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class q38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k38 a;
    public h38 b;
    public p38 c;
    public l38 d;
    public o38 e;
    public j38 f;
    public m38 g;
    public n38 h;
    public BdTypeListView i;
    public i38 j;
    public List<cn> k;

    public q38(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.k = new ArrayList();
        this.i = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.t();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new k38(tbPageContext, c48.b);
            this.b = new h38(tbPageContext, w38.f);
            this.c = new p38(tbPageContext, i48.b);
            this.d = new l38(tbPageContext, y38.b);
            this.e = new o38(tbPageContext, z38.b);
            this.j = new i38(tbPageContext, a48.c);
            this.g = new m38(tbPageContext, e48.b);
            this.h = new n38(tbPageContext, f48.b);
            this.f = new j38(tbPageContext, b48.l);
            this.k.add(this.a);
            this.k.add(this.b);
            this.k.add(this.d);
            this.k.add(this.e);
            this.k.add(this.c);
            this.k.add(this.g);
            this.k.add(this.h);
            this.k.add(this.f);
            this.k.add(this.j);
            bdTypeListView.a(this.k);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.i) != null && (bdTypeListView.getAdapter2() instanceof gn)) {
            this.i.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        m38 m38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (m38Var = this.g) == null) {
            return;
        }
        m38Var.onScroll();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.w();
        }
    }
}
