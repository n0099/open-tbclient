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
public class qg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public ch6 c;
    public tg6 d;
    public vg6 e;
    public ug6 f;
    public wg6 g;
    public dh6 h;
    public yg6 i;
    public ah6 j;
    public zg6 k;
    public xg6 l;
    public bh6 m;
    public sg6 n;
    public eh6 o;
    public List<ln> p;

    public qg6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ch6 ch6Var = new ch6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.c = ch6Var;
            ch6Var.w(this.b);
            this.p.add(this.c);
            tg6 tg6Var = new tg6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.d = tg6Var;
            tg6Var.x(this.b);
            this.p.add(this.d);
            vg6 vg6Var = new vg6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.e = vg6Var;
            vg6Var.w(this.b);
            this.p.add(this.e);
            ug6 ug6Var = new ug6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.f = ug6Var;
            ug6Var.w(this.b);
            this.p.add(this.f);
            wg6 wg6Var = new wg6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.g = wg6Var;
            wg6Var.w(this.b);
            this.p.add(this.g);
            dh6 dh6Var = new dh6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E1());
            this.h = dh6Var;
            dh6Var.z(this.b);
            this.p.add(this.h);
            yg6 yg6Var = new yg6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E1());
            this.i = yg6Var;
            yg6Var.u(this.b);
            this.p.add(this.i);
            ah6 ah6Var = new ah6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E1());
            this.j = ah6Var;
            ah6Var.w(this.b);
            this.p.add(this.j);
            zg6 zg6Var = new zg6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E1());
            this.k = zg6Var;
            zg6Var.u(this.b);
            this.p.add(this.k);
            xg6 xg6Var = new xg6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E1());
            this.l = xg6Var;
            xg6Var.w(this.b);
            this.p.add(this.l);
            bh6 bh6Var = new bh6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.m = bh6Var;
            bh6Var.w(this.b);
            this.p.add(this.m);
            sg6 sg6Var = new sg6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E1());
            this.n = sg6Var;
            sg6Var.x(this.b);
            this.p.add(this.n);
            eh6 eh6Var = new eh6(this.a.getPageContext(), av4.d, this.a.getUniqueId(), this.a.E1());
            this.o = eh6Var;
            eh6Var.v(this.b);
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

    public void c(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            tg6 tg6Var = this.d;
            if (tg6Var != null) {
                tg6Var.setFromCDN(z);
            }
            ug6 ug6Var = this.f;
            if (ug6Var != null) {
                ug6Var.setFromCDN(z);
            }
            vg6 vg6Var = this.e;
            if (vg6Var != null) {
                vg6Var.setFromCDN(z);
            }
        }
    }
}
