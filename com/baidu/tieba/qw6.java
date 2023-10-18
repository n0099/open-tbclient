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
public class qw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public cx6 c;
    public tw6 d;
    public vw6 e;
    public uw6 f;
    public ww6 g;
    public dx6 h;
    public yw6 i;
    public ax6 j;
    public zw6 k;
    public xw6 l;
    public bx6 m;
    public sw6 n;
    public ex6 o;
    public List<lh> p;

    public qw6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            cx6 cx6Var = new cx6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.e2());
            this.c = cx6Var;
            cx6Var.y(this.b);
            this.p.add(this.c);
            tw6 tw6Var = new tw6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.e2());
            this.d = tw6Var;
            tw6Var.z(this.b);
            this.p.add(this.d);
            vw6 vw6Var = new vw6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.e2());
            this.e = vw6Var;
            vw6Var.y(this.b);
            this.p.add(this.e);
            uw6 uw6Var = new uw6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.e2());
            this.f = uw6Var;
            uw6Var.y(this.b);
            this.p.add(this.f);
            ww6 ww6Var = new ww6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.e2());
            this.g = ww6Var;
            ww6Var.y(this.b);
            this.p.add(this.g);
            dx6 dx6Var = new dx6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.e2());
            this.h = dx6Var;
            dx6Var.B(this.b);
            this.p.add(this.h);
            yw6 yw6Var = new yw6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.e2());
            this.i = yw6Var;
            yw6Var.u(this.b);
            this.p.add(this.i);
            ax6 ax6Var = new ax6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.e2());
            this.j = ax6Var;
            ax6Var.y(this.b);
            this.p.add(this.j);
            zw6 zw6Var = new zw6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.e2());
            this.k = zw6Var;
            zw6Var.u(this.b);
            this.p.add(this.k);
            xw6 xw6Var = new xw6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.e2());
            this.l = xw6Var;
            xw6Var.y(this.b);
            this.p.add(this.l);
            bx6 bx6Var = new bx6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.e2());
            this.m = bx6Var;
            bx6Var.y(this.b);
            this.p.add(this.m);
            sw6 sw6Var = new sw6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.e2());
            this.n = sw6Var;
            sw6Var.z(this.b);
            this.p.add(this.n);
            ex6 ex6Var = new ex6(this.a.getPageContext(), gy4.d, this.a.getUniqueId(), this.a.e2());
            this.o = ex6Var;
            ex6Var.x(this.b);
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

    public void c(ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            tw6 tw6Var = this.d;
            if (tw6Var != null) {
                tw6Var.setFromCDN(z);
            }
            uw6 uw6Var = this.f;
            if (uw6Var != null) {
                uw6Var.setFromCDN(z);
            }
            vw6 vw6Var = this.e;
            if (vw6Var != null) {
                vw6Var.setFromCDN(z);
            }
        }
    }
}
