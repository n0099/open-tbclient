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
public class zq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public lr6 c;
    public cr6 d;
    public er6 e;
    public dr6 f;
    public fr6 g;
    public mr6 h;
    public hr6 i;
    public jr6 j;
    public ir6 k;
    public gr6 l;
    public kr6 m;
    public br6 n;
    public nr6 o;
    public List<um> p;

    public zq6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            lr6 lr6Var = new lr6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.c = lr6Var;
            lr6Var.y(this.b);
            this.p.add(this.c);
            cr6 cr6Var = new cr6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.G1());
            this.d = cr6Var;
            cr6Var.z(this.b);
            this.p.add(this.d);
            er6 er6Var = new er6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.e = er6Var;
            er6Var.y(this.b);
            this.p.add(this.e);
            dr6 dr6Var = new dr6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.G1());
            this.f = dr6Var;
            dr6Var.y(this.b);
            this.p.add(this.f);
            fr6 fr6Var = new fr6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.g = fr6Var;
            fr6Var.y(this.b);
            this.p.add(this.g);
            mr6 mr6Var = new mr6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.G1());
            this.h = mr6Var;
            mr6Var.B(this.b);
            this.p.add(this.h);
            hr6 hr6Var = new hr6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.G1());
            this.i = hr6Var;
            hr6Var.u(this.b);
            this.p.add(this.i);
            jr6 jr6Var = new jr6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.G1());
            this.j = jr6Var;
            jr6Var.y(this.b);
            this.p.add(this.j);
            ir6 ir6Var = new ir6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.G1());
            this.k = ir6Var;
            ir6Var.u(this.b);
            this.p.add(this.k);
            gr6 gr6Var = new gr6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.G1());
            this.l = gr6Var;
            gr6Var.y(this.b);
            this.p.add(this.l);
            kr6 kr6Var = new kr6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.m = kr6Var;
            kr6Var.y(this.b);
            this.p.add(this.m);
            br6 br6Var = new br6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.G1());
            this.n = br6Var;
            br6Var.z(this.b);
            this.p.add(this.n);
            nr6 nr6Var = new nr6(this.a.getPageContext(), fz4.d, this.a.getUniqueId(), this.a.G1());
            this.o = nr6Var;
            nr6Var.x(this.b);
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

    public void c(ArrayList<hn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            cr6 cr6Var = this.d;
            if (cr6Var != null) {
                cr6Var.setFromCDN(z);
            }
            dr6 dr6Var = this.f;
            if (dr6Var != null) {
                dr6Var.setFromCDN(z);
            }
            er6 er6Var = this.e;
            if (er6Var != null) {
                er6Var.setFromCDN(z);
            }
        }
    }
}
