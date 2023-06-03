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
public class w18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public s28 c;
    public l28 d;
    public g28 e;
    public i28 f;
    public h28 g;
    public j28 h;
    public t28 i;
    public k28 j;
    public n28 k;
    public p28 l;
    public o28 m;
    public r28 n;
    public e28 o;
    public c28 p;
    public b28 q;
    public d28 r;
    public m28 s;
    public q28 t;
    public f28 u;
    public u28 v;
    public List<in> w;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w18 a;

        public a(w18 w18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof v28)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public w18(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        u28 u28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (u28Var = this.v) != null) {
            u28Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (in inVar : this.w) {
                if (inVar instanceof y18) {
                    ((y18) inVar).h(str);
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
            s28 s28Var = new s28(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.U1(), this.a.T1());
            this.c = s28Var;
            s28Var.y(this.b);
            this.w.add(this.c);
            l28 l28Var = new l28(this.a.getPageContext());
            this.d = l28Var;
            l28Var.x(this.b);
            this.w.add(this.d);
            g28 g28Var = new g28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.e = g28Var;
            g28Var.z(this.b);
            this.w.add(this.e);
            i28 i28Var = new i28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.f = i28Var;
            i28Var.y(this.b);
            this.w.add(this.f);
            h28 h28Var = new h28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.U1());
            this.g = h28Var;
            h28Var.y(this.b);
            this.w.add(this.g);
            j28 j28Var = new j28(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.h = j28Var;
            j28Var.y(this.b);
            this.w.add(this.h);
            t28 t28Var = new t28(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.U1());
            this.i = t28Var;
            t28Var.B(this.b);
            this.w.add(this.i);
            k28 k28Var = new k28(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.U1());
            this.j = k28Var;
            k28Var.y(this.b);
            if ("fashion".equals(this.a.T1()) || "local".equals(this.a.T1())) {
                this.w.add(this.j);
            }
            n28 n28Var = new n28(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.U1());
            this.k = n28Var;
            n28Var.u(this.b);
            this.w.add(this.k);
            p28 p28Var = new p28(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.U1());
            this.l = p28Var;
            p28Var.x(this.b);
            this.w.add(this.l);
            o28 o28Var = new o28(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.U1());
            this.m = o28Var;
            o28Var.u(this.b);
            this.w.add(this.m);
            r28 r28Var = new r28(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.U1());
            this.n = r28Var;
            r28Var.x(this.b);
            this.w.add(this.n);
            e28 e28Var = new e28(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.U1());
            this.o = e28Var;
            e28Var.z(this.b);
            this.w.add(this.o);
            d28 d28Var = new d28(this.a.getPageContext(), to6.Q0, this.a.U1());
            this.r = d28Var;
            this.w.add(d28Var);
            c28 c28Var = new c28(this.a.getPageContext(), a45.e);
            this.p = c28Var;
            c28Var.x(this.b);
            this.w.add(this.p);
            b28 b28Var = new b28(this.a.getPageContext(), e25.b);
            this.q = b28Var;
            b28Var.A(this.b);
            this.w.add(this.q);
            m28 m28Var = new m28(this.a.getPageContext());
            this.s = m28Var;
            m28Var.u(this.b);
            this.w.add(this.s);
            q28 q28Var = new q28(this.a.getPageContext());
            this.t = q28Var;
            q28Var.u(this.b);
            this.w.add(this.t);
            f28 f28Var = new f28(this.a.getPageContext(), b());
            this.u = f28Var;
            this.w.add(f28Var);
            u28 u28Var = new u28(this.a.getPageContext());
            this.v = u28Var;
            this.w.add(u28Var);
            this.b.addAdapters(this.w);
        }
    }
}
