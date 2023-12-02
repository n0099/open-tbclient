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
public class vy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public hz6 c;
    public yy6 d;
    public az6 e;
    public zy6 f;
    public bz6 g;
    public iz6 h;
    public dz6 i;
    public fz6 j;
    public ez6 k;
    public cz6 l;
    public gz6 m;
    public xy6 n;
    public jz6 o;
    public List<ci> p;

    public vy6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            hz6 hz6Var = new hz6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.I2());
            this.c = hz6Var;
            hz6Var.z(this.b);
            this.p.add(this.c);
            yy6 yy6Var = new yy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.I2());
            this.d = yy6Var;
            yy6Var.A(this.b);
            this.p.add(this.d);
            az6 az6Var = new az6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.I2());
            this.e = az6Var;
            az6Var.z(this.b);
            this.p.add(this.e);
            zy6 zy6Var = new zy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.I2());
            this.f = zy6Var;
            zy6Var.z(this.b);
            this.p.add(this.f);
            bz6 bz6Var = new bz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.I2());
            this.g = bz6Var;
            bz6Var.z(this.b);
            this.p.add(this.g);
            iz6 iz6Var = new iz6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.I2());
            this.h = iz6Var;
            iz6Var.C(this.b);
            this.p.add(this.h);
            dz6 dz6Var = new dz6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.I2());
            this.i = dz6Var;
            dz6Var.x(this.b);
            this.p.add(this.i);
            fz6 fz6Var = new fz6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.I2());
            this.j = fz6Var;
            fz6Var.z(this.b);
            this.p.add(this.j);
            ez6 ez6Var = new ez6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.I2());
            this.k = ez6Var;
            ez6Var.x(this.b);
            this.p.add(this.k);
            cz6 cz6Var = new cz6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.I2());
            this.l = cz6Var;
            cz6Var.z(this.b);
            this.p.add(this.l);
            gz6 gz6Var = new gz6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.I2());
            this.m = gz6Var;
            gz6Var.z(this.b);
            this.p.add(this.m);
            xy6 xy6Var = new xy6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.I2());
            this.n = xy6Var;
            xy6Var.A(this.b);
            this.p.add(this.n);
            jz6 jz6Var = new jz6(this.a.getPageContext(), dz4.d, this.a.getUniqueId(), this.a.I2());
            this.o = jz6Var;
            jz6Var.y(this.b);
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

    public void c(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            yy6 yy6Var = this.d;
            if (yy6Var != null) {
                yy6Var.setFromCDN(z);
            }
            zy6 zy6Var = this.f;
            if (zy6Var != null) {
                zy6Var.setFromCDN(z);
            }
            az6 az6Var = this.e;
            if (az6Var != null) {
                az6Var.setFromCDN(z);
            }
        }
    }
}
