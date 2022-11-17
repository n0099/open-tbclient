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
public class r57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public n67 c;
    public g67 d;
    public b67 e;
    public d67 f;
    public c67 g;
    public e67 h;
    public o67 i;
    public f67 j;
    public i67 k;
    public k67 l;
    public j67 m;
    public m67 n;
    public z57 o;
    public x57 p;
    public w57 q;
    public y57 r;
    public h67 s;
    public l67 t;
    public a67 u;
    public p67 v;
    public List<kn> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r57 a;

        public a(r57 r57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof q67)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public r57(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        p67 p67Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (p67Var = this.v) != null) {
            p67Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (kn knVar : this.w) {
                if (knVar instanceof t57) {
                    ((t57) knVar).h(str);
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
            n67 n67Var = new n67(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E1(), this.a.D1());
            this.c = n67Var;
            n67Var.w(this.b);
            this.w.add(this.c);
            g67 g67Var = new g67(this.a.getPageContext());
            this.d = g67Var;
            g67Var.v(this.b);
            this.w.add(this.d);
            b67 b67Var = new b67(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.e = b67Var;
            b67Var.x(this.b);
            this.w.add(this.e);
            d67 d67Var = new d67(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.f = d67Var;
            d67Var.w(this.b);
            this.w.add(this.f);
            c67 c67Var = new c67(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.g = c67Var;
            c67Var.w(this.b);
            this.w.add(this.g);
            e67 e67Var = new e67(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.h = e67Var;
            e67Var.w(this.b);
            this.w.add(this.h);
            o67 o67Var = new o67(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E1());
            this.i = o67Var;
            o67Var.z(this.b);
            this.w.add(this.i);
            f67 f67Var = new f67(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E1());
            this.j = f67Var;
            f67Var.w(this.b);
            if ("fashion".equals(this.a.D1()) || ImagesContract.LOCAL.equals(this.a.D1())) {
                this.w.add(this.j);
            }
            i67 i67Var = new i67(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E1());
            this.k = i67Var;
            i67Var.u(this.b);
            this.w.add(this.k);
            k67 k67Var = new k67(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E1());
            this.l = k67Var;
            k67Var.v(this.b);
            this.w.add(this.l);
            j67 j67Var = new j67(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E1());
            this.m = j67Var;
            j67Var.u(this.b);
            this.w.add(this.m);
            m67 m67Var = new m67(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.n = m67Var;
            m67Var.v(this.b);
            this.w.add(this.n);
            z57 z57Var = new z57(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E1());
            this.o = z57Var;
            z57Var.x(this.b);
            this.w.add(this.o);
            y57 y57Var = new y57(this.a.getPageContext(), a56.N0, this.a.E1());
            this.r = y57Var;
            this.w.add(y57Var);
            x57 x57Var = new x57(this.a.getPageContext(), mu4.e);
            this.p = x57Var;
            x57Var.v(this.b);
            this.w.add(this.p);
            w57 w57Var = new w57(this.a.getPageContext(), rs4.b);
            this.q = w57Var;
            w57Var.y(this.b);
            this.w.add(this.q);
            h67 h67Var = new h67(this.a.getPageContext());
            this.s = h67Var;
            h67Var.u(this.b);
            this.w.add(this.s);
            l67 l67Var = new l67(this.a.getPageContext());
            this.t = l67Var;
            l67Var.u(this.b);
            this.w.add(this.t);
            a67 a67Var = new a67(this.a.getPageContext(), b());
            this.u = a67Var;
            this.w.add(a67Var);
            p67 p67Var = new p67(this.a.getPageContext());
            this.v = p67Var;
            this.w.add(p67Var);
            this.b.a(this.w);
        }
    }
}
