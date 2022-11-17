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
/* loaded from: classes4.dex */
public class it7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public gt7 d;
    public zs7 e;
    public bt7 f;
    public at7 g;
    public ct7 h;
    public ht7 i;
    public dt7 j;
    public et7 k;
    public ys7 l;
    public jt7 m;
    public ft7 n;
    public List<kn> o;

    public it7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            gt7 gt7Var = new gt7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = gt7Var;
            gt7Var.A(this.c);
            this.o.add(this.d);
            zs7 zs7Var = new zs7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = zs7Var;
            zs7Var.B(this.c);
            this.o.add(this.e);
            bt7 bt7Var = new bt7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = bt7Var;
            bt7Var.A(this.c);
            this.o.add(this.f);
            at7 at7Var = new at7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = at7Var;
            at7Var.A(this.c);
            this.o.add(this.g);
            ct7 ct7Var = new ct7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = ct7Var;
            ct7Var.A(this.c);
            this.o.add(this.h);
            ht7 ht7Var = new ht7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = ht7Var;
            ht7Var.D(this.c);
            this.o.add(this.i);
            dt7 dt7Var = new dt7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = dt7Var;
            dt7Var.A(this.c);
            this.o.add(this.j);
            et7 et7Var = new et7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = et7Var;
            et7Var.A(this.c);
            this.o.add(this.k);
            ys7 ys7Var = new ys7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = ys7Var;
            ys7Var.B(this.c);
            this.o.add(this.l);
            jt7 jt7Var = new jt7(this.a, rs4.b);
            this.m = jt7Var;
            jt7Var.z(this.c);
            this.o.add(this.m);
            ft7 ft7Var = new ft7(this.a, b56.r0);
            this.n = ft7Var;
            this.o.add(ft7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (kn knVar : this.o) {
                if (knVar instanceof xs7) {
                    ((xs7) knVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends xn> list) {
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
