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
public class iz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public uz6 c;
    public lz6 d;
    public nz6 e;
    public mz6 f;
    public oz6 g;
    public vz6 h;
    public qz6 i;
    public sz6 j;
    public rz6 k;
    public pz6 l;
    public tz6 m;
    public kz6 n;
    public wz6 o;
    public List<lm> p;

    public iz6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            uz6 uz6Var = new uz6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.K1());
            this.c = uz6Var;
            uz6Var.y(this.b);
            this.p.add(this.c);
            lz6 lz6Var = new lz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.K1());
            this.d = lz6Var;
            lz6Var.z(this.b);
            this.p.add(this.d);
            nz6 nz6Var = new nz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.K1());
            this.e = nz6Var;
            nz6Var.y(this.b);
            this.p.add(this.e);
            mz6 mz6Var = new mz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.K1());
            this.f = mz6Var;
            mz6Var.y(this.b);
            this.p.add(this.f);
            oz6 oz6Var = new oz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.K1());
            this.g = oz6Var;
            oz6Var.y(this.b);
            this.p.add(this.g);
            vz6 vz6Var = new vz6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.K1());
            this.h = vz6Var;
            vz6Var.B(this.b);
            this.p.add(this.h);
            qz6 qz6Var = new qz6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.K1());
            this.i = qz6Var;
            qz6Var.u(this.b);
            this.p.add(this.i);
            sz6 sz6Var = new sz6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.K1());
            this.j = sz6Var;
            sz6Var.y(this.b);
            this.p.add(this.j);
            rz6 rz6Var = new rz6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.K1());
            this.k = rz6Var;
            rz6Var.u(this.b);
            this.p.add(this.k);
            pz6 pz6Var = new pz6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.K1());
            this.l = pz6Var;
            pz6Var.y(this.b);
            this.p.add(this.l);
            tz6 tz6Var = new tz6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.K1());
            this.m = tz6Var;
            tz6Var.y(this.b);
            this.p.add(this.m);
            kz6 kz6Var = new kz6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.K1());
            this.n = kz6Var;
            kz6Var.z(this.b);
            this.p.add(this.n);
            wz6 wz6Var = new wz6(this.a.getPageContext(), n35.d, this.a.getUniqueId(), this.a.K1());
            this.o = wz6Var;
            wz6Var.x(this.b);
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

    public void c(ArrayList<ym> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            lz6 lz6Var = this.d;
            if (lz6Var != null) {
                lz6Var.setFromCDN(z);
            }
            mz6 mz6Var = this.f;
            if (mz6Var != null) {
                mz6Var.setFromCDN(z);
            }
            nz6 nz6Var = this.e;
            if (nz6Var != null) {
                nz6Var.setFromCDN(z);
            }
        }
    }
}
