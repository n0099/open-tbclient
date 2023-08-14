package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class so7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public kn c;
    public List<lm> d;
    public List<lm> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<ym> g;
    public FrsViewData h;
    public CustomMessageListener i;

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ so7 a;

        public a(so7 so7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {so7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = so7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ so7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(so7 so7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {so7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = so7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                so7 so7Var = this.a;
                so7Var.g(so7Var.b);
                so7 so7Var2 = this.a;
                so7Var2.p(so7Var2.g, this.a.h);
            }
        }
    }

    public so7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new LinkedList();
        this.i = new b(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
        this.c = new kn(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<ym> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            saa.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.g = arrayList;
            this.h = frsViewData;
            u();
        }
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.d = new ArrayList();
                ArrayList<BdUniqueId> g = saa.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        hf7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = bf7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.e.add(b2);
                            this.d.add(b2);
                        }
                    }
                    if (!ListUtils.isEmpty(this.d)) {
                        bdTypeRecyclerView.addAdapters(this.d);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (HashMap) invokeV.objValue;
    }

    public List<ym> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.e(new a(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.setData(this.g);
            l();
        }
    }

    public final void i(ArrayList<ym> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                ym ymVar = arrayList.get(i);
                if ((ymVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(ymVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) ymVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (lm lmVar : this.e) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (lm lmVar : this.e) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).A(frsViewData);
                }
            }
        }
    }

    public void t(in inVar) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, inVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (lm lmVar : this.e) {
                if (lmVar != null && (lmVar instanceof hf7)) {
                    ((hf7) lmVar).setOnAdapterItemClickListener(inVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            tj7 tj7Var = new tj7(frsNewAreaFragment.u(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            tj7Var.C(bdTypeRecyclerView);
            fj7 fj7Var = new fj7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            fj7Var.C(bdTypeRecyclerView);
            qj7 qj7Var = new qj7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            qj7Var.C(bdTypeRecyclerView);
            nj7 nj7Var = new nj7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            nj7Var.C(bdTypeRecyclerView);
            ej7 ej7Var = new ej7(frsNewAreaFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            ej7Var.C(bdTypeRecyclerView);
            hj7 hj7Var = new hj7(frsNewAreaFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            hj7Var.C(bdTypeRecyclerView);
            vj7 vj7Var = new vj7(frsNewAreaFragment.u(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            vj7Var.C(bdTypeRecyclerView);
            rj7 rj7Var = new rj7(frsNewAreaFragment.u(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            rj7Var.C(bdTypeRecyclerView);
            pj7 pj7Var = new pj7(frsNewAreaFragment.u(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            mj7 mj7Var = new mj7(frsNewAreaFragment.u(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            uj7 uj7Var = new uj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            uj7Var.C(bdTypeRecyclerView);
            gj7 gj7Var = new gj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            gj7Var.C(bdTypeRecyclerView);
            kj7 kj7Var = new kj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            kj7Var.C(bdTypeRecyclerView);
            ti7 ti7Var = new ti7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ti7Var.C(bdTypeRecyclerView);
            aj7 aj7Var = new aj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            aj7Var.C(bdTypeRecyclerView);
            bj7 bj7Var = new bj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            bj7Var.C(bdTypeRecyclerView);
            oj7 oj7Var = new oj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            oj7Var.C(bdTypeRecyclerView);
            uj7 uj7Var2 = new uj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            uj7Var2.C(bdTypeRecyclerView);
            of7 of7Var = new of7(frsNewAreaFragment.getPageContext(), pf7.b);
            of7Var.C(bdTypeRecyclerView);
            lm<? extends w35, ? extends TypeAdapter.ViewHolder> a2 = bf7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            lm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = bf7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            lm<?, ?> e = mx9.m().e(this.a, AdvertAppInfo.x);
            lm<?, ?> e2 = mx9.m().e(this.a, AdvertAppInfo.A);
            sj7 sj7Var = new sj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            sj7Var.C(bdTypeRecyclerView);
            yi7 yi7Var = new yi7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            yi7Var.x(bdTypeRecyclerView);
            ri7 ri7Var = new ri7(frsNewAreaFragment.u(), i56.g);
            xi7 xi7Var = new xi7(frsNewAreaFragment.getPageContext(), sn6.A0);
            xi7Var.u(bdTypeRecyclerView);
            this.e.add(tj7Var);
            this.e.add(fj7Var);
            this.e.add(qj7Var);
            this.e.add(nj7Var);
            this.e.add(ej7Var);
            this.e.add(hj7Var);
            this.e.add(rj7Var);
            this.e.add(vj7Var);
            this.e.add(pj7Var);
            this.e.add(mj7Var);
            this.e.add(uj7Var);
            this.e.add(kj7Var);
            this.e.add(ti7Var);
            this.e.add(aj7Var);
            this.e.add(bj7Var);
            this.e.add(oj7Var);
            this.e.add(of7Var);
            this.e.add(gj7Var);
            this.e.add(uj7Var2);
            this.e.add(sj7Var);
            this.e.add(yi7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(ri7Var);
            this.e.add(new wi7(frsNewAreaFragment.getPageContext()));
            this.e.add(xi7Var);
            lm<?, ?> g = ev7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
            lm<?, ?> g2 = ev7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            this.e.add(g);
            this.e.add(g2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<lm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    lm<?, ?> next = it.next();
                    if (next instanceof hf7) {
                        ((hf7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<lm> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            y26 y26Var = new y26(this.a, 1);
            y26Var.u(this.e);
            y26Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, y26Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (lm lmVar : this.e) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).x();
                } else if (lmVar instanceof cx9) {
                    ((cx9) lmVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (lm lmVar : this.e) {
            if (lmVar instanceof hf7) {
                ((hf7) lmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        rq7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (lm lmVar : this.e) {
            if ((lmVar instanceof tq7) && (i = ((tq7) lmVar).i()) != null) {
                if (this.h.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.h.getForum() != null) {
                    i.c = this.h.getForum().getId();
                    i.d = this.h.getForum().getName();
                }
            }
        }
    }

    public void v() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getData() != null && this.b.getData().size() != 0) {
            for (ym ymVar : this.b.getData()) {
                if (ymVar instanceof w35) {
                    w35 w35Var = (w35) ymVar;
                    if (w35Var.t.getIs_top() != 0) {
                        w35Var.t.parser_title();
                    }
                }
            }
        }
    }
}
