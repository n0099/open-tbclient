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
/* loaded from: classes8.dex */
public class wr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public on c;
    public List<pm> d;
    public List<pm> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<cn> g;
    public FrsViewData h;
    public CustomMessageListener i;

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr7 a;

        public a(wr7 wr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wr7 wr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var, Integer.valueOf(i)};
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
            this.a = wr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                wr7 wr7Var = this.a;
                wr7Var.g(wr7Var.b);
                wr7 wr7Var2 = this.a;
                wr7Var2.p(wr7Var2.g, this.a.h);
            }
        }
    }

    public wr7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new on(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<cn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            tga.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = tga.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        fi7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = zh7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<cn> j() {
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

    public final void i(ArrayList<cn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                cn cnVar = arrayList.get(i);
                if ((cnVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(cnVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) cnVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (pm pmVar : this.e) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (pm pmVar : this.e) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).A(frsViewData);
                }
            }
        }
    }

    public void t(mn mnVar) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, mnVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (pm pmVar : this.e) {
                if (pmVar != null && (pmVar instanceof fi7)) {
                    ((fi7) pmVar).setOnAdapterItemClickListener(mnVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            xm7 xm7Var = new xm7(frsNewAreaFragment.u(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            xm7Var.C(bdTypeRecyclerView);
            jm7 jm7Var = new jm7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            jm7Var.C(bdTypeRecyclerView);
            um7 um7Var = new um7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            um7Var.C(bdTypeRecyclerView);
            rm7 rm7Var = new rm7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            rm7Var.C(bdTypeRecyclerView);
            im7 im7Var = new im7(frsNewAreaFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            im7Var.C(bdTypeRecyclerView);
            lm7 lm7Var = new lm7(frsNewAreaFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            lm7Var.C(bdTypeRecyclerView);
            zm7 zm7Var = new zm7(frsNewAreaFragment.u(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            zm7Var.C(bdTypeRecyclerView);
            vm7 vm7Var = new vm7(frsNewAreaFragment.u(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            vm7Var.C(bdTypeRecyclerView);
            tm7 tm7Var = new tm7(frsNewAreaFragment.u(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            qm7 qm7Var = new qm7(frsNewAreaFragment.u(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            ym7 ym7Var = new ym7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            ym7Var.C(bdTypeRecyclerView);
            km7 km7Var = new km7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            km7Var.C(bdTypeRecyclerView);
            om7 om7Var = new om7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            om7Var.C(bdTypeRecyclerView);
            wl7 wl7Var = new wl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            wl7Var.C(bdTypeRecyclerView);
            dm7 dm7Var = new dm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            dm7Var.C(bdTypeRecyclerView);
            em7 em7Var = new em7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            em7Var.C(bdTypeRecyclerView);
            sm7 sm7Var = new sm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            sm7Var.C(bdTypeRecyclerView);
            ym7 ym7Var2 = new ym7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            ym7Var2.C(bdTypeRecyclerView);
            mi7 mi7Var = new mi7(frsNewAreaFragment.getPageContext(), ni7.b);
            mi7Var.C(bdTypeRecyclerView);
            pm<? extends h45, ? extends TypeAdapter.ViewHolder> a2 = zh7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            pm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = zh7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            pm<?, ?> e = i3a.m().e(this.a, AdvertAppInfo.x);
            pm<?, ?> e2 = i3a.m().e(this.a, AdvertAppInfo.A);
            wm7 wm7Var = new wm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            wm7Var.C(bdTypeRecyclerView);
            bm7 bm7Var = new bm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            bm7Var.x(bdTypeRecyclerView);
            hm7 hm7Var = new hm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            tl7 tl7Var = new tl7(frsNewAreaFragment.u(), v66.g);
            am7 am7Var = new am7(frsNewAreaFragment.getPageContext(), cq6.A0);
            am7Var.u(bdTypeRecyclerView);
            fm7 fm7Var = new fm7(frsNewAreaFragment.getPageContext(), hq6.j);
            fm7Var.u(bdTypeRecyclerView);
            this.e.add(xm7Var);
            this.e.add(jm7Var);
            this.e.add(um7Var);
            this.e.add(rm7Var);
            this.e.add(im7Var);
            this.e.add(lm7Var);
            this.e.add(vm7Var);
            this.e.add(zm7Var);
            this.e.add(tm7Var);
            this.e.add(qm7Var);
            this.e.add(ym7Var);
            this.e.add(om7Var);
            this.e.add(wl7Var);
            this.e.add(dm7Var);
            this.e.add(em7Var);
            this.e.add(sm7Var);
            this.e.add(mi7Var);
            this.e.add(km7Var);
            this.e.add(ym7Var2);
            this.e.add(wm7Var);
            this.e.add(bm7Var);
            this.e.add(hm7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(tl7Var);
            this.e.add(new zl7(frsNewAreaFragment.getPageContext()));
            this.e.add(am7Var);
            this.e.add(fm7Var);
            pm<?, ?> g = jy7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
            pm<?, ?> g2 = jy7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            this.e.add(g);
            this.e.add(g2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<pm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    pm<?, ?> next = it.next();
                    if (next instanceof fi7) {
                        ((fi7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<pm> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            l46 l46Var = new l46(this.a, 1);
            l46Var.u(this.e);
            l46Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, l46Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (pm pmVar : this.e) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).x();
                } else if (pmVar instanceof y2a) {
                    ((y2a) pmVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (pm pmVar : this.e) {
            if (pmVar instanceof fi7) {
                ((fi7) pmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        vt7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (pm pmVar : this.e) {
            if ((pmVar instanceof xt7) && (i = ((xt7) pmVar).i()) != null) {
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
            for (cn cnVar : this.b.getData()) {
                if (cnVar instanceof h45) {
                    h45 h45Var = (h45) cnVar;
                    if (h45Var.t.getIs_top() != 0) {
                        h45Var.t.parser_title();
                    }
                }
            }
        }
    }
}
