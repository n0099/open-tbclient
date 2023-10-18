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
/* loaded from: classes9.dex */
public class yk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public BdTypeRecyclerView b;
    public List<lh> c;
    public List<lh> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<yh> f;
    public ArrayList<yh> g;
    public FrsViewData h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yk7 yk7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk7Var, Integer.valueOf(i)};
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
            this.a = yk7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<lh<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    lh<?, ?> next = it.next();
                    if (next instanceof yc7) {
                        ((yc7) next).m(this.a.a.getPageContext(), this.a.a.getUniqueId());
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

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yk7 yk7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk7Var, Integer.valueOf(i)};
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
            this.a = yk7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                yk7 yk7Var = this.a;
                yk7Var.i(yk7Var.b);
                yk7 yk7Var2 = this.a;
                yk7Var2.w(yk7Var2.f, this.a.h);
            }
        }
    }

    public yk7(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void w(ArrayList<yh> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof gd7)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            pda.f(arrayList, 1);
            k(arrayList);
            ArrayList<yh> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
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
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, str) != null) || (list = this.d) == null) {
            return;
        }
        for (lh lhVar : list) {
            if (lhVar instanceof yz5) {
                ((yz5) lhVar).g(str);
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (lh lhVar : this.d) {
                if (lhVar instanceof zj6) {
                    ((zj6) lhVar).r(3);
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

    public List<yh> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public List<yh> m() {
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

    public void B(ii iiVar) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iiVar) == null) && (list = this.d) != null && list.size() != 0) {
            for (lh lhVar : this.d) {
                if (lhVar != null && (lhVar instanceof yc7)) {
                    ((yc7) lhVar).setOnAdapterItemClickListener(iiVar);
                }
            }
        }
    }

    public final void k(ArrayList<yh> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                yh yhVar = arrayList.get(i);
                if ((yhVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(yhVar)) {
                    this.e.put(Integer.valueOf(i), (ThreadData) yhVar);
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
            for (lh lhVar : this.d) {
                if (lhVar != null && lhVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void u(ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) && arrayList != null && arrayList.size() > 0) {
            Iterator<yh> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == ThreadData.TYPE_TOP) {
                    it.remove();
                }
            }
        }
    }

    public void x(boolean z) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (list = this.d) != null && list.size() != 0) {
            for (lh lhVar : this.d) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).setFromCDN(z);
                }
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (lh lhVar : this.d) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).A(frsViewData);
                }
            }
        }
    }

    public final void C() {
        go7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.h == null) {
            return;
        }
        for (lh lhVar : this.d) {
            if ((lhVar instanceof io7) && (i = ((io7) lhVar).i()) != null) {
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
            for (yh yhVar : this.b.getData()) {
                if (yhVar instanceof py4) {
                    py4 py4Var = (py4) yhVar;
                    if (py4Var.t.getIs_top() != 0) {
                        py4Var.t.parser_title();
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
                ArrayList<BdUniqueId> g = pda.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        yc7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = sc7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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
            qh7 qh7Var = new qh7(frsGoodFragment.D(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            ch7 ch7Var = new ch7(frsGoodFragment.D(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            nh7 nh7Var = new nh7(frsGoodFragment.D(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            kh7 kh7Var = new kh7(frsGoodFragment.D(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            bh7 bh7Var = new bh7(frsGoodFragment.D(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            eh7 eh7Var = new eh7(frsGoodFragment.D(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            sh7 sh7Var = new sh7(frsGoodFragment.D(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            oh7 oh7Var = new oh7(frsGoodFragment.D(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            mh7 mh7Var = new mh7(frsGoodFragment.D(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            jh7 jh7Var = new jh7(frsGoodFragment.D(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            rh7 rh7Var = new rh7(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            hh7 hh7Var = new hh7(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            lh7 lh7Var = new lh7(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            rh7 rh7Var2 = new rh7(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            fd7 fd7Var = new fd7(frsGoodFragment.getPageContext(), gd7.b);
            lh<? extends py4, ? extends TypeAdapter.ViewHolder> a2 = sc7.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            lh<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = sc7.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            lh<?, ?> e = tz9.m().e(this.a, AdvertAppInfo.x);
            lh<?, ?> e2 = tz9.m().e(this.a, AdvertAppInfo.A);
            ph7 ph7Var = new ph7(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            pg7 pg7Var = new pg7(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            wg7 wg7Var = new wg7(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            xg7 xg7Var = new xg7(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            ug7 ug7Var = new ug7(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ug7Var.x(bdTypeRecyclerView);
            ah7 ah7Var = new ah7(frsGoodFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            this.d.add(qh7Var);
            this.d.add(ch7Var);
            this.d.add(nh7Var);
            this.d.add(kh7Var);
            this.d.add(bh7Var);
            this.d.add(eh7Var);
            this.d.add(oh7Var);
            this.d.add(sh7Var);
            this.d.add(mh7Var);
            this.d.add(jh7Var);
            this.d.add(rh7Var);
            this.d.add(hh7Var);
            this.d.add(hh7Var);
            this.d.add(lh7Var);
            this.d.add(fd7Var);
            this.d.add(rh7Var);
            this.d.add(rh7Var2);
            this.d.add(ph7Var);
            this.d.add(pg7Var);
            this.d.add(wg7Var);
            this.d.add(xg7Var);
            this.d.add(ug7Var);
            this.d.add(ah7Var);
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
            this.d.add(ws7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, null));
            this.d.add(ws7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, null));
            vy5 vy5Var = new vy5(this.a, 1);
            vy5Var.u(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, vy5Var));
            bdTypeRecyclerView.addAdapters(this.d);
            v("page_frs_good");
            for (lh lhVar : this.d) {
                if (lhVar instanceof ak6) {
                    ((ak6) lhVar).j(true);
                }
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (lh lhVar : this.d) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).x();
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
        for (lh lhVar : this.d) {
            if (lhVar instanceof yc7) {
                ((yc7) lhVar).E(this.a.getTbPageTag());
            }
        }
    }
}
