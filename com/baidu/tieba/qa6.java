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
/* loaded from: classes5.dex */
public class qa6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public cb6 c;
    public ta6 d;
    public va6 e;
    public ua6 f;
    public wa6 g;
    public db6 h;
    public ya6 i;
    public ab6 j;
    public za6 k;
    public xa6 l;
    public bb6 m;
    public sa6 n;
    public eb6 o;
    public List p;

    public qa6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            cb6 cb6Var = new cb6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.c = cb6Var;
            cb6Var.w(this.b);
            this.p.add(this.c);
            ta6 ta6Var = new ta6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.d = ta6Var;
            ta6Var.x(this.b);
            this.p.add(this.d);
            va6 va6Var = new va6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.e = va6Var;
            va6Var.w(this.b);
            this.p.add(this.e);
            ua6 ua6Var = new ua6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.f = ua6Var;
            ua6Var.w(this.b);
            this.p.add(this.f);
            wa6 wa6Var = new wa6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.g = wa6Var;
            wa6Var.w(this.b);
            this.p.add(this.g);
            db6 db6Var = new db6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.s1());
            this.h = db6Var;
            db6Var.z(this.b);
            this.p.add(this.h);
            ya6 ya6Var = new ya6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.s1());
            this.i = ya6Var;
            ya6Var.u(this.b);
            this.p.add(this.i);
            ab6 ab6Var = new ab6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.s1());
            this.j = ab6Var;
            ab6Var.w(this.b);
            this.p.add(this.j);
            za6 za6Var = new za6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.s1());
            this.k = za6Var;
            za6Var.u(this.b);
            this.p.add(this.k);
            xa6 xa6Var = new xa6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.s1());
            this.l = xa6Var;
            xa6Var.w(this.b);
            this.p.add(this.l);
            bb6 bb6Var = new bb6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.m = bb6Var;
            bb6Var.w(this.b);
            this.p.add(this.m);
            sa6 sa6Var = new sa6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.s1());
            this.n = sa6Var;
            sa6Var.x(this.b);
            this.p.add(this.n);
            eb6 eb6Var = new eb6(this.a.getPageContext(), wt4.d, this.a.getUniqueId(), this.a.s1());
            this.o = eb6Var;
            eb6Var.v(this.b);
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

    public void c(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            ta6 ta6Var = this.d;
            if (ta6Var != null) {
                ta6Var.setFromCDN(z);
            }
            ua6 ua6Var = this.f;
            if (ua6Var != null) {
                ua6Var.setFromCDN(z);
            }
            va6 va6Var = this.e;
            if (va6Var != null) {
                va6Var.setFromCDN(z);
            }
        }
    }
}
