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
/* loaded from: classes6.dex */
public class z27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public v37 c;
    public o37 d;
    public j37 e;
    public l37 f;
    public k37 g;
    public m37 h;
    public w37 i;
    public n37 j;
    public q37 k;
    public s37 l;
    public r37 m;
    public u37 n;
    public h37 o;
    public f37 p;
    public e37 q;
    public g37 r;
    public p37 s;
    public t37 t;
    public i37 u;
    public x37 v;
    public List<qn> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z27 a;

        public a(z27 z27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z27Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof y37)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public z27(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            v37 v37Var = new v37(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E1(), this.a.D1());
            this.c = v37Var;
            v37Var.w(this.b);
            this.w.add(this.c);
            o37 o37Var = new o37(this.a.getPageContext());
            this.d = o37Var;
            o37Var.v(this.b);
            this.w.add(this.d);
            j37 j37Var = new j37(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.e = j37Var;
            j37Var.x(this.b);
            this.w.add(this.e);
            l37 l37Var = new l37(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.f = l37Var;
            l37Var.w(this.b);
            this.w.add(this.f);
            k37 k37Var = new k37(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.g = k37Var;
            k37Var.w(this.b);
            this.w.add(this.g);
            m37 m37Var = new m37(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.h = m37Var;
            m37Var.w(this.b);
            this.w.add(this.h);
            w37 w37Var = new w37(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E1());
            this.i = w37Var;
            w37Var.z(this.b);
            this.w.add(this.i);
            n37 n37Var = new n37(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E1());
            this.j = n37Var;
            n37Var.w(this.b);
            if ("fashion".equals(this.a.D1()) || ImagesContract.LOCAL.equals(this.a.D1())) {
                this.w.add(this.j);
            }
            q37 q37Var = new q37(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E1());
            this.k = q37Var;
            q37Var.u(this.b);
            this.w.add(this.k);
            s37 s37Var = new s37(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E1());
            this.l = s37Var;
            s37Var.v(this.b);
            this.w.add(this.l);
            r37 r37Var = new r37(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E1());
            this.m = r37Var;
            r37Var.u(this.b);
            this.w.add(this.m);
            u37 u37Var = new u37(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.n = u37Var;
            u37Var.v(this.b);
            this.w.add(this.n);
            h37 h37Var = new h37(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E1());
            this.o = h37Var;
            h37Var.x(this.b);
            this.w.add(this.o);
            g37 g37Var = new g37(this.a.getPageContext(), j26.N0, this.a.E1());
            this.r = g37Var;
            this.w.add(g37Var);
            f37 f37Var = new f37(this.a.getPageContext(), ft4.e);
            this.p = f37Var;
            f37Var.v(this.b);
            this.w.add(this.p);
            e37 e37Var = new e37(this.a.getPageContext(), jr4.b);
            this.q = e37Var;
            e37Var.y(this.b);
            this.w.add(this.q);
            p37 p37Var = new p37(this.a.getPageContext());
            this.s = p37Var;
            p37Var.u(this.b);
            this.w.add(this.s);
            t37 t37Var = new t37(this.a.getPageContext());
            this.t = t37Var;
            t37Var.u(this.b);
            this.w.add(this.t);
            i37 i37Var = new i37(this.a.getPageContext(), b());
            this.u = i37Var;
            this.w.add(i37Var);
            x37 x37Var = new x37(this.a.getPageContext());
            this.v = x37Var;
            this.w.add(x37Var);
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
        x37 x37Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (x37Var = this.v) == null) {
            return;
        }
        x37Var.u(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (qn qnVar : this.w) {
                if (qnVar instanceof b37) {
                    ((b37) qnVar).h(str);
                }
            }
        }
    }
}
