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
/* loaded from: classes7.dex */
public class ov7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kw7 A;
    public boolean B;
    public bj C;
    public CustomMessageListener D;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public ns7 c;
    public List<ci> d;
    public ax7 e;
    public mw7 f;
    public xw7 g;
    public uw7 h;
    public lw7 i;
    public ow7 j;
    public yw7 k;
    public cx7 l;
    public ww7 m;
    public tw7 n;
    public bx7 o;
    public nw7 p;
    public vw7 q;
    public rw7 r;
    public zw7 s;
    public yv7 t;
    public aw7 u;
    public zv7 v;
    public gw7 w;
    public hw7 x;
    public bx7 y;
    public ew7 z;

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ov7 ov7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var, Integer.valueOf(i)};
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
            this.a = ov7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<ci<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    ci<?, ?> next = it.next();
                    if (next instanceof jm6) {
                        jm6 jm6Var = (jm6) next;
                        if ("FrsHottopicDelegateAdapter".equals(jm6Var.from()) && this.a.d != null) {
                            jm6Var.n(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.B) {
                                jm6Var.setFrom("c13010");
                            }
                            this.a.d.add(next);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov7 a;

        public b(ov7 ov7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ov7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public ov7(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
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
        this.C = new bj(bdTypeRecyclerView);
    }

    public void j(ArrayList<pi> arrayList) {
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
            this.e = new ax7(frsCommonTabFragment.I(), ThreadData.TYPE_USER_NORMAL, frsCommonTabFragment.getUniqueId());
            this.f = new mw7(frsCommonTabFragment.I(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsCommonTabFragment.getUniqueId());
            this.g = new xw7(frsCommonTabFragment.I(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsCommonTabFragment.getUniqueId());
            this.h = new uw7(frsCommonTabFragment.I(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.i = new lw7(frsCommonTabFragment.I(), ThreadData.TYPE_BOTTOM_NORMAL, frsCommonTabFragment.getUniqueId());
            this.j = new ow7(frsCommonTabFragment.I(), ThreadData.TYPE_GODREPLY_NORMAL, frsCommonTabFragment.getUniqueId());
            this.k = new yw7(frsCommonTabFragment.I(), ThreadData.TYPE_SMART_APP, frsCommonTabFragment.getUniqueId());
            this.l = new cx7(frsCommonTabFragment.I(), ThreadData.TYPE_VOTE, frsCommonTabFragment.getUniqueId());
            ww7 ww7Var = new ww7(frsCommonTabFragment.I(), ThreadData.TYPE_SINGLE_LINK, frsCommonTabFragment.getUniqueId());
            this.m = ww7Var;
            ww7Var.J(frsCommonTabFragment.h);
            tw7 tw7Var = new tw7(frsCommonTabFragment.I(), ThreadData.TYPE_MULTI_LINK, frsCommonTabFragment.getUniqueId());
            this.n = tw7Var;
            tw7Var.J(frsCommonTabFragment.h);
            this.o = new bx7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.p = new nw7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.q = new vw7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsCommonTabFragment.getUniqueId());
            this.r = new rw7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_LINK, frsCommonTabFragment.getUniqueId());
            this.s = new zw7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.t = new yv7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsCommonTabFragment.getUniqueId());
            this.u = new aw7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.v = new zv7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.w = new gw7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.x = new hw7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.y = new bx7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, frsCommonTabFragment.getUniqueId());
            this.A = new kw7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            this.c = new ns7(frsCommonTabFragment.getPageContext(), os7.b);
            if (!z) {
                this.z = new ew7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ITEM, frsCommonTabFragment.getUniqueId());
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
            for (ci ciVar : this.d) {
                if (ciVar instanceof gs7) {
                    gs7 gs7Var = (gs7) ciVar;
                    gs7Var.D(bdTypeRecyclerView);
                    if (frsCommonTabFragment.g == 89) {
                        gs7Var.setFrom("c13010");
                    }
                }
                if (ciVar instanceof km6) {
                    ((km6) ciVar).q(3);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<ci<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    ci<?, ?> next = it.next();
                    if (next instanceof gs7) {
                        ((gs7) next).n(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<ci> list = this.d;
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
            ci<?, ?> e = vha.m().e(this.a, AdvertAppInfo.y);
            ci<?, ?> e2 = vha.m().e(this.a, AdvertAppInfo.B);
            ci<?, ?> e3 = vha.m().e(this.a, AdvertAppInfo.C);
            ci<?, ?> e4 = vha.m().e(this.a, AdvertAppInfo.D);
            ci<?, ?> e5 = vha.m().e(this.a, AdvertAppInfo.E);
            this.d.add(e);
            this.d.add(e2);
            this.d.add(e3);
            this.d.add(e4);
            this.d.add(e5);
            ci<?, ?> d = q88.h().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.J);
            ci<?, ?> d2 = q88.h().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.d.add(d);
            this.d.add(d2);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a != null && !ListUtils.isEmpty(this.d)) {
            for (ci ciVar : this.d) {
                if (ciVar instanceof w38) {
                    w38 w38Var = (w38) ciVar;
                    if (w38Var.i() != null) {
                        w38Var.i().a = this.a.k;
                        w38Var.i().c = this.a.e;
                        w38Var.i().d = this.a.f;
                        w38Var.i().e = this.a.g;
                        u38 i = w38Var.i();
                        FrsCommonTabFragment frsCommonTabFragment = this.a;
                        i.h = frsCommonTabFragment.h;
                        if (frsCommonTabFragment.j == 1) {
                            w38Var.i().g = 12;
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
            for (ci ciVar : this.d) {
                if (ciVar instanceof gs7) {
                    ((gs7) ciVar).y();
                } else if (ciVar instanceof lha) {
                    ((lha) ciVar).onDestroy();
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (ci ciVar : this.d) {
            if (ciVar instanceof gs7) {
                ((gs7) ciVar).F(this.a.getTbPageTag());
            }
        }
    }

    public final ArrayList<pi> i(ArrayList<pi> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<pi> arrayList2 = new ArrayList<>();
            Iterator<pi> it = arrayList.iterator();
            while (it.hasNext()) {
                pi next = it.next();
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
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (ci ciVar : this.d) {
                if (ciVar instanceof gs7) {
                    ((gs7) ciVar).B(frsViewData);
                }
            }
        }
    }
}
