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
import com.baidu.tieba.ip5;
import com.baidu.tieba.kp5;
import com.baidu.tieba.l45;
import com.baidu.tieba.zp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class iq5<Q extends kp5, P extends ip5> extends dq5<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public io5 b;
    public ko5<Q, P> c;
    public qp5 d;
    public BdUniqueId e;
    public TbPageContext f;
    public lo5 g;
    public BdTypeRecyclerView h;
    public BdSwipeRefreshLayout i;
    public m45 j;
    public eq5 k;
    public fq5<P> l;
    public BdListView.p m;
    public qv9 n;
    public View.OnClickListener o;
    public final BdListView.p p;
    public final RecyclerView.OnScrollListener q;
    public final RecyclerView.RecyclerListener r;
    public final l45.g s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iq5 a;

        public a(iq5 iq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iq5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aq5.b(" ----LoadMoreClickListener----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                this.a.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iq5 a;

        public b(iq5 iq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iq5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                aq5.b(" ----onScrollToBottom----");
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

    /* loaded from: classes6.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ iq5 b;

        public c(iq5 iq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iq5Var;
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

    /* loaded from: classes6.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iq5 a;

        public d(iq5 iq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iq5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && viewHolder != null && viewHolder.itemView != null && this.a.n != null) {
                this.a.n.k(viewHolder.itemView);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements l45.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iq5 a;

        public e(iq5 iq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iq5Var;
        }

        @Override // com.baidu.tieba.l45.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                aq5.b(" ----onListPullRefresh---- auto=" + z);
                this.a.o(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;
        public fq5 b;
        public eq5 c;
        public zp5.c d;
        public List<lh> e;
        public eu4<jv4> f;
        public bp5 g;
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
                this.d = new zp5.c();
            }
        }

        public f a(List<lh> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                this.e = list;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f b(zp5.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.d = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public iq5 c(TbPageContext<?> tbPageContext) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
                this.a = tbPageContext;
                d();
                return new iq5(this, null);
            }
            return (iq5) invokeL.objValue;
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

        public f f(eq5 eq5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eq5Var)) == null) {
                this.c = eq5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f g(eu4<jv4> eu4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eu4Var)) == null) {
                this.f = eu4Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(bp5 bp5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bp5Var)) == null) {
                this.g = bp5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(fq5 fq5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fq5Var)) == null) {
                this.b = fq5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    public iq5(f fVar) {
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
        this.b = new io5();
        t(fVar.d);
        s(fVar.i);
        lo5 lo5Var = new lo5(this.f, this.h);
        this.g = lo5Var;
        lo5Var.a(fVar.e);
        this.g.k(this.h);
        this.g.i(fVar.f);
        this.g.f(fVar.g);
        this.g.e(fVar.h);
    }

    public final void t(zp5.c cVar) {
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
                this.k = new jq5(this.f, this.h, cVar);
            }
            m45 m45Var = new m45(this.f);
            this.j = m45Var;
            m45Var.a(this.s);
            this.i.setProgressView(this.j);
            qp5 qp5Var = new qp5(this.h);
            this.d = qp5Var;
            qp5Var.e(this.e);
        }
    }

    public /* synthetic */ iq5(f fVar, a aVar) {
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
        qv9 qv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (bdTypeRecyclerView = this.h) != null && (qv9Var = this.n) != null) {
            qv9Var.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.h.getLastVisiblePosition(), z, true);
        }
    }

    public final void C(hp5 hp5Var) {
        List<yh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hp5Var) == null) && hp5Var != null && (list = hp5Var.a) != null) {
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

    public void J(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            aq5.b(" ----submitDataList--size =" + ListUtils.getCount(list));
            lo5 lo5Var = this.g;
            if (lo5Var != null) {
                lo5Var.h(list);
            }
        }
    }

    @Override // com.baidu.tieba.dq5
    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            qv9 qv9Var = this.n;
            if (qv9Var != null) {
                qv9Var.u(bdUniqueId);
            }
            qp5 qp5Var = this.d;
            if (qp5Var != null) {
                qp5Var.e(bdUniqueId);
            }
            lo5 lo5Var = this.g;
            if (lo5Var != null) {
                lo5Var.j(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.tieba.dq5
    public void i(ko5 ko5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ko5Var) == null) {
            this.c = ko5Var;
            ko5Var.b(this.b);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            aq5.b(" ----callRefresh---- ");
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

    @Override // com.baidu.tieba.hq5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            eq5 eq5Var = this.k;
            if (eq5Var != null) {
                eq5Var.onChangeSkinType(i);
            }
            m45 m45Var = this.j;
            if (m45Var != null) {
                m45Var.D(i);
            }
            fq5<P> fq5Var = this.l;
            if (fq5Var != null) {
                fq5Var.onChangeSkinType(i);
            }
            L();
            v();
        }
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (i == 1 || i == 0 || i == 2) {
                qv9 qv9Var = new qv9(this.f, this.h);
                this.n = qv9Var;
                qv9Var.p(i);
                this.n.u(this.e);
            }
        }
    }

    public void z(List<lh> list) {
        lo5 lo5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, list) == null) && (lo5Var = this.g) != null) {
            lo5Var.g(list);
            this.g.k(this.h);
        }
    }

    public void A() {
        qv9 qv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (qv9Var = this.n) != null) {
            qv9Var.r(true);
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
        eq5 eq5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (eq5Var = this.k) != null) {
            eq5Var.a();
        }
    }

    public final void H() {
        eq5 eq5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (eq5Var = this.k) != null) {
            eq5Var.b();
        }
    }

    public final void I() {
        eq5 eq5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (eq5Var = this.k) != null) {
            eq5Var.c();
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

    @Override // com.baidu.tieba.dq5
    public void d() {
        qv9 qv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (qv9Var = this.n) != null) {
            qv9Var.h();
        }
    }

    @Override // com.baidu.tieba.dq5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            x();
        }
    }

    @Override // com.baidu.tieba.dq5
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            A();
        }
    }

    @Override // com.baidu.tieba.dq5
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            aq5.b(" ----sendReq---- ");
            o(true);
        }
    }

    @Override // com.baidu.tieba.cq5
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
        lo5 lo5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (lo5Var = this.g) != null) {
            lo5Var.d();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            y();
        }
    }

    public final void y() {
        qv9 qv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (qv9Var = this.n) != null) {
            qv9Var.z();
            this.n.r(false);
        }
    }

    public final void F(P p) {
        fq5<P> fq5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, p) == null) && this.h != null && (fq5Var = this.l) != null && fq5Var.getView() != null) {
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
            aq5.b(" ----loadMore---- ");
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
    @Override // com.baidu.tieba.gq5
    /* renamed from: w */
    public hp5 onBindDataToView(P p) {
        InterceptResult invokeL;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, p)) == null) {
            aq5.b(" ----onBindDataToView---- ");
            D(false);
            if (p != null && p.getErrorCode() == 0) {
                aq5.b(" ----showContent---- ");
                hp5 d2 = this.d.d(this.c.e(), this.c.d());
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
            aq5.b(" ----showError---- ");
            if (!ListUtils.isEmpty(this.h.getData())) {
                E();
                return null;
            }
            ko5<Q, P> ko5Var = this.c;
            if (p != null) {
                q = p.getErrorMsg();
            } else {
                q = q(R.string.obfuscated_res_0x7f0f06b2, new Object[0]);
            }
            ko5Var.q(q);
            return null;
        }
        return (hp5) invokeL.objValue;
    }
}
