package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class mt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public kt8 d;
    public dt8 e;
    public ft8 f;
    public et8 g;
    public gt8 h;
    public lt8 i;
    public ht8 j;
    public it8 k;
    public ct8 l;
    public nt8 m;
    public jt8 n;
    public List<en> o;

    public mt8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new LinkedList();
        this.a = tbPageContext;
        this.b = bdUniqueId;
        this.c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            kt8 kt8Var = new kt8(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = kt8Var;
            kt8Var.C(this.c);
            this.o.add(this.d);
            dt8 dt8Var = new dt8(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = dt8Var;
            dt8Var.D(this.c);
            this.o.add(this.e);
            ft8 ft8Var = new ft8(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = ft8Var;
            ft8Var.C(this.c);
            this.o.add(this.f);
            et8 et8Var = new et8(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = et8Var;
            et8Var.C(this.c);
            this.o.add(this.g);
            gt8 gt8Var = new gt8(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = gt8Var;
            gt8Var.C(this.c);
            this.o.add(this.h);
            lt8 lt8Var = new lt8(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = lt8Var;
            lt8Var.F(this.c);
            this.o.add(this.i);
            ht8 ht8Var = new ht8(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = ht8Var;
            ht8Var.C(this.c);
            this.o.add(this.j);
            it8 it8Var = new it8(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = it8Var;
            it8Var.C(this.c);
            this.o.add(this.k);
            ct8 ct8Var = new ct8(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = ct8Var;
            ct8Var.D(this.c);
            this.o.add(this.l);
            nt8 nt8Var = new nt8(this.a, iz4.b);
            this.m = nt8Var;
            nt8Var.B(this.c);
            this.o.add(this.m);
            jt8 jt8Var = new jt8(this.a, lk6.t0);
            this.n = jt8Var;
            this.o.add(jt8Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (en enVar : this.o) {
                if (enVar instanceof bt8) {
                    ((bt8) enVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends rn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }
}
