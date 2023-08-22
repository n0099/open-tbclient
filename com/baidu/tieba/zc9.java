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
/* loaded from: classes9.dex */
public class zc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public xc9 d;
    public qc9 e;
    public sc9 f;
    public rc9 g;
    public tc9 h;
    public yc9 i;
    public uc9 j;
    public vc9 k;
    public pc9 l;
    public ad9 m;
    public wc9 n;
    public List<om> o;

    public zc9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            xc9 xc9Var = new xc9(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = xc9Var;
            xc9Var.C(this.c);
            this.o.add(this.d);
            qc9 qc9Var = new qc9(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = qc9Var;
            qc9Var.D(this.c);
            this.o.add(this.e);
            sc9 sc9Var = new sc9(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = sc9Var;
            sc9Var.C(this.c);
            this.o.add(this.f);
            rc9 rc9Var = new rc9(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = rc9Var;
            rc9Var.C(this.c);
            this.o.add(this.g);
            tc9 tc9Var = new tc9(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = tc9Var;
            tc9Var.C(this.c);
            this.o.add(this.h);
            yc9 yc9Var = new yc9(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = yc9Var;
            yc9Var.F(this.c);
            this.o.add(this.i);
            uc9 uc9Var = new uc9(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = uc9Var;
            uc9Var.C(this.c);
            this.o.add(this.j);
            vc9 vc9Var = new vc9(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = vc9Var;
            vc9Var.C(this.c);
            this.o.add(this.k);
            pc9 pc9Var = new pc9(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = pc9Var;
            pc9Var.D(this.c);
            this.o.add(this.l);
            ad9 ad9Var = new ad9(this.a, w15.b);
            this.m = ad9Var;
            ad9Var.B(this.c);
            this.o.add(this.m);
            wc9 wc9Var = new wc9(this.a, zo6.u0);
            this.n = wc9Var;
            this.o.add(wc9Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (om omVar : this.o) {
                if (omVar instanceof oc9) {
                    ((oc9) omVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends bn> list) {
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
