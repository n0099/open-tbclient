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
/* loaded from: classes5.dex */
public class s17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public o27 c;
    public h27 d;
    public c27 e;
    public e27 f;
    public d27 g;
    public f27 h;
    public p27 i;
    public g27 j;
    public j27 k;
    public l27 l;
    public k27 m;
    public n27 n;
    public a27 o;
    public y17 p;
    public x17 q;
    public z17 r;
    public i27 s;
    public m27 t;
    public b27 u;
    public q27 v;
    public List<cn> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s17 a;

        public a(s17 s17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s17Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof r27)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public s17(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final View.OnClickListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (View.OnClickListener) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            o27 o27Var = new o27(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.F1(), this.a.E1());
            this.c = o27Var;
            o27Var.w(this.b);
            this.w.add(this.c);
            h27 h27Var = new h27(this.a.getPageContext());
            this.d = h27Var;
            h27Var.v(this.b);
            this.w.add(this.d);
            c27 c27Var = new c27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.e = c27Var;
            c27Var.x(this.b);
            this.w.add(this.e);
            e27 e27Var = new e27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.f = e27Var;
            e27Var.w(this.b);
            this.w.add(this.f);
            d27 d27Var = new d27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.g = d27Var;
            d27Var.w(this.b);
            this.w.add(this.g);
            f27 f27Var = new f27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.h = f27Var;
            f27Var.w(this.b);
            this.w.add(this.h);
            p27 p27Var = new p27(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.F1());
            this.i = p27Var;
            p27Var.z(this.b);
            this.w.add(this.i);
            g27 g27Var = new g27(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.F1());
            this.j = g27Var;
            g27Var.w(this.b);
            if ("fashion".equals(this.a.E1()) || "local".equals(this.a.E1())) {
                this.w.add(this.j);
            }
            j27 j27Var = new j27(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.F1());
            this.k = j27Var;
            j27Var.u(this.b);
            this.w.add(this.k);
            l27 l27Var = new l27(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.F1());
            this.l = l27Var;
            l27Var.v(this.b);
            this.w.add(this.l);
            k27 k27Var = new k27(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.F1());
            this.m = k27Var;
            k27Var.u(this.b);
            this.w.add(this.m);
            n27 n27Var = new n27(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.n = n27Var;
            n27Var.v(this.b);
            this.w.add(this.n);
            a27 a27Var = new a27(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.F1());
            this.o = a27Var;
            a27Var.x(this.b);
            this.w.add(this.o);
            z17 z17Var = new z17(this.a.getPageContext(), s06.N0, this.a.F1());
            this.r = z17Var;
            this.w.add(z17Var);
            y17 y17Var = new y17(this.a.getPageContext(), ar4.e);
            this.p = y17Var;
            y17Var.v(this.b);
            this.w.add(this.p);
            x17 x17Var = new x17(this.a.getPageContext(), ep4.b);
            this.q = x17Var;
            x17Var.y(this.b);
            this.w.add(this.q);
            i27 i27Var = new i27(this.a.getPageContext());
            this.s = i27Var;
            i27Var.u(this.b);
            this.w.add(this.s);
            m27 m27Var = new m27(this.a.getPageContext());
            this.t = m27Var;
            m27Var.u(this.b);
            this.w.add(this.t);
            b27 b27Var = new b27(this.a.getPageContext(), b());
            this.u = b27Var;
            this.w.add(b27Var);
            q27 q27Var = new q27(this.a.getPageContext());
            this.v = q27Var;
            this.w.add(q27Var);
            this.b.a(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<pn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        q27 q27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (q27Var = this.v) == null) {
            return;
        }
        q27Var.u(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (cn cnVar : this.w) {
                if (cnVar instanceof u17) {
                    ((u17) cnVar).h(str);
                }
            }
        }
    }
}
