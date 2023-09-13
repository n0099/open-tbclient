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
/* loaded from: classes6.dex */
public class lq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public BdTypeRecyclerView b;
    public mi7 c;
    public List<pm> d;
    public qq7 e;
    public xq7 f;
    public sq7 g;
    public wq7 h;
    public rq7 i;
    public vq7 j;
    public tq7 k;
    public uq7 l;
    public xm7 m;
    public jm7 n;
    public um7 o;
    public rm7 p;
    public im7 q;
    public sm7 r;
    public pq7 s;

    /* loaded from: classes6.dex */
    public class a extends mp6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq7 b;

        public a(lq7 lq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends mp6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq7 b;

        public b(lq7 lq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends mp6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq7 b;

        public c(lq7 lq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    public lq7(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if ((interceptable != null && interceptable.invokeL(1048576, this, threadData) != null) || threadData == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new va5(4, threadData.getPositionInFrsItemTab(), 1)));
    }

    public void g(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            i();
            this.b.setData(arrayList);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        pq7 pq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) && (pq7Var = this.s) != null) {
            pq7Var.u(bdUniqueId);
        }
    }

    public void c(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsItemTabFragment, bdTypeRecyclerView) == null) {
            this.a = frsItemTabFragment;
            this.g = new sq7(frsItemTabFragment.getPageContext(), hr7.b, frsItemTabFragment.getUniqueId());
            this.h = new wq7(frsItemTabFragment.getPageContext(), ir7.b, frsItemTabFragment.getUniqueId());
            this.f = new xq7(frsItemTabFragment.getPageContext(), jr7.b, frsItemTabFragment.getUniqueId());
            this.e = new qq7(frsItemTabFragment.getPageContext(), fr7.b, frsItemTabFragment.getUniqueId());
            this.i = new rq7(frsItemTabFragment.getPageContext(), gr7.c, frsItemTabFragment.getUniqueId());
            this.j = new vq7(frsItemTabFragment.getPageContext(), er7.c, frsItemTabFragment.getUniqueId());
            this.k = new tq7(frsItemTabFragment.getPageContext(), er7.d, frsItemTabFragment.getUniqueId());
            this.l = new uq7(frsItemTabFragment.getPageContext(), er7.e, frsItemTabFragment.getUniqueId());
            xm7 xm7Var = new xm7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_USER_NORMAL, frsItemTabFragment.getUniqueId());
            this.m = xm7Var;
            xm7Var.B(true);
            this.m.setFrom(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK);
            jm7 jm7Var = new jm7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsItemTabFragment.getUniqueId());
            this.n = jm7Var;
            jm7Var.D(new a(this));
            um7 um7Var = new um7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsItemTabFragment.getUniqueId());
            this.o = um7Var;
            um7Var.D(new b(this));
            rm7 rm7Var = new rm7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsItemTabFragment.getUniqueId());
            this.p = rm7Var;
            rm7Var.D(new c(this));
            this.q = new im7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, frsItemTabFragment.getUniqueId());
            this.r = new sm7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsItemTabFragment.getUniqueId());
            this.c = new mi7(frsItemTabFragment.getPageContext(), ni7.b);
            this.s = new pq7(frsItemTabFragment.getPageContext().getPageActivity(), dr7.c);
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
            for (pm pmVar : this.d) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).C(bdTypeRecyclerView);
                }
                if (pmVar instanceof kp6) {
                    ((kp6) pmVar).p(3);
                }
            }
            i();
            bdTypeRecyclerView.addAdapters(this.d);
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
        rq7 rq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (rq7Var = this.i) != null) {
            rq7Var.notifyDataSetChanged();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (pm pmVar : this.d) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).x();
                } else if (pmVar instanceof y2a) {
                    ((y2a) pmVar).onDestroy();
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (pm pmVar : this.d) {
            if (pmVar instanceof fi7) {
                ((fi7) pmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a != null && !ListUtils.isEmpty(this.d)) {
            for (pm pmVar : this.d) {
                if (pmVar instanceof xt7) {
                    xt7 xt7Var = (xt7) pmVar;
                    if (xt7Var.i() != null) {
                        xt7Var.i().a = this.a.f;
                        xt7Var.i().c = this.a.d;
                        xt7Var.i().d = this.a.e;
                        xt7Var.i().e = this.a.a;
                        xt7Var.i().h = this.a.b;
                    }
                }
            }
        }
    }
}
