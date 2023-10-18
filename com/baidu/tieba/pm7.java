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
public class pm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public ki c;
    public List<lh> d;
    public List<lh> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<yh> g;
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
        public final /* synthetic */ pm7 a;

        public a(pm7 pm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm7Var;
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
        public final /* synthetic */ pm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pm7 pm7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm7Var, Integer.valueOf(i)};
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
            this.a = pm7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                pm7 pm7Var = this.a;
                pm7Var.g(pm7Var.b);
                pm7 pm7Var2 = this.a;
                pm7Var2.p(pm7Var2.g, this.a.h);
            }
        }
    }

    public pm7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new ki(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<yh> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            pda.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = pda.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        yc7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = sc7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<yh> j() {
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

    public final void i(ArrayList<yh> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                yh yhVar = arrayList.get(i);
                if ((yhVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(yhVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) yhVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (lh lhVar : this.e) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (lh lhVar : this.e) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).A(frsViewData);
                }
            }
        }
    }

    public void t(ii iiVar) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, iiVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (lh lhVar : this.e) {
                if (lhVar != null && (lhVar instanceof yc7)) {
                    ((yc7) lhVar).setOnAdapterItemClickListener(iiVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            qh7 qh7Var = new qh7(frsNewAreaFragment.D(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            qh7Var.C(bdTypeRecyclerView);
            ch7 ch7Var = new ch7(frsNewAreaFragment.D(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            ch7Var.C(bdTypeRecyclerView);
            nh7 nh7Var = new nh7(frsNewAreaFragment.D(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            nh7Var.C(bdTypeRecyclerView);
            kh7 kh7Var = new kh7(frsNewAreaFragment.D(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            kh7Var.C(bdTypeRecyclerView);
            bh7 bh7Var = new bh7(frsNewAreaFragment.D(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            bh7Var.C(bdTypeRecyclerView);
            eh7 eh7Var = new eh7(frsNewAreaFragment.D(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            eh7Var.C(bdTypeRecyclerView);
            sh7 sh7Var = new sh7(frsNewAreaFragment.D(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            sh7Var.C(bdTypeRecyclerView);
            oh7 oh7Var = new oh7(frsNewAreaFragment.D(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            oh7Var.C(bdTypeRecyclerView);
            mh7 mh7Var = new mh7(frsNewAreaFragment.D(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            jh7 jh7Var = new jh7(frsNewAreaFragment.D(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            rh7 rh7Var = new rh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            rh7Var.C(bdTypeRecyclerView);
            dh7 dh7Var = new dh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            dh7Var.C(bdTypeRecyclerView);
            hh7 hh7Var = new hh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            hh7Var.C(bdTypeRecyclerView);
            pg7 pg7Var = new pg7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            pg7Var.C(bdTypeRecyclerView);
            wg7 wg7Var = new wg7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            wg7Var.C(bdTypeRecyclerView);
            xg7 xg7Var = new xg7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            xg7Var.C(bdTypeRecyclerView);
            lh7 lh7Var = new lh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            lh7Var.C(bdTypeRecyclerView);
            rh7 rh7Var2 = new rh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            rh7Var2.C(bdTypeRecyclerView);
            fd7 fd7Var = new fd7(frsNewAreaFragment.getPageContext(), gd7.b);
            fd7Var.C(bdTypeRecyclerView);
            lh<? extends py4, ? extends TypeAdapter.ViewHolder> a2 = sc7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            lh<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = sc7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            lh<?, ?> e = tz9.m().e(this.a, AdvertAppInfo.x);
            lh<?, ?> e2 = tz9.m().e(this.a, AdvertAppInfo.A);
            ph7 ph7Var = new ph7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ph7Var.C(bdTypeRecyclerView);
            ug7 ug7Var = new ug7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ug7Var.x(bdTypeRecyclerView);
            ah7 ah7Var = new ah7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            mg7 mg7Var = new mg7(frsNewAreaFragment.D(), f16.g);
            tg7 tg7Var = new tg7(frsNewAreaFragment.getPageContext(), rk6.A0);
            tg7Var.u(bdTypeRecyclerView);
            yg7 yg7Var = new yg7(frsNewAreaFragment.getPageContext(), wk6.j);
            yg7Var.u(bdTypeRecyclerView);
            this.e.add(qh7Var);
            this.e.add(ch7Var);
            this.e.add(nh7Var);
            this.e.add(kh7Var);
            this.e.add(bh7Var);
            this.e.add(eh7Var);
            this.e.add(oh7Var);
            this.e.add(sh7Var);
            this.e.add(mh7Var);
            this.e.add(jh7Var);
            this.e.add(rh7Var);
            this.e.add(hh7Var);
            this.e.add(pg7Var);
            this.e.add(wg7Var);
            this.e.add(xg7Var);
            this.e.add(lh7Var);
            this.e.add(fd7Var);
            this.e.add(dh7Var);
            this.e.add(rh7Var2);
            this.e.add(ph7Var);
            this.e.add(ug7Var);
            this.e.add(ah7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(mg7Var);
            this.e.add(new sg7(frsNewAreaFragment.getPageContext()));
            this.e.add(tg7Var);
            this.e.add(yg7Var);
            lh<?, ?> g = ws7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
            lh<?, ?> g2 = ws7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            this.e.add(g);
            this.e.add(g2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<lh<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    lh<?, ?> next = it.next();
                    if (next instanceof yc7) {
                        ((yc7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<lh> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            vy5 vy5Var = new vy5(this.a, 1);
            vy5Var.u(this.e);
            vy5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, vy5Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (lh lhVar : this.e) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).x();
                } else if (lhVar instanceof jz9) {
                    ((jz9) lhVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (lh lhVar : this.e) {
            if (lhVar instanceof yc7) {
                ((yc7) lhVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        go7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (lh lhVar : this.e) {
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
            }
        }
    }

    public void v() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getData() != null && this.b.getData().size() != 0) {
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
}
