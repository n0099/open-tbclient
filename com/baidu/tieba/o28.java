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
public class o28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public k38 c;
    public d38 d;
    public y28 e;
    public a38 f;
    public z28 g;
    public b38 h;
    public l38 i;
    public c38 j;
    public f38 k;
    public h38 l;
    public g38 m;
    public j38 n;
    public w28 o;
    public u28 p;
    public t28 q;
    public v28 r;
    public e38 s;
    public i38 t;
    public x28 u;
    public m38 v;
    public List<jn> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o28 a;

        public a(o28 o28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof n38)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public o28(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        m38 m38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (m38Var = this.v) != null) {
            m38Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (jn jnVar : this.w) {
                if (jnVar instanceof q28) {
                    ((q28) jnVar).h(str);
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
            k38 k38Var = new k38(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.U1(), this.a.T1());
            this.c = k38Var;
            k38Var.y(this.b);
            this.w.add(this.c);
            d38 d38Var = new d38(this.a.getPageContext());
            this.d = d38Var;
            d38Var.x(this.b);
            this.w.add(this.d);
            y28 y28Var = new y28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.e = y28Var;
            y28Var.z(this.b);
            this.w.add(this.e);
            a38 a38Var = new a38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.f = a38Var;
            a38Var.y(this.b);
            this.w.add(this.f);
            z28 z28Var = new z28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.g = z28Var;
            z28Var.y(this.b);
            this.w.add(this.g);
            b38 b38Var = new b38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.h = b38Var;
            b38Var.y(this.b);
            this.w.add(this.h);
            l38 l38Var = new l38(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.U1());
            this.i = l38Var;
            l38Var.B(this.b);
            this.w.add(this.i);
            c38 c38Var = new c38(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.U1());
            this.j = c38Var;
            c38Var.y(this.b);
            if ("fashion".equals(this.a.T1()) || "local".equals(this.a.T1())) {
                this.w.add(this.j);
            }
            f38 f38Var = new f38(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.U1());
            this.k = f38Var;
            f38Var.u(this.b);
            this.w.add(this.k);
            h38 h38Var = new h38(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.U1());
            this.l = h38Var;
            h38Var.x(this.b);
            this.w.add(this.l);
            g38 g38Var = new g38(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.U1());
            this.m = g38Var;
            g38Var.u(this.b);
            this.w.add(this.m);
            j38 j38Var = new j38(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.n = j38Var;
            j38Var.x(this.b);
            this.w.add(this.n);
            w28 w28Var = new w28(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.U1());
            this.o = w28Var;
            w28Var.z(this.b);
            this.w.add(this.o);
            v28 v28Var = new v28(this.a.getPageContext(), ap6.R0, this.a.U1());
            this.r = v28Var;
            this.w.add(v28Var);
            u28 u28Var = new u28(this.a.getPageContext(), d45.e);
            this.p = u28Var;
            u28Var.x(this.b);
            this.w.add(this.p);
            t28 t28Var = new t28(this.a.getPageContext(), h25.b);
            this.q = t28Var;
            t28Var.A(this.b);
            this.w.add(this.q);
            e38 e38Var = new e38(this.a.getPageContext());
            this.s = e38Var;
            e38Var.u(this.b);
            this.w.add(this.s);
            i38 i38Var = new i38(this.a.getPageContext());
            this.t = i38Var;
            i38Var.u(this.b);
            this.w.add(this.t);
            x28 x28Var = new x28(this.a.getPageContext(), b());
            this.u = x28Var;
            this.w.add(x28Var);
            m38 m38Var = new m38(this.a.getPageContext());
            this.v = m38Var;
            this.w.add(m38Var);
            this.b.addAdapters(this.w);
        }
    }
}
