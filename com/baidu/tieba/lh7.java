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
public class lh7 {
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
        public final /* synthetic */ lh7 a;

        public a(lh7 lh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh7Var;
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
        public final /* synthetic */ lh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(lh7 lh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh7Var, Integer.valueOf(i)};
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
            this.a = lh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                lh7 lh7Var = this.a;
                lh7Var.g(lh7Var.b);
                lh7 lh7Var2 = this.a;
                lh7Var2.p(lh7Var2.g, this.a.h);
            }
        }
    }

    public lh7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            rq9.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = rq9.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        d87<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = x77.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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
                if (enVar instanceof d87) {
                    ((d87) enVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (en enVar : this.e) {
                if (enVar instanceof d87) {
                    ((d87) enVar).A(frsViewData);
                }
            }
        }
    }

    public void t(bo boVar) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, boVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (en enVar : this.e) {
                if (enVar != null && (enVar instanceof d87)) {
                    ((d87) enVar).setOnAdapterItemClickListener(boVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            oc7 oc7Var = new oc7(frsNewAreaFragment.s(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            oc7Var.C(bdTypeRecyclerView);
            ac7 ac7Var = new ac7(frsNewAreaFragment.s(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            ac7Var.C(bdTypeRecyclerView);
            lc7 lc7Var = new lc7(frsNewAreaFragment.s(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            lc7Var.C(bdTypeRecyclerView);
            ic7 ic7Var = new ic7(frsNewAreaFragment.s(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            ic7Var.C(bdTypeRecyclerView);
            zb7 zb7Var = new zb7(frsNewAreaFragment.s(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            zb7Var.C(bdTypeRecyclerView);
            cc7 cc7Var = new cc7(frsNewAreaFragment.s(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            cc7Var.C(bdTypeRecyclerView);
            qc7 qc7Var = new qc7(frsNewAreaFragment.s(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            qc7Var.C(bdTypeRecyclerView);
            mc7 mc7Var = new mc7(frsNewAreaFragment.s(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            mc7Var.C(bdTypeRecyclerView);
            kc7 kc7Var = new kc7(frsNewAreaFragment.s(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            hc7 hc7Var = new hc7(frsNewAreaFragment.s(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            pc7 pc7Var = new pc7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            pc7Var.C(bdTypeRecyclerView);
            bc7 bc7Var = new bc7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            bc7Var.C(bdTypeRecyclerView);
            fc7 fc7Var = new fc7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            fc7Var.C(bdTypeRecyclerView);
            pb7 pb7Var = new pb7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            pb7Var.C(bdTypeRecyclerView);
            vb7 vb7Var = new vb7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            vb7Var.C(bdTypeRecyclerView);
            wb7 wb7Var = new wb7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            wb7Var.C(bdTypeRecyclerView);
            jc7 jc7Var = new jc7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            jc7Var.C(bdTypeRecyclerView);
            pc7 pc7Var2 = new pc7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            pc7Var2.C(bdTypeRecyclerView);
            k87 k87Var = new k87(frsNewAreaFragment.getPageContext(), l87.b);
            k87Var.C(bdTypeRecyclerView);
            en<? extends o15, ? extends TypeAdapter.ViewHolder> a2 = x77.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            en<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = x77.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            en<?, ?> d2 = xf9.l().d(this.a, AdvertAppInfo.w);
            en<?, ?> d3 = xf9.l().d(this.a, AdvertAppInfo.z);
            nc7 nc7Var = new nc7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            nc7Var.C(bdTypeRecyclerView);
            tb7 tb7Var = new tb7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            tb7Var.x(bdTypeRecyclerView);
            nb7 nb7Var = new nb7(frsNewAreaFragment.s(), j26.g);
            this.e.add(oc7Var);
            this.e.add(ac7Var);
            this.e.add(lc7Var);
            this.e.add(ic7Var);
            this.e.add(zb7Var);
            this.e.add(cc7Var);
            this.e.add(mc7Var);
            this.e.add(qc7Var);
            this.e.add(kc7Var);
            this.e.add(hc7Var);
            this.e.add(pc7Var);
            this.e.add(fc7Var);
            this.e.add(pb7Var);
            this.e.add(vb7Var);
            this.e.add(wb7Var);
            this.e.add(jc7Var);
            this.e.add(k87Var);
            this.e.add(bc7Var);
            this.e.add(pc7Var2);
            this.e.add(nc7Var);
            this.e.add(tb7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(nb7Var);
            this.e.add(new sb7(frsNewAreaFragment.getPageContext()));
            en<?, ?> d4 = on7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            en<?, ?> d5 = on7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
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
                    if (next instanceof d87) {
                        ((d87) next).m(this.a.getPageContext(), this.a.getUniqueId());
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
                if (enVar instanceof d87) {
                    ((d87) enVar).x();
                } else if (enVar instanceof nf9) {
                    ((nf9) enVar).onDestroy();
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
            if (enVar instanceof d87) {
                ((d87) enVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        hj7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (en enVar : this.e) {
            if ((enVar instanceof jj7) && (i = ((jj7) enVar).i()) != null) {
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
