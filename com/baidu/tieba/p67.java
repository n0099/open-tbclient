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
/* loaded from: classes5.dex */
public class p67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public l77 c;
    public e77 d;
    public z67 e;
    public b77 f;
    public a77 g;
    public c77 h;
    public m77 i;
    public d77 j;
    public g77 k;
    public i77 l;
    public h77 m;
    public k77 n;
    public x67 o;
    public v67 p;
    public u67 q;
    public w67 r;
    public f77 s;
    public j77 t;
    public y67 u;
    public n77 v;
    public List<kn> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p67 a;

        public a(p67 p67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p67Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.E(0) instanceof o77)) {
                    this.a.b.G(0);
                }
            }
        }
    }

    public p67(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        n77 n77Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (n77Var = this.v) != null) {
            n77Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (kn knVar : this.w) {
                if (knVar instanceof r67) {
                    ((r67) knVar).h(str);
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
            l77 l77Var = new l77(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.K1(), this.a.J1());
            this.c = l77Var;
            l77Var.w(this.b);
            this.w.add(this.c);
            e77 e77Var = new e77(this.a.getPageContext());
            this.d = e77Var;
            e77Var.v(this.b);
            this.w.add(this.d);
            z67 z67Var = new z67(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.K1());
            this.e = z67Var;
            z67Var.x(this.b);
            this.w.add(this.e);
            b77 b77Var = new b77(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.K1());
            this.f = b77Var;
            b77Var.w(this.b);
            this.w.add(this.f);
            a77 a77Var = new a77(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.K1());
            this.g = a77Var;
            a77Var.w(this.b);
            this.w.add(this.g);
            c77 c77Var = new c77(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.K1());
            this.h = c77Var;
            c77Var.w(this.b);
            this.w.add(this.h);
            m77 m77Var = new m77(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.K1());
            this.i = m77Var;
            m77Var.z(this.b);
            this.w.add(this.i);
            d77 d77Var = new d77(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.K1());
            this.j = d77Var;
            d77Var.w(this.b);
            if ("fashion".equals(this.a.J1()) || "local".equals(this.a.J1())) {
                this.w.add(this.j);
            }
            g77 g77Var = new g77(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.K1());
            this.k = g77Var;
            g77Var.u(this.b);
            this.w.add(this.k);
            i77 i77Var = new i77(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.K1());
            this.l = i77Var;
            i77Var.v(this.b);
            this.w.add(this.l);
            h77 h77Var = new h77(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.K1());
            this.m = h77Var;
            h77Var.u(this.b);
            this.w.add(this.m);
            k77 k77Var = new k77(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.K1());
            this.n = k77Var;
            k77Var.v(this.b);
            this.w.add(this.n);
            x67 x67Var = new x67(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.K1());
            this.o = x67Var;
            x67Var.x(this.b);
            this.w.add(this.o);
            w67 w67Var = new w67(this.a.getPageContext(), v56.O0, this.a.K1());
            this.r = w67Var;
            this.w.add(w67Var);
            v67 v67Var = new v67(this.a.getPageContext(), nu4.e);
            this.p = v67Var;
            v67Var.v(this.b);
            this.w.add(this.p);
            u67 u67Var = new u67(this.a.getPageContext(), ts4.b);
            this.q = u67Var;
            u67Var.y(this.b);
            this.w.add(this.q);
            f77 f77Var = new f77(this.a.getPageContext());
            this.s = f77Var;
            f77Var.u(this.b);
            this.w.add(this.s);
            j77 j77Var = new j77(this.a.getPageContext());
            this.t = j77Var;
            j77Var.u(this.b);
            this.w.add(this.t);
            y67 y67Var = new y67(this.a.getPageContext(), b());
            this.u = y67Var;
            this.w.add(y67Var);
            n77 n77Var = new n77(this.a.getPageContext());
            this.v = n77Var;
            this.w.add(n77Var);
            this.b.a(this.w);
        }
    }
}
