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
public class nq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public nn c;
    public List<om> d;
    public List<om> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<bn> g;
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
        public final /* synthetic */ nq7 a;

        public a(nq7 nq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nq7Var;
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
        public final /* synthetic */ nq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(nq7 nq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq7Var, Integer.valueOf(i)};
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
            this.a = nq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                nq7 nq7Var = this.a;
                nq7Var.g(nq7Var.b);
                nq7 nq7Var2 = this.a;
                nq7Var2.p(nq7Var2.g, this.a.h);
            }
        }
    }

    public nq7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new nn(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<bn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            afa.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = afa.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        yg7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = sg7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<bn> j() {
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

    public final void i(ArrayList<bn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                bn bnVar = arrayList.get(i);
                if ((bnVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(bnVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) bnVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (om omVar : this.e) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (om omVar : this.e) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).A(frsViewData);
                }
            }
        }
    }

    public void t(ln lnVar) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, lnVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (om omVar : this.e) {
                if (omVar != null && (omVar instanceof yg7)) {
                    ((yg7) omVar).setOnAdapterItemClickListener(lnVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            ol7 ol7Var = new ol7(frsNewAreaFragment.u(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            ol7Var.C(bdTypeRecyclerView);
            al7 al7Var = new al7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            al7Var.C(bdTypeRecyclerView);
            ll7 ll7Var = new ll7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            ll7Var.C(bdTypeRecyclerView);
            il7 il7Var = new il7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            il7Var.C(bdTypeRecyclerView);
            zk7 zk7Var = new zk7(frsNewAreaFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            zk7Var.C(bdTypeRecyclerView);
            cl7 cl7Var = new cl7(frsNewAreaFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            cl7Var.C(bdTypeRecyclerView);
            ql7 ql7Var = new ql7(frsNewAreaFragment.u(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            ql7Var.C(bdTypeRecyclerView);
            ml7 ml7Var = new ml7(frsNewAreaFragment.u(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            ml7Var.C(bdTypeRecyclerView);
            kl7 kl7Var = new kl7(frsNewAreaFragment.u(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            hl7 hl7Var = new hl7(frsNewAreaFragment.u(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            pl7 pl7Var = new pl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            pl7Var.C(bdTypeRecyclerView);
            bl7 bl7Var = new bl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            bl7Var.C(bdTypeRecyclerView);
            fl7 fl7Var = new fl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            fl7Var.C(bdTypeRecyclerView);
            ok7 ok7Var = new ok7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ok7Var.C(bdTypeRecyclerView);
            vk7 vk7Var = new vk7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            vk7Var.C(bdTypeRecyclerView);
            wk7 wk7Var = new wk7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            wk7Var.C(bdTypeRecyclerView);
            jl7 jl7Var = new jl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            jl7Var.C(bdTypeRecyclerView);
            pl7 pl7Var2 = new pl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            pl7Var2.C(bdTypeRecyclerView);
            fh7 fh7Var = new fh7(frsNewAreaFragment.getPageContext(), gh7.b);
            fh7Var.C(bdTypeRecyclerView);
            om<? extends c45, ? extends TypeAdapter.ViewHolder> a2 = sg7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            om<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = sg7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            om<?, ?> e = r1a.m().e(this.a, AdvertAppInfo.x);
            om<?, ?> e2 = r1a.m().e(this.a, AdvertAppInfo.A);
            nl7 nl7Var = new nl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            nl7Var.C(bdTypeRecyclerView);
            tk7 tk7Var = new tk7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            tk7Var.x(bdTypeRecyclerView);
            mk7 mk7Var = new mk7(frsNewAreaFragment.u(), z56.g);
            sk7 sk7Var = new sk7(frsNewAreaFragment.getPageContext(), zo6.A0);
            sk7Var.u(bdTypeRecyclerView);
            this.e.add(ol7Var);
            this.e.add(al7Var);
            this.e.add(ll7Var);
            this.e.add(il7Var);
            this.e.add(zk7Var);
            this.e.add(cl7Var);
            this.e.add(ml7Var);
            this.e.add(ql7Var);
            this.e.add(kl7Var);
            this.e.add(hl7Var);
            this.e.add(pl7Var);
            this.e.add(fl7Var);
            this.e.add(ok7Var);
            this.e.add(vk7Var);
            this.e.add(wk7Var);
            this.e.add(jl7Var);
            this.e.add(fh7Var);
            this.e.add(bl7Var);
            this.e.add(pl7Var2);
            this.e.add(nl7Var);
            this.e.add(tk7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(mk7Var);
            this.e.add(new rk7(frsNewAreaFragment.getPageContext()));
            this.e.add(sk7Var);
            om<?, ?> g = zw7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
            om<?, ?> g2 = zw7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            this.e.add(g);
            this.e.add(g2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<om<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    om<?, ?> next = it.next();
                    if (next instanceof yg7) {
                        ((yg7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<om> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            p36 p36Var = new p36(this.a, 1);
            p36Var.u(this.e);
            p36Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p36Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (om omVar : this.e) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).x();
                } else if (omVar instanceof h1a) {
                    ((h1a) omVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (om omVar : this.e) {
            if (omVar instanceof yg7) {
                ((yg7) omVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        ms7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (om omVar : this.e) {
            if ((omVar instanceof os7) && (i = ((os7) omVar).i()) != null) {
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
            for (bn bnVar : this.b.getData()) {
                if (bnVar instanceof c45) {
                    c45 c45Var = (c45) bnVar;
                    if (c45Var.t.getIs_top() != 0) {
                        c45Var.t.parser_title();
                    }
                }
            }
        }
    }
}
