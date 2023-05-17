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
/* loaded from: classes6.dex */
public class kh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public Cdo c;
    public List<en> d;
    public List<en> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<rn> g;
    public FrsViewData h;
    public CustomMessageListener i;

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh7 a;

        public a(kh7 kh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kh7 kh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var, Integer.valueOf(i)};
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
            this.a = kh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                kh7 kh7Var = this.a;
                kh7Var.g(kh7Var.b);
                kh7 kh7Var2 = this.a;
                kh7Var2.p(kh7Var2.g, this.a.h);
            }
        }
    }

    public kh7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new Cdo(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<rn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            qq9.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = qq9.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        c87<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = w77.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<rn> j() {
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

    public final void i(ArrayList<rn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                rn rnVar = arrayList.get(i);
                if ((rnVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(rnVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) rnVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (en enVar : this.e) {
                if (enVar instanceof c87) {
                    ((c87) enVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (en enVar : this.e) {
                if (enVar instanceof c87) {
                    ((c87) enVar).A(frsViewData);
                }
            }
        }
    }

    public void t(bo boVar) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, boVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (en enVar : this.e) {
                if (enVar != null && (enVar instanceof c87)) {
                    ((c87) enVar).setOnAdapterItemClickListener(boVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            nc7 nc7Var = new nc7(frsNewAreaFragment.s(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            nc7Var.C(bdTypeRecyclerView);
            zb7 zb7Var = new zb7(frsNewAreaFragment.s(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            zb7Var.C(bdTypeRecyclerView);
            kc7 kc7Var = new kc7(frsNewAreaFragment.s(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            kc7Var.C(bdTypeRecyclerView);
            hc7 hc7Var = new hc7(frsNewAreaFragment.s(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            hc7Var.C(bdTypeRecyclerView);
            yb7 yb7Var = new yb7(frsNewAreaFragment.s(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            yb7Var.C(bdTypeRecyclerView);
            bc7 bc7Var = new bc7(frsNewAreaFragment.s(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            bc7Var.C(bdTypeRecyclerView);
            pc7 pc7Var = new pc7(frsNewAreaFragment.s(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            pc7Var.C(bdTypeRecyclerView);
            lc7 lc7Var = new lc7(frsNewAreaFragment.s(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            lc7Var.C(bdTypeRecyclerView);
            jc7 jc7Var = new jc7(frsNewAreaFragment.s(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            gc7 gc7Var = new gc7(frsNewAreaFragment.s(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            oc7 oc7Var = new oc7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            oc7Var.C(bdTypeRecyclerView);
            ac7 ac7Var = new ac7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            ac7Var.C(bdTypeRecyclerView);
            ec7 ec7Var = new ec7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ec7Var.C(bdTypeRecyclerView);
            ob7 ob7Var = new ob7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ob7Var.C(bdTypeRecyclerView);
            ub7 ub7Var = new ub7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ub7Var.C(bdTypeRecyclerView);
            vb7 vb7Var = new vb7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            vb7Var.C(bdTypeRecyclerView);
            ic7 ic7Var = new ic7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            ic7Var.C(bdTypeRecyclerView);
            oc7 oc7Var2 = new oc7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            oc7Var2.C(bdTypeRecyclerView);
            j87 j87Var = new j87(frsNewAreaFragment.getPageContext(), k87.b);
            j87Var.C(bdTypeRecyclerView);
            en<? extends o15, ? extends TypeAdapter.ViewHolder> a2 = w77.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            en<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = w77.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            en<?, ?> d2 = wf9.l().d(this.a, AdvertAppInfo.w);
            en<?, ?> d3 = wf9.l().d(this.a, AdvertAppInfo.z);
            mc7 mc7Var = new mc7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            mc7Var.C(bdTypeRecyclerView);
            sb7 sb7Var = new sb7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            sb7Var.x(bdTypeRecyclerView);
            mb7 mb7Var = new mb7(frsNewAreaFragment.s(), j26.g);
            this.e.add(nc7Var);
            this.e.add(zb7Var);
            this.e.add(kc7Var);
            this.e.add(hc7Var);
            this.e.add(yb7Var);
            this.e.add(bc7Var);
            this.e.add(lc7Var);
            this.e.add(pc7Var);
            this.e.add(jc7Var);
            this.e.add(gc7Var);
            this.e.add(oc7Var);
            this.e.add(ec7Var);
            this.e.add(ob7Var);
            this.e.add(ub7Var);
            this.e.add(vb7Var);
            this.e.add(ic7Var);
            this.e.add(j87Var);
            this.e.add(ac7Var);
            this.e.add(oc7Var2);
            this.e.add(mc7Var);
            this.e.add(sb7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(mb7Var);
            this.e.add(new rb7(frsNewAreaFragment.getPageContext()));
            en<?, ?> d4 = nn7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            en<?, ?> d5 = nn7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<en<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    en<?, ?> next = it.next();
                    if (next instanceof c87) {
                        ((c87) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<en> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            zz5 zz5Var = new zz5(this.a, 1);
            zz5Var.u(this.e);
            zz5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, zz5Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (en enVar : this.e) {
                if (enVar instanceof c87) {
                    ((c87) enVar).x();
                } else if (enVar instanceof mf9) {
                    ((mf9) enVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (en enVar : this.e) {
            if (enVar instanceof c87) {
                ((c87) enVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        gj7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (en enVar : this.e) {
            if ((enVar instanceof ij7) && (i = ((ij7) enVar).i()) != null) {
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
            for (rn rnVar : this.b.getData()) {
                if (rnVar instanceof o15) {
                    o15 o15Var = (o15) rnVar;
                    if (o15Var.t.getIs_top() != 0) {
                        o15Var.t.parser_title();
                    }
                }
            }
        }
    }
}
