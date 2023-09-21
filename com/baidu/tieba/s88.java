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
public class s88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public o98 c;
    public h98 d;
    public c98 e;
    public e98 f;
    public d98 g;
    public f98 h;
    public p98 i;
    public g98 j;
    public j98 k;
    public l98 l;
    public k98 m;
    public n98 n;
    public a98 o;
    public y88 p;
    public x88 q;
    public z88 r;
    public i98 s;
    public m98 t;
    public b98 u;
    public q98 v;
    public List<om> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s88 a;

        public a(s88 s88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s88Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof r98)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public s88(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        q98 q98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (q98Var = this.v) != null) {
            q98Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (om omVar : this.w) {
                if (omVar instanceof u88) {
                    ((u88) omVar).h(str);
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
            o98 o98Var = new o98(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.p2(), this.a.o2());
            this.c = o98Var;
            o98Var.y(this.b);
            this.w.add(this.c);
            h98 h98Var = new h98(this.a.getPageContext());
            this.d = h98Var;
            h98Var.x(this.b);
            this.w.add(this.d);
            c98 c98Var = new c98(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.p2());
            this.e = c98Var;
            c98Var.z(this.b);
            this.w.add(this.e);
            e98 e98Var = new e98(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.p2());
            this.f = e98Var;
            e98Var.y(this.b);
            this.w.add(this.f);
            d98 d98Var = new d98(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.p2());
            this.g = d98Var;
            d98Var.y(this.b);
            this.w.add(this.g);
            f98 f98Var = new f98(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.p2());
            this.h = f98Var;
            f98Var.y(this.b);
            this.w.add(this.h);
            p98 p98Var = new p98(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.p2());
            this.i = p98Var;
            p98Var.B(this.b);
            this.w.add(this.i);
            g98 g98Var = new g98(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.p2());
            this.j = g98Var;
            g98Var.y(this.b);
            if ("fashion".equals(this.a.o2()) || "local".equals(this.a.o2())) {
                this.w.add(this.j);
            }
            j98 j98Var = new j98(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.p2());
            this.k = j98Var;
            j98Var.u(this.b);
            this.w.add(this.k);
            l98 l98Var = new l98(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.p2());
            this.l = l98Var;
            l98Var.x(this.b);
            this.w.add(this.l);
            k98 k98Var = new k98(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.p2());
            this.m = k98Var;
            k98Var.u(this.b);
            this.w.add(this.m);
            n98 n98Var = new n98(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.p2());
            this.n = n98Var;
            n98Var.x(this.b);
            this.w.add(this.n);
            a98 a98Var = new a98(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.p2());
            this.o = a98Var;
            a98Var.z(this.b);
            this.w.add(this.o);
            z88 z88Var = new z88(this.a.getPageContext(), hq6.S0, this.a.p2());
            this.r = z88Var;
            this.w.add(z88Var);
            y88 y88Var = new y88(this.a.getPageContext(), w35.e);
            this.p = y88Var;
            y88Var.x(this.b);
            this.w.add(this.p);
            x88 x88Var = new x88(this.a.getPageContext(), b25.b);
            this.q = x88Var;
            x88Var.A(this.b);
            this.w.add(this.q);
            i98 i98Var = new i98(this.a.getPageContext());
            this.s = i98Var;
            i98Var.u(this.b);
            this.w.add(this.s);
            m98 m98Var = new m98(this.a.getPageContext());
            this.t = m98Var;
            m98Var.u(this.b);
            this.w.add(this.t);
            b98 b98Var = new b98(this.a.getPageContext(), b());
            this.u = b98Var;
            this.w.add(b98Var);
            q98 q98Var = new q98(this.a.getPageContext());
            this.v = q98Var;
            this.w.add(q98Var);
            this.b.addAdapters(this.w);
        }
    }
}
