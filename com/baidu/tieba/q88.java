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
public class q88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public m98 c;
    public f98 d;
    public a98 e;
    public c98 f;
    public b98 g;
    public d98 h;
    public n98 i;
    public e98 j;
    public h98 k;
    public j98 l;
    public i98 m;
    public l98 n;
    public y88 o;
    public w88 p;
    public v88 q;
    public x88 r;
    public g98 s;
    public k98 t;
    public z88 u;
    public o98 v;
    public List<pm> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q88 a;

        public a(q88 q88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q88Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof p98)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public q88(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        o98 o98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (o98Var = this.v) != null) {
            o98Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (pm pmVar : this.w) {
                if (pmVar instanceof s88) {
                    ((s88) pmVar).h(str);
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
            m98 m98Var = new m98(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.j2(), this.a.i2());
            this.c = m98Var;
            m98Var.y(this.b);
            this.w.add(this.c);
            f98 f98Var = new f98(this.a.getPageContext());
            this.d = f98Var;
            f98Var.x(this.b);
            this.w.add(this.d);
            a98 a98Var = new a98(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.j2());
            this.e = a98Var;
            a98Var.z(this.b);
            this.w.add(this.e);
            c98 c98Var = new c98(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.j2());
            this.f = c98Var;
            c98Var.y(this.b);
            this.w.add(this.f);
            b98 b98Var = new b98(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.j2());
            this.g = b98Var;
            b98Var.y(this.b);
            this.w.add(this.g);
            d98 d98Var = new d98(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.j2());
            this.h = d98Var;
            d98Var.y(this.b);
            this.w.add(this.h);
            n98 n98Var = new n98(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.j2());
            this.i = n98Var;
            n98Var.B(this.b);
            this.w.add(this.i);
            e98 e98Var = new e98(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.j2());
            this.j = e98Var;
            e98Var.y(this.b);
            if ("fashion".equals(this.a.i2()) || "local".equals(this.a.i2())) {
                this.w.add(this.j);
            }
            h98 h98Var = new h98(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.j2());
            this.k = h98Var;
            h98Var.u(this.b);
            this.w.add(this.k);
            j98 j98Var = new j98(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.j2());
            this.l = j98Var;
            j98Var.x(this.b);
            this.w.add(this.l);
            i98 i98Var = new i98(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.j2());
            this.m = i98Var;
            i98Var.u(this.b);
            this.w.add(this.m);
            l98 l98Var = new l98(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.j2());
            this.n = l98Var;
            l98Var.x(this.b);
            this.w.add(this.n);
            y88 y88Var = new y88(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.j2());
            this.o = y88Var;
            y88Var.z(this.b);
            this.w.add(this.o);
            x88 x88Var = new x88(this.a.getPageContext(), bq6.S0, this.a.j2());
            this.r = x88Var;
            this.w.add(x88Var);
            w88 w88Var = new w88(this.a.getPageContext(), w35.e);
            this.p = w88Var;
            w88Var.x(this.b);
            this.w.add(this.p);
            v88 v88Var = new v88(this.a.getPageContext(), b25.b);
            this.q = v88Var;
            v88Var.A(this.b);
            this.w.add(this.q);
            g98 g98Var = new g98(this.a.getPageContext());
            this.s = g98Var;
            g98Var.u(this.b);
            this.w.add(this.s);
            k98 k98Var = new k98(this.a.getPageContext());
            this.t = k98Var;
            k98Var.u(this.b);
            this.w.add(this.t);
            z88 z88Var = new z88(this.a.getPageContext(), b());
            this.u = z88Var;
            this.w.add(z88Var);
            o98 o98Var = new o98(this.a.getPageContext());
            this.v = o98Var;
            this.w.add(o98Var);
            this.b.addAdapters(this.w);
        }
    }
}
