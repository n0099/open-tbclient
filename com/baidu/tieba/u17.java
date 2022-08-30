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
public class u17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public q27 c;
    public j27 d;
    public e27 e;
    public g27 f;
    public f27 g;
    public h27 h;
    public r27 i;
    public i27 j;
    public l27 k;
    public n27 l;
    public m27 m;
    public p27 n;
    public c27 o;
    public a27 p;
    public z17 q;
    public b27 r;
    public k27 s;
    public o27 t;
    public d27 u;
    public s27 v;
    public List<cn> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u17 a;

        public a(u17 u17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u17Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof t27)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public u17(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            q27 q27Var = new q27(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.F1(), this.a.E1());
            this.c = q27Var;
            q27Var.w(this.b);
            this.w.add(this.c);
            j27 j27Var = new j27(this.a.getPageContext());
            this.d = j27Var;
            j27Var.v(this.b);
            this.w.add(this.d);
            e27 e27Var = new e27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.e = e27Var;
            e27Var.x(this.b);
            this.w.add(this.e);
            g27 g27Var = new g27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.f = g27Var;
            g27Var.w(this.b);
            this.w.add(this.f);
            f27 f27Var = new f27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.g = f27Var;
            f27Var.w(this.b);
            this.w.add(this.g);
            h27 h27Var = new h27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.h = h27Var;
            h27Var.w(this.b);
            this.w.add(this.h);
            r27 r27Var = new r27(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.F1());
            this.i = r27Var;
            r27Var.z(this.b);
            this.w.add(this.i);
            i27 i27Var = new i27(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.F1());
            this.j = i27Var;
            i27Var.w(this.b);
            if ("fashion".equals(this.a.E1()) || "local".equals(this.a.E1())) {
                this.w.add(this.j);
            }
            l27 l27Var = new l27(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.F1());
            this.k = l27Var;
            l27Var.u(this.b);
            this.w.add(this.k);
            n27 n27Var = new n27(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.F1());
            this.l = n27Var;
            n27Var.v(this.b);
            this.w.add(this.l);
            m27 m27Var = new m27(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.F1());
            this.m = m27Var;
            m27Var.u(this.b);
            this.w.add(this.m);
            p27 p27Var = new p27(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.n = p27Var;
            p27Var.v(this.b);
            this.w.add(this.n);
            c27 c27Var = new c27(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.F1());
            this.o = c27Var;
            c27Var.x(this.b);
            this.w.add(this.o);
            b27 b27Var = new b27(this.a.getPageContext(), u06.N0, this.a.F1());
            this.r = b27Var;
            this.w.add(b27Var);
            a27 a27Var = new a27(this.a.getPageContext(), br4.e);
            this.p = a27Var;
            a27Var.v(this.b);
            this.w.add(this.p);
            z17 z17Var = new z17(this.a.getPageContext(), fp4.b);
            this.q = z17Var;
            z17Var.y(this.b);
            this.w.add(this.q);
            k27 k27Var = new k27(this.a.getPageContext());
            this.s = k27Var;
            k27Var.u(this.b);
            this.w.add(this.s);
            o27 o27Var = new o27(this.a.getPageContext());
            this.t = o27Var;
            o27Var.u(this.b);
            this.w.add(this.t);
            d27 d27Var = new d27(this.a.getPageContext(), b());
            this.u = d27Var;
            this.w.add(d27Var);
            s27 s27Var = new s27(this.a.getPageContext());
            this.v = s27Var;
            this.w.add(s27Var);
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
        s27 s27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (s27Var = this.v) == null) {
            return;
        }
        s27Var.u(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (cn cnVar : this.w) {
                if (cnVar instanceof w17) {
                    ((w17) cnVar).h(str);
                }
            }
        }
    }
}
