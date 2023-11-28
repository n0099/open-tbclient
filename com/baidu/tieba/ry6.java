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
public class ry6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public dz6 c;
    public uy6 d;
    public wy6 e;
    public vy6 f;
    public xy6 g;
    public ez6 h;
    public zy6 i;
    public bz6 j;
    public az6 k;
    public yy6 l;
    public cz6 m;
    public ty6 n;
    public fz6 o;
    public List<ci> p;

    public ry6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            dz6 dz6Var = new dz6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.I2());
            this.c = dz6Var;
            dz6Var.z(this.b);
            this.p.add(this.c);
            uy6 uy6Var = new uy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.I2());
            this.d = uy6Var;
            uy6Var.A(this.b);
            this.p.add(this.d);
            wy6 wy6Var = new wy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.I2());
            this.e = wy6Var;
            wy6Var.z(this.b);
            this.p.add(this.e);
            vy6 vy6Var = new vy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.I2());
            this.f = vy6Var;
            vy6Var.z(this.b);
            this.p.add(this.f);
            xy6 xy6Var = new xy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.I2());
            this.g = xy6Var;
            xy6Var.z(this.b);
            this.p.add(this.g);
            ez6 ez6Var = new ez6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.I2());
            this.h = ez6Var;
            ez6Var.C(this.b);
            this.p.add(this.h);
            zy6 zy6Var = new zy6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.I2());
            this.i = zy6Var;
            zy6Var.x(this.b);
            this.p.add(this.i);
            bz6 bz6Var = new bz6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.I2());
            this.j = bz6Var;
            bz6Var.z(this.b);
            this.p.add(this.j);
            az6 az6Var = new az6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.I2());
            this.k = az6Var;
            az6Var.x(this.b);
            this.p.add(this.k);
            yy6 yy6Var = new yy6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.I2());
            this.l = yy6Var;
            yy6Var.z(this.b);
            this.p.add(this.l);
            cz6 cz6Var = new cz6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.I2());
            this.m = cz6Var;
            cz6Var.z(this.b);
            this.p.add(this.m);
            ty6 ty6Var = new ty6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.I2());
            this.n = ty6Var;
            ty6Var.A(this.b);
            this.p.add(this.n);
            fz6 fz6Var = new fz6(this.a.getPageContext(), az4.d, this.a.getUniqueId(), this.a.I2());
            this.o = fz6Var;
            fz6Var.y(this.b);
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
            uy6 uy6Var = this.d;
            if (uy6Var != null) {
                uy6Var.setFromCDN(z);
            }
            vy6 vy6Var = this.f;
            if (vy6Var != null) {
                vy6Var.setFromCDN(z);
            }
            wy6 wy6Var = this.e;
            if (wy6Var != null) {
                wy6Var.setFromCDN(z);
            }
        }
    }
}
