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
public class rw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public ko c;
    public List<ln> d;
    public List<ln> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<yn> g;
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
        public final /* synthetic */ rw6 a;

        public a(rw6 rw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rw6Var;
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
        public final /* synthetic */ rw6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rw6 rw6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw6Var, Integer.valueOf(i)};
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
            this.a = rw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                rw6 rw6Var = this.a;
                rw6Var.g(rw6Var.b);
                rw6 rw6Var2 = this.a;
                rw6Var2.p(rw6Var2.g, this.a.h);
            }
        }
    }

    public rw6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new ko(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<yn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            hw8.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = hw8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        pn6<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = jn6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.e.add(b2);
                            this.d.add(b2);
                        }
                    }
                    if (!ListUtils.isEmpty(this.d)) {
                        bdTypeRecyclerView.a(this.d);
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

    public List<yn> j() {
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

    public final void i(ArrayList<yn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                yn ynVar = arrayList.get(i);
                if ((ynVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(ynVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) ynVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (ln lnVar : this.e) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (ln lnVar : this.e) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).y(frsViewData);
                }
            }
        }
    }

    public void t(io ioVar) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, ioVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (ln lnVar : this.e) {
                if (lnVar != null && (lnVar instanceof pn6)) {
                    ((pn6) lnVar).setOnAdapterItemClickListener(ioVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            as6 as6Var = new as6(frsNewAreaFragment.p(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            as6Var.A(bdTypeRecyclerView);
            mr6 mr6Var = new mr6(frsNewAreaFragment.p(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            mr6Var.A(bdTypeRecyclerView);
            xr6 xr6Var = new xr6(frsNewAreaFragment.p(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            xr6Var.A(bdTypeRecyclerView);
            ur6 ur6Var = new ur6(frsNewAreaFragment.p(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            ur6Var.A(bdTypeRecyclerView);
            lr6 lr6Var = new lr6(frsNewAreaFragment.p(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            lr6Var.A(bdTypeRecyclerView);
            or6 or6Var = new or6(frsNewAreaFragment.p(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            or6Var.A(bdTypeRecyclerView);
            cs6 cs6Var = new cs6(frsNewAreaFragment.p(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            cs6Var.A(bdTypeRecyclerView);
            yr6 yr6Var = new yr6(frsNewAreaFragment.p(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            yr6Var.A(bdTypeRecyclerView);
            wr6 wr6Var = new wr6(frsNewAreaFragment.p(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            tr6 tr6Var = new tr6(frsNewAreaFragment.p(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            bs6 bs6Var = new bs6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            bs6Var.A(bdTypeRecyclerView);
            nr6 nr6Var = new nr6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            nr6Var.A(bdTypeRecyclerView);
            rr6 rr6Var = new rr6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            rr6Var.A(bdTypeRecyclerView);
            br6 br6Var = new br6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            br6Var.A(bdTypeRecyclerView);
            hr6 hr6Var = new hr6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            hr6Var.A(bdTypeRecyclerView);
            ir6 ir6Var = new ir6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            ir6Var.A(bdTypeRecyclerView);
            vr6 vr6Var = new vr6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            vr6Var.A(bdTypeRecyclerView);
            bs6 bs6Var2 = new bs6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            bs6Var2.A(bdTypeRecyclerView);
            wn6 wn6Var = new wn6(frsNewAreaFragment.getPageContext(), xn6.b);
            wn6Var.A(bdTypeRecyclerView);
            ln<? extends jv4, ? extends TypeAdapter.ViewHolder> a2 = jn6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            ln<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = jn6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            ln<?, ?> d2 = rn8.l().d(this.a, AdvertAppInfo.w);
            ln<?, ?> d3 = rn8.l().d(this.a, AdvertAppInfo.z);
            zr6 zr6Var = new zr6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            zr6Var.A(bdTypeRecyclerView);
            fr6 fr6Var = new fr6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            fr6Var.v(bdTypeRecyclerView);
            zq6 zq6Var = new zq6(frsNewAreaFragment.p(), gt5.g);
            this.e.add(as6Var);
            this.e.add(mr6Var);
            this.e.add(xr6Var);
            this.e.add(ur6Var);
            this.e.add(lr6Var);
            this.e.add(or6Var);
            this.e.add(yr6Var);
            this.e.add(cs6Var);
            this.e.add(wr6Var);
            this.e.add(tr6Var);
            this.e.add(bs6Var);
            this.e.add(rr6Var);
            this.e.add(br6Var);
            this.e.add(hr6Var);
            this.e.add(ir6Var);
            this.e.add(vr6Var);
            this.e.add(wn6Var);
            this.e.add(nr6Var);
            this.e.add(bs6Var2);
            this.e.add(zr6Var);
            this.e.add(fr6Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(zq6Var);
            this.e.add(new er6(frsNewAreaFragment.getPageContext()));
            ln<?, ?> d4 = u17.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            ln<?, ?> d5 = u17.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<ln<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    ln<?, ?> next = it.next();
                    if (next instanceof pn6) {
                        ((pn6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<ln> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            yq5 yq5Var = new yq5(this.a, 1);
            yq5Var.u(this.e);
            yq5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, yq5Var));
            bdTypeRecyclerView.a(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (ln lnVar : this.e) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).v();
                } else if (lnVar instanceof in8) {
                    ((in8) lnVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (ln lnVar : this.e) {
            if (lnVar instanceof pn6) {
                ((pn6) lnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        qy6 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (ln lnVar : this.e) {
            if ((lnVar instanceof sy6) && (i = ((sy6) lnVar).i()) != null) {
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
            for (yn ynVar : this.b.getData()) {
                if (ynVar instanceof jv4) {
                    jv4 jv4Var = (jv4) ynVar;
                    if (jv4Var.t.getIs_top() != 0) {
                        jv4Var.t.parser_title();
                    }
                }
            }
        }
    }
}
