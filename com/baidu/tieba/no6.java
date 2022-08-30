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
/* loaded from: classes5.dex */
public class no6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public List<cn> c;
    public List<cn> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<pn> f;
    public FrsViewData g;
    public CustomMessageListener h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(no6 no6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no6Var, Integer.valueOf(i)};
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
            this.a = no6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                no6 no6Var = this.a;
                no6Var.g(no6Var.b);
                no6 no6Var2 = this.a;
                no6Var2.q(no6Var2.f, this.a.g);
            }
        }
    }

    public no6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.d = new LinkedList();
        this.h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
        this.e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.c = new ArrayList();
                ArrayList<BdUniqueId> g = ik8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        cf6<ICardInfo, ? extends TypeAdapter.ViewHolder> b = we6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b != null) {
                            this.d.add(b);
                            this.c.add(b);
                        }
                    }
                    if (ListUtils.isEmpty(this.c)) {
                        return true;
                    }
                    bdTypeRecyclerView.a(this.c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<pn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            pn pnVar = arrayList.get(i);
            if ((pnVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(pnVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) pnVar);
            }
        }
    }

    public List<pn> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            vj6 vj6Var = new vj6(frsNewAreaFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            vj6Var.A(bdTypeRecyclerView);
            hj6 hj6Var = new hj6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            hj6Var.A(bdTypeRecyclerView);
            sj6 sj6Var = new sj6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            sj6Var.A(bdTypeRecyclerView);
            pj6 pj6Var = new pj6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            pj6Var.A(bdTypeRecyclerView);
            gj6 gj6Var = new gj6(frsNewAreaFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            gj6Var.A(bdTypeRecyclerView);
            jj6 jj6Var = new jj6(frsNewAreaFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            jj6Var.A(bdTypeRecyclerView);
            xj6 xj6Var = new xj6(frsNewAreaFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            xj6Var.A(bdTypeRecyclerView);
            tj6 tj6Var = new tj6(frsNewAreaFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            tj6Var.A(bdTypeRecyclerView);
            rj6 rj6Var = new rj6(frsNewAreaFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            oj6 oj6Var = new oj6(frsNewAreaFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            wj6 wj6Var = new wj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            wj6Var.A(bdTypeRecyclerView);
            ij6 ij6Var = new ij6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            ij6Var.A(bdTypeRecyclerView);
            mj6 mj6Var = new mj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            mj6Var.A(bdTypeRecyclerView);
            xi6 xi6Var = new xi6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            xi6Var.A(bdTypeRecyclerView);
            cj6 cj6Var = new cj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            cj6Var.A(bdTypeRecyclerView);
            dj6 dj6Var = new dj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            dj6Var.A(bdTypeRecyclerView);
            qj6 qj6Var = new qj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            qj6Var.A(bdTypeRecyclerView);
            wj6 wj6Var2 = new wj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            wj6Var2.A(bdTypeRecyclerView);
            jf6 jf6Var = new jf6(frsNewAreaFragment.getPageContext(), kf6.b);
            jf6Var.A(bdTypeRecyclerView);
            cn<? extends kr4, ? extends TypeAdapter.ViewHolder> a2 = we6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            cn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = we6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            cn<?, ?> d2 = gc8.l().d(this.a, AdvertAppInfo.w);
            cn<?, ?> d3 = gc8.l().d(this.a, AdvertAppInfo.z);
            uj6 uj6Var = new uj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            uj6Var.A(bdTypeRecyclerView);
            aj6 aj6Var = new aj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            aj6Var.v(bdTypeRecyclerView);
            this.d.add(vj6Var);
            this.d.add(hj6Var);
            this.d.add(sj6Var);
            this.d.add(pj6Var);
            this.d.add(gj6Var);
            this.d.add(jj6Var);
            this.d.add(tj6Var);
            this.d.add(xj6Var);
            this.d.add(rj6Var);
            this.d.add(oj6Var);
            this.d.add(wj6Var);
            this.d.add(mj6Var);
            this.d.add(xi6Var);
            this.d.add(cj6Var);
            this.d.add(dj6Var);
            this.d.add(qj6Var);
            this.d.add(jf6Var);
            this.d.add(ij6Var);
            this.d.add(wj6Var2);
            this.d.add(uj6Var);
            this.d.add(aj6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            cn<?, ?> d4 = at6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            cn<?, ?> d5 = at6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.d.add(d4);
            this.d.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<cn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    cn<?, ?> next = it.next();
                    if (next instanceof cf6) {
                        ((cf6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<cn> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            wk5 wk5Var = new wk5(this.a, 1);
            wk5Var.u(this.d);
            wk5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wk5Var));
            bdTypeRecyclerView.a(this.d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (cn cnVar : this.d) {
                if (cnVar instanceof cf6) {
                    ((cf6) cnVar).v();
                } else if (cnVar instanceof xb8) {
                    ((xb8) cnVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setData(this.f);
            l();
        }
    }

    public void q(ArrayList<pn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            ik8.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.f = arrayList;
            this.g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.d) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (cn cnVar : this.d) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.d) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).y(frsViewData);
            }
        }
    }

    public void u(zn znVar) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, znVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.d) {
            if (cnVar != null && (cnVar instanceof cf6)) {
                ((cf6) cnVar).setOnAdapterItemClickListener(znVar);
            }
        }
    }

    public final void v() {
        fq6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.g == null) {
            return;
        }
        for (cn cnVar : this.d) {
            if ((cnVar instanceof hq6) && (i = ((hq6) cnVar).i()) != null) {
                if (this.g.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.g.getForum() != null) {
                    i.c = this.g.getForum().getId();
                    i.d = this.g.getForum().getName();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.b) == null || bdTypeRecyclerView.getData() == null || this.b.getData().size() == 0) {
            return;
        }
        for (pn pnVar : this.b.getData()) {
            if (pnVar instanceof kr4) {
                kr4 kr4Var = (kr4) pnVar;
                if (kr4Var.t.getIs_top() != 0) {
                    kr4Var.t.parser_title();
                }
            }
        }
    }
}
