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
public class mz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public kz8 d;
    public dz8 e;
    public fz8 f;
    public ez8 g;
    public gz8 h;
    public lz8 i;
    public hz8 j;
    public iz8 k;
    public cz8 l;
    public nz8 m;
    public jz8 n;
    public List<in> o;

    public mz8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            kz8 kz8Var = new kz8(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = kz8Var;
            kz8Var.C(this.c);
            this.o.add(this.d);
            dz8 dz8Var = new dz8(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = dz8Var;
            dz8Var.D(this.c);
            this.o.add(this.e);
            fz8 fz8Var = new fz8(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = fz8Var;
            fz8Var.C(this.c);
            this.o.add(this.f);
            ez8 ez8Var = new ez8(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = ez8Var;
            ez8Var.C(this.c);
            this.o.add(this.g);
            gz8 gz8Var = new gz8(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = gz8Var;
            gz8Var.C(this.c);
            this.o.add(this.h);
            lz8 lz8Var = new lz8(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = lz8Var;
            lz8Var.F(this.c);
            this.o.add(this.i);
            hz8 hz8Var = new hz8(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = hz8Var;
            hz8Var.C(this.c);
            this.o.add(this.j);
            iz8 iz8Var = new iz8(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = iz8Var;
            iz8Var.C(this.c);
            this.o.add(this.k);
            cz8 cz8Var = new cz8(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = cz8Var;
            cz8Var.D(this.c);
            this.o.add(this.l);
            nz8 nz8Var = new nz8(this.a, g25.b);
            this.m = nz8Var;
            nz8Var.B(this.c);
            this.o.add(this.m);
            jz8 jz8Var = new jz8(this.a, wo6.u0);
            this.n = jz8Var;
            this.o.add(jz8Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (in inVar : this.o) {
                if (inVar instanceof bz8) {
                    ((bz8) inVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends vn> list) {
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
