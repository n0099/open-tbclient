package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class ll7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hm7 A;
    public boolean B;
    public on C;
    public CustomMessageListener D;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public mi7 c;
    public List<pm> d;
    public xm7 e;
    public jm7 f;
    public um7 g;
    public rm7 h;
    public im7 i;
    public lm7 j;
    public vm7 k;
    public zm7 l;
    public tm7 m;
    public qm7 n;
    public ym7 o;
    public km7 p;
    public sm7 q;
    public om7 r;
    public wm7 s;
    public vl7 t;
    public xl7 u;
    public wl7 v;
    public dm7 w;
    public em7 x;
    public ym7 y;
    public bm7 z;

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ll7 ll7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var, Integer.valueOf(i)};
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
            this.a = ll7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<pm<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    pm<?, ?> next = it.next();
                    if (next instanceof jp6) {
                        jp6 jp6Var = (jp6) next;
                        if ("FrsHottopicDelegateAdapter".equals(jp6Var.from()) && this.a.d != null) {
                            jp6Var.m(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.B) {
                                jp6Var.setFrom("c13010");
                            }
                            this.a.d.add(next);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        public b(ll7 ll7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public ll7(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)};
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
        this.D = new a(this, 2003008);
        e(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.b = bdTypeRecyclerView;
        this.C = new on(bdTypeRecyclerView);
    }

    public void j(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            l();
            this.b.setData(i(arrayList));
        }
    }

    public void e(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.a = frsCommonTabFragment;
            this.D.setPriority(1);
            this.D.setSelfListener(true);
            this.a.registerListener(this.D);
            this.e = new xm7(frsCommonTabFragment.u(), ThreadData.TYPE_USER_NORMAL, frsCommonTabFragment.getUniqueId());
            this.f = new jm7(frsCommonTabFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsCommonTabFragment.getUniqueId());
            this.g = new um7(frsCommonTabFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsCommonTabFragment.getUniqueId());
            this.h = new rm7(frsCommonTabFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.i = new im7(frsCommonTabFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, frsCommonTabFragment.getUniqueId());
            this.j = new lm7(frsCommonTabFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, frsCommonTabFragment.getUniqueId());
            this.k = new vm7(frsCommonTabFragment.u(), ThreadData.TYPE_SMART_APP, frsCommonTabFragment.getUniqueId());
            this.l = new zm7(frsCommonTabFragment.u(), ThreadData.TYPE_VOTE, frsCommonTabFragment.getUniqueId());
            tm7 tm7Var = new tm7(frsCommonTabFragment.u(), ThreadData.TYPE_SINGLE_LINK, frsCommonTabFragment.getUniqueId());
            this.m = tm7Var;
            tm7Var.I(frsCommonTabFragment.h);
            qm7 qm7Var = new qm7(frsCommonTabFragment.u(), ThreadData.TYPE_MULTI_LINK, frsCommonTabFragment.getUniqueId());
            this.n = qm7Var;
            qm7Var.I(frsCommonTabFragment.h);
            this.o = new ym7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.p = new km7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.q = new sm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsCommonTabFragment.getUniqueId());
            this.r = new om7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_LINK, frsCommonTabFragment.getUniqueId());
            this.s = new wm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.t = new vl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsCommonTabFragment.getUniqueId());
            this.u = new xl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.v = new wl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.w = new dm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.x = new em7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.y = new ym7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, frsCommonTabFragment.getUniqueId());
            this.A = new hm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            this.c = new mi7(frsCommonTabFragment.getPageContext(), ni7.b);
            if (!z) {
                this.z = new bm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ITEM, frsCommonTabFragment.getUniqueId());
            }
            this.d.add(this.e);
            this.d.add(this.f);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.i);
            this.d.add(this.j);
            this.d.add(this.k);
            this.d.add(this.l);
            this.d.add(this.m);
            this.d.add(this.n);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.r);
            this.d.add(this.s);
            this.d.add(this.t);
            this.d.add(this.u);
            this.d.add(this.v);
            this.d.add(this.w);
            this.d.add(this.A);
            this.d.add(this.x);
            this.d.add(this.y);
            this.d.add(this.c);
            if (!z) {
                this.d.add(this.z);
            }
            f();
            for (pm pmVar : this.d) {
                if (pmVar instanceof fi7) {
                    fi7 fi7Var = (fi7) pmVar;
                    fi7Var.C(bdTypeRecyclerView);
                    if (frsCommonTabFragment.g == 89) {
                        fi7Var.setFrom("c13010");
                    }
                }
                if (pmVar instanceof kp6) {
                    ((kp6) pmVar).p(3);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<pm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    pm<?, ?> next = it.next();
                    if (next instanceof fi7) {
                        ((fi7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<pm> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.j == 1) {
                m(frsViewData);
            }
            l();
            bdTypeRecyclerView.addAdapters(this.d);
            n();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            pm<?, ?> e = i3a.m().e(this.a, AdvertAppInfo.x);
            pm<?, ?> e2 = i3a.m().e(this.a, AdvertAppInfo.A);
            pm<?, ?> e3 = i3a.m().e(this.a, AdvertAppInfo.B);
            pm<?, ?> e4 = i3a.m().e(this.a, AdvertAppInfo.C);
            pm<?, ?> e5 = i3a.m().e(this.a, AdvertAppInfo.D);
            this.d.add(e);
            this.d.add(e2);
            this.d.add(e3);
            this.d.add(e4);
            this.d.add(e5);
            pm<?, ?> d = jy7.h().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.I);
            pm<?, ?> d2 = jy7.h().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.d.add(d);
            this.d.add(d2);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a != null && !ListUtils.isEmpty(this.d)) {
            for (pm pmVar : this.d) {
                if (pmVar instanceof xt7) {
                    xt7 xt7Var = (xt7) pmVar;
                    if (xt7Var.i() != null) {
                        xt7Var.i().a = this.a.k;
                        xt7Var.i().c = this.a.e;
                        xt7Var.i().d = this.a.f;
                        xt7Var.i().e = this.a.g;
                        vt7 i = xt7Var.i();
                        FrsCommonTabFragment frsCommonTabFragment = this.a;
                        i.h = frsCommonTabFragment.h;
                        if (frsCommonTabFragment.j == 1) {
                            xt7Var.i().g = 12;
                        }
                    }
                }
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.C.e(new b(this));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (pm pmVar : this.d) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).x();
                } else if (pmVar instanceof y2a) {
                    ((y2a) pmVar).onDestroy();
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (pm pmVar : this.d) {
            if (pmVar instanceof fi7) {
                ((fi7) pmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final ArrayList<cn> i(ArrayList<cn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<cn> arrayList2 = new ArrayList<>();
            Iterator<cn> it = arrayList.iterator();
            while (it.hasNext()) {
                cn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.getItem() != null) {
                        if (!threadData.isVoteThreadType()) {
                            arrayList2.add(next);
                        } else {
                            threadData.setItem(null);
                            arrayList2.add(next);
                        }
                    } else {
                        arrayList2.add(next);
                    }
                } else {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void m(FrsViewData frsViewData) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (pm pmVar : this.d) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).A(frsViewData);
                }
            }
        }
    }
}
