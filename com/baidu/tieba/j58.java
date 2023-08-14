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
/* loaded from: classes6.dex */
public class j58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public f68 c;
    public y58 d;
    public t58 e;
    public v58 f;
    public u58 g;
    public w58 h;
    public g68 i;
    public x58 j;
    public a68 k;
    public c68 l;
    public b68 m;
    public e68 n;
    public r58 o;
    public p58 p;
    public o58 q;
    public q58 r;
    public z58 s;
    public d68 t;
    public s58 u;
    public h68 v;
    public List<lm> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j58 a;

        public a(j58 j58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j58Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof i68)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public j58(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<ym> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        h68 h68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (h68Var = this.v) != null) {
            h68Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (lm lmVar : this.w) {
                if (lmVar instanceof l58) {
                    ((l58) lmVar).h(str);
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
            f68 f68Var = new f68(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.V1(), this.a.U1());
            this.c = f68Var;
            f68Var.y(this.b);
            this.w.add(this.c);
            y58 y58Var = new y58(this.a.getPageContext());
            this.d = y58Var;
            y58Var.x(this.b);
            this.w.add(this.d);
            t58 t58Var = new t58(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.V1());
            this.e = t58Var;
            t58Var.z(this.b);
            this.w.add(this.e);
            v58 v58Var = new v58(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.V1());
            this.f = v58Var;
            v58Var.y(this.b);
            this.w.add(this.f);
            u58 u58Var = new u58(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.V1());
            this.g = u58Var;
            u58Var.y(this.b);
            this.w.add(this.g);
            w58 w58Var = new w58(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.V1());
            this.h = w58Var;
            w58Var.y(this.b);
            this.w.add(this.h);
            g68 g68Var = new g68(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.V1());
            this.i = g68Var;
            g68Var.B(this.b);
            this.w.add(this.i);
            x58 x58Var = new x58(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.V1());
            this.j = x58Var;
            x58Var.y(this.b);
            if ("fashion".equals(this.a.U1()) || "local".equals(this.a.U1())) {
                this.w.add(this.j);
            }
            a68 a68Var = new a68(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.V1());
            this.k = a68Var;
            a68Var.u(this.b);
            this.w.add(this.k);
            c68 c68Var = new c68(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.V1());
            this.l = c68Var;
            c68Var.x(this.b);
            this.w.add(this.l);
            b68 b68Var = new b68(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.V1());
            this.m = b68Var;
            b68Var.u(this.b);
            this.w.add(this.m);
            e68 e68Var = new e68(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.V1());
            this.n = e68Var;
            e68Var.x(this.b);
            this.w.add(this.n);
            r58 r58Var = new r58(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.V1());
            this.o = r58Var;
            r58Var.z(this.b);
            this.w.add(this.o);
            q58 q58Var = new q58(this.a.getPageContext(), rn6.S0, this.a.V1());
            this.r = q58Var;
            this.w.add(q58Var);
            p58 p58Var = new p58(this.a.getPageContext(), l35.e);
            this.p = p58Var;
            p58Var.x(this.b);
            this.w.add(this.p);
            o58 o58Var = new o58(this.a.getPageContext(), q15.b);
            this.q = o58Var;
            o58Var.A(this.b);
            this.w.add(this.q);
            z58 z58Var = new z58(this.a.getPageContext());
            this.s = z58Var;
            z58Var.u(this.b);
            this.w.add(this.s);
            d68 d68Var = new d68(this.a.getPageContext());
            this.t = d68Var;
            d68Var.u(this.b);
            this.w.add(this.t);
            s58 s58Var = new s58(this.a.getPageContext(), b());
            this.u = s58Var;
            this.w.add(s58Var);
            h68 h68Var = new h68(this.a.getPageContext());
            this.v = h68Var;
            this.w.add(h68Var);
            this.b.addAdapters(this.w);
        }
    }
}
