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
/* loaded from: classes4.dex */
public class ja6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public va6 c;
    public ma6 d;
    public oa6 e;
    public na6 f;
    public pa6 g;
    public wa6 h;
    public ra6 i;
    public ta6 j;
    public sa6 k;
    public qa6 l;
    public ua6 m;
    public la6 n;
    public xa6 o;
    public List<qn> p;

    public ja6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            va6 va6Var = new va6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.c = va6Var;
            va6Var.w(this.b);
            this.p.add(this.c);
            ma6 ma6Var = new ma6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.d = ma6Var;
            ma6Var.x(this.b);
            this.p.add(this.d);
            oa6 oa6Var = new oa6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.e = oa6Var;
            oa6Var.w(this.b);
            this.p.add(this.e);
            na6 na6Var = new na6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.f = na6Var;
            na6Var.w(this.b);
            this.p.add(this.f);
            pa6 pa6Var = new pa6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.g = pa6Var;
            pa6Var.w(this.b);
            this.p.add(this.g);
            wa6 wa6Var = new wa6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.s1());
            this.h = wa6Var;
            wa6Var.z(this.b);
            this.p.add(this.h);
            ra6 ra6Var = new ra6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.s1());
            this.i = ra6Var;
            ra6Var.u(this.b);
            this.p.add(this.i);
            ta6 ta6Var = new ta6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.s1());
            this.j = ta6Var;
            ta6Var.w(this.b);
            this.p.add(this.j);
            sa6 sa6Var = new sa6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.s1());
            this.k = sa6Var;
            sa6Var.u(this.b);
            this.p.add(this.k);
            qa6 qa6Var = new qa6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.s1());
            this.l = qa6Var;
            qa6Var.w(this.b);
            this.p.add(this.l);
            ua6 ua6Var = new ua6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.m = ua6Var;
            ua6Var.w(this.b);
            this.p.add(this.m);
            la6 la6Var = new la6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.s1());
            this.n = la6Var;
            la6Var.x(this.b);
            this.p.add(this.n);
            xa6 xa6Var = new xa6(this.a.getPageContext(), ut4.d, this.a.getUniqueId(), this.a.s1());
            this.o = xa6Var;
            xa6Var.v(this.b);
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
            ma6 ma6Var = this.d;
            if (ma6Var != null) {
                ma6Var.setFromCDN(z);
            }
            na6 na6Var = this.f;
            if (na6Var != null) {
                na6Var.setFromCDN(z);
            }
            oa6 oa6Var = this.e;
            if (oa6Var != null) {
                oa6Var.setFromCDN(z);
            }
        }
    }
}
