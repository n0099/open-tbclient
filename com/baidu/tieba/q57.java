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
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class q57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public m67 c;
    public f67 d;
    public a67 e;
    public c67 f;
    public b67 g;
    public d67 h;
    public n67 i;
    public e67 j;
    public h67 k;
    public j67 l;
    public i67 m;
    public l67 n;
    public y57 o;
    public w57 p;
    public v57 q;
    public x57 r;
    public g67 s;
    public k67 t;
    public z57 u;
    public o67 v;
    public List<kn> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q57 a;

        public a(q57 q57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof p67)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public q57(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        o67 o67Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (o67Var = this.v) != null) {
            o67Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (kn knVar : this.w) {
                if (knVar instanceof s57) {
                    ((s57) knVar).h(str);
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
            m67 m67Var = new m67(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E1(), this.a.D1());
            this.c = m67Var;
            m67Var.w(this.b);
            this.w.add(this.c);
            f67 f67Var = new f67(this.a.getPageContext());
            this.d = f67Var;
            f67Var.v(this.b);
            this.w.add(this.d);
            a67 a67Var = new a67(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.e = a67Var;
            a67Var.x(this.b);
            this.w.add(this.e);
            c67 c67Var = new c67(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.f = c67Var;
            c67Var.w(this.b);
            this.w.add(this.f);
            b67 b67Var = new b67(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.g = b67Var;
            b67Var.w(this.b);
            this.w.add(this.g);
            d67 d67Var = new d67(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.h = d67Var;
            d67Var.w(this.b);
            this.w.add(this.h);
            n67 n67Var = new n67(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E1());
            this.i = n67Var;
            n67Var.z(this.b);
            this.w.add(this.i);
            e67 e67Var = new e67(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E1());
            this.j = e67Var;
            e67Var.w(this.b);
            if ("fashion".equals(this.a.D1()) || ImagesContract.LOCAL.equals(this.a.D1())) {
                this.w.add(this.j);
            }
            h67 h67Var = new h67(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E1());
            this.k = h67Var;
            h67Var.u(this.b);
            this.w.add(this.k);
            j67 j67Var = new j67(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E1());
            this.l = j67Var;
            j67Var.v(this.b);
            this.w.add(this.l);
            i67 i67Var = new i67(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E1());
            this.m = i67Var;
            i67Var.u(this.b);
            this.w.add(this.m);
            l67 l67Var = new l67(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.n = l67Var;
            l67Var.v(this.b);
            this.w.add(this.n);
            y57 y57Var = new y57(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E1());
            this.o = y57Var;
            y57Var.x(this.b);
            this.w.add(this.o);
            x57 x57Var = new x57(this.a.getPageContext(), z46.N0, this.a.E1());
            this.r = x57Var;
            this.w.add(x57Var);
            w57 w57Var = new w57(this.a.getPageContext(), lu4.e);
            this.p = w57Var;
            w57Var.v(this.b);
            this.w.add(this.p);
            v57 v57Var = new v57(this.a.getPageContext(), qs4.b);
            this.q = v57Var;
            v57Var.y(this.b);
            this.w.add(this.q);
            g67 g67Var = new g67(this.a.getPageContext());
            this.s = g67Var;
            g67Var.u(this.b);
            this.w.add(this.s);
            k67 k67Var = new k67(this.a.getPageContext());
            this.t = k67Var;
            k67Var.u(this.b);
            this.w.add(this.t);
            z57 z57Var = new z57(this.a.getPageContext(), b());
            this.u = z57Var;
            this.w.add(z57Var);
            o67 o67Var = new o67(this.a.getPageContext());
            this.v = o67Var;
            this.w.add(o67Var);
            this.b.a(this.w);
        }
    }
}
