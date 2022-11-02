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
public class tr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public List<jn> c;
    public List<jn> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<wn> f;
    public FrsViewData g;
    public CustomMessageListener h;

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tr6 tr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr6Var, Integer.valueOf(i)};
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
            this.a = tr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                tr6 tr6Var = this.a;
                tr6Var.g(tr6Var.b);
                tr6 tr6Var2 = this.a;
                tr6Var2.q(tr6Var2.f, this.a.g);
            }
        }
    }

    public tr6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.h);
        }
    }

    public void q(ArrayList<wn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            zn8.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.f = arrayList;
            this.g = frsViewData;
            v();
        }
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.c = new ArrayList();
                ArrayList<BdUniqueId> g = zn8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        ui6<ICardInfo, ? extends TypeAdapter.ViewHolder> b = oi6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b != null) {
                            this.d.add(b);
                            this.c.add(b);
                        }
                    }
                    if (!ListUtils.isEmpty(this.c)) {
                        bdTypeRecyclerView.a(this.c);
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
            return this.e;
        }
        return (HashMap) invokeV.objValue;
    }

    public List<wn> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
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

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setData(this.f);
            l();
        }
    }

    public final void i(ArrayList<wn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                wn wnVar = arrayList.get(i);
                if ((wnVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(wnVar)) {
                    this.e.put(Integer.valueOf(i), (ThreadData) wnVar);
                }
            }
        }
    }

    public void r(boolean z) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (list = this.d) != null && list.size() != 0) {
            for (jn jnVar : this.d) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).setFromCDN(z);
                }
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (jn jnVar : this.d) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).y(frsViewData);
                }
            }
        }
    }

    public void u(go goVar) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, goVar) == null) && (list = this.d) != null && list.size() != 0) {
            for (jn jnVar : this.d) {
                if (jnVar != null && (jnVar instanceof ui6)) {
                    ((ui6) jnVar).setOnAdapterItemClickListener(goVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            dn6 dn6Var = new dn6(frsNewAreaFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            dn6Var.A(bdTypeRecyclerView);
            pm6 pm6Var = new pm6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            pm6Var.A(bdTypeRecyclerView);
            an6 an6Var = new an6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            an6Var.A(bdTypeRecyclerView);
            xm6 xm6Var = new xm6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            xm6Var.A(bdTypeRecyclerView);
            om6 om6Var = new om6(frsNewAreaFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            om6Var.A(bdTypeRecyclerView);
            rm6 rm6Var = new rm6(frsNewAreaFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            rm6Var.A(bdTypeRecyclerView);
            fn6 fn6Var = new fn6(frsNewAreaFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            fn6Var.A(bdTypeRecyclerView);
            bn6 bn6Var = new bn6(frsNewAreaFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            bn6Var.A(bdTypeRecyclerView);
            zm6 zm6Var = new zm6(frsNewAreaFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            wm6 wm6Var = new wm6(frsNewAreaFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            en6 en6Var = new en6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            en6Var.A(bdTypeRecyclerView);
            qm6 qm6Var = new qm6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            qm6Var.A(bdTypeRecyclerView);
            um6 um6Var = new um6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            um6Var.A(bdTypeRecyclerView);
            fm6 fm6Var = new fm6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            fm6Var.A(bdTypeRecyclerView);
            km6 km6Var = new km6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            km6Var.A(bdTypeRecyclerView);
            lm6 lm6Var = new lm6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            lm6Var.A(bdTypeRecyclerView);
            ym6 ym6Var = new ym6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            ym6Var.A(bdTypeRecyclerView);
            en6 en6Var2 = new en6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            en6Var2.A(bdTypeRecyclerView);
            bj6 bj6Var = new bj6(frsNewAreaFragment.getPageContext(), cj6.b);
            bj6Var.A(bdTypeRecyclerView);
            jn<? extends vu4, ? extends TypeAdapter.ViewHolder> a2 = oi6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            jn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = oi6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            jn<?, ?> d2 = vf8.l().d(this.a, AdvertAppInfo.w);
            jn<?, ?> d3 = vf8.l().d(this.a, AdvertAppInfo.z);
            cn6 cn6Var = new cn6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            cn6Var.A(bdTypeRecyclerView);
            im6 im6Var = new im6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            im6Var.v(bdTypeRecyclerView);
            dm6 dm6Var = new dm6(frsNewAreaFragment.o(), er5.g);
            this.d.add(dn6Var);
            this.d.add(pm6Var);
            this.d.add(an6Var);
            this.d.add(xm6Var);
            this.d.add(om6Var);
            this.d.add(rm6Var);
            this.d.add(bn6Var);
            this.d.add(fn6Var);
            this.d.add(zm6Var);
            this.d.add(wm6Var);
            this.d.add(en6Var);
            this.d.add(um6Var);
            this.d.add(fm6Var);
            this.d.add(km6Var);
            this.d.add(lm6Var);
            this.d.add(ym6Var);
            this.d.add(bj6Var);
            this.d.add(qm6Var);
            this.d.add(en6Var2);
            this.d.add(cn6Var);
            this.d.add(im6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            this.d.add(dm6Var);
            jn<?, ?> d4 = nw6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            jn<?, ?> d5 = nw6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.d.add(d4);
            this.d.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<jn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    jn<?, ?> next = it.next();
                    if (next instanceof ui6) {
                        ((ui6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<jn> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            wo5 wo5Var = new wo5(this.a, 1);
            wo5Var.u(this.d);
            wo5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wo5Var));
            bdTypeRecyclerView.a(this.d);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (jn jnVar : this.d) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).v();
                } else if (jnVar instanceof mf8) {
                    ((mf8) jnVar).onDestroy();
                }
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (jn jnVar : this.d) {
            if (jnVar instanceof ui6) {
                ((ui6) jnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void v() {
        qt6 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.g == null) {
            return;
        }
        for (jn jnVar : this.d) {
            if ((jnVar instanceof st6) && (i = ((st6) jnVar).i()) != null) {
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
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getData() != null && this.b.getData().size() != 0) {
            for (wn wnVar : this.b.getData()) {
                if (wnVar instanceof vu4) {
                    vu4 vu4Var = (vu4) wnVar;
                    if (vu4Var.t.getIs_top() != 0) {
                        vu4Var.t.parser_title();
                    }
                }
            }
        }
    }
}
