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
/* loaded from: classes7.dex */
public class qz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public c07 c;
    public tz6 d;
    public vz6 e;
    public uz6 f;
    public wz6 g;
    public d07 h;
    public yz6 i;
    public a07 j;
    public zz6 k;
    public xz6 l;
    public b07 m;
    public sz6 n;
    public e07 o;
    public List<kn> p;

    public qz6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            c07 c07Var = new c07(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.c = c07Var;
            c07Var.y(this.b);
            this.p.add(this.c);
            tz6 tz6Var = new tz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.d = tz6Var;
            tz6Var.z(this.b);
            this.p.add(this.d);
            vz6 vz6Var = new vz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.e = vz6Var;
            vz6Var.y(this.b);
            this.p.add(this.e);
            uz6 uz6Var = new uz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.f = uz6Var;
            uz6Var.y(this.b);
            this.p.add(this.f);
            wz6 wz6Var = new wz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.g = wz6Var;
            wz6Var.y(this.b);
            this.p.add(this.g);
            d07 d07Var = new d07(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.J1());
            this.h = d07Var;
            d07Var.B(this.b);
            this.p.add(this.h);
            yz6 yz6Var = new yz6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.J1());
            this.i = yz6Var;
            yz6Var.u(this.b);
            this.p.add(this.i);
            a07 a07Var = new a07(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.J1());
            this.j = a07Var;
            a07Var.y(this.b);
            this.p.add(this.j);
            zz6 zz6Var = new zz6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.J1());
            this.k = zz6Var;
            zz6Var.u(this.b);
            this.p.add(this.k);
            xz6 xz6Var = new xz6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.J1());
            this.l = xz6Var;
            xz6Var.y(this.b);
            this.p.add(this.l);
            b07 b07Var = new b07(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.m = b07Var;
            b07Var.y(this.b);
            this.p.add(this.m);
            sz6 sz6Var = new sz6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.J1());
            this.n = sz6Var;
            sz6Var.z(this.b);
            this.p.add(this.n);
            e07 e07Var = new e07(this.a.getPageContext(), i45.d, this.a.getUniqueId(), this.a.J1());
            this.o = e07Var;
            e07Var.x(this.b);
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

    public void c(ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            tz6 tz6Var = this.d;
            if (tz6Var != null) {
                tz6Var.setFromCDN(z);
            }
            uz6 uz6Var = this.f;
            if (uz6Var != null) {
                uz6Var.setFromCDN(z);
            }
            vz6 vz6Var = this.e;
            if (vz6Var != null) {
                vz6Var.setFromCDN(z);
            }
        }
    }
}
