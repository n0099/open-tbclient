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
public class jr7 {
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
        public final /* synthetic */ jr7 a;

        public a(jr7 jr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jr7Var;
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
        public final /* synthetic */ jr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(jr7 jr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jr7Var, Integer.valueOf(i)};
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
            this.a = jr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                jr7 jr7Var = this.a;
                jr7Var.g(jr7Var.b);
                jr7 jr7Var2 = this.a;
                jr7Var2.p(jr7Var2.g, this.a.h);
            }
        }
    }

    public jr7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            xba.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = xba.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        yh7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = sh7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (ln lnVar : this.e) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).A(frsViewData);
                }
            }
        }
    }

    public void t(io ioVar) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, ioVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (ln lnVar : this.e) {
                if (lnVar != null && (lnVar instanceof yh7)) {
                    ((yh7) lnVar).setOnAdapterItemClickListener(ioVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            km7 km7Var = new km7(frsNewAreaFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            km7Var.C(bdTypeRecyclerView);
            wl7 wl7Var = new wl7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            wl7Var.C(bdTypeRecyclerView);
            hm7 hm7Var = new hm7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            hm7Var.C(bdTypeRecyclerView);
            em7 em7Var = new em7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            em7Var.C(bdTypeRecyclerView);
            vl7 vl7Var = new vl7(frsNewAreaFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            vl7Var.C(bdTypeRecyclerView);
            yl7 yl7Var = new yl7(frsNewAreaFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            yl7Var.C(bdTypeRecyclerView);
            mm7 mm7Var = new mm7(frsNewAreaFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            mm7Var.C(bdTypeRecyclerView);
            im7 im7Var = new im7(frsNewAreaFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            im7Var.C(bdTypeRecyclerView);
            gm7 gm7Var = new gm7(frsNewAreaFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            dm7 dm7Var = new dm7(frsNewAreaFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            lm7 lm7Var = new lm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            lm7Var.C(bdTypeRecyclerView);
            xl7 xl7Var = new xl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            xl7Var.C(bdTypeRecyclerView);
            bm7 bm7Var = new bm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            bm7Var.C(bdTypeRecyclerView);
            kl7 kl7Var = new kl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            kl7Var.C(bdTypeRecyclerView);
            rl7 rl7Var = new rl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            rl7Var.C(bdTypeRecyclerView);
            sl7 sl7Var = new sl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            sl7Var.C(bdTypeRecyclerView);
            fm7 fm7Var = new fm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            fm7Var.C(bdTypeRecyclerView);
            lm7 lm7Var2 = new lm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            lm7Var2.C(bdTypeRecyclerView);
            fi7 fi7Var = new fi7(frsNewAreaFragment.getPageContext(), gi7.b);
            fi7Var.C(bdTypeRecyclerView);
            ln<? extends z45, ? extends TypeAdapter.ViewHolder> a2 = sh7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            ln<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = sh7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            ln<?, ?> e = uy9.m().e(this.a, AdvertAppInfo.x);
            ln<?, ?> e2 = uy9.m().e(this.a, AdvertAppInfo.A);
            jm7 jm7Var = new jm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            jm7Var.C(bdTypeRecyclerView);
            pl7 pl7Var = new pl7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            pl7Var.x(bdTypeRecyclerView);
            il7 il7Var = new il7(frsNewAreaFragment.t(), a86.g);
            ol7 ol7Var = new ol7(frsNewAreaFragment.getPageContext(), kq6.A0);
            ol7Var.u(bdTypeRecyclerView);
            this.e.add(km7Var);
            this.e.add(wl7Var);
            this.e.add(hm7Var);
            this.e.add(em7Var);
            this.e.add(vl7Var);
            this.e.add(yl7Var);
            this.e.add(im7Var);
            this.e.add(mm7Var);
            this.e.add(gm7Var);
            this.e.add(dm7Var);
            this.e.add(lm7Var);
            this.e.add(bm7Var);
            this.e.add(kl7Var);
            this.e.add(rl7Var);
            this.e.add(sl7Var);
            this.e.add(fm7Var);
            this.e.add(fi7Var);
            this.e.add(xl7Var);
            this.e.add(lm7Var2);
            this.e.add(jm7Var);
            this.e.add(pl7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(il7Var);
            this.e.add(new nl7(frsNewAreaFragment.getPageContext()));
            this.e.add(ol7Var);
            ln<?, ?> g = vx7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
            ln<?, ?> g2 = vx7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            this.e.add(g);
            this.e.add(g2);
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
                    if (next instanceof yh7) {
                        ((yh7) next).m(this.a.getPageContext(), this.a.getUniqueId());
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
            q56 q56Var = new q56(this.a, 1);
            q56Var.u(this.e);
            q56Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, q56Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (ln lnVar : this.e) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).x();
                } else if (lnVar instanceof ky9) {
                    ((ky9) lnVar).onDestroy();
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
            if (lnVar instanceof yh7) {
                ((yh7) lnVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        it7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (ln lnVar : this.e) {
            if ((lnVar instanceof kt7) && (i = ((kt7) lnVar).i()) != null) {
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
                if (ynVar instanceof z45) {
                    z45 z45Var = (z45) ynVar;
                    if (z45Var.t.getIs_top() != 0) {
                        z45Var.t.parser_title();
                    }
                }
            }
        }
    }
}
