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
/* loaded from: classes8.dex */
public class yp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public BdTypeRecyclerView b;
    public fi7 c;
    public List<ln> d;
    public dq7 e;
    public kq7 f;
    public fq7 g;
    public jq7 h;
    public eq7 i;
    public iq7 j;
    public gq7 k;
    public hq7 l;
    public km7 m;
    public wl7 n;
    public hm7 o;
    public em7 p;
    public vl7 q;
    public fm7 r;
    public cq7 s;

    /* loaded from: classes8.dex */
    public class a extends up6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp7 b;

        public a(yp7 yp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yp7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends up6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp7 b;

        public b(yp7 yp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yp7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends up6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp7 b;

        public c(yp7 yp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yp7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    public yp7(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new pb5(4, threadData.getPositionInFrsItemTab(), 1)));
    }

    public void g(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            i();
            this.b.setData(arrayList);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        cq7 cq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) && (cq7Var = this.s) != null) {
            cq7Var.u(bdUniqueId);
        }
    }

    public void c(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsItemTabFragment, bdTypeRecyclerView) == null) {
            this.a = frsItemTabFragment;
            this.g = new fq7(frsItemTabFragment.getPageContext(), uq7.b, frsItemTabFragment.getUniqueId());
            this.h = new jq7(frsItemTabFragment.getPageContext(), vq7.b, frsItemTabFragment.getUniqueId());
            this.f = new kq7(frsItemTabFragment.getPageContext(), wq7.b, frsItemTabFragment.getUniqueId());
            this.e = new dq7(frsItemTabFragment.getPageContext(), sq7.b, frsItemTabFragment.getUniqueId());
            this.i = new eq7(frsItemTabFragment.getPageContext(), tq7.c, frsItemTabFragment.getUniqueId());
            this.j = new iq7(frsItemTabFragment.getPageContext(), rq7.c, frsItemTabFragment.getUniqueId());
            this.k = new gq7(frsItemTabFragment.getPageContext(), rq7.d, frsItemTabFragment.getUniqueId());
            this.l = new hq7(frsItemTabFragment.getPageContext(), rq7.e, frsItemTabFragment.getUniqueId());
            km7 km7Var = new km7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_USER_NORMAL, frsItemTabFragment.getUniqueId());
            this.m = km7Var;
            km7Var.B(true);
            this.m.setFrom(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK);
            wl7 wl7Var = new wl7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsItemTabFragment.getUniqueId());
            this.n = wl7Var;
            wl7Var.D(new a(this));
            hm7 hm7Var = new hm7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsItemTabFragment.getUniqueId());
            this.o = hm7Var;
            hm7Var.D(new b(this));
            em7 em7Var = new em7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsItemTabFragment.getUniqueId());
            this.p = em7Var;
            em7Var.D(new c(this));
            this.q = new vl7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, frsItemTabFragment.getUniqueId());
            this.r = new fm7(frsItemTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsItemTabFragment.getUniqueId());
            this.c = new fi7(frsItemTabFragment.getPageContext(), gi7.b);
            this.s = new cq7(frsItemTabFragment.getPageContext().getPageActivity(), qq7.c);
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
            for (ln lnVar : this.d) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).C(bdTypeRecyclerView);
                }
                if (lnVar instanceof sp6) {
                    ((sp6) lnVar).p(3);
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
        eq7 eq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (eq7Var = this.i) != null) {
            eq7Var.notifyDataSetChanged();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (ln lnVar : this.d) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).x();
                } else if (lnVar instanceof ky9) {
                    ((ky9) lnVar).onDestroy();
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (ln lnVar : this.d) {
            if (lnVar instanceof yh7) {
                ((yh7) lnVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a != null && !ListUtils.isEmpty(this.d)) {
            for (ln lnVar : this.d) {
                if (lnVar instanceof kt7) {
                    kt7 kt7Var = (kt7) lnVar;
                    if (kt7Var.i() != null) {
                        kt7Var.i().a = this.a.f;
                        kt7Var.i().c = this.a.d;
                        kt7Var.i().d = this.a.e;
                        kt7Var.i().e = this.a.a;
                        kt7Var.i().h = this.a.b;
                    }
                }
            }
        }
    }
}
