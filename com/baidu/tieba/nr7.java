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
/* loaded from: classes5.dex */
public class nr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public lr7 d;
    public er7 e;
    public gr7 f;
    public fr7 g;
    public hr7 h;
    public mr7 i;
    public ir7 j;
    public jr7 k;
    public dr7 l;
    public or7 m;
    public kr7 n;
    public List o;

    public nr7(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            lr7 lr7Var = new lr7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = lr7Var;
            lr7Var.A(this.c);
            this.o.add(this.d);
            er7 er7Var = new er7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = er7Var;
            er7Var.B(this.c);
            this.o.add(this.e);
            gr7 gr7Var = new gr7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = gr7Var;
            gr7Var.A(this.c);
            this.o.add(this.f);
            fr7 fr7Var = new fr7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = fr7Var;
            fr7Var.A(this.c);
            this.o.add(this.g);
            hr7 hr7Var = new hr7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = hr7Var;
            hr7Var.A(this.c);
            this.o.add(this.h);
            mr7 mr7Var = new mr7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = mr7Var;
            mr7Var.D(this.c);
            this.o.add(this.i);
            ir7 ir7Var = new ir7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = ir7Var;
            ir7Var.A(this.c);
            this.o.add(this.j);
            jr7 jr7Var = new jr7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = jr7Var;
            jr7Var.A(this.c);
            this.o.add(this.k);
            dr7 dr7Var = new dr7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = dr7Var;
            dr7Var.B(this.c);
            this.o.add(this.l);
            or7 or7Var = new or7(this.a, yr4.b);
            this.m = or7Var;
            or7Var.z(this.c);
            this.o.add(this.m);
            kr7 kr7Var = new kr7(this.a, e36.r0);
            this.n = kr7Var;
            this.o.add(kr7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (rn rnVar : this.o) {
                if (rnVar instanceof cr7) {
                    ((cr7) rnVar).u(z);
                }
            }
        }
    }

    public void d(List list) {
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
