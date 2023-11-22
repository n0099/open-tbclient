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
public class kz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public aj c;
    public List<bi> d;
    public List<bi> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<oi> g;
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
        public final /* synthetic */ kz7 a;

        public a(kz7 kz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz7Var;
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
        public final /* synthetic */ kz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kz7 kz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var, Integer.valueOf(i)};
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
            this.a = kz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                kz7 kz7Var = this.a;
                kz7Var.g(kz7Var.b);
                kz7 kz7Var2 = this.a;
                kz7Var2.p(kz7Var2.g, this.a.h);
            }
        }
    }

    public kz7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new aj(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<oi> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            vqa.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = vqa.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        qp7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = kp7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<oi> j() {
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

    public final void i(ArrayList<oi> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                oi oiVar = arrayList.get(i);
                if ((oiVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(oiVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) oiVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (bi biVar : this.e) {
                if (biVar instanceof qp7) {
                    ((qp7) biVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (bi biVar : this.e) {
                if (biVar instanceof qp7) {
                    ((qp7) biVar).B(frsViewData);
                }
            }
        }
    }

    public void t(yi yiVar) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, yiVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (bi biVar : this.e) {
                if (biVar != null && (biVar instanceof qp7)) {
                    ((qp7) biVar).setOnAdapterItemClickListener(yiVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            lu7 lu7Var = new lu7(frsNewAreaFragment.H(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            lu7Var.D(bdTypeRecyclerView);
            xt7 xt7Var = new xt7(frsNewAreaFragment.H(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            xt7Var.D(bdTypeRecyclerView);
            iu7 iu7Var = new iu7(frsNewAreaFragment.H(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            iu7Var.D(bdTypeRecyclerView);
            fu7 fu7Var = new fu7(frsNewAreaFragment.H(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            fu7Var.D(bdTypeRecyclerView);
            wt7 wt7Var = new wt7(frsNewAreaFragment.H(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            wt7Var.D(bdTypeRecyclerView);
            zt7 zt7Var = new zt7(frsNewAreaFragment.H(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            zt7Var.D(bdTypeRecyclerView);
            nu7 nu7Var = new nu7(frsNewAreaFragment.H(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            nu7Var.D(bdTypeRecyclerView);
            ju7 ju7Var = new ju7(frsNewAreaFragment.H(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            ju7Var.D(bdTypeRecyclerView);
            hu7 hu7Var = new hu7(frsNewAreaFragment.H(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            eu7 eu7Var = new eu7(frsNewAreaFragment.H(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            mu7 mu7Var = new mu7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            mu7Var.D(bdTypeRecyclerView);
            yt7 yt7Var = new yt7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            yt7Var.D(bdTypeRecyclerView);
            cu7 cu7Var = new cu7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            cu7Var.D(bdTypeRecyclerView);
            kt7 kt7Var = new kt7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            kt7Var.D(bdTypeRecyclerView);
            rt7 rt7Var = new rt7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            rt7Var.D(bdTypeRecyclerView);
            st7 st7Var = new st7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            st7Var.D(bdTypeRecyclerView);
            gu7 gu7Var = new gu7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            gu7Var.D(bdTypeRecyclerView);
            mu7 mu7Var2 = new mu7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            mu7Var2.D(bdTypeRecyclerView);
            xp7 xp7Var = new xp7(frsNewAreaFragment.getPageContext(), yp7.b);
            xp7Var.D(bdTypeRecyclerView);
            bi<? extends hz4, ? extends TypeAdapter.ViewHolder> a2 = kp7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            bi<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = kp7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            bi<?, ?> e = zca.m().e(this.a, AdvertAppInfo.y);
            bi<?, ?> e2 = zca.m().e(this.a, AdvertAppInfo.B);
            ku7 ku7Var = new ku7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ku7Var.D(bdTypeRecyclerView);
            pt7 pt7Var = new pt7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            pt7Var.y(bdTypeRecyclerView);
            vt7 vt7Var = new vt7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            ht7 ht7Var = new ht7(frsNewAreaFragment.H(), a36.g);
            ot7 ot7Var = new ot7(frsNewAreaFragment.getPageContext(), om6.A0);
            ot7Var.x(bdTypeRecyclerView);
            tt7 tt7Var = new tt7(frsNewAreaFragment.getPageContext(), tm6.j);
            tt7Var.x(bdTypeRecyclerView);
            this.e.add(lu7Var);
            this.e.add(xt7Var);
            this.e.add(iu7Var);
            this.e.add(fu7Var);
            this.e.add(wt7Var);
            this.e.add(zt7Var);
            this.e.add(ju7Var);
            this.e.add(nu7Var);
            this.e.add(hu7Var);
            this.e.add(eu7Var);
            this.e.add(mu7Var);
            this.e.add(cu7Var);
            this.e.add(kt7Var);
            this.e.add(rt7Var);
            this.e.add(st7Var);
            this.e.add(gu7Var);
            this.e.add(xp7Var);
            this.e.add(yt7Var);
            this.e.add(mu7Var2);
            this.e.add(ku7Var);
            this.e.add(pt7Var);
            this.e.add(vt7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(ht7Var);
            this.e.add(new nt7(frsNewAreaFragment.getPageContext()));
            this.e.add(ot7Var);
            this.e.add(tt7Var);
            bi<?, ?> g = s58.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.J, "frs_new_tab");
            bi<?, ?> g2 = s58.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
            this.e.add(g);
            this.e.add(g2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<bi<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    bi<?, ?> next = it.next();
                    if (next instanceof qp7) {
                        ((qp7) next).n(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<bi> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            q06 q06Var = new q06(this.a, 1);
            q06Var.u(this.e);
            q06Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, q06Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (bi biVar : this.e) {
                if (biVar instanceof qp7) {
                    ((qp7) biVar).y();
                } else if (biVar instanceof pca) {
                    ((pca) biVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (bi biVar : this.e) {
            if (biVar instanceof qp7) {
                ((qp7) biVar).F(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        b18 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (bi biVar : this.e) {
            if ((biVar instanceof d18) && (i = ((d18) biVar).i()) != null) {
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
            for (oi oiVar : this.b.getData()) {
                if (oiVar instanceof hz4) {
                    hz4 hz4Var = (hz4) oiVar;
                    if (hz4Var.t.getIs_top() != 0) {
                        hz4Var.t.parser_title();
                    }
                }
            }
        }
    }
}
