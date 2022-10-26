package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
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
/* loaded from: classes4.dex */
public class kq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public List c;
    public List d;
    public final HashMap e;
    public ArrayList f;
    public FrsViewData g;
    public CustomMessageListener h;

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kq6 kq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq6Var, Integer.valueOf(i)};
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
            this.a = kq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                kq6 kq6Var = this.a;
                kq6Var.g(kq6Var.b);
                kq6 kq6Var2 = this.a;
                kq6Var2.q(kq6Var2.f, this.a.g);
            }
        }
    }

    public kq6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.e = new HashMap();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.h);
        }
    }

    public void q(ArrayList arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            qm8.f(arrayList, 1);
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
                ArrayList g = qm8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        kh6 b = eh6.e().b(this.a.getPageContext(), (BdUniqueId) g.get(i), this.a.getUniqueId());
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

    public HashMap h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (HashMap) invokeV.objValue;
    }

    public List j() {
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

    public final void i(ArrayList arrayList) {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                eo eoVar = (eo) arrayList.get(i);
                if ((eoVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(eoVar)) {
                    this.e.put(Integer.valueOf(i), (ThreadData) eoVar);
                }
            }
        }
    }

    public void r(boolean z) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (list = this.d) != null && list.size() != 0) {
            for (rn rnVar : this.d) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).setFromCDN(z);
                }
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (rn rnVar : this.d) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).y(frsViewData);
                }
            }
        }
    }

    public void u(oo ooVar) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, ooVar) == null) && (list = this.d) != null && list.size() != 0) {
            for (rn rnVar : this.d) {
                if (rnVar != null && (rnVar instanceof kh6)) {
                    ((kh6) rnVar).setOnAdapterItemClickListener(ooVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            sl6 sl6Var = new sl6(frsNewAreaFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            sl6Var.A(bdTypeRecyclerView);
            el6 el6Var = new el6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            el6Var.A(bdTypeRecyclerView);
            pl6 pl6Var = new pl6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            pl6Var.A(bdTypeRecyclerView);
            ml6 ml6Var = new ml6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            ml6Var.A(bdTypeRecyclerView);
            dl6 dl6Var = new dl6(frsNewAreaFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            dl6Var.A(bdTypeRecyclerView);
            gl6 gl6Var = new gl6(frsNewAreaFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            gl6Var.A(bdTypeRecyclerView);
            ul6 ul6Var = new ul6(frsNewAreaFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            ul6Var.A(bdTypeRecyclerView);
            ql6 ql6Var = new ql6(frsNewAreaFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            ql6Var.A(bdTypeRecyclerView);
            ol6 ol6Var = new ol6(frsNewAreaFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            ll6 ll6Var = new ll6(frsNewAreaFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            tl6 tl6Var = new tl6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            tl6Var.A(bdTypeRecyclerView);
            fl6 fl6Var = new fl6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            fl6Var.A(bdTypeRecyclerView);
            jl6 jl6Var = new jl6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            jl6Var.A(bdTypeRecyclerView);
            uk6 uk6Var = new uk6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            uk6Var.A(bdTypeRecyclerView);
            zk6 zk6Var = new zk6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            zk6Var.A(bdTypeRecyclerView);
            al6 al6Var = new al6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            al6Var.A(bdTypeRecyclerView);
            nl6 nl6Var = new nl6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            nl6Var.A(bdTypeRecyclerView);
            tl6 tl6Var2 = new tl6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            tl6Var2.A(bdTypeRecyclerView);
            rh6 rh6Var = new rh6(frsNewAreaFragment.getPageContext(), sh6.b);
            rh6Var.A(bdTypeRecyclerView);
            rn a2 = eh6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            rn d = eh6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            rn d2 = le8.l().d(this.a, AdvertAppInfo.w);
            rn d3 = le8.l().d(this.a, AdvertAppInfo.z);
            rl6 rl6Var = new rl6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            rl6Var.A(bdTypeRecyclerView);
            xk6 xk6Var = new xk6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            xk6Var.v(bdTypeRecyclerView);
            this.d.add(sl6Var);
            this.d.add(el6Var);
            this.d.add(pl6Var);
            this.d.add(ml6Var);
            this.d.add(dl6Var);
            this.d.add(gl6Var);
            this.d.add(ql6Var);
            this.d.add(ul6Var);
            this.d.add(ol6Var);
            this.d.add(ll6Var);
            this.d.add(tl6Var);
            this.d.add(jl6Var);
            this.d.add(uk6Var);
            this.d.add(zk6Var);
            this.d.add(al6Var);
            this.d.add(nl6Var);
            this.d.add(rh6Var);
            this.d.add(fl6Var);
            this.d.add(tl6Var2);
            this.d.add(rl6Var);
            this.d.add(xk6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            rn d4 = ev6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            rn d5 = ev6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.d.add(d4);
            this.d.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<E> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    rn rnVar = (rn) it.next();
                    if (rnVar instanceof kh6) {
                        ((kh6) rnVar).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            xn5 xn5Var = new xn5(this.a, 1);
            xn5Var.u(this.d);
            xn5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, xn5Var));
            bdTypeRecyclerView.a(this.d);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (rn rnVar : this.d) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).v();
                } else if (rnVar instanceof ce8) {
                    ((ce8) rnVar).onDestroy();
                }
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (rn rnVar : this.d) {
            if (rnVar instanceof kh6) {
                ((kh6) rnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void v() {
        hs6 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.g == null) {
            return;
        }
        for (rn rnVar : this.d) {
            if ((rnVar instanceof js6) && (i = ((js6) rnVar).i()) != null) {
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
            for (eo eoVar : this.b.getData()) {
                if (eoVar instanceof du4) {
                    du4 du4Var = (du4) eoVar;
                    if (du4Var.t.getIs_top() != 0) {
                        du4Var.t.parser_title();
                    }
                }
            }
        }
    }
}
