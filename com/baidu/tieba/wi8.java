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
/* loaded from: classes8.dex */
public class wi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public sj8 c;
    public lj8 d;
    public gj8 e;
    public ij8 f;
    public hj8 g;
    public jj8 h;
    public tj8 i;
    public kj8 j;
    public nj8 k;
    public pj8 l;
    public oj8 m;
    public rj8 n;
    public ej8 o;
    public cj8 p;
    public bj8 q;
    public dj8 r;
    public mj8 s;
    public qj8 t;
    public fj8 u;
    public uj8 v;
    public List<ci> w;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wi8 a;

        public a(wi8 wi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wi8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof vj8)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public wi8(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        uj8 uj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (uj8Var = this.v) != null) {
            uj8Var.x(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (ci ciVar : this.w) {
                if (ciVar instanceof yi8) {
                    ((yi8) ciVar).h(str);
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
            sj8 sj8Var = new sj8(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.T2(), this.a.S2());
            this.c = sj8Var;
            sj8Var.z(this.b);
            this.w.add(this.c);
            lj8 lj8Var = new lj8(this.a.getPageContext());
            this.d = lj8Var;
            lj8Var.y(this.b);
            this.w.add(this.d);
            gj8 gj8Var = new gj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.T2());
            this.e = gj8Var;
            gj8Var.A(this.b);
            this.w.add(this.e);
            ij8 ij8Var = new ij8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.T2());
            this.f = ij8Var;
            ij8Var.z(this.b);
            this.w.add(this.f);
            hj8 hj8Var = new hj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.T2());
            this.g = hj8Var;
            hj8Var.z(this.b);
            this.w.add(this.g);
            jj8 jj8Var = new jj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.T2());
            this.h = jj8Var;
            jj8Var.z(this.b);
            this.w.add(this.h);
            tj8 tj8Var = new tj8(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.T2());
            this.i = tj8Var;
            tj8Var.C(this.b);
            this.w.add(this.i);
            kj8 kj8Var = new kj8(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.T2());
            this.j = kj8Var;
            kj8Var.z(this.b);
            if ("fashion".equals(this.a.S2()) || "local".equals(this.a.S2())) {
                this.w.add(this.j);
            }
            nj8 nj8Var = new nj8(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.T2());
            this.k = nj8Var;
            nj8Var.x(this.b);
            this.w.add(this.k);
            pj8 pj8Var = new pj8(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.T2());
            this.l = pj8Var;
            pj8Var.y(this.b);
            this.w.add(this.l);
            oj8 oj8Var = new oj8(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.T2());
            this.m = oj8Var;
            oj8Var.x(this.b);
            this.w.add(this.m);
            rj8 rj8Var = new rj8(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.T2());
            this.n = rj8Var;
            rj8Var.y(this.b);
            this.w.add(this.n);
            ej8 ej8Var = new ej8(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.T2());
            this.o = ej8Var;
            ej8Var.A(this.b);
            this.w.add(this.o);
            dj8 dj8Var = new dj8(this.a.getPageContext(), ym6.S0, this.a.T2());
            this.r = dj8Var;
            this.w.add(dj8Var);
            cj8 cj8Var = new cj8(this.a.getPageContext(), yy4.e);
            this.p = cj8Var;
            cj8Var.y(this.b);
            this.w.add(this.p);
            bj8 bj8Var = new bj8(this.a.getPageContext(), dx4.b);
            this.q = bj8Var;
            bj8Var.B(this.b);
            this.w.add(this.q);
            mj8 mj8Var = new mj8(this.a.getPageContext());
            this.s = mj8Var;
            mj8Var.x(this.b);
            this.w.add(this.s);
            qj8 qj8Var = new qj8(this.a.getPageContext());
            this.t = qj8Var;
            qj8Var.x(this.b);
            this.w.add(this.t);
            fj8 fj8Var = new fj8(this.a.getPageContext(), b());
            this.u = fj8Var;
            this.w.add(fj8Var);
            uj8 uj8Var = new uj8(this.a.getPageContext());
            this.v = uj8Var;
            this.w.add(uj8Var);
            this.b.addAdapters(this.w);
        }
    }
}
