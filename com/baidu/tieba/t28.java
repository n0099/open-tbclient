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
/* loaded from: classes7.dex */
public class t28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public p38 c;
    public i38 d;
    public d38 e;
    public f38 f;
    public e38 g;
    public g38 h;
    public q38 i;
    public h38 j;
    public k38 k;
    public m38 l;
    public l38 m;
    public o38 n;
    public b38 o;
    public z28 p;
    public y28 q;
    public a38 r;
    public j38 s;
    public n38 t;
    public c38 u;
    public r38 v;
    public List<kn> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

        public a(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof s38)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public t28(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        r38 r38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (r38Var = this.v) != null) {
            r38Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (kn knVar : this.w) {
                if (knVar instanceof v28) {
                    ((v28) knVar).h(str);
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
            p38 p38Var = new p38(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.U1(), this.a.T1());
            this.c = p38Var;
            p38Var.y(this.b);
            this.w.add(this.c);
            i38 i38Var = new i38(this.a.getPageContext());
            this.d = i38Var;
            i38Var.x(this.b);
            this.w.add(this.d);
            d38 d38Var = new d38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.e = d38Var;
            d38Var.z(this.b);
            this.w.add(this.e);
            f38 f38Var = new f38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.f = f38Var;
            f38Var.y(this.b);
            this.w.add(this.f);
            e38 e38Var = new e38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.g = e38Var;
            e38Var.y(this.b);
            this.w.add(this.g);
            g38 g38Var = new g38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.h = g38Var;
            g38Var.y(this.b);
            this.w.add(this.h);
            q38 q38Var = new q38(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.U1());
            this.i = q38Var;
            q38Var.B(this.b);
            this.w.add(this.i);
            h38 h38Var = new h38(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.U1());
            this.j = h38Var;
            h38Var.y(this.b);
            if ("fashion".equals(this.a.T1()) || "local".equals(this.a.T1())) {
                this.w.add(this.j);
            }
            k38 k38Var = new k38(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.U1());
            this.k = k38Var;
            k38Var.u(this.b);
            this.w.add(this.k);
            m38 m38Var = new m38(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.U1());
            this.l = m38Var;
            m38Var.x(this.b);
            this.w.add(this.l);
            l38 l38Var = new l38(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.U1());
            this.m = l38Var;
            l38Var.u(this.b);
            this.w.add(this.m);
            o38 o38Var = new o38(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.n = o38Var;
            o38Var.x(this.b);
            this.w.add(this.n);
            b38 b38Var = new b38(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.U1());
            this.o = b38Var;
            b38Var.z(this.b);
            this.w.add(this.o);
            a38 a38Var = new a38(this.a.getPageContext(), fp6.R0, this.a.U1());
            this.r = a38Var;
            this.w.add(a38Var);
            z28 z28Var = new z28(this.a.getPageContext(), g45.e);
            this.p = z28Var;
            z28Var.x(this.b);
            this.w.add(this.p);
            y28 y28Var = new y28(this.a.getPageContext(), k25.b);
            this.q = y28Var;
            y28Var.A(this.b);
            this.w.add(this.q);
            j38 j38Var = new j38(this.a.getPageContext());
            this.s = j38Var;
            j38Var.u(this.b);
            this.w.add(this.s);
            n38 n38Var = new n38(this.a.getPageContext());
            this.t = n38Var;
            n38Var.u(this.b);
            this.w.add(this.t);
            c38 c38Var = new c38(this.a.getPageContext(), b());
            this.u = c38Var;
            this.w.add(c38Var);
            r38 r38Var = new r38(this.a.getPageContext());
            this.v = r38Var;
            this.w.add(r38Var);
            this.b.addAdapters(this.w);
        }
    }
}
