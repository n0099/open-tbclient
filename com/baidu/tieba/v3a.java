package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.pb.data.PbFirstFloorRecommendData;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.AiBotChatAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbChatGuideFloorAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorRecommendAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorSimilarTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorWebViewAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class v3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v0a A;
    public PbReplyLoadMoreAdapter B;
    public ArrayList<jy9> C;
    public rz9 D;
    public k0a E;
    public y1a F;
    public PbFirstFloorWebViewAdapter G;
    public AiBotChatAdapter H;
    public ky9 I;
    public int J;
    public final List<ci> K;
    public final List<ci> L;
    public CustomMessageListener M;
    public BdTypeListView a;
    public PbFragment b;
    public d0a c;
    public e0a d;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public PbFirstFloorEnterForumAdapter f;
    public PbFirstFloorItemAdapter g;
    public PbFirstFloorRecommendAdapter h;
    public PbFirstFloorSimilarTitleAdapter i;
    public z1a j;
    public w1a k;
    public b1a l;
    public o0a m;
    public b1a n;
    public tz9 o;
    public e1a p;
    public PbChatGuideFloorAdapter q;
    public a6a r;
    public hn6 s;
    public ci t;
    public ci u;
    public ci v;
    public ci w;
    public ci x;
    public w0a y;
    public z0a z;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v3a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v3a v3aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3aVar, Integer.valueOf(i)};
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
            this.a = v3aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof dwa)) {
                AbsDelegateAdapterList a = ((dwa) customResponsedMessage.getData()).a();
                Iterator<ci<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    ci<?, ?> next = it.next();
                    if (next instanceof vz9) {
                        ((vz9) next).u(this.a.b);
                        if (next instanceof jy9) {
                            this.a.C.add((jy9) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.L.clear();
                this.a.L.addAll(arrayList);
                if (this.a.a != null) {
                    this.a.a.addAdapters(arrayList);
                }
            }
        }
    }

    public v3a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.C = new ArrayList<>();
        this.J = -1;
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.M = new a(this, 2004015);
        this.a = bdTypeListView;
        this.b = pbFragment;
    }

    public void E(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.G = new PbFirstFloorWebViewAdapter(pbFragment, bw9.c);
        }
    }

    public PbReplyLoadMoreAdapter A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.B;
        }
        return (PbReplyLoadMoreAdapter) invokeV.objValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.J;
        }
        return invokeV.intValue;
    }

    public e1a C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.p;
        }
        return (e1a) invokeV.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.J = x3a.g(this.a);
            if (this.a.getAdapter2() instanceof gi) {
                this.a.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public PbChatGuideFloorAdapter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.q;
        }
        return (PbChatGuideFloorAdapter) invokeV.objValue;
    }

    public PbFirstFloorItemAdapter i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.g;
        }
        return (PbFirstFloorItemAdapter) invokeV.objValue;
    }

    public k0a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.E;
        }
        return (k0a) invokeV.objValue;
    }

    public ci l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.u;
        }
        return (ci) invokeV.objValue;
    }

    public rz9 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.D;
        }
        return (rz9) invokeV.objValue;
    }

    public tz9 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.o;
        }
        return (tz9) invokeV.objValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.e;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public ArrayList<jy9> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.C;
        }
        return (ArrayList) invokeV.objValue;
    }

    public a6a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.r;
        }
        return (a6a) invokeV.objValue;
    }

    public b1a r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.n;
        }
        return (b1a) invokeV.objValue;
    }

    public BdTypeListView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.a;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public o0a t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.m;
        }
        return (o0a) invokeV.objValue;
    }

    public b1a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.l;
        }
        return (b1a) invokeV.objValue;
    }

    public w1a v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.k;
        }
        return (w1a) invokeV.objValue;
    }

    public d0a w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.c;
        }
        return (d0a) invokeV.objValue;
    }

    public w0a x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.y;
        }
        return (w0a) invokeV.objValue;
    }

    public ky9 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.I;
        }
        return (ky9) invokeV.objValue;
    }

    public z0a z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.z;
        }
        return (z0a) invokeV.objValue;
    }

    public void D(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        e0a e0aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, pbFragment, bdTypeListView) == null) {
            if (i1a.z(pbFragment)) {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new e0a(pbFragment, nwa.X0);
            } else {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorAdapter");
                d0a d0aVar = new d0a(pbFragment, nwa.X0);
                this.c = d0aVar;
                d0aVar.f0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, kw9.g);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, xv9.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), yv9.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), aw9.f1085T);
            this.j = new z1a(pbFragment.getPageContext(), zv9.X0);
            this.k = new w1a(pbFragment, sv9.c);
            this.l = new b1a(pbFragment, jw9.g);
            this.m = new o0a(pbFragment, fw9.c);
            this.n = new b1a(pbFragment, jw9.h);
            tz9 tz9Var = new tz9(pbFragment, nwa.Y0);
            this.o = tz9Var;
            tz9Var.A0(pbFragment);
            e1a e1aVar = new e1a(pbFragment, nwa.Z0);
            this.p = e1aVar;
            e1aVar.A0(pbFragment);
            this.q = new PbChatGuideFloorAdapter(pbFragment, nwa.a1);
            this.t = rha.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.u = rha.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.B);
            this.v = m88.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.w = m88.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.x = m88.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.K);
            this.A = new v0a(pbFragment, hw9.m1);
            this.y = new w0a(pbFragment, u0a.l1);
            this.z = new z0a(pbFragment, ky4.r1);
            this.B = new PbReplyLoadMoreAdapter(pbFragment, nwa.g1);
            this.r = new a6a(pbFragment, b6a.a);
            this.s = new hn6(pbFragment.getPageContext());
            this.D = new rz9(pbFragment, uw4.e);
            this.E = new k0a(pbFragment, pbFragment.getUniqueId());
            this.F = new y1a(pbFragment.getPageContext(), h36.g);
            if (i1a.z(pbFragment)) {
                E(pbFragment);
            }
            ky9 ky9Var = new ky9(pbFragment, pbFragment.getUniqueId(), this.a);
            this.I = ky9Var;
            this.K.addAll(ky9Var.a());
            this.H = new AiBotChatAdapter(pbFragment.getContext(), jw4.e);
            if (i1a.z(pbFragment) && (e0aVar = this.d) != null) {
                this.K.add(e0aVar);
            } else {
                d0a d0aVar2 = this.c;
                if (d0aVar2 != null) {
                    this.K.add(d0aVar2);
                }
            }
            this.K.add(this.e);
            this.K.add(this.f);
            this.K.add(this.g);
            this.K.add(this.h);
            this.K.add(this.i);
            this.K.add(this.j);
            this.K.add(this.k);
            this.K.add(this.o);
            this.K.add(this.p);
            this.K.add(this.q);
            this.K.add(this.l);
            this.K.add(this.m);
            this.K.add(this.n);
            this.K.add(this.t);
            this.K.add(this.u);
            this.K.add(this.v);
            this.K.add(this.w);
            this.K.add(this.x);
            this.K.add(this.A);
            this.K.add(this.y);
            this.K.add(this.z);
            this.K.add(this.r);
            this.K.add(this.B);
            this.K.add(this.s);
            this.K.add(this.D);
            this.K.add(this.E);
            this.K.add(new PbPrivateTitleAdapter(pbFragment));
            this.K.add(this.F);
            this.K.add(this.H);
            if (i1a.z(pbFragment)) {
                this.K.add(this.G);
            }
            this.M.setPriority(1);
            this.M.setSelfListener(true);
            pbFragment.registerListener(this.M);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new dwa(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.K);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d0a d0aVar = this.c;
            if (d0aVar != null) {
                d0aVar.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.G;
            if (pbFirstFloorWebViewAdapter != null) {
                pbFirstFloorWebViewAdapter.onDestroy();
            }
            ci ciVar = this.u;
            if (ciVar instanceof hha) {
                ((hha) ciVar).onDestroy();
            }
            ci ciVar2 = this.v;
            if (ciVar2 instanceof hha) {
                ((hha) ciVar2).onDestroy();
            }
            ci ciVar3 = this.x;
            if (ciVar3 instanceof hha) {
                ((hha) ciVar3).onDestroy();
            }
            uz9.a().d();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d0a d0aVar = this.c;
            if (d0aVar != null) {
                d0aVar.X();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.G;
            if (pbFirstFloorWebViewAdapter != null) {
                pbFirstFloorWebViewAdapter.onResume();
            }
            ci ciVar = this.u;
            if (ciVar instanceof hha) {
                ((hha) ciVar).onResume();
            }
            ci ciVar2 = this.v;
            if (ciVar2 instanceof hha) {
                ((hha) ciVar2).onResume();
            }
            ci ciVar3 = this.x;
            if (ciVar3 instanceof hha) {
                ((hha) ciVar3).onResume();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b1a b1aVar = this.l;
            if (b1aVar != null) {
                b1aVar.onDestroy();
            }
            b1a b1aVar2 = this.n;
            if (b1aVar2 != null) {
                b1aVar2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            w1a w1aVar = this.k;
            if (w1aVar != null) {
                w1aVar.onDestroy();
            }
            j26.k().q(false);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d0a d0aVar = this.c;
            if (d0aVar != null) {
                d0aVar.V();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.G;
            if (pbFirstFloorWebViewAdapter != null) {
                pbFirstFloorWebViewAdapter.onPause();
            }
            ci ciVar = this.u;
            if (ciVar instanceof hha) {
                ((hha) ciVar).onPause();
            }
            ci ciVar2 = this.v;
            if (ciVar2 instanceof hha) {
                ((hha) ciVar2).onPause();
            }
            ci ciVar3 = this.x;
            if (ciVar3 instanceof hha) {
                ((hha) ciVar3).onPause();
            }
            uz9.a().i(this.b.u0());
            no5.a().d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.K != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正Adapter");
            this.K.remove(this.c);
            if (this.d == null) {
                this.d = new e0a(this.b, nwa.X0);
            }
            if (!this.K.contains(this.d)) {
                this.K.add(this.d);
            }
            if (this.G == null) {
                E(this.b);
            }
            if (!this.K.contains(this.G)) {
                this.K.add(this.G);
            }
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            d0a d0aVar = this.c;
            if (d0aVar != null && d0aVar.Q() != null) {
                if (this.c.Q().z != null && this.c.Q().z.isShown()) {
                    return this.c.Q().z;
                }
                return this.c.Q().y;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            tz9 tz9Var = this.o;
            if (tz9Var != null) {
                tz9Var.y0(z);
            }
            PbChatGuideFloorAdapter pbChatGuideFloorAdapter = this.q;
            if (pbChatGuideFloorAdapter != null) {
                pbChatGuideFloorAdapter.y0(z);
            }
            b1a b1aVar = this.l;
            if (b1aVar != null) {
                b1aVar.B(z);
            }
            ci ciVar = this.x;
            if (ciVar != null) {
                ciVar.setMulDel(z);
            }
            ci ciVar2 = this.u;
            if (ciVar2 != null) {
                ciVar2.setMulDel(z);
            }
            d0a d0aVar = this.c;
            if (d0aVar != null) {
                d0aVar.setMulDel(z);
            }
        }
    }

    public void L(List<pi> list, List<pi> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, list, list2) == null) {
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            dw9 dw9Var = new dw9();
            PbListView g1 = this.b.i7().g1();
            if (g1 != null && g1.q()) {
                dw9Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1037);
                dw9Var.b = true;
            } else {
                dw9Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                dw9Var.b = false;
            }
            arrayList.add(dw9Var);
            kn6 kn6Var = new kn6();
            kn6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            kn6Var.needTopMargin = false;
            arrayList.add(kn6Var);
            arrayList.addAll(list2);
            this.a.setData(arrayList);
        }
    }

    public boolean e(List<ci> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
            if (this.b == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<BdUniqueId> g = ova.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                rf9 b = vg9.d().b(this.b.getPageContext(), g.get(i), 2);
                if (b != null) {
                    this.K.add(b);
                    arrayList.add(b);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.a.addAdapters(arrayList);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(vv9 vv9Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, vv9Var) == null) && vv9Var.R() != null && vv9Var.R().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(vv9Var.R().getTaskInfoData())) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正头条卡信息");
            if (this.G == null && this.a != null) {
                i1a.C(this.b, vv9Var.R().getTaskInfoData().j());
                f();
                this.a.F();
                this.a.addAdapters(this.K);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.G;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.x() != 1 && (pbFragment = this.b) != null && pbFragment.i7() != null) {
                this.b.i7().w4();
            }
        }
    }
}
