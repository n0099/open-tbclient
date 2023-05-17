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
public class lt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public jt8 d;
    public ct8 e;
    public et8 f;
    public dt8 g;
    public ft8 h;
    public kt8 i;
    public gt8 j;
    public ht8 k;
    public bt8 l;
    public mt8 m;
    public it8 n;
    public List<en> o;

    public lt8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            jt8 jt8Var = new jt8(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = jt8Var;
            jt8Var.C(this.c);
            this.o.add(this.d);
            ct8 ct8Var = new ct8(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = ct8Var;
            ct8Var.D(this.c);
            this.o.add(this.e);
            et8 et8Var = new et8(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = et8Var;
            et8Var.C(this.c);
            this.o.add(this.f);
            dt8 dt8Var = new dt8(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = dt8Var;
            dt8Var.C(this.c);
            this.o.add(this.g);
            ft8 ft8Var = new ft8(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = ft8Var;
            ft8Var.C(this.c);
            this.o.add(this.h);
            kt8 kt8Var = new kt8(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = kt8Var;
            kt8Var.F(this.c);
            this.o.add(this.i);
            gt8 gt8Var = new gt8(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = gt8Var;
            gt8Var.C(this.c);
            this.o.add(this.j);
            ht8 ht8Var = new ht8(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = ht8Var;
            ht8Var.C(this.c);
            this.o.add(this.k);
            bt8 bt8Var = new bt8(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = bt8Var;
            bt8Var.D(this.c);
            this.o.add(this.l);
            mt8 mt8Var = new mt8(this.a, iz4.b);
            this.m = mt8Var;
            mt8Var.B(this.c);
            this.o.add(this.m);
            it8 it8Var = new it8(this.a, kk6.t0);
            this.n = it8Var;
            this.o.add(it8Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (en enVar : this.o) {
                if (enVar instanceof at8) {
                    ((at8) enVar).u(z);
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
