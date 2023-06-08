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
public class qm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public ho c;
    public List<in> d;
    public List<in> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<vn> g;
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
        public final /* synthetic */ qm7 a;

        public a(qm7 qm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm7Var;
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
        public final /* synthetic */ qm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qm7 qm7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm7Var, Integer.valueOf(i)};
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
            this.a = qm7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                qm7 qm7Var = this.a;
                qm7Var.g(qm7Var.b);
                qm7 qm7Var2 = this.a;
                qm7Var2.p(qm7Var2.g, this.a.h);
            }
        }
    }

    public qm7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new ho(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<vn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            ix9.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = ix9.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        id7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = cd7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<vn> j() {
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

    public final void i(ArrayList<vn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                vn vnVar = arrayList.get(i);
                if ((vnVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(vnVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) vnVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (in inVar : this.e) {
                if (inVar instanceof id7) {
                    ((id7) inVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (in inVar : this.e) {
                if (inVar instanceof id7) {
                    ((id7) inVar).A(frsViewData);
                }
            }
        }
    }

    public void t(fo foVar) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, foVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (in inVar : this.e) {
                if (inVar != null && (inVar instanceof id7)) {
                    ((id7) inVar).setOnAdapterItemClickListener(foVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            th7 th7Var = new th7(frsNewAreaFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            th7Var.C(bdTypeRecyclerView);
            fh7 fh7Var = new fh7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            fh7Var.C(bdTypeRecyclerView);
            qh7 qh7Var = new qh7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            qh7Var.C(bdTypeRecyclerView);
            nh7 nh7Var = new nh7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            nh7Var.C(bdTypeRecyclerView);
            eh7 eh7Var = new eh7(frsNewAreaFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            eh7Var.C(bdTypeRecyclerView);
            hh7 hh7Var = new hh7(frsNewAreaFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            hh7Var.C(bdTypeRecyclerView);
            vh7 vh7Var = new vh7(frsNewAreaFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            vh7Var.C(bdTypeRecyclerView);
            rh7 rh7Var = new rh7(frsNewAreaFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            rh7Var.C(bdTypeRecyclerView);
            ph7 ph7Var = new ph7(frsNewAreaFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            mh7 mh7Var = new mh7(frsNewAreaFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            uh7 uh7Var = new uh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            uh7Var.C(bdTypeRecyclerView);
            gh7 gh7Var = new gh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            gh7Var.C(bdTypeRecyclerView);
            kh7 kh7Var = new kh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            kh7Var.C(bdTypeRecyclerView);
            ug7 ug7Var = new ug7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ug7Var.C(bdTypeRecyclerView);
            ah7 ah7Var = new ah7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ah7Var.C(bdTypeRecyclerView);
            bh7 bh7Var = new bh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            bh7Var.C(bdTypeRecyclerView);
            oh7 oh7Var = new oh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            oh7Var.C(bdTypeRecyclerView);
            uh7 uh7Var2 = new uh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            uh7Var2.C(bdTypeRecyclerView);
            pd7 pd7Var = new pd7(frsNewAreaFragment.getPageContext(), qd7.b);
            pd7Var.C(bdTypeRecyclerView);
            in<? extends n45, ? extends TypeAdapter.ViewHolder> a2 = cd7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            in<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = cd7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            in<?, ?> d2 = jm9.l().d(this.a, AdvertAppInfo.w);
            in<?, ?> d3 = jm9.l().d(this.a, AdvertAppInfo.z);
            sh7 sh7Var = new sh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            sh7Var.C(bdTypeRecyclerView);
            yg7 yg7Var = new yg7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            yg7Var.x(bdTypeRecyclerView);
            sg7 sg7Var = new sg7(frsNewAreaFragment.t(), m66.g);
            this.e.add(th7Var);
            this.e.add(fh7Var);
            this.e.add(qh7Var);
            this.e.add(nh7Var);
            this.e.add(eh7Var);
            this.e.add(hh7Var);
            this.e.add(rh7Var);
            this.e.add(vh7Var);
            this.e.add(ph7Var);
            this.e.add(mh7Var);
            this.e.add(uh7Var);
            this.e.add(kh7Var);
            this.e.add(ug7Var);
            this.e.add(ah7Var);
            this.e.add(bh7Var);
            this.e.add(oh7Var);
            this.e.add(pd7Var);
            this.e.add(gh7Var);
            this.e.add(uh7Var2);
            this.e.add(sh7Var);
            this.e.add(yg7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(sg7Var);
            this.e.add(new xg7(frsNewAreaFragment.getPageContext()));
            in<?, ?> d4 = ts7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            in<?, ?> d5 = ts7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<in<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    in<?, ?> next = it.next();
                    if (next instanceof id7) {
                        ((id7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<in> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            c46 c46Var = new c46(this.a, 1);
            c46Var.u(this.e);
            c46Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, c46Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (in inVar : this.e) {
                if (inVar instanceof id7) {
                    ((id7) inVar).x();
                } else if (inVar instanceof zl9) {
                    ((zl9) inVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (in inVar : this.e) {
            if (inVar instanceof id7) {
                ((id7) inVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        mo7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (in inVar : this.e) {
            if ((inVar instanceof oo7) && (i = ((oo7) inVar).i()) != null) {
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
            for (vn vnVar : this.b.getData()) {
                if (vnVar instanceof n45) {
                    n45 n45Var = (n45) vnVar;
                    if (n45Var.t.getIs_top() != 0) {
                        n45Var.t.parser_title();
                    }
                }
            }
        }
    }
}
