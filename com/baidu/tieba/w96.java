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
/* loaded from: classes6.dex */
public class w96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public ia6 c;
    public z96 d;
    public ba6 e;
    public aa6 f;
    public ca6 g;
    public ja6 h;
    public ea6 i;
    public ga6 j;
    public fa6 k;
    public da6 l;
    public ha6 m;
    public y96 n;
    public ka6 o;
    public List<qn> p;

    public w96(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ia6 ia6Var = new ia6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.c = ia6Var;
            ia6Var.w(this.b);
            this.p.add(this.c);
            z96 z96Var = new z96(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.d = z96Var;
            z96Var.x(this.b);
            this.p.add(this.d);
            ba6 ba6Var = new ba6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.e = ba6Var;
            ba6Var.w(this.b);
            this.p.add(this.e);
            aa6 aa6Var = new aa6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.f = aa6Var;
            aa6Var.w(this.b);
            this.p.add(this.f);
            ca6 ca6Var = new ca6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.g = ca6Var;
            ca6Var.w(this.b);
            this.p.add(this.g);
            ja6 ja6Var = new ja6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.s1());
            this.h = ja6Var;
            ja6Var.z(this.b);
            this.p.add(this.h);
            ea6 ea6Var = new ea6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.s1());
            this.i = ea6Var;
            ea6Var.u(this.b);
            this.p.add(this.i);
            ga6 ga6Var = new ga6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.s1());
            this.j = ga6Var;
            ga6Var.w(this.b);
            this.p.add(this.j);
            fa6 fa6Var = new fa6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.s1());
            this.k = fa6Var;
            fa6Var.u(this.b);
            this.p.add(this.k);
            da6 da6Var = new da6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.s1());
            this.l = da6Var;
            da6Var.w(this.b);
            this.p.add(this.l);
            ha6 ha6Var = new ha6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.m = ha6Var;
            ha6Var.w(this.b);
            this.p.add(this.m);
            y96 y96Var = new y96(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.s1());
            this.n = y96Var;
            y96Var.x(this.b);
            this.p.add(this.n);
            ka6 ka6Var = new ka6(this.a.getPageContext(), ht4.d, this.a.getUniqueId(), this.a.s1());
            this.o = ka6Var;
            ka6Var.v(this.b);
            this.p.add(this.o);
            this.b.a(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            z96 z96Var = this.d;
            if (z96Var != null) {
                z96Var.setFromCDN(z);
            }
            aa6 aa6Var = this.f;
            if (aa6Var != null) {
                aa6Var.setFromCDN(z);
            }
            ba6 ba6Var = this.e;
            if (ba6Var != null) {
                ba6Var.setFromCDN(z);
            }
        }
    }
}
