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
public class qs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public ct6 c;
    public ts6 d;
    public vs6 e;
    public us6 f;
    public ws6 g;
    public dt6 h;
    public ys6 i;
    public at6 j;
    public zs6 k;
    public xs6 l;
    public bt6 m;
    public ss6 n;
    public et6 o;
    public List<vm> p;

    public qs6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ct6 ct6Var = new ct6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.H1());
            this.c = ct6Var;
            ct6Var.y(this.b);
            this.p.add(this.c);
            ts6 ts6Var = new ts6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.H1());
            this.d = ts6Var;
            ts6Var.z(this.b);
            this.p.add(this.d);
            vs6 vs6Var = new vs6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.H1());
            this.e = vs6Var;
            vs6Var.y(this.b);
            this.p.add(this.e);
            us6 us6Var = new us6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.H1());
            this.f = us6Var;
            us6Var.y(this.b);
            this.p.add(this.f);
            ws6 ws6Var = new ws6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.H1());
            this.g = ws6Var;
            ws6Var.y(this.b);
            this.p.add(this.g);
            dt6 dt6Var = new dt6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.H1());
            this.h = dt6Var;
            dt6Var.B(this.b);
            this.p.add(this.h);
            ys6 ys6Var = new ys6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.H1());
            this.i = ys6Var;
            ys6Var.u(this.b);
            this.p.add(this.i);
            at6 at6Var = new at6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.H1());
            this.j = at6Var;
            at6Var.y(this.b);
            this.p.add(this.j);
            zs6 zs6Var = new zs6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.H1());
            this.k = zs6Var;
            zs6Var.u(this.b);
            this.p.add(this.k);
            xs6 xs6Var = new xs6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.H1());
            this.l = xs6Var;
            xs6Var.y(this.b);
            this.p.add(this.l);
            bt6 bt6Var = new bt6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.H1());
            this.m = bt6Var;
            bt6Var.y(this.b);
            this.p.add(this.m);
            ss6 ss6Var = new ss6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.H1());
            this.n = ss6Var;
            ss6Var.z(this.b);
            this.p.add(this.n);
            et6 et6Var = new et6(this.a.getPageContext(), wz4.d, this.a.getUniqueId(), this.a.H1());
            this.o = et6Var;
            et6Var.x(this.b);
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

    public void c(ArrayList<in> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            ts6 ts6Var = this.d;
            if (ts6Var != null) {
                ts6Var.setFromCDN(z);
            }
            us6 us6Var = this.f;
            if (us6Var != null) {
                us6Var.setFromCDN(z);
            }
            vs6 vs6Var = this.e;
            if (vs6Var != null) {
                vs6Var.setFromCDN(z);
            }
        }
    }
}
