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
public class xf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public un c;
    public List<vm> d;
    public List<vm> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<in> g;
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
        public final /* synthetic */ xf7 a;

        public a(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
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
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xf7 xf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i)};
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
            this.a = xf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                xf7 xf7Var = this.a;
                xf7Var.g(xf7Var.b);
                xf7 xf7Var2 = this.a;
                xf7Var2.p(xf7Var2.g, this.a.h);
            }
        }
    }

    public xf7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new un(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<in> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            oo9.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = oo9.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        p67<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = j67.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<in> j() {
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

    public final void i(ArrayList<in> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                in inVar = arrayList.get(i);
                if ((inVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(inVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) inVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (vm vmVar : this.e) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (vm vmVar : this.e) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).A(frsViewData);
                }
            }
        }
    }

    public void t(sn snVar) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, snVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (vm vmVar : this.e) {
                if (vmVar != null && (vmVar instanceof p67)) {
                    ((p67) vmVar).setOnAdapterItemClickListener(snVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            ab7 ab7Var = new ab7(frsNewAreaFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            ab7Var.C(bdTypeRecyclerView);
            ma7 ma7Var = new ma7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            ma7Var.C(bdTypeRecyclerView);
            xa7 xa7Var = new xa7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            xa7Var.C(bdTypeRecyclerView);
            ua7 ua7Var = new ua7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            ua7Var.C(bdTypeRecyclerView);
            la7 la7Var = new la7(frsNewAreaFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            la7Var.C(bdTypeRecyclerView);
            oa7 oa7Var = new oa7(frsNewAreaFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            oa7Var.C(bdTypeRecyclerView);
            cb7 cb7Var = new cb7(frsNewAreaFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            cb7Var.C(bdTypeRecyclerView);
            ya7 ya7Var = new ya7(frsNewAreaFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            ya7Var.C(bdTypeRecyclerView);
            wa7 wa7Var = new wa7(frsNewAreaFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            ta7 ta7Var = new ta7(frsNewAreaFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            bb7 bb7Var = new bb7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            bb7Var.C(bdTypeRecyclerView);
            na7 na7Var = new na7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            na7Var.C(bdTypeRecyclerView);
            ra7 ra7Var = new ra7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ra7Var.C(bdTypeRecyclerView);
            ba7 ba7Var = new ba7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ba7Var.C(bdTypeRecyclerView);
            ha7 ha7Var = new ha7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ha7Var.C(bdTypeRecyclerView);
            ia7 ia7Var = new ia7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            ia7Var.C(bdTypeRecyclerView);
            va7 va7Var = new va7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            va7Var.C(bdTypeRecyclerView);
            bb7 bb7Var2 = new bb7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            bb7Var2.C(bdTypeRecyclerView);
            w67 w67Var = new w67(frsNewAreaFragment.getPageContext(), x67.b);
            w67Var.C(bdTypeRecyclerView);
            vm<? extends f05, ? extends TypeAdapter.ViewHolder> a2 = j67.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            vm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = j67.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            vm<?, ?> d2 = ae9.l().d(this.a, AdvertAppInfo.w);
            vm<?, ?> d3 = ae9.l().d(this.a, AdvertAppInfo.z);
            za7 za7Var = new za7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            za7Var.C(bdTypeRecyclerView);
            fa7 fa7Var = new fa7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            fa7Var.x(bdTypeRecyclerView);
            z97 z97Var = new z97(frsNewAreaFragment.t(), x06.g);
            this.e.add(ab7Var);
            this.e.add(ma7Var);
            this.e.add(xa7Var);
            this.e.add(ua7Var);
            this.e.add(la7Var);
            this.e.add(oa7Var);
            this.e.add(ya7Var);
            this.e.add(cb7Var);
            this.e.add(wa7Var);
            this.e.add(ta7Var);
            this.e.add(bb7Var);
            this.e.add(ra7Var);
            this.e.add(ba7Var);
            this.e.add(ha7Var);
            this.e.add(ia7Var);
            this.e.add(va7Var);
            this.e.add(w67Var);
            this.e.add(na7Var);
            this.e.add(bb7Var2);
            this.e.add(za7Var);
            this.e.add(fa7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(z97Var);
            this.e.add(new ea7(frsNewAreaFragment.getPageContext()));
            vm<?, ?> d4 = am7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            vm<?, ?> d5 = am7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<vm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    vm<?, ?> next = it.next();
                    if (next instanceof p67) {
                        ((p67) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<vm> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            ny5 ny5Var = new ny5(this.a, 1);
            ny5Var.u(this.e);
            ny5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ny5Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (vm vmVar : this.e) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).x();
                } else if (vmVar instanceof qd9) {
                    ((qd9) vmVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (vm vmVar : this.e) {
            if (vmVar instanceof p67) {
                ((p67) vmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        th7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (vm vmVar : this.e) {
            if ((vmVar instanceof vh7) && (i = ((vh7) vmVar).i()) != null) {
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
            for (in inVar : this.b.getData()) {
                if (inVar instanceof f05) {
                    f05 f05Var = (f05) inVar;
                    if (f05Var.t.getIs_top() != 0) {
                        f05Var.t.parser_title();
                    }
                }
            }
        }
    }
}
