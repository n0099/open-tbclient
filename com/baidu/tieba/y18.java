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
public class y18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public u28 c;
    public n28 d;
    public i28 e;
    public k28 f;
    public j28 g;
    public l28 h;
    public v28 i;
    public m28 j;
    public p28 k;
    public r28 l;
    public q28 m;
    public t28 n;
    public g28 o;
    public e28 p;
    public d28 q;
    public f28 r;
    public o28 s;
    public s28 t;
    public h28 u;
    public w28 v;
    public List<in> w;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y18 a;

        public a(y18 y18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof x28)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public y18(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<vn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        w28 w28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (w28Var = this.v) != null) {
            w28Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (in inVar : this.w) {
                if (inVar instanceof a28) {
                    ((a28) inVar).h(str);
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
            u28 u28Var = new u28(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.U1(), this.a.T1());
            this.c = u28Var;
            u28Var.y(this.b);
            this.w.add(this.c);
            n28 n28Var = new n28(this.a.getPageContext());
            this.d = n28Var;
            n28Var.x(this.b);
            this.w.add(this.d);
            i28 i28Var = new i28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.e = i28Var;
            i28Var.z(this.b);
            this.w.add(this.e);
            k28 k28Var = new k28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.f = k28Var;
            k28Var.y(this.b);
            this.w.add(this.f);
            j28 j28Var = new j28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.g = j28Var;
            j28Var.y(this.b);
            this.w.add(this.g);
            l28 l28Var = new l28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.h = l28Var;
            l28Var.y(this.b);
            this.w.add(this.h);
            v28 v28Var = new v28(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.U1());
            this.i = v28Var;
            v28Var.B(this.b);
            this.w.add(this.i);
            m28 m28Var = new m28(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.U1());
            this.j = m28Var;
            m28Var.y(this.b);
            if ("fashion".equals(this.a.T1()) || "local".equals(this.a.T1())) {
                this.w.add(this.j);
            }
            p28 p28Var = new p28(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.U1());
            this.k = p28Var;
            p28Var.u(this.b);
            this.w.add(this.k);
            r28 r28Var = new r28(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.U1());
            this.l = r28Var;
            r28Var.x(this.b);
            this.w.add(this.l);
            q28 q28Var = new q28(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.U1());
            this.m = q28Var;
            q28Var.u(this.b);
            this.w.add(this.m);
            t28 t28Var = new t28(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.n = t28Var;
            t28Var.x(this.b);
            this.w.add(this.n);
            g28 g28Var = new g28(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.U1());
            this.o = g28Var;
            g28Var.z(this.b);
            this.w.add(this.o);
            f28 f28Var = new f28(this.a.getPageContext(), vo6.Q0, this.a.U1());
            this.r = f28Var;
            this.w.add(f28Var);
            e28 e28Var = new e28(this.a.getPageContext(), c45.e);
            this.p = e28Var;
            e28Var.x(this.b);
            this.w.add(this.p);
            d28 d28Var = new d28(this.a.getPageContext(), g25.b);
            this.q = d28Var;
            d28Var.A(this.b);
            this.w.add(this.q);
            o28 o28Var = new o28(this.a.getPageContext());
            this.s = o28Var;
            o28Var.u(this.b);
            this.w.add(this.s);
            s28 s28Var = new s28(this.a.getPageContext());
            this.t = s28Var;
            s28Var.u(this.b);
            this.w.add(this.t);
            h28 h28Var = new h28(this.a.getPageContext(), b());
            this.u = h28Var;
            this.w.add(h28Var);
            w28 w28Var = new w28(this.a.getPageContext());
            this.v = w28Var;
            this.w.add(w28Var);
            this.b.addAdapters(this.w);
        }
    }
}
