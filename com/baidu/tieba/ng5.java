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
import com.baidu.tieba.eg5;
import com.baidu.tieba.nf5;
import com.baidu.tieba.pf5;
import com.baidu.tieba.yx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ng5<Q extends pf5, P extends nf5> extends ig5<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ne5 b;
    public pe5<Q, P> c;
    public vf5 d;
    public BdUniqueId e;
    public TbPageContext f;
    public qe5 g;
    public BdTypeRecyclerView h;
    public BdSwipeRefreshLayout i;
    public zx4 j;
    public jg5 k;
    public kg5<P> l;
    public BdListView.p m;
    public qa8 n;
    public View.OnClickListener o;
    public final BdListView.p p;
    public final RecyclerView.OnScrollListener q;
    public final RecyclerView.RecyclerListener r;
    public final yx4.g s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng5 a;

        public a(ng5 ng5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                fg5.b(" ----LoadMoreClickListener----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                this.a.o();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng5 a;

        public b(ng5 ng5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fg5.b(" ----onScrollToBottom----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                if (this.a.m != null) {
                    this.a.m.onScrollToBottom();
                }
                this.a.o();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ ng5 b;

        public c(ng5 ng5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ng5Var;
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

    /* loaded from: classes5.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng5 a;

        public d(ng5 ng5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || viewHolder.itemView == null || this.a.n == null) {
                return;
            }
            this.a.n.k(viewHolder.itemView);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements yx4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng5 a;

        public e(ng5 ng5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng5Var;
        }

        @Override // com.baidu.tieba.yx4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                fg5.b(" ----onListPullRefresh---- auto=" + z);
                this.a.p(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;
        public kg5 b;
        public jg5 c;
        public eg5.c d;
        public List<qn> e;
        public qp4<yq4> f;
        public gf5 g;
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

        public f a(List<qn> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                this.e = list;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f b(eg5.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.d = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public ng5 c(TbPageContext<?> tbPageContext) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
                this.a = tbPageContext;
                d();
                return new ng5(this, null);
            }
            return (ng5) invokeL.objValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.d == null) {
                this.d = new eg5.c();
            }
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

        public f f(jg5 jg5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jg5Var)) == null) {
                this.c = jg5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f g(qp4<yq4> qp4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, qp4Var)) == null) {
                this.f = qp4Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(gf5 gf5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gf5Var)) == null) {
                this.g = gf5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(kg5 kg5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kg5Var)) == null) {
                this.b = kg5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    public /* synthetic */ ng5(f fVar, a aVar) {
        this(fVar);
    }

    public void A() {
        qa8 qa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (qa8Var = this.n) == null) {
            return;
        }
        qa8Var.r(true);
        B(false);
    }

    public final void B(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        qa8 qa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdTypeRecyclerView = this.h) == null || (qa8Var = this.n) == null) {
            return;
        }
        qa8Var.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.h.getLastVisiblePosition(), z, true);
    }

    public final void C(mf5 mf5Var) {
        List<Cdo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mf5Var) == null) || mf5Var == null || (list = mf5Var.a) == null) {
            return;
        }
        J(list);
    }

    public void D(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (bdSwipeRefreshLayout = this.i) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
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

    public final void F(P p) {
        kg5<P> kg5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, p) == null) || this.h == null || (kg5Var = this.l) == null || kg5Var.getView() == null) {
            return;
        }
        if (this.l.a(p) != null) {
            this.h.setHeaderView(this.l.getView());
        } else {
            this.h.removeHeaderView(this.l.getView());
        }
    }

    public final void G() {
        jg5 jg5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (jg5Var = this.k) == null) {
            return;
        }
        jg5Var.a();
    }

    public final void H() {
        jg5 jg5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (jg5Var = this.k) == null) {
            return;
        }
        jg5Var.b();
    }

    public final void I() {
        jg5 jg5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (jg5Var = this.k) == null) {
            return;
        }
        jg5Var.c();
    }

    public void J(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            fg5.b(" ----submitDataList--size =" + ListUtils.getCount(list));
            qe5 qe5Var = this.g;
            if (qe5Var != null) {
                qe5Var.h(list);
            }
        }
    }

    public void K() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdTypeRecyclerView = this.h) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.h.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0202);
        }
    }

    @Override // com.baidu.tieba.ig5
    public void e() {
        qa8 qa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (qa8Var = this.n) == null) {
            return;
        }
        qa8Var.h();
    }

    @Override // com.baidu.tieba.ig5
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            x();
        }
    }

    @Override // com.baidu.tieba.ig5
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            A();
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f.getPageActivity() : (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hg5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ig5
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            fg5.b(" ----sendReq---- ");
            p(true);
        }
    }

    @Override // com.baidu.tieba.ig5
    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            qa8 qa8Var = this.n;
            if (qa8Var != null) {
                qa8Var.u(bdUniqueId);
            }
            vf5 vf5Var = this.d;
            if (vf5Var != null) {
                vf5Var.e(bdUniqueId);
            }
            qe5 qe5Var = this.g;
            if (qe5Var != null) {
                qe5Var.j(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.tieba.ig5
    public void j(pe5 pe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, pe5Var) == null) {
            this.c = pe5Var;
            pe5Var.b(this.b);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            fg5.b(" ----loadMore---- ");
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

    @Override // com.baidu.tieba.mg5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            jg5 jg5Var = this.k;
            if (jg5Var != null) {
                jg5Var.onChangeSkinType(i);
            }
            zx4 zx4Var = this.j;
            if (zx4Var != null) {
                zx4Var.H(i);
            }
            kg5<P> kg5Var = this.l;
            if (kg5Var != null) {
                kg5Var.onChangeSkinType(i);
            }
            L();
            v();
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            fg5.b(" ----callRefresh---- ");
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

    public final String q(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i, objArr)) == null) ? TbadkCoreApplication.getInst().getResources().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.b.c() : invokeV.booleanValue;
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (i == 1 || i == 0 || i == 2) {
                qa8 qa8Var = new qa8(this.f, this.h);
                this.n = qa8Var;
                qa8Var.p(i);
                this.n.u(this.e);
            }
        }
    }

    public final void t(eg5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) {
            this.i = new BdSwipeRefreshLayout(getActivity());
            this.h = new BdTypeRecyclerView(getActivity());
            L();
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
                this.k = new og5(this.f, this.h, cVar);
            }
            zx4 zx4Var = new zx4(this.f);
            this.j = zx4Var;
            zx4Var.f(this.s);
            this.i.setProgressView(this.j);
            vf5 vf5Var = new vf5(this.h);
            this.d = vf5Var;
            vf5Var.e(this.e);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? ListUtils.isEmpty(this.h.getData()) : invokeV.booleanValue;
    }

    public void v() {
        qe5 qe5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (qe5Var = this.g) == null) {
            return;
        }
        qe5Var.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lg5
    /* renamed from: w */
    public mf5 a(P p) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, p)) == null) {
            fg5.b(" ----onBindDataToView---- ");
            D(false);
            if (p != null && p.getErrorCode() == 0) {
                fg5.b(" ----showContent---- ");
                mf5 d2 = this.d.d(this.c.e(), this.c.d());
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
            fg5.b(" ----showError---- ");
            if (!ListUtils.isEmpty(this.h.getData())) {
                E();
                return null;
            }
            this.c.q(p != null ? p.getErrorMsg() : q(R.string.error_unkown_try_again, new Object[0]));
            return null;
        }
        return (mf5) invokeL.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            y();
        }
    }

    public final void y() {
        qa8 qa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (qa8Var = this.n) == null) {
            return;
        }
        qa8Var.y();
        this.n.r(false);
    }

    public void z(List<qn> list) {
        qe5 qe5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, list) == null) || (qe5Var = this.g) == null) {
            return;
        }
        qe5Var.g(list);
        this.g.k(this.h);
    }

    public ng5(f fVar) {
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
        this.b = new ne5();
        t(fVar.d);
        s(fVar.i);
        qe5 qe5Var = new qe5(this.f, this.h);
        this.g = qe5Var;
        qe5Var.a(fVar.e);
        this.g.k(this.h);
        this.g.i(fVar.f);
        this.g.f(fVar.g);
        this.g.e(fVar.h);
    }
}
