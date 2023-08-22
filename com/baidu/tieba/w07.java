package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class w07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public i17 c;
    public z07 d;
    public b17 e;
    public a17 f;
    public c17 g;
    public j17 h;
    public e17 i;
    public g17 j;
    public f17 k;
    public d17 l;
    public h17 m;
    public y07 n;
    public k17 o;
    public List<om> p;

    public w07(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new LinkedList();
        this.a = enterForumTabFeedFragment;
        this.b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i17 i17Var = new i17(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.W1());
            this.c = i17Var;
            i17Var.y(this.b);
            this.p.add(this.c);
            z07 z07Var = new z07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.W1());
            this.d = z07Var;
            z07Var.z(this.b);
            this.p.add(this.d);
            b17 b17Var = new b17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.W1());
            this.e = b17Var;
            b17Var.y(this.b);
            this.p.add(this.e);
            a17 a17Var = new a17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.W1());
            this.f = a17Var;
            a17Var.y(this.b);
            this.p.add(this.f);
            c17 c17Var = new c17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.W1());
            this.g = c17Var;
            c17Var.y(this.b);
            this.p.add(this.g);
            j17 j17Var = new j17(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.W1());
            this.h = j17Var;
            j17Var.B(this.b);
            this.p.add(this.h);
            e17 e17Var = new e17(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.W1());
            this.i = e17Var;
            e17Var.u(this.b);
            this.p.add(this.i);
            g17 g17Var = new g17(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.W1());
            this.j = g17Var;
            g17Var.y(this.b);
            this.p.add(this.j);
            f17 f17Var = new f17(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.W1());
            this.k = f17Var;
            f17Var.u(this.b);
            this.p.add(this.k);
            d17 d17Var = new d17(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.W1());
            this.l = d17Var;
            d17Var.y(this.b);
            this.p.add(this.l);
            h17 h17Var = new h17(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.W1());
            this.m = h17Var;
            h17Var.y(this.b);
            this.p.add(this.m);
            y07 y07Var = new y07(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.W1());
            this.n = y07Var;
            y07Var.z(this.b);
            this.p.add(this.n);
            k17 k17Var = new k17(this.a.getPageContext(), t35.d, this.a.getUniqueId(), this.a.W1());
            this.o = k17Var;
            k17Var.x(this.b);
            this.p.add(this.o);
            this.b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            z07 z07Var = this.d;
            if (z07Var != null) {
                z07Var.setFromCDN(z);
            }
            a17 a17Var = this.f;
            if (a17Var != null) {
                a17Var.setFromCDN(z);
            }
            b17 b17Var = this.e;
            if (b17Var != null) {
                b17Var.setFromCDN(z);
            }
        }
    }
}
