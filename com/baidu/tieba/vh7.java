package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class vh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public ri7 c;
    public ki7 d;
    public fi7 e;
    public hi7 f;
    public gi7 g;
    public ii7 h;
    public si7 i;
    public ji7 j;
    public mi7 k;
    public oi7 l;
    public ni7 m;
    public qi7 n;
    public di7 o;
    public bi7 p;
    public ai7 q;
    public ci7 r;
    public li7 s;
    public pi7 t;
    public ei7 u;
    public ti7 v;
    public List<qn> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh7 a;

        public a(vh7 vh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.E(0) instanceof ui7)) {
                    this.a.b.G(0);
                }
            }
        }
    }

    public vh7(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new LinkedList();
        this.a = homePageTabFeedFragment;
        this.b = bdTypeRecyclerView;
        c();
    }

    public void e(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        ti7 ti7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (ti7Var = this.v) != null) {
            ti7Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (qn qnVar : this.w) {
                if (qnVar instanceof xh7) {
                    ((xh7) qnVar).h(str);
                }
            }
        }
    }

    public final View.OnClickListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ri7 ri7Var = new ri7(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.P1(), this.a.O1());
            this.c = ri7Var;
            ri7Var.w(this.b);
            this.w.add(this.c);
            ki7 ki7Var = new ki7(this.a.getPageContext());
            this.d = ki7Var;
            ki7Var.v(this.b);
            this.w.add(this.d);
            fi7 fi7Var = new fi7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.P1());
            this.e = fi7Var;
            fi7Var.x(this.b);
            this.w.add(this.e);
            hi7 hi7Var = new hi7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.P1());
            this.f = hi7Var;
            hi7Var.w(this.b);
            this.w.add(this.f);
            gi7 gi7Var = new gi7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.P1());
            this.g = gi7Var;
            gi7Var.w(this.b);
            this.w.add(this.g);
            ii7 ii7Var = new ii7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.P1());
            this.h = ii7Var;
            ii7Var.w(this.b);
            this.w.add(this.h);
            si7 si7Var = new si7(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.P1());
            this.i = si7Var;
            si7Var.z(this.b);
            this.w.add(this.i);
            ji7 ji7Var = new ji7(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.P1());
            this.j = ji7Var;
            ji7Var.w(this.b);
            if ("fashion".equals(this.a.O1()) || "local".equals(this.a.O1())) {
                this.w.add(this.j);
            }
            mi7 mi7Var = new mi7(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.P1());
            this.k = mi7Var;
            mi7Var.u(this.b);
            this.w.add(this.k);
            oi7 oi7Var = new oi7(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.P1());
            this.l = oi7Var;
            oi7Var.v(this.b);
            this.w.add(this.l);
            ni7 ni7Var = new ni7(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.P1());
            this.m = ni7Var;
            ni7Var.u(this.b);
            this.w.add(this.m);
            qi7 qi7Var = new qi7(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.P1());
            this.n = qi7Var;
            qi7Var.v(this.b);
            this.w.add(this.n);
            di7 di7Var = new di7(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.P1());
            this.o = di7Var;
            di7Var.x(this.b);
            this.w.add(this.o);
            ci7 ci7Var = new ci7(this.a.getPageContext(), lg6.P0, this.a.P1());
            this.r = ci7Var;
            this.w.add(ci7Var);
            bi7 bi7Var = new bi7(this.a.getPageContext(), s05.e);
            this.p = bi7Var;
            bi7Var.v(this.b);
            this.w.add(this.p);
            ai7 ai7Var = new ai7(this.a.getPageContext(), xy4.b);
            this.q = ai7Var;
            ai7Var.y(this.b);
            this.w.add(this.q);
            li7 li7Var = new li7(this.a.getPageContext());
            this.s = li7Var;
            li7Var.u(this.b);
            this.w.add(this.s);
            pi7 pi7Var = new pi7(this.a.getPageContext());
            this.t = pi7Var;
            pi7Var.u(this.b);
            this.w.add(this.t);
            ei7 ei7Var = new ei7(this.a.getPageContext(), b());
            this.u = ei7Var;
            this.w.add(ei7Var);
            ti7 ti7Var = new ti7(this.a.getPageContext());
            this.v = ti7Var;
            this.w.add(ti7Var);
            this.b.a(this.w);
        }
    }
}
