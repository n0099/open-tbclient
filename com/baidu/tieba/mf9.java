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
public class mf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public kf9 d;
    public df9 e;
    public ff9 f;
    public ef9 g;
    public gf9 h;
    public lf9 i;
    public hf9 j;
    public if9 k;
    public cf9 l;
    public nf9 m;
    public jf9 n;
    public List<om> o;

    public mf9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            kf9 kf9Var = new kf9(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = kf9Var;
            kf9Var.C(this.c);
            this.o.add(this.d);
            df9 df9Var = new df9(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = df9Var;
            df9Var.D(this.c);
            this.o.add(this.e);
            ff9 ff9Var = new ff9(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = ff9Var;
            ff9Var.C(this.c);
            this.o.add(this.f);
            ef9 ef9Var = new ef9(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = ef9Var;
            ef9Var.C(this.c);
            this.o.add(this.g);
            gf9 gf9Var = new gf9(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = gf9Var;
            gf9Var.C(this.c);
            this.o.add(this.h);
            lf9 lf9Var = new lf9(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = lf9Var;
            lf9Var.F(this.c);
            this.o.add(this.i);
            hf9 hf9Var = new hf9(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = hf9Var;
            hf9Var.C(this.c);
            this.o.add(this.j);
            if9 if9Var = new if9(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = if9Var;
            if9Var.C(this.c);
            this.o.add(this.k);
            cf9 cf9Var = new cf9(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = cf9Var;
            cf9Var.D(this.c);
            this.o.add(this.l);
            nf9 nf9Var = new nf9(this.a, b25.b);
            this.m = nf9Var;
            nf9Var.B(this.c);
            this.o.add(this.m);
            jf9 jf9Var = new jf9(this.a, iq6.u0);
            this.n = jf9Var;
            this.o.add(jf9Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (om omVar : this.o) {
                if (omVar instanceof bf9) {
                    ((bf9) omVar).u(z);
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
