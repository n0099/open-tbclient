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
public class ro7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public kn c;
    public List<lm> d;
    public List<lm> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<ym> g;
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
        public final /* synthetic */ ro7 a;

        public a(ro7 ro7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ro7Var;
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
        public final /* synthetic */ ro7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ro7 ro7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro7Var, Integer.valueOf(i)};
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
            this.a = ro7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                ro7 ro7Var = this.a;
                ro7Var.g(ro7Var.b);
                ro7 ro7Var2 = this.a;
                ro7Var2.p(ro7Var2.g, this.a.h);
            }
        }
    }

    public ro7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new kn(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<ym> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            raa.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = raa.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        gf7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = af7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<ym> j() {
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

    public final void i(ArrayList<ym> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                ym ymVar = arrayList.get(i);
                if ((ymVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(ymVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) ymVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (lm lmVar : this.e) {
                if (lmVar instanceof gf7) {
                    ((gf7) lmVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (lm lmVar : this.e) {
                if (lmVar instanceof gf7) {
                    ((gf7) lmVar).A(frsViewData);
                }
            }
        }
    }

    public void t(in inVar) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, inVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (lm lmVar : this.e) {
                if (lmVar != null && (lmVar instanceof gf7)) {
                    ((gf7) lmVar).setOnAdapterItemClickListener(inVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            sj7 sj7Var = new sj7(frsNewAreaFragment.u(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            sj7Var.C(bdTypeRecyclerView);
            ej7 ej7Var = new ej7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            ej7Var.C(bdTypeRecyclerView);
            pj7 pj7Var = new pj7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            pj7Var.C(bdTypeRecyclerView);
            mj7 mj7Var = new mj7(frsNewAreaFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            mj7Var.C(bdTypeRecyclerView);
            dj7 dj7Var = new dj7(frsNewAreaFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            dj7Var.C(bdTypeRecyclerView);
            gj7 gj7Var = new gj7(frsNewAreaFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            gj7Var.C(bdTypeRecyclerView);
            uj7 uj7Var = new uj7(frsNewAreaFragment.u(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            uj7Var.C(bdTypeRecyclerView);
            qj7 qj7Var = new qj7(frsNewAreaFragment.u(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            qj7Var.C(bdTypeRecyclerView);
            oj7 oj7Var = new oj7(frsNewAreaFragment.u(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            lj7 lj7Var = new lj7(frsNewAreaFragment.u(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            tj7 tj7Var = new tj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            tj7Var.C(bdTypeRecyclerView);
            fj7 fj7Var = new fj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            fj7Var.C(bdTypeRecyclerView);
            jj7 jj7Var = new jj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            jj7Var.C(bdTypeRecyclerView);
            si7 si7Var = new si7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            si7Var.C(bdTypeRecyclerView);
            zi7 zi7Var = new zi7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            zi7Var.C(bdTypeRecyclerView);
            aj7 aj7Var = new aj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            aj7Var.C(bdTypeRecyclerView);
            nj7 nj7Var = new nj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            nj7Var.C(bdTypeRecyclerView);
            tj7 tj7Var2 = new tj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            tj7Var2.C(bdTypeRecyclerView);
            nf7 nf7Var = new nf7(frsNewAreaFragment.getPageContext(), of7.b);
            nf7Var.C(bdTypeRecyclerView);
            lm<? extends w35, ? extends TypeAdapter.ViewHolder> a2 = af7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            lm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = af7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            lm<?, ?> e = lx9.m().e(this.a, AdvertAppInfo.x);
            lm<?, ?> e2 = lx9.m().e(this.a, AdvertAppInfo.A);
            rj7 rj7Var = new rj7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            rj7Var.C(bdTypeRecyclerView);
            xi7 xi7Var = new xi7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            xi7Var.x(bdTypeRecyclerView);
            qi7 qi7Var = new qi7(frsNewAreaFragment.u(), h56.g);
            wi7 wi7Var = new wi7(frsNewAreaFragment.getPageContext(), rn6.A0);
            wi7Var.u(bdTypeRecyclerView);
            this.e.add(sj7Var);
            this.e.add(ej7Var);
            this.e.add(pj7Var);
            this.e.add(mj7Var);
            this.e.add(dj7Var);
            this.e.add(gj7Var);
            this.e.add(qj7Var);
            this.e.add(uj7Var);
            this.e.add(oj7Var);
            this.e.add(lj7Var);
            this.e.add(tj7Var);
            this.e.add(jj7Var);
            this.e.add(si7Var);
            this.e.add(zi7Var);
            this.e.add(aj7Var);
            this.e.add(nj7Var);
            this.e.add(nf7Var);
            this.e.add(fj7Var);
            this.e.add(tj7Var2);
            this.e.add(rj7Var);
            this.e.add(xi7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(qi7Var);
            this.e.add(new vi7(frsNewAreaFragment.getPageContext()));
            this.e.add(wi7Var);
            lm<?, ?> g = dv7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
            lm<?, ?> g2 = dv7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            this.e.add(g);
            this.e.add(g2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<lm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    lm<?, ?> next = it.next();
                    if (next instanceof gf7) {
                        ((gf7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<lm> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            x26 x26Var = new x26(this.a, 1);
            x26Var.u(this.e);
            x26Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, x26Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (lm lmVar : this.e) {
                if (lmVar instanceof gf7) {
                    ((gf7) lmVar).x();
                } else if (lmVar instanceof bx9) {
                    ((bx9) lmVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (lm lmVar : this.e) {
            if (lmVar instanceof gf7) {
                ((gf7) lmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        qq7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (lm lmVar : this.e) {
            if ((lmVar instanceof sq7) && (i = ((sq7) lmVar).i()) != null) {
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
            for (ym ymVar : this.b.getData()) {
                if (ymVar instanceof w35) {
                    w35 w35Var = (w35) ymVar;
                    if (w35Var.t.getIs_top() != 0) {
                        w35Var.t.parser_title();
                    }
                }
            }
        }
    }
}
