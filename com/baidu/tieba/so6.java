package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class so6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public BdTypeRecyclerView b;
    public kh6 c;
    public List<qn> d;
    public xo6 e;
    public ep6 f;
    public zo6 g;
    public dp6 h;
    public yo6 i;
    public cp6 j;
    public ap6 k;
    public bp6 l;
    public ll6 m;
    public xk6 n;
    public il6 o;
    public fl6 p;
    public wk6 q;
    public gl6 r;
    public wo6 s;

    /* loaded from: classes5.dex */
    public class a extends i26<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ so6 b;

        public a(so6 so6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {so6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = so6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends i26<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ so6 b;

        public b(so6 so6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {so6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = so6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends i26<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ so6 b;

        public c(so6 so6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {so6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = so6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    public so6(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new LinkedList();
        c(frsItemTabFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
    }

    public final void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new wy4(4, threadData.getPositionInFrsItemTab(), 1)));
    }

    public void c(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsItemTabFragment, bdTypeRecyclerView) == null) {
            this.a = frsItemTabFragment;
            this.g = new zo6(frsItemTabFragment.getPageContext(), op6.b, frsItemTabFragment.getUniqueId());
            this.h = new dp6(frsItemTabFragment.getPageContext(), pp6.b, frsItemTabFragment.getUniqueId());
            this.f = new ep6(frsItemTabFragment.getPageContext(), qp6.b, frsItemTabFragment.getUniqueId());
            this.e = new xo6(frsItemTabFragment.getPageContext(), mp6.b, frsItemTabFragment.getUniqueId());
            this.i = new yo6(frsItemTabFragment.getPageContext(), np6.c, frsItemTabFragment.getUniqueId());
            this.j = new cp6(frsItemTabFragment.getPageContext(), lp6.c, frsItemTabFragment.getUniqueId());
            this.k = new ap6(frsItemTabFragment.getPageContext(), lp6.d, frsItemTabFragment.getUniqueId());
            this.l = new bp6(frsItemTabFragment.getPageContext(), lp6.e, frsItemTabFragment.getUniqueId());
            ll6 ll6Var = new ll6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_USER_NORMAL, frsItemTabFragment.getUniqueId());
            this.m = ll6Var;
            ll6Var.z(true);
            this.m.setFrom(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK);
            xk6 xk6Var = new xk6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsItemTabFragment.getUniqueId());
            this.n = xk6Var;
            xk6Var.B(new a(this));
            il6 il6Var = new il6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsItemTabFragment.getUniqueId());
            this.o = il6Var;
            il6Var.B(new b(this));
            fl6 fl6Var = new fl6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsItemTabFragment.getUniqueId());
            this.p = fl6Var;
            fl6Var.B(new c(this));
            this.q = new wk6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, frsItemTabFragment.getUniqueId());
            this.r = new gl6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsItemTabFragment.getUniqueId());
            this.c = new kh6(frsItemTabFragment.getPageContext(), lh6.b);
            this.s = new wo6(frsItemTabFragment.getPageContext().getPageActivity(), kp6.c);
            this.d.add(this.i);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.d.add(this.j);
            this.d.add(this.k);
            this.d.add(this.l);
            this.d.add(this.m);
            this.d.add(this.n);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.r);
            this.d.add(this.c);
            this.d.add(this.s);
            for (qn qnVar : this.d) {
                if (qnVar instanceof dh6) {
                    ((dh6) qnVar).A(bdTypeRecyclerView);
                }
                if (qnVar instanceof g26) {
                    ((g26) qnVar).p(frsItemTabFragment.a);
                }
            }
            i();
            bdTypeRecyclerView.a(this.d);
            j();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e() {
        yo6 yo6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (yo6Var = this.i) == null) {
            return;
        }
        yo6Var.notifyDataSetChanged();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (qn qnVar : this.d) {
                if (qnVar instanceof dh6) {
                    ((dh6) qnVar).v();
                } else if (qnVar instanceof sd8) {
                    ((sd8) qnVar).onDestroy();
                }
            }
        }
    }

    public void g(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            i();
            this.b.setData(arrayList);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        wo6 wo6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (wo6Var = this.s) == null) {
            return;
        }
        wo6Var.u(bdUniqueId);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (qn qnVar : this.d) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a == null || ListUtils.isEmpty(this.d)) {
            return;
        }
        for (qn qnVar : this.d) {
            if (qnVar instanceof ds6) {
                ds6 ds6Var = (ds6) qnVar;
                if (ds6Var.i() != null) {
                    ds6Var.i().a = this.a.f;
                    ds6Var.i().c = this.a.d;
                    ds6Var.i().d = this.a.e;
                    ds6Var.i().e = this.a.a;
                    ds6Var.i().h = this.a.b;
                }
            }
        }
    }
}
