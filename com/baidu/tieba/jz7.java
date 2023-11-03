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
public class jz7 {
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public a(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
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
        public final /* synthetic */ jz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(jz7 jz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var, Integer.valueOf(i)};
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
            this.a = jz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                jz7 jz7Var = this.a;
                jz7Var.g(jz7Var.b);
                jz7 jz7Var2 = this.a;
                jz7Var2.p(jz7Var2.g, this.a.h);
            }
        }
    }

    public jz7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            uqa.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = uqa.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        pp7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = jp7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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
                if (biVar instanceof pp7) {
                    ((pp7) biVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (bi biVar : this.e) {
                if (biVar instanceof pp7) {
                    ((pp7) biVar).B(frsViewData);
                }
            }
        }
    }

    public void t(yi yiVar) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, yiVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (bi biVar : this.e) {
                if (biVar != null && (biVar instanceof pp7)) {
                    ((pp7) biVar).setOnAdapterItemClickListener(yiVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            ku7 ku7Var = new ku7(frsNewAreaFragment.H(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            ku7Var.D(bdTypeRecyclerView);
            wt7 wt7Var = new wt7(frsNewAreaFragment.H(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            wt7Var.D(bdTypeRecyclerView);
            hu7 hu7Var = new hu7(frsNewAreaFragment.H(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            hu7Var.D(bdTypeRecyclerView);
            eu7 eu7Var = new eu7(frsNewAreaFragment.H(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            eu7Var.D(bdTypeRecyclerView);
            vt7 vt7Var = new vt7(frsNewAreaFragment.H(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            vt7Var.D(bdTypeRecyclerView);
            yt7 yt7Var = new yt7(frsNewAreaFragment.H(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            yt7Var.D(bdTypeRecyclerView);
            mu7 mu7Var = new mu7(frsNewAreaFragment.H(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            mu7Var.D(bdTypeRecyclerView);
            iu7 iu7Var = new iu7(frsNewAreaFragment.H(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            iu7Var.D(bdTypeRecyclerView);
            gu7 gu7Var = new gu7(frsNewAreaFragment.H(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            du7 du7Var = new du7(frsNewAreaFragment.H(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            lu7 lu7Var = new lu7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            lu7Var.D(bdTypeRecyclerView);
            xt7 xt7Var = new xt7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            xt7Var.D(bdTypeRecyclerView);
            bu7 bu7Var = new bu7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            bu7Var.D(bdTypeRecyclerView);
            jt7 jt7Var = new jt7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            jt7Var.D(bdTypeRecyclerView);
            qt7 qt7Var = new qt7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            qt7Var.D(bdTypeRecyclerView);
            rt7 rt7Var = new rt7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            rt7Var.D(bdTypeRecyclerView);
            fu7 fu7Var = new fu7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            fu7Var.D(bdTypeRecyclerView);
            lu7 lu7Var2 = new lu7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            lu7Var2.D(bdTypeRecyclerView);
            wp7 wp7Var = new wp7(frsNewAreaFragment.getPageContext(), xp7.b);
            wp7Var.D(bdTypeRecyclerView);
            bi<? extends hz4, ? extends TypeAdapter.ViewHolder> a2 = jp7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            bi<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = jp7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            bi<?, ?> e = yca.m().e(this.a, AdvertAppInfo.y);
            bi<?, ?> e2 = yca.m().e(this.a, AdvertAppInfo.B);
            ju7 ju7Var = new ju7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ju7Var.D(bdTypeRecyclerView);
            ot7 ot7Var = new ot7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ot7Var.y(bdTypeRecyclerView);
            ut7 ut7Var = new ut7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            gt7 gt7Var = new gt7(frsNewAreaFragment.H(), z26.g);
            nt7 nt7Var = new nt7(frsNewAreaFragment.getPageContext(), nm6.A0);
            nt7Var.x(bdTypeRecyclerView);
            st7 st7Var = new st7(frsNewAreaFragment.getPageContext(), sm6.j);
            st7Var.x(bdTypeRecyclerView);
            this.e.add(ku7Var);
            this.e.add(wt7Var);
            this.e.add(hu7Var);
            this.e.add(eu7Var);
            this.e.add(vt7Var);
            this.e.add(yt7Var);
            this.e.add(iu7Var);
            this.e.add(mu7Var);
            this.e.add(gu7Var);
            this.e.add(du7Var);
            this.e.add(lu7Var);
            this.e.add(bu7Var);
            this.e.add(jt7Var);
            this.e.add(qt7Var);
            this.e.add(rt7Var);
            this.e.add(fu7Var);
            this.e.add(wp7Var);
            this.e.add(xt7Var);
            this.e.add(lu7Var2);
            this.e.add(ju7Var);
            this.e.add(ot7Var);
            this.e.add(ut7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(gt7Var);
            this.e.add(new mt7(frsNewAreaFragment.getPageContext()));
            this.e.add(nt7Var);
            this.e.add(st7Var);
            bi<?, ?> g = r58.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.J, "frs_new_tab");
            bi<?, ?> g2 = r58.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
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
                    if (next instanceof pp7) {
                        ((pp7) next).n(this.a.getPageContext(), this.a.getUniqueId());
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
            p06 p06Var = new p06(this.a, 1);
            p06Var.u(this.e);
            p06Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p06Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (bi biVar : this.e) {
                if (biVar instanceof pp7) {
                    ((pp7) biVar).y();
                } else if (biVar instanceof oca) {
                    ((oca) biVar).onDestroy();
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
            if (biVar instanceof pp7) {
                ((pp7) biVar).F(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        a18 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (bi biVar : this.e) {
            if ((biVar instanceof c18) && (i = ((c18) biVar).i()) != null) {
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
