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
public class lz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public xz6 c;
    public oz6 d;
    public qz6 e;
    public pz6 f;
    public rz6 g;
    public yz6 h;
    public tz6 i;
    public vz6 j;
    public uz6 k;
    public sz6 l;
    public wz6 m;
    public nz6 n;
    public zz6 o;
    public List<jn> p;

    public lz6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            xz6 xz6Var = new xz6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.c = xz6Var;
            xz6Var.y(this.b);
            this.p.add(this.c);
            oz6 oz6Var = new oz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.d = oz6Var;
            oz6Var.z(this.b);
            this.p.add(this.d);
            qz6 qz6Var = new qz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.e = qz6Var;
            qz6Var.y(this.b);
            this.p.add(this.e);
            pz6 pz6Var = new pz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.f = pz6Var;
            pz6Var.y(this.b);
            this.p.add(this.f);
            rz6 rz6Var = new rz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.g = rz6Var;
            rz6Var.y(this.b);
            this.p.add(this.g);
            yz6 yz6Var = new yz6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.J1());
            this.h = yz6Var;
            yz6Var.B(this.b);
            this.p.add(this.h);
            tz6 tz6Var = new tz6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.J1());
            this.i = tz6Var;
            tz6Var.u(this.b);
            this.p.add(this.i);
            vz6 vz6Var = new vz6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.J1());
            this.j = vz6Var;
            vz6Var.y(this.b);
            this.p.add(this.j);
            uz6 uz6Var = new uz6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.J1());
            this.k = uz6Var;
            uz6Var.u(this.b);
            this.p.add(this.k);
            sz6 sz6Var = new sz6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.J1());
            this.l = sz6Var;
            sz6Var.y(this.b);
            this.p.add(this.l);
            wz6 wz6Var = new wz6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.m = wz6Var;
            wz6Var.y(this.b);
            this.p.add(this.m);
            nz6 nz6Var = new nz6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.J1());
            this.n = nz6Var;
            nz6Var.z(this.b);
            this.p.add(this.n);
            zz6 zz6Var = new zz6(this.a.getPageContext(), f45.d, this.a.getUniqueId(), this.a.J1());
            this.o = zz6Var;
            zz6Var.x(this.b);
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

    public void c(ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            oz6 oz6Var = this.d;
            if (oz6Var != null) {
                oz6Var.setFromCDN(z);
            }
            pz6 pz6Var = this.f;
            if (pz6Var != null) {
                pz6Var.setFromCDN(z);
            }
            qz6 qz6Var = this.e;
            if (qz6Var != null) {
                qz6Var.setFromCDN(z);
            }
        }
    }
}
