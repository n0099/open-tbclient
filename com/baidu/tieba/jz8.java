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
public class jz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public hz8 d;
    public az8 e;
    public cz8 f;
    public bz8 g;
    public dz8 h;
    public iz8 i;
    public ez8 j;
    public fz8 k;
    public zy8 l;
    public kz8 m;
    public gz8 n;
    public List<in> o;

    public jz8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            hz8 hz8Var = new hz8(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = hz8Var;
            hz8Var.C(this.c);
            this.o.add(this.d);
            az8 az8Var = new az8(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = az8Var;
            az8Var.D(this.c);
            this.o.add(this.e);
            cz8 cz8Var = new cz8(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = cz8Var;
            cz8Var.C(this.c);
            this.o.add(this.f);
            bz8 bz8Var = new bz8(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = bz8Var;
            bz8Var.C(this.c);
            this.o.add(this.g);
            dz8 dz8Var = new dz8(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = dz8Var;
            dz8Var.C(this.c);
            this.o.add(this.h);
            iz8 iz8Var = new iz8(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = iz8Var;
            iz8Var.F(this.c);
            this.o.add(this.i);
            ez8 ez8Var = new ez8(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = ez8Var;
            ez8Var.C(this.c);
            this.o.add(this.j);
            fz8 fz8Var = new fz8(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = fz8Var;
            fz8Var.C(this.c);
            this.o.add(this.k);
            zy8 zy8Var = new zy8(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = zy8Var;
            zy8Var.D(this.c);
            this.o.add(this.l);
            kz8 kz8Var = new kz8(this.a, e25.b);
            this.m = kz8Var;
            kz8Var.B(this.c);
            this.o.add(this.m);
            gz8 gz8Var = new gz8(this.a, uo6.u0);
            this.n = gz8Var;
            this.o.add(gz8Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (in inVar : this.o) {
                if (inVar instanceof yy8) {
                    ((yy8) inVar).u(z);
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
