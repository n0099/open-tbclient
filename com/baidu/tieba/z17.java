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
public class z17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public l27 c;
    public c27 d;
    public e27 e;
    public d27 f;
    public f27 g;
    public m27 h;
    public h27 i;
    public j27 j;
    public i27 k;
    public g27 l;
    public k27 m;
    public b27 n;
    public n27 o;
    public List<ln> p;

    public z17(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            l27 l27Var = new l27(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.c = l27Var;
            l27Var.y(this.b);
            this.p.add(this.c);
            c27 c27Var = new c27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.d = c27Var;
            c27Var.z(this.b);
            this.p.add(this.d);
            e27 e27Var = new e27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.e = e27Var;
            e27Var.y(this.b);
            this.p.add(this.e);
            d27 d27Var = new d27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.f = d27Var;
            d27Var.y(this.b);
            this.p.add(this.f);
            f27 f27Var = new f27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.g = f27Var;
            f27Var.y(this.b);
            this.p.add(this.g);
            m27 m27Var = new m27(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.J1());
            this.h = m27Var;
            m27Var.B(this.b);
            this.p.add(this.h);
            h27 h27Var = new h27(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.J1());
            this.i = h27Var;
            h27Var.u(this.b);
            this.p.add(this.i);
            j27 j27Var = new j27(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.J1());
            this.j = j27Var;
            j27Var.y(this.b);
            this.p.add(this.j);
            i27 i27Var = new i27(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.J1());
            this.k = i27Var;
            i27Var.u(this.b);
            this.p.add(this.k);
            g27 g27Var = new g27(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.J1());
            this.l = g27Var;
            g27Var.y(this.b);
            this.p.add(this.l);
            k27 k27Var = new k27(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.m = k27Var;
            k27Var.y(this.b);
            this.p.add(this.m);
            b27 b27Var = new b27(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.J1());
            this.n = b27Var;
            b27Var.z(this.b);
            this.p.add(this.n);
            n27 n27Var = new n27(this.a.getPageContext(), q45.d, this.a.getUniqueId(), this.a.J1());
            this.o = n27Var;
            n27Var.x(this.b);
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

    public void c(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c27 c27Var = this.d;
            if (c27Var != null) {
                c27Var.setFromCDN(z);
            }
            d27 d27Var = this.f;
            if (d27Var != null) {
                d27Var.setFromCDN(z);
            }
            e27 e27Var = this.e;
            if (e27Var != null) {
                e27Var.setFromCDN(z);
            }
        }
    }
}
