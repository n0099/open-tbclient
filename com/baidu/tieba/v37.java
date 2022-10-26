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
public class v37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public r47 c;
    public k47 d;
    public f47 e;
    public h47 f;
    public g47 g;
    public i47 h;
    public s47 i;
    public j47 j;
    public m47 k;
    public o47 l;
    public n47 m;
    public q47 n;
    public d47 o;
    public b47 p;
    public a47 q;
    public c47 r;
    public l47 s;
    public p47 t;
    public e47 u;
    public t47 v;
    public List w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v37 a;

        public a(v37 v37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v37Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof u47)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public v37(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        t47 t47Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (t47Var = this.v) != null) {
            t47Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (rn rnVar : this.w) {
                if (rnVar instanceof x37) {
                    ((x37) rnVar).h(str);
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
            r47 r47Var = new r47(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E1(), this.a.D1());
            this.c = r47Var;
            r47Var.w(this.b);
            this.w.add(this.c);
            k47 k47Var = new k47(this.a.getPageContext());
            this.d = k47Var;
            k47Var.v(this.b);
            this.w.add(this.d);
            f47 f47Var = new f47(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.e = f47Var;
            f47Var.x(this.b);
            this.w.add(this.e);
            h47 h47Var = new h47(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.f = h47Var;
            h47Var.w(this.b);
            this.w.add(this.f);
            g47 g47Var = new g47(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.g = g47Var;
            g47Var.w(this.b);
            this.w.add(this.g);
            i47 i47Var = new i47(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.h = i47Var;
            i47Var.w(this.b);
            this.w.add(this.h);
            s47 s47Var = new s47(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E1());
            this.i = s47Var;
            s47Var.z(this.b);
            this.w.add(this.i);
            j47 j47Var = new j47(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E1());
            this.j = j47Var;
            j47Var.w(this.b);
            if ("fashion".equals(this.a.D1()) || ImagesContract.LOCAL.equals(this.a.D1())) {
                this.w.add(this.j);
            }
            m47 m47Var = new m47(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E1());
            this.k = m47Var;
            m47Var.u(this.b);
            this.w.add(this.k);
            o47 o47Var = new o47(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E1());
            this.l = o47Var;
            o47Var.v(this.b);
            this.w.add(this.l);
            n47 n47Var = new n47(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E1());
            this.m = n47Var;
            n47Var.u(this.b);
            this.w.add(this.m);
            q47 q47Var = new q47(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.n = q47Var;
            q47Var.v(this.b);
            this.w.add(this.n);
            d47 d47Var = new d47(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E1());
            this.o = d47Var;
            d47Var.x(this.b);
            this.w.add(this.o);
            c47 c47Var = new c47(this.a.getPageContext(), d36.N0, this.a.E1());
            this.r = c47Var;
            this.w.add(c47Var);
            b47 b47Var = new b47(this.a.getPageContext(), ut4.e);
            this.p = b47Var;
            b47Var.v(this.b);
            this.w.add(this.p);
            a47 a47Var = new a47(this.a.getPageContext(), yr4.b);
            this.q = a47Var;
            a47Var.y(this.b);
            this.w.add(this.q);
            l47 l47Var = new l47(this.a.getPageContext());
            this.s = l47Var;
            l47Var.u(this.b);
            this.w.add(this.s);
            p47 p47Var = new p47(this.a.getPageContext());
            this.t = p47Var;
            p47Var.u(this.b);
            this.w.add(this.t);
            e47 e47Var = new e47(this.a.getPageContext(), b());
            this.u = e47Var;
            this.w.add(e47Var);
            t47 t47Var = new t47(this.a.getPageContext());
            this.v = t47Var;
            this.w.add(t47Var);
            this.b.a(this.w);
        }
    }
}
