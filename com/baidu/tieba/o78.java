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
public class o78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public k88 c;
    public d88 d;
    public y78 e;
    public a88 f;
    public z78 g;
    public b88 h;
    public l88 i;
    public c88 j;
    public f88 k;
    public h88 l;
    public g88 m;
    public j88 n;
    public w78 o;
    public u78 p;
    public t78 q;
    public v78 r;
    public e88 s;
    public i88 t;
    public x78 u;
    public m88 v;
    public List<ln> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o78 a;

        public a(o78 o78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o78Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof n88)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public o78(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        m88 m88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (m88Var = this.v) != null) {
            m88Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (ln lnVar : this.w) {
                if (lnVar instanceof q78) {
                    ((q78) lnVar).h(str);
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
            k88 k88Var = new k88(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.U1(), this.a.T1());
            this.c = k88Var;
            k88Var.y(this.b);
            this.w.add(this.c);
            d88 d88Var = new d88(this.a.getPageContext());
            this.d = d88Var;
            d88Var.x(this.b);
            this.w.add(this.d);
            y78 y78Var = new y78(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.e = y78Var;
            y78Var.z(this.b);
            this.w.add(this.e);
            a88 a88Var = new a88(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.f = a88Var;
            a88Var.y(this.b);
            this.w.add(this.f);
            z78 z78Var = new z78(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.g = z78Var;
            z78Var.y(this.b);
            this.w.add(this.g);
            b88 b88Var = new b88(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.h = b88Var;
            b88Var.y(this.b);
            this.w.add(this.h);
            l88 l88Var = new l88(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.U1());
            this.i = l88Var;
            l88Var.B(this.b);
            this.w.add(this.i);
            c88 c88Var = new c88(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.U1());
            this.j = c88Var;
            c88Var.y(this.b);
            if ("fashion".equals(this.a.T1()) || "local".equals(this.a.T1())) {
                this.w.add(this.j);
            }
            f88 f88Var = new f88(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.U1());
            this.k = f88Var;
            f88Var.u(this.b);
            this.w.add(this.k);
            h88 h88Var = new h88(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.U1());
            this.l = h88Var;
            h88Var.x(this.b);
            this.w.add(this.l);
            g88 g88Var = new g88(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.U1());
            this.m = g88Var;
            g88Var.u(this.b);
            this.w.add(this.m);
            j88 j88Var = new j88(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.n = j88Var;
            j88Var.x(this.b);
            this.w.add(this.n);
            w78 w78Var = new w78(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.U1());
            this.o = w78Var;
            w78Var.z(this.b);
            this.w.add(this.o);
            v78 v78Var = new v78(this.a.getPageContext(), jq6.S0, this.a.U1());
            this.r = v78Var;
            this.w.add(v78Var);
            u78 u78Var = new u78(this.a.getPageContext(), o45.e);
            this.p = u78Var;
            u78Var.x(this.b);
            this.w.add(this.p);
            t78 t78Var = new t78(this.a.getPageContext(), s25.b);
            this.q = t78Var;
            t78Var.A(this.b);
            this.w.add(this.q);
            e88 e88Var = new e88(this.a.getPageContext());
            this.s = e88Var;
            e88Var.u(this.b);
            this.w.add(this.s);
            i88 i88Var = new i88(this.a.getPageContext());
            this.t = i88Var;
            i88Var.u(this.b);
            this.w.add(this.t);
            x78 x78Var = new x78(this.a.getPageContext(), b());
            this.u = x78Var;
            this.w.add(x78Var);
            m88 m88Var = new m88(this.a.getPageContext());
            this.v = m88Var;
            this.w.add(m88Var);
            this.b.addAdapters(this.w);
        }
    }
}
