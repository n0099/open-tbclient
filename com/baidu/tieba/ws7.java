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
public class ws7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public us7 d;
    public ns7 e;
    public ps7 f;
    public os7 g;
    public qs7 h;
    public vs7 i;
    public rs7 j;
    public ss7 k;
    public ms7 l;
    public xs7 m;
    public ts7 n;
    public List<jn> o;

    public ws7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            us7 us7Var = new us7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = us7Var;
            us7Var.A(this.c);
            this.o.add(this.d);
            ns7 ns7Var = new ns7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = ns7Var;
            ns7Var.B(this.c);
            this.o.add(this.e);
            ps7 ps7Var = new ps7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = ps7Var;
            ps7Var.A(this.c);
            this.o.add(this.f);
            os7 os7Var = new os7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = os7Var;
            os7Var.A(this.c);
            this.o.add(this.g);
            qs7 qs7Var = new qs7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = qs7Var;
            qs7Var.A(this.c);
            this.o.add(this.h);
            vs7 vs7Var = new vs7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = vs7Var;
            vs7Var.D(this.c);
            this.o.add(this.i);
            rs7 rs7Var = new rs7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = rs7Var;
            rs7Var.A(this.c);
            this.o.add(this.j);
            ss7 ss7Var = new ss7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = ss7Var;
            ss7Var.A(this.c);
            this.o.add(this.k);
            ms7 ms7Var = new ms7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = ms7Var;
            ms7Var.B(this.c);
            this.o.add(this.l);
            xs7 xs7Var = new xs7(this.a, ps4.b);
            this.m = xs7Var;
            xs7Var.z(this.c);
            this.o.add(this.m);
            ts7 ts7Var = new ts7(this.a, o46.r0);
            this.n = ts7Var;
            this.o.add(ts7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (jn jnVar : this.o) {
                if (jnVar instanceof ls7) {
                    ((ls7) jnVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends wn> list) {
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
