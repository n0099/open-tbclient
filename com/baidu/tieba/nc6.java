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
public class nc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public zc6 c;
    public qc6 d;
    public sc6 e;
    public rc6 f;
    public tc6 g;
    public ad6 h;
    public vc6 i;
    public xc6 j;
    public wc6 k;
    public uc6 l;
    public yc6 m;
    public pc6 n;
    public bd6 o;
    public List<kn> p;

    public nc6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            zc6 zc6Var = new zc6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.c = zc6Var;
            zc6Var.w(this.b);
            this.p.add(this.c);
            qc6 qc6Var = new qc6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.d = qc6Var;
            qc6Var.x(this.b);
            this.p.add(this.d);
            sc6 sc6Var = new sc6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.e = sc6Var;
            sc6Var.w(this.b);
            this.p.add(this.e);
            rc6 rc6Var = new rc6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.f = rc6Var;
            rc6Var.w(this.b);
            this.p.add(this.f);
            tc6 tc6Var = new tc6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.g = tc6Var;
            tc6Var.w(this.b);
            this.p.add(this.g);
            ad6 ad6Var = new ad6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.s1());
            this.h = ad6Var;
            ad6Var.z(this.b);
            this.p.add(this.h);
            vc6 vc6Var = new vc6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.s1());
            this.i = vc6Var;
            vc6Var.u(this.b);
            this.p.add(this.i);
            xc6 xc6Var = new xc6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.s1());
            this.j = xc6Var;
            xc6Var.w(this.b);
            this.p.add(this.j);
            wc6 wc6Var = new wc6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.s1());
            this.k = wc6Var;
            wc6Var.u(this.b);
            this.p.add(this.k);
            uc6 uc6Var = new uc6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.s1());
            this.l = uc6Var;
            uc6Var.w(this.b);
            this.p.add(this.l);
            yc6 yc6Var = new yc6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.m = yc6Var;
            yc6Var.w(this.b);
            this.p.add(this.m);
            pc6 pc6Var = new pc6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.s1());
            this.n = pc6Var;
            pc6Var.x(this.b);
            this.p.add(this.n);
            bd6 bd6Var = new bd6(this.a.getPageContext(), ou4.d, this.a.getUniqueId(), this.a.s1());
            this.o = bd6Var;
            bd6Var.v(this.b);
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

    public void c(ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            qc6 qc6Var = this.d;
            if (qc6Var != null) {
                qc6Var.setFromCDN(z);
            }
            rc6 rc6Var = this.f;
            if (rc6Var != null) {
                rc6Var.setFromCDN(z);
            }
            sc6 sc6Var = this.e;
            if (sc6Var != null) {
                sc6Var.setFromCDN(z);
            }
        }
    }
}
