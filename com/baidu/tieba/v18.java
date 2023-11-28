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
public class v18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public bj c;
    public List<ci> d;
    public List<ci> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<pi> g;
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
        public final /* synthetic */ v18 a;

        public a(v18 v18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v18Var;
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
        public final /* synthetic */ v18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(v18 v18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v18Var, Integer.valueOf(i)};
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
            this.a = v18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                v18 v18Var = this.a;
                v18Var.g(v18Var.b);
                v18 v18Var2 = this.a;
                v18Var2.p(v18Var2.g, this.a.h);
            }
        }
    }

    public v18(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new bj(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<pi> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            ova.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = ova.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        cs7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = wr7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<pi> j() {
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

    public final void i(ArrayList<pi> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                pi piVar = arrayList.get(i);
                if ((piVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(piVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) piVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (ci ciVar : this.e) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (ci ciVar : this.e) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).B(frsViewData);
                }
            }
        }
    }

    public void t(zi ziVar) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, ziVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (ci ciVar : this.e) {
                if (ciVar != null && (ciVar instanceof cs7)) {
                    ((cs7) ciVar).setOnAdapterItemClickListener(ziVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            ww7 ww7Var = new ww7(frsNewAreaFragment.I(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            ww7Var.D(bdTypeRecyclerView);
            iw7 iw7Var = new iw7(frsNewAreaFragment.I(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            iw7Var.D(bdTypeRecyclerView);
            tw7 tw7Var = new tw7(frsNewAreaFragment.I(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            tw7Var.D(bdTypeRecyclerView);
            qw7 qw7Var = new qw7(frsNewAreaFragment.I(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            qw7Var.D(bdTypeRecyclerView);
            hw7 hw7Var = new hw7(frsNewAreaFragment.I(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            hw7Var.D(bdTypeRecyclerView);
            kw7 kw7Var = new kw7(frsNewAreaFragment.I(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            kw7Var.D(bdTypeRecyclerView);
            yw7 yw7Var = new yw7(frsNewAreaFragment.I(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            yw7Var.D(bdTypeRecyclerView);
            uw7 uw7Var = new uw7(frsNewAreaFragment.I(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            uw7Var.D(bdTypeRecyclerView);
            sw7 sw7Var = new sw7(frsNewAreaFragment.I(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            pw7 pw7Var = new pw7(frsNewAreaFragment.I(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            xw7 xw7Var = new xw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            xw7Var.D(bdTypeRecyclerView);
            jw7 jw7Var = new jw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            jw7Var.D(bdTypeRecyclerView);
            nw7 nw7Var = new nw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            nw7Var.D(bdTypeRecyclerView);
            vv7 vv7Var = new vv7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            vv7Var.D(bdTypeRecyclerView);
            cw7 cw7Var = new cw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            cw7Var.D(bdTypeRecyclerView);
            dw7 dw7Var = new dw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            dw7Var.D(bdTypeRecyclerView);
            rw7 rw7Var = new rw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            rw7Var.D(bdTypeRecyclerView);
            xw7 xw7Var2 = new xw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            xw7Var2.D(bdTypeRecyclerView);
            js7 js7Var = new js7(frsNewAreaFragment.getPageContext(), ks7.b);
            js7Var.D(bdTypeRecyclerView);
            ci<? extends jz4, ? extends TypeAdapter.ViewHolder> a2 = wr7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            ci<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = wr7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            ci<?, ?> e = rha.m().e(this.a, AdvertAppInfo.y);
            ci<?, ?> e2 = rha.m().e(this.a, AdvertAppInfo.B);
            vw7 vw7Var = new vw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            vw7Var.D(bdTypeRecyclerView);
            aw7 aw7Var = new aw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            aw7Var.y(bdTypeRecyclerView);
            gw7 gw7Var = new gw7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            sv7 sv7Var = new sv7(frsNewAreaFragment.I(), h36.g);
            zv7 zv7Var = new zv7(frsNewAreaFragment.getPageContext(), zm6.A0);
            zv7Var.x(bdTypeRecyclerView);
            ew7 ew7Var = new ew7(frsNewAreaFragment.getPageContext(), en6.j);
            ew7Var.x(bdTypeRecyclerView);
            this.e.add(ww7Var);
            this.e.add(iw7Var);
            this.e.add(tw7Var);
            this.e.add(qw7Var);
            this.e.add(hw7Var);
            this.e.add(kw7Var);
            this.e.add(uw7Var);
            this.e.add(yw7Var);
            this.e.add(sw7Var);
            this.e.add(pw7Var);
            this.e.add(xw7Var);
            this.e.add(nw7Var);
            this.e.add(vv7Var);
            this.e.add(cw7Var);
            this.e.add(dw7Var);
            this.e.add(rw7Var);
            this.e.add(js7Var);
            this.e.add(jw7Var);
            this.e.add(xw7Var2);
            this.e.add(vw7Var);
            this.e.add(aw7Var);
            this.e.add(gw7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(sv7Var);
            this.e.add(new yv7(frsNewAreaFragment.getPageContext()));
            this.e.add(zv7Var);
            this.e.add(ew7Var);
            ci<?, ?> g = m88.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.J, "frs_new_tab");
            ci<?, ?> g2 = m88.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
            this.e.add(g);
            this.e.add(g2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<ci<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    ci<?, ?> next = it.next();
                    if (next instanceof cs7) {
                        ((cs7) next).n(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<ci> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            x06 x06Var = new x06(this.a, 1);
            x06Var.u(this.e);
            x06Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, x06Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (ci ciVar : this.e) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).y();
                } else if (ciVar instanceof hha) {
                    ((hha) ciVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (ci ciVar : this.e) {
            if (ciVar instanceof cs7) {
                ((cs7) ciVar).F(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        q38 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (ci ciVar : this.e) {
            if ((ciVar instanceof s38) && (i = ((s38) ciVar).i()) != null) {
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
            for (pi piVar : this.b.getData()) {
                if (piVar instanceof jz4) {
                    jz4 jz4Var = (jz4) piVar;
                    if (jz4Var.t.getIs_top() != 0) {
                        jz4Var.t.parser_title();
                    }
                }
            }
        }
    }
}
