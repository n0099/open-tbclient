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
/* loaded from: classes7.dex */
public class zo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public xo8 d;
    public qo8 e;
    public so8 f;
    public ro8 g;
    public to8 h;
    public yo8 i;
    public uo8 j;
    public vo8 k;
    public po8 l;
    public ap8 m;
    public wo8 n;
    public List<um> o;

    public zo8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            xo8 xo8Var = new xo8(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = xo8Var;
            xo8Var.C(this.c);
            this.o.add(this.d);
            qo8 qo8Var = new qo8(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = qo8Var;
            qo8Var.D(this.c);
            this.o.add(this.e);
            so8 so8Var = new so8(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = so8Var;
            so8Var.C(this.c);
            this.o.add(this.f);
            ro8 ro8Var = new ro8(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = ro8Var;
            ro8Var.C(this.c);
            this.o.add(this.g);
            to8 to8Var = new to8(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = to8Var;
            to8Var.C(this.c);
            this.o.add(this.h);
            yo8 yo8Var = new yo8(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = yo8Var;
            yo8Var.F(this.c);
            this.o.add(this.i);
            uo8 uo8Var = new uo8(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = uo8Var;
            uo8Var.C(this.c);
            this.o.add(this.j);
            vo8 vo8Var = new vo8(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = vo8Var;
            vo8Var.C(this.c);
            this.o.add(this.k);
            po8 po8Var = new po8(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = po8Var;
            po8Var.D(this.c);
            this.o.add(this.l);
            ap8 ap8Var = new ap8(this.a, ix4.b);
            this.m = ap8Var;
            ap8Var.B(this.c);
            this.o.add(this.m);
            wo8 wo8Var = new wo8(this.a, mh6.t0);
            this.n = wo8Var;
            this.o.add(wo8Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (um umVar : this.o) {
                if (umVar instanceof oo8) {
                    ((oo8) umVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends hn> list) {
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
