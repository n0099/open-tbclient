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
public class wn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public io6 c;
    public zn6 d;
    public bo6 e;
    public ao6 f;
    public co6 g;
    public jo6 h;
    public eo6 i;
    public go6 j;
    public fo6 k;
    public do6 l;
    public ho6 m;
    public yn6 n;
    public ko6 o;
    public List<tm> p;

    public wn6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            io6 io6Var = new io6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.c = io6Var;
            io6Var.y(this.b);
            this.p.add(this.c);
            zn6 zn6Var = new zn6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.G1());
            this.d = zn6Var;
            zn6Var.z(this.b);
            this.p.add(this.d);
            bo6 bo6Var = new bo6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.e = bo6Var;
            bo6Var.y(this.b);
            this.p.add(this.e);
            ao6 ao6Var = new ao6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.G1());
            this.f = ao6Var;
            ao6Var.y(this.b);
            this.p.add(this.f);
            co6 co6Var = new co6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.g = co6Var;
            co6Var.y(this.b);
            this.p.add(this.g);
            jo6 jo6Var = new jo6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.G1());
            this.h = jo6Var;
            jo6Var.B(this.b);
            this.p.add(this.h);
            eo6 eo6Var = new eo6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.G1());
            this.i = eo6Var;
            eo6Var.u(this.b);
            this.p.add(this.i);
            go6 go6Var = new go6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.G1());
            this.j = go6Var;
            go6Var.y(this.b);
            this.p.add(this.j);
            fo6 fo6Var = new fo6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.G1());
            this.k = fo6Var;
            fo6Var.u(this.b);
            this.p.add(this.k);
            do6 do6Var = new do6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.G1());
            this.l = do6Var;
            do6Var.y(this.b);
            this.p.add(this.l);
            ho6 ho6Var = new ho6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.m = ho6Var;
            ho6Var.y(this.b);
            this.p.add(this.m);
            yn6 yn6Var = new yn6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.G1());
            this.n = yn6Var;
            yn6Var.z(this.b);
            this.p.add(this.n);
            ko6 ko6Var = new ko6(this.a.getPageContext(), dz4.d, this.a.getUniqueId(), this.a.G1());
            this.o = ko6Var;
            ko6Var.x(this.b);
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

    public void c(ArrayList<gn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            zn6 zn6Var = this.d;
            if (zn6Var != null) {
                zn6Var.setFromCDN(z);
            }
            ao6 ao6Var = this.f;
            if (ao6Var != null) {
                ao6Var.setFromCDN(z);
            }
            bo6 bo6Var = this.e;
            if (bo6Var != null) {
                bo6Var.setFromCDN(z);
            }
        }
    }
}
