package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.gs5;
import com.baidu.tieba.p55;
import com.baidu.tieba.pr5;
import com.baidu.tieba.rr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class ps5<Q extends rr5, P extends pr5> extends ks5<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pq5 b;
    public rq5<Q, P> c;
    public xr5 d;
    public BdUniqueId e;
    public TbPageContext f;
    public sq5 g;
    public BdTypeRecyclerView h;
    public BdSwipeRefreshLayout i;
    public q55 j;
    public ls5 k;
    public ms5<P> l;
    public BdListView.p m;
    public wda n;
    public View.OnClickListener o;
    public final BdListView.p p;
    public final RecyclerView.OnScrollListener q;
    public final RecyclerView.RecyclerListener r;
    public final p55.g s;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps5 a;

        public a(ps5 ps5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ps5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                hs5.b(" ----LoadMoreClickListener----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                this.a.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps5 a;

        public b(ps5 ps5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ps5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hs5.b(" ----onScrollToBottom----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                if (this.a.m != null) {
                    this.a.m.onScrollToBottom();
                }
                this.a.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ ps5 b;

        public c(ps5 ps5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ps5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                this.b.B(this.a);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps5 a;

        public d(ps5 ps5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ps5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && viewHolder != null && viewHolder.itemView != null && this.a.n != null) {
                this.a.n.k(viewHolder.itemView);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements p55.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps5 a;

        public e(ps5 ps5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ps5Var;
        }

        @Override // com.baidu.tieba.p55.g
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                hs5.b(" ----onListPullRefresh---- auto=" + z);
                this.a.o(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;
        public ms5 b;
        public ls5 c;
        public gs5.c d;
        public List<ci> e;
        public av4<fw4> f;
        public ir5 g;
        public int h;
        public int i;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = 2;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.d == null) {
                this.d = new gs5.c();
            }
        }

        public f a(List<ci> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                this.e = list;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f b(gs5.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.d = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public ps5 c(TbPageContext<?> tbPageContext) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
                this.a = tbPageContext;
                d();
                return new ps5(this, null);
            }
            return (ps5) invokeL.objValue;
        }

        public f e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.h = i;
                return this;
            }
            return (f) invokeI.objValue;
        }

        public f f(ls5 ls5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ls5Var)) == null) {
                this.c = ls5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f g(av4<fw4> av4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, av4Var)) == null) {
                this.f = av4Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(ir5 ir5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ir5Var)) == null) {
                this.g = ir5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(ms5 ms5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ms5Var)) == null) {
                this.b = ms5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    public ps5(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        TbPageContext<?> tbPageContext = fVar.a;
        this.f = tbPageContext;
        this.k = fVar.c;
        this.l = fVar.b;
        this.e = tbPageContext.getUniqueId();
        this.b = new pq5();
        t(fVar.d);
        s(fVar.i);
        sq5 sq5Var = new sq5(this.f, this.h);
        this.g = sq5Var;
        sq5Var.a(fVar.e);
        this.g.k(this.h);
        this.g.i(fVar.f);
        this.g.f(fVar.g);
        this.g.e(fVar.h);
    }

    public final void t(gs5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) {
            this.i = new BdSwipeRefreshLayout(p());
            this.h = new BdTypeRecyclerView(p());
            L();
            this.i.addView(this.h);
            this.h.setLayoutManager(new LinearLayoutManager(p()));
            this.h.setFadingEdgeLength(0);
            this.h.setVerticalScrollBarEnabled(false);
            this.h.setOverScrollMode(2);
            this.h.setOnSrollToBottomListener(this.p);
            this.h.addOnScrollListener(this.q);
            this.h.setRecyclerListener(this.r);
            if (this.k == null) {
                cVar.h = this.o;
                this.k = new qs5(this.f, this.h, cVar);
            }
            q55 q55Var = new q55(this.f);
            this.j = q55Var;
            q55Var.a(this.s);
            this.i.setProgressView(this.j);
            xr5 xr5Var = new xr5(this.h);
            this.d = xr5Var;
            xr5Var.e(this.e);
        }
    }

    public /* synthetic */ ps5(f fVar, a aVar) {
        this(fVar);
    }

    public final String q(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getResources().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final void B(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        wda wdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (bdTypeRecyclerView = this.h) != null && (wdaVar = this.n) != null) {
            wdaVar.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.h.getLastVisiblePosition(), z, true);
        }
    }

    public final void C(or5 or5Var) {
        List<pi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, or5Var) == null) && or5Var != null && (list = or5Var.a) != null) {
            J(list);
        }
    }

    public void D(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (bdSwipeRefreshLayout = this.i) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void J(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            hs5.b(" ----submitDataList--size =" + ListUtils.getCount(list));
            sq5 sq5Var = this.g;
            if (sq5Var != null) {
                sq5Var.h(list);
            }
        }
    }

    @Override // com.baidu.tieba.ks5
    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            wda wdaVar = this.n;
            if (wdaVar != null) {
                wdaVar.u(bdUniqueId);
            }
            xr5 xr5Var = this.d;
            if (xr5Var != null) {
                xr5Var.e(bdUniqueId);
            }
            sq5 sq5Var = this.g;
            if (sq5Var != null) {
                sq5Var.j(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.tieba.ks5
    public void i(rq5 rq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, rq5Var) == null) {
            this.c = rq5Var;
            rq5Var.b(this.b);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            hs5.b(" ----callRefresh---- ");
            if (z) {
                if (u()) {
                    this.c.r();
                } else {
                    K();
                    D(true);
                }
            }
            this.c.f(true);
        }
    }

    @Override // com.baidu.tieba.os5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            ls5 ls5Var = this.k;
            if (ls5Var != null) {
                ls5Var.onChangeSkinType(i);
            }
            q55 q55Var = this.j;
            if (q55Var != null) {
                q55Var.D(i);
            }
            ms5<P> ms5Var = this.l;
            if (ms5Var != null) {
                ms5Var.onChangeSkinType(i);
            }
            L();
            v();
        }
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (i == 1 || i == 0 || i == 2) {
                wda wdaVar = new wda(this.f, this.h);
                this.n = wdaVar;
                wdaVar.p(i);
                this.n.u(this.e);
            }
        }
    }

    public void z(List<ci> list) {
        sq5 sq5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, list) == null) && (sq5Var = this.g) != null) {
            sq5Var.g(list);
            this.g.k(this.h);
        }
    }

    public void A() {
        wda wdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (wdaVar = this.n) != null) {
            wdaVar.r(true);
            B(false);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!r()) {
                I();
            } else {
                G();
            }
        }
    }

    public final void G() {
        ls5 ls5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ls5Var = this.k) != null) {
            ls5Var.a();
        }
    }

    public final void H() {
        ls5 ls5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (ls5Var = this.k) != null) {
            ls5Var.b();
        }
    }

    public final void I() {
        ls5 ls5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (ls5Var = this.k) != null) {
            ls5Var.c();
        }
    }

    public void K() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdTypeRecyclerView = this.h) != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.h.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0202);
        }
    }

    @Override // com.baidu.tieba.ks5
    public void d() {
        wda wdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (wdaVar = this.n) != null) {
            wdaVar.h();
        }
    }

    @Override // com.baidu.tieba.ks5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            x();
        }
    }

    @Override // com.baidu.tieba.ks5
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            A();
        }
    }

    @Override // com.baidu.tieba.ks5
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            hs5.b(" ----sendReq---- ");
            o(true);
        }
    }

    @Override // com.baidu.tieba.js5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public Activity p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.f.getPageActivity();
        }
        return (Activity) invokeV.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.b.c();
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return ListUtils.isEmpty(this.h.getData());
        }
        return invokeV.booleanValue;
    }

    public void v() {
        sq5 sq5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (sq5Var = this.g) != null) {
            sq5Var.d();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            y();
        }
    }

    public final void y() {
        wda wdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (wdaVar = this.n) != null) {
            wdaVar.z();
            this.n.r(false);
        }
    }

    public final void F(P p) {
        ms5<P> ms5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, p) == null) && this.h != null && (ms5Var = this.l) != null && ms5Var.getView() != null) {
            if (this.l.onBindDataToView(p) != null) {
                this.h.setHeaderView(this.l.getView());
            } else {
                this.h.removeHeaderView(this.l.getView());
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            hs5.b(" ----loadMore---- ");
            if (r()) {
                H();
                if (u()) {
                    this.c.r();
                } else {
                    this.c.s();
                }
                this.c.g();
                return;
            }
            if (u()) {
                this.c.r();
            } else {
                this.c.s();
            }
            G();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ns5
    /* renamed from: w */
    public or5 onBindDataToView(P p) {
        InterceptResult invokeL;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, p)) == null) {
            hs5.b(" ----onBindDataToView---- ");
            D(false);
            if (p != null && p.getErrorCode() == 0) {
                hs5.b(" ----showContent---- ");
                or5 d2 = this.d.d(this.c.e(), this.c.d());
                if (d2 != null && !ListUtils.isEmpty(d2.a)) {
                    this.c.s();
                    F(p);
                    E();
                    C(d2);
                    B(false);
                } else {
                    this.c.p(p.getErrorMsg());
                }
                return d2;
            }
            hs5.b(" ----showError---- ");
            if (!ListUtils.isEmpty(this.h.getData())) {
                E();
                return null;
            }
            rq5<Q, P> rq5Var = this.c;
            if (p != null) {
                q = p.getErrorMsg();
            } else {
                q = q(R.string.obfuscated_res_0x7f0f06bc, new Object[0]);
            }
            rq5Var.q(q);
            return null;
        }
        return (or5) invokeL.objValue;
    }
}
