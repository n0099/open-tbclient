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
import com.baidu.tieba.hu5;
import com.baidu.tieba.i95;
import com.baidu.tieba.qt5;
import com.baidu.tieba.st5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class qu5<Q extends st5, P extends qt5> extends lu5<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qs5 b;
    public ss5<Q, P> c;
    public yt5 d;
    public BdUniqueId e;
    public TbPageContext f;
    public ts5 g;
    public BdTypeRecyclerView h;
    public BdSwipeRefreshLayout i;
    public j95 j;
    public mu5 k;
    public nu5<P> l;
    public BdListView.p m;
    public jt9 n;
    public View.OnClickListener o;
    public final BdListView.p p;
    public final RecyclerView.OnScrollListener q;
    public final RecyclerView.RecyclerListener r;
    public final i95.g s;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu5 a;

        public a(qu5 qu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                iu5.b(" ----LoadMoreClickListener----");
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
        public final /* synthetic */ qu5 a;

        public b(qu5 qu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                iu5.b(" ----onScrollToBottom----");
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
        public final /* synthetic */ qu5 b;

        public c(qu5 qu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qu5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                this.b.A(this.a);
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
        public final /* synthetic */ qu5 a;

        public d(qu5 qu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu5Var;
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
    public class e implements i95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu5 a;

        public e(qu5 qu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu5Var;
        }

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                iu5.b(" ----onListPullRefresh---- auto=" + z);
                this.a.o(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;
        public nu5 b;
        public mu5 c;
        public hu5.c d;
        public List<lm> e;
        public mz4<q05> f;
        public jt5 g;
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
                this.d = new hu5.c();
            }
        }

        public f a(List<lm> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                this.e = list;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f b(hu5.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.d = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public qu5 c(TbPageContext<?> tbPageContext) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
                this.a = tbPageContext;
                d();
                return new qu5(this, null);
            }
            return (qu5) invokeL.objValue;
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

        public f f(mu5 mu5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mu5Var)) == null) {
                this.c = mu5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f g(mz4<q05> mz4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mz4Var)) == null) {
                this.f = mz4Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(jt5 jt5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jt5Var)) == null) {
                this.g = jt5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(nu5 nu5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nu5Var)) == null) {
                this.b = nu5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    public qu5(f fVar) {
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
        this.b = new qs5();
        s(fVar.d);
        r(fVar.i);
        ts5 ts5Var = new ts5(this.f, this.h);
        this.g = ts5Var;
        ts5Var.a(fVar.e);
        this.g.k(this.h);
        this.g.i(fVar.f);
        this.g.f(fVar.g);
        this.g.e(fVar.h);
    }

    public final void s(hu5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.i = new BdSwipeRefreshLayout(getActivity());
            this.h = new BdTypeRecyclerView(getActivity());
            K();
            this.i.addView(this.h);
            this.h.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.h.setFadingEdgeLength(0);
            this.h.setVerticalScrollBarEnabled(false);
            this.h.setOverScrollMode(2);
            this.h.setOnSrollToBottomListener(this.p);
            this.h.addOnScrollListener(this.q);
            this.h.setRecyclerListener(this.r);
            if (this.k == null) {
                cVar.h = this.o;
                this.k = new ru5(this.f, this.h, cVar);
            }
            j95 j95Var = new j95(this.f);
            this.j = j95Var;
            j95Var.a(this.s);
            this.i.setProgressView(this.j);
            yt5 yt5Var = new yt5(this.h);
            this.d = yt5Var;
            yt5Var.e(this.e);
        }
    }

    public /* synthetic */ qu5(f fVar, a aVar) {
        this(fVar);
    }

    public final String p(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048599, this, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getResources().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final void A(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        jt9 jt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (bdTypeRecyclerView = this.h) != null && (jt9Var = this.n) != null) {
            jt9Var.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.h.getLastVisiblePosition(), z, true);
        }
    }

    public final void B(pt5 pt5Var) {
        List<ym> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pt5Var) == null) && pt5Var != null && (list = pt5Var.a) != null) {
            I(list);
        }
    }

    public void C(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (bdSwipeRefreshLayout = this.i) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void I(List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            iu5.b(" ----submitDataList--size =" + ListUtils.getCount(list));
            ts5 ts5Var = this.g;
            if (ts5Var != null) {
                ts5Var.h(list);
            }
        }
    }

    @Override // com.baidu.tieba.lu5
    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            jt9 jt9Var = this.n;
            if (jt9Var != null) {
                jt9Var.u(bdUniqueId);
            }
            yt5 yt5Var = this.d;
            if (yt5Var != null) {
                yt5Var.e(bdUniqueId);
            }
            ts5 ts5Var = this.g;
            if (ts5Var != null) {
                ts5Var.j(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.tieba.lu5
    public void i(ss5 ss5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ss5Var) == null) {
            this.c = ss5Var;
            ss5Var.b(this.b);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            iu5.b(" ----callRefresh---- ");
            if (z) {
                if (t()) {
                    this.c.r();
                } else {
                    J();
                    C(true);
                }
            }
            this.c.f(true);
        }
    }

    @Override // com.baidu.tieba.pu5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            mu5 mu5Var = this.k;
            if (mu5Var != null) {
                mu5Var.onChangeSkinType(i);
            }
            j95 j95Var = this.j;
            if (j95Var != null) {
                j95Var.C(i);
            }
            nu5<P> nu5Var = this.l;
            if (nu5Var != null) {
                nu5Var.onChangeSkinType(i);
            }
            K();
            u();
        }
    }

    public final void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            if (i == 1 || i == 0 || i == 2) {
                jt9 jt9Var = new jt9(this.f, this.h);
                this.n = jt9Var;
                jt9Var.p(i);
                this.n.u(this.e);
            }
        }
    }

    public void y(List<lm> list) {
        ts5 ts5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, list) == null) && (ts5Var = this.g) != null) {
            ts5Var.g(list);
            this.g.k(this.h);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!q()) {
                H();
            } else {
                F();
            }
        }
    }

    public final void F() {
        mu5 mu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (mu5Var = this.k) != null) {
            mu5Var.a();
        }
    }

    public final void G() {
        mu5 mu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (mu5Var = this.k) != null) {
            mu5Var.b();
        }
    }

    public final void H() {
        mu5 mu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (mu5Var = this.k) != null) {
            mu5Var.c();
        }
    }

    public void J() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (bdTypeRecyclerView = this.h) != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.h.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0202);
        }
    }

    @Override // com.baidu.tieba.lu5
    public void d() {
        jt9 jt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (jt9Var = this.n) != null) {
            jt9Var.h();
        }
    }

    @Override // com.baidu.tieba.lu5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            w();
        }
    }

    @Override // com.baidu.tieba.lu5
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z();
        }
    }

    @Override // com.baidu.tieba.lu5
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            iu5.b(" ----sendReq---- ");
            o(true);
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f.getPageActivity();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ku5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.b.c();
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return ListUtils.isEmpty(this.h.getData());
        }
        return invokeV.booleanValue;
    }

    public void u() {
        ts5 ts5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (ts5Var = this.g) != null) {
            ts5Var.d();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            x();
        }
    }

    public final void x() {
        jt9 jt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (jt9Var = this.n) != null) {
            jt9Var.z();
            this.n.r(false);
        }
    }

    public void z() {
        jt9 jt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (jt9Var = this.n) != null) {
            jt9Var.r(true);
            A(false);
        }
    }

    public final void E(P p) {
        nu5<P> nu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, p) == null) && this.h != null && (nu5Var = this.l) != null && nu5Var.getView() != null) {
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
            iu5.b(" ----loadMore---- ");
            if (q()) {
                G();
                if (t()) {
                    this.c.r();
                } else {
                    this.c.s();
                }
                this.c.g();
                return;
            }
            if (t()) {
                this.c.r();
            } else {
                this.c.s();
            }
            F();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ou5
    /* renamed from: v */
    public pt5 onBindDataToView(P p) {
        InterceptResult invokeL;
        String p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, p)) == null) {
            iu5.b(" ----onBindDataToView---- ");
            C(false);
            if (p != null && p.getErrorCode() == 0) {
                iu5.b(" ----showContent---- ");
                pt5 d2 = this.d.d(this.c.e(), this.c.d());
                if (d2 != null && !ListUtils.isEmpty(d2.a)) {
                    this.c.s();
                    E(p);
                    D();
                    B(d2);
                    A(false);
                } else {
                    this.c.p(p.getErrorMsg());
                }
                return d2;
            }
            iu5.b(" ----showError---- ");
            if (!ListUtils.isEmpty(this.h.getData())) {
                D();
                return null;
            }
            ss5<Q, P> ss5Var = this.c;
            if (p != null) {
                p2 = p.getErrorMsg();
            } else {
                p2 = p(R.string.obfuscated_res_0x7f0f06a2, new Object[0]);
            }
            ss5Var.q(p2);
            return null;
        }
        return (pt5) invokeL.objValue;
    }
}
