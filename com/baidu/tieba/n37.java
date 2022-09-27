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
public class n37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public j47 c;
    public c47 d;
    public x37 e;
    public z37 f;
    public y37 g;
    public a47 h;
    public k47 i;
    public b47 j;
    public e47 k;
    public g47 l;
    public f47 m;
    public i47 n;
    public v37 o;
    public t37 p;
    public s37 q;
    public u37 r;
    public d47 s;
    public h47 t;
    public w37 u;
    public l47 v;
    public List<qn> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n37 a;

        public a(n37 n37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n37Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof m47)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public n37(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            j47 j47Var = new j47(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E1(), this.a.D1());
            this.c = j47Var;
            j47Var.w(this.b);
            this.w.add(this.c);
            c47 c47Var = new c47(this.a.getPageContext());
            this.d = c47Var;
            c47Var.v(this.b);
            this.w.add(this.d);
            x37 x37Var = new x37(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.e = x37Var;
            x37Var.x(this.b);
            this.w.add(this.e);
            z37 z37Var = new z37(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.f = z37Var;
            z37Var.w(this.b);
            this.w.add(this.f);
            y37 y37Var = new y37(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.g = y37Var;
            y37Var.w(this.b);
            this.w.add(this.g);
            a47 a47Var = new a47(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.h = a47Var;
            a47Var.w(this.b);
            this.w.add(this.h);
            k47 k47Var = new k47(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E1());
            this.i = k47Var;
            k47Var.z(this.b);
            this.w.add(this.i);
            b47 b47Var = new b47(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E1());
            this.j = b47Var;
            b47Var.w(this.b);
            if ("fashion".equals(this.a.D1()) || ImagesContract.LOCAL.equals(this.a.D1())) {
                this.w.add(this.j);
            }
            e47 e47Var = new e47(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E1());
            this.k = e47Var;
            e47Var.u(this.b);
            this.w.add(this.k);
            g47 g47Var = new g47(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E1());
            this.l = g47Var;
            g47Var.v(this.b);
            this.w.add(this.l);
            f47 f47Var = new f47(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E1());
            this.m = f47Var;
            f47Var.u(this.b);
            this.w.add(this.m);
            i47 i47Var = new i47(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.n = i47Var;
            i47Var.v(this.b);
            this.w.add(this.n);
            v37 v37Var = new v37(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E1());
            this.o = v37Var;
            v37Var.x(this.b);
            this.w.add(this.o);
            u37 u37Var = new u37(this.a.getPageContext(), w26.N0, this.a.E1());
            this.r = u37Var;
            this.w.add(u37Var);
            t37 t37Var = new t37(this.a.getPageContext(), st4.e);
            this.p = t37Var;
            t37Var.v(this.b);
            this.w.add(this.p);
            s37 s37Var = new s37(this.a.getPageContext(), wr4.b);
            this.q = s37Var;
            s37Var.y(this.b);
            this.w.add(this.q);
            d47 d47Var = new d47(this.a.getPageContext());
            this.s = d47Var;
            d47Var.u(this.b);
            this.w.add(this.s);
            h47 h47Var = new h47(this.a.getPageContext());
            this.t = h47Var;
            h47Var.u(this.b);
            this.w.add(this.t);
            w37 w37Var = new w37(this.a.getPageContext(), b());
            this.u = w37Var;
            this.w.add(w37Var);
            l47 l47Var = new l47(this.a.getPageContext());
            this.v = l47Var;
            this.w.add(l47Var);
            this.b.a(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        l47 l47Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (l47Var = this.v) == null) {
            return;
        }
        l47Var.u(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (qn qnVar : this.w) {
                if (qnVar instanceof p37) {
                    ((p37) qnVar).h(str);
                }
            }
        }
    }
}
