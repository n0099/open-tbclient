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
import com.baidu.tieba.frs.good.FrsGoodFragment;
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
public class wo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public BdTypeRecyclerView b;
    public List<om> c;
    public List<om> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<bn> f;
    public ArrayList<bn> g;
    public FrsViewData h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wo7 wo7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo7Var, Integer.valueOf(i)};
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
            this.a = wo7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<om<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    om<?, ?> next = it.next();
                    if (next instanceof yg7) {
                        ((yg7) next).m(this.a.a.getPageContext(), this.a.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.a.d != null) {
                    this.a.d.addAll(arrayList);
                }
                if (this.a.b != null) {
                    this.a.b.addAdapters(arrayList);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wo7 wo7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo7Var, Integer.valueOf(i)};
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
            this.a = wo7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                wo7 wo7Var = this.a;
                wo7Var.i(wo7Var.b);
                wo7 wo7Var2 = this.a;
                wo7Var2.w(wo7Var2.f, this.a.h);
            }
        }
    }

    public wo7(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment, bdTypeRecyclerView};
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
        this.i = new a(this, 2003008);
        this.j = new b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
        this.e = new HashMap<>();
    }

    public void w(ArrayList<bn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof gh7)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            afa.f(arrayList, 1);
            k(arrayList);
            ArrayList<bn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.b.setData(switchThreadDataToThreadCardInfo);
            this.g = switchThreadDataToThreadCardInfo;
            this.f = arrayList;
            this.h = frsViewData;
            C();
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !i(bdTypeRecyclerView)) {
            this.a.registerListener(this.j);
        }
    }

    public final void v(String str) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, str) != null) || (list = this.d) == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof s46) {
                ((s46) omVar).g(str);
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (om omVar : this.d) {
                if (omVar instanceof ho6) {
                    ((ho6) omVar).p(3);
                }
            }
        }
    }

    public HashMap<Integer, ThreadData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (HashMap) invokeV.objValue;
    }

    public List<bn> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public List<bn> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.setData(this.g);
            p();
        }
    }

    public void B(ln lnVar) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lnVar) == null) && (list = this.d) != null && list.size() != 0) {
            for (om omVar : this.d) {
                if (omVar != null && (omVar instanceof yg7)) {
                    ((yg7) omVar).setOnAdapterItemClickListener(lnVar);
                }
            }
        }
    }

    public final void k(ArrayList<bn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                bn bnVar = arrayList.get(i);
                if ((bnVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(bnVar)) {
                    this.e.put(Integer.valueOf(i), (ThreadData) bnVar);
                }
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (om omVar : this.d) {
                if (omVar != null && omVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void u(ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) && arrayList != null && arrayList.size() > 0) {
            Iterator<bn> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == ThreadData.TYPE_TOP) {
                    it.remove();
                }
            }
        }
    }

    public void x(boolean z) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (list = this.d) != null && list.size() != 0) {
            for (om omVar : this.d) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).setFromCDN(z);
                }
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (om omVar : this.d) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).A(frsViewData);
                }
            }
        }
    }

    public final void C() {
        ms7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.h == null) {
            return;
        }
        for (om omVar : this.d) {
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
                if (this.a != null) {
                    i.b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getData() != null && this.b.getData().size() != 0) {
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

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.c = new ArrayList();
                ArrayList<BdUniqueId> g = afa.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        yg7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = sg7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.d.add(b2);
                            this.c.add(b2);
                        }
                    }
                    if (!ListUtils.isEmpty(this.c)) {
                        bdTypeRecyclerView.addAdapters(this.c);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.a = frsGoodFragment;
            this.i.setPriority(1);
            this.i.setSelfListener(true);
            this.a.registerListener(this.i);
            ol7 ol7Var = new ol7(frsGoodFragment.u(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            al7 al7Var = new al7(frsGoodFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            ll7 ll7Var = new ll7(frsGoodFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            il7 il7Var = new il7(frsGoodFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            zk7 zk7Var = new zk7(frsGoodFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            cl7 cl7Var = new cl7(frsGoodFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            ql7 ql7Var = new ql7(frsGoodFragment.u(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            ml7 ml7Var = new ml7(frsGoodFragment.u(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            kl7 kl7Var = new kl7(frsGoodFragment.u(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            hl7 hl7Var = new hl7(frsGoodFragment.u(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            pl7 pl7Var = new pl7(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            fl7 fl7Var = new fl7(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            jl7 jl7Var = new jl7(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            pl7 pl7Var2 = new pl7(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            fh7 fh7Var = new fh7(frsGoodFragment.getPageContext(), gh7.b);
            om<? extends c45, ? extends TypeAdapter.ViewHolder> a2 = sg7.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            om<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = sg7.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            om<?, ?> e = r1a.m().e(this.a, AdvertAppInfo.x);
            om<?, ?> e2 = r1a.m().e(this.a, AdvertAppInfo.A);
            nl7 nl7Var = new nl7(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ok7 ok7Var = new ok7(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            vk7 vk7Var = new vk7(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            wk7 wk7Var = new wk7(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            tk7 tk7Var = new tk7(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            tk7Var.x(bdTypeRecyclerView);
            this.d.add(ol7Var);
            this.d.add(al7Var);
            this.d.add(ll7Var);
            this.d.add(il7Var);
            this.d.add(zk7Var);
            this.d.add(cl7Var);
            this.d.add(ml7Var);
            this.d.add(ql7Var);
            this.d.add(kl7Var);
            this.d.add(hl7Var);
            this.d.add(pl7Var);
            this.d.add(fl7Var);
            this.d.add(fl7Var);
            this.d.add(jl7Var);
            this.d.add(fh7Var);
            this.d.add(pl7Var);
            this.d.add(pl7Var2);
            this.d.add(nl7Var);
            this.d.add(ok7Var);
            this.d.add(vk7Var);
            this.d.add(wk7Var);
            this.d.add(tk7Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(e);
            this.d.add(e2);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.d.add(zw7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, null));
            this.d.add(zw7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, null));
            p36 p36Var = new p36(this.a, 1);
            p36Var.u(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p36Var));
            bdTypeRecyclerView.addAdapters(this.d);
            v("page_frs_good");
            for (om omVar : this.d) {
                if (omVar instanceof io6) {
                    ((io6) omVar).j(true);
                }
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (om omVar : this.d) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).x();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (om omVar : this.d) {
            if (omVar instanceof yg7) {
                ((yg7) omVar).E(this.a.getTbPageTag());
            }
        }
    }
}
