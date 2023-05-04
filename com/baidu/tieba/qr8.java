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
public class qr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public or8 d;
    public hr8 e;
    public jr8 f;
    public ir8 g;
    public kr8 h;
    public pr8 i;
    public lr8 j;
    public mr8 k;
    public gr8 l;
    public rr8 m;
    public nr8 n;
    public List<vm> o;

    public qr8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            or8 or8Var = new or8(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = or8Var;
            or8Var.C(this.c);
            this.o.add(this.d);
            hr8 hr8Var = new hr8(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = hr8Var;
            hr8Var.D(this.c);
            this.o.add(this.e);
            jr8 jr8Var = new jr8(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = jr8Var;
            jr8Var.C(this.c);
            this.o.add(this.f);
            ir8 ir8Var = new ir8(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = ir8Var;
            ir8Var.C(this.c);
            this.o.add(this.g);
            kr8 kr8Var = new kr8(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = kr8Var;
            kr8Var.C(this.c);
            this.o.add(this.h);
            pr8 pr8Var = new pr8(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = pr8Var;
            pr8Var.F(this.c);
            this.o.add(this.i);
            lr8 lr8Var = new lr8(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = lr8Var;
            lr8Var.C(this.c);
            this.o.add(this.j);
            mr8 mr8Var = new mr8(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = mr8Var;
            mr8Var.C(this.c);
            this.o.add(this.k);
            gr8 gr8Var = new gr8(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = gr8Var;
            gr8Var.D(this.c);
            this.o.add(this.l);
            rr8 rr8Var = new rr8(this.a, zx4.b);
            this.m = rr8Var;
            rr8Var.B(this.c);
            this.o.add(this.m);
            nr8 nr8Var = new nr8(this.a, yi6.t0);
            this.n = nr8Var;
            this.o.add(nr8Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (vm vmVar : this.o) {
                if (vmVar instanceof fr8) {
                    ((fr8) vmVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends in> list) {
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
