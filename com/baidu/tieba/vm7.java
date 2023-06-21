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
/* loaded from: classes8.dex */
public class vm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public io c;
    public List<jn> d;
    public List<jn> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<wn> g;
    public FrsViewData h;
    public CustomMessageListener i;

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm7 a;

        public a(vm7 vm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vm7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vm7 vm7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm7Var, Integer.valueOf(i)};
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
            this.a = vm7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                vm7 vm7Var = this.a;
                vm7Var.g(vm7Var.b);
                vm7 vm7Var2 = this.a;
                vm7Var2.p(vm7Var2.g, this.a.h);
            }
        }
    }

    public vm7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new io(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<wn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            az9.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = az9.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        nd7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = hd7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<wn> j() {
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

    public final void i(ArrayList<wn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                wn wnVar = arrayList.get(i);
                if ((wnVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(wnVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) wnVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (jn jnVar : this.e) {
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (jn jnVar : this.e) {
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).A(frsViewData);
                }
            }
        }
    }

    public void t(go goVar) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, goVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (jn jnVar : this.e) {
                if (jnVar != null && (jnVar instanceof nd7)) {
                    ((nd7) jnVar).setOnAdapterItemClickListener(goVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            yh7 yh7Var = new yh7(frsNewAreaFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            yh7Var.C(bdTypeRecyclerView);
            kh7 kh7Var = new kh7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            kh7Var.C(bdTypeRecyclerView);
            vh7 vh7Var = new vh7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            vh7Var.C(bdTypeRecyclerView);
            sh7 sh7Var = new sh7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            sh7Var.C(bdTypeRecyclerView);
            jh7 jh7Var = new jh7(frsNewAreaFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            jh7Var.C(bdTypeRecyclerView);
            mh7 mh7Var = new mh7(frsNewAreaFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            mh7Var.C(bdTypeRecyclerView);
            ai7 ai7Var = new ai7(frsNewAreaFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            ai7Var.C(bdTypeRecyclerView);
            wh7 wh7Var = new wh7(frsNewAreaFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            wh7Var.C(bdTypeRecyclerView);
            uh7 uh7Var = new uh7(frsNewAreaFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            rh7 rh7Var = new rh7(frsNewAreaFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            zh7 zh7Var = new zh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            zh7Var.C(bdTypeRecyclerView);
            lh7 lh7Var = new lh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            lh7Var.C(bdTypeRecyclerView);
            ph7 ph7Var = new ph7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ph7Var.C(bdTypeRecyclerView);
            zg7 zg7Var = new zg7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            zg7Var.C(bdTypeRecyclerView);
            fh7 fh7Var = new fh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            fh7Var.C(bdTypeRecyclerView);
            gh7 gh7Var = new gh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            gh7Var.C(bdTypeRecyclerView);
            th7 th7Var = new th7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            th7Var.C(bdTypeRecyclerView);
            zh7 zh7Var2 = new zh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            zh7Var2.C(bdTypeRecyclerView);
            ud7 ud7Var = new ud7(frsNewAreaFragment.getPageContext(), vd7.b);
            ud7Var.C(bdTypeRecyclerView);
            jn<? extends o45, ? extends TypeAdapter.ViewHolder> a2 = hd7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            jn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = hd7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            jn<?, ?> d2 = bo9.l().d(this.a, AdvertAppInfo.w);
            jn<?, ?> d3 = bo9.l().d(this.a, AdvertAppInfo.z);
            xh7 xh7Var = new xh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            xh7Var.C(bdTypeRecyclerView);
            dh7 dh7Var = new dh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            dh7Var.x(bdTypeRecyclerView);
            xg7 xg7Var = new xg7(frsNewAreaFragment.t(), r66.g);
            this.e.add(yh7Var);
            this.e.add(kh7Var);
            this.e.add(vh7Var);
            this.e.add(sh7Var);
            this.e.add(jh7Var);
            this.e.add(mh7Var);
            this.e.add(wh7Var);
            this.e.add(ai7Var);
            this.e.add(uh7Var);
            this.e.add(rh7Var);
            this.e.add(zh7Var);
            this.e.add(ph7Var);
            this.e.add(zg7Var);
            this.e.add(fh7Var);
            this.e.add(gh7Var);
            this.e.add(th7Var);
            this.e.add(ud7Var);
            this.e.add(lh7Var);
            this.e.add(zh7Var2);
            this.e.add(xh7Var);
            this.e.add(dh7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(xg7Var);
            this.e.add(new ch7(frsNewAreaFragment.getPageContext()));
            jn<?, ?> d4 = bt7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            jn<?, ?> d5 = bt7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
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
                    if (next instanceof nd7) {
                        ((nd7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<jn> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            h46 h46Var = new h46(this.a, 1);
            h46Var.u(this.e);
            h46Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, h46Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (jn jnVar : this.e) {
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).x();
                } else if (jnVar instanceof rn9) {
                    ((rn9) jnVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (jn jnVar : this.e) {
            if (jnVar instanceof nd7) {
                ((nd7) jnVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        uo7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (jn jnVar : this.e) {
            if ((jnVar instanceof wo7) && (i = ((wo7) jnVar).i()) != null) {
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
            for (wn wnVar : this.b.getData()) {
                if (wnVar instanceof o45) {
                    o45 o45Var = (o45) wnVar;
                    if (o45Var.t.getIs_top() != 0) {
                        o45Var.t.parser_title();
                    }
                }
            }
        }
    }
}
