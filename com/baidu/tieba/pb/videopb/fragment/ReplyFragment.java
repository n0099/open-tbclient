package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import d.a.p0.s.q.b2;
import d.a.q0.h2.k.e.m0;
import d.a.q0.h2.k.e.n;
import d.a.q0.h2.p.e;
import d.a.q0.h3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements d.a.q0.h2.o.a, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public RecyclerView.OnScrollListener D;
    public MultiNestedLayout.b E;
    public final f.g F;
    public CustomMessageListener G;
    public final BdListView.p H;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f19935e;

    /* renamed from: f  reason: collision with root package name */
    public AbsVideoPbFragment f19936f;

    /* renamed from: g  reason: collision with root package name */
    public View f19937g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f19938h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.h2.o.c f19939i;
    public d.a.q0.h2.o.g.b j;
    public MultiNestedLayout k;
    public PbListView l;
    public View m;
    public d.a.q0.h2.p.e n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;
    public d.a.q0.h2.o.k.b u;
    public View v;
    public BdSwipeRefreshLayout w;
    public g x;
    public boolean y;
    public int z;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19940a;

        public a(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19940a = replyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    this.f19940a.v().o4();
                    this.f19940a.v().q4();
                }
                if (this.f19940a.v() != null) {
                    this.f19940a.v().b4(i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (recyclerView.canScrollVertically(-1)) {
                    this.f19940a.z = 2;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f19940a.z != 0) {
                    this.f19940a.o.setVisibility(8);
                }
                this.f19940a.z = 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MultiNestedLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19941a;

        public b(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19941a = replyFragment;
        }

        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f19941a.A != 1 || i2 == 1 || this.f19941a.z == 0) {
                    if (this.f19941a.A != 0 || i2 == 0) {
                        if (this.f19941a.A != 0 && i2 == 0) {
                            this.f19941a.v().F4(8);
                        }
                    } else if (this.f19941a.o.getVisibility() != 0) {
                        this.f19941a.v().F4(0);
                    }
                } else {
                    this.f19941a.v().F4(8);
                    this.f19941a.o.setVisibility(0);
                }
                this.f19941a.A = i2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19942e;

        public c(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19942e = replyFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f19942e.y() != null && this.f19942e.y().y1(true)) {
                    TiebaStatic.eventStat(this.f19942e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.f19942e.a1();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19943a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ReplyFragment replyFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19943a = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19943a.y() == null || this.f19943a.y().L0() == null || this.f19943a.y().L0().E() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = this.f19943a.y().L0().E().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof o) {
                    o oVar2 = (o) next;
                    if (str.equals(oVar2.D0())) {
                        oVar = oVar2;
                        break;
                    }
                }
            }
            if (oVar == null || this.f19943a.f19939i == null || this.f19943a.f19938h == null) {
                return;
            }
            this.f19943a.y().L0().E().remove(oVar);
            if (this.f19943a.f19939i.a() != null) {
                this.f19943a.f19939i.a().remove(oVar);
            }
            if (this.f19943a.f19938h.getListView2().getData() != null) {
                this.f19943a.f19938h.getListView2().getData().remove(oVar);
            }
            this.f19943a.f19939i.e();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19944e;

        public e(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19944e = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f19944e.x1();
                } else {
                    this.f19944e.l();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f19945e;

        public f(ReplyFragment replyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19945e = replyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19945e.mIsLogin) {
                if (!this.f19945e.C && this.f19945e.Y0() && this.f19945e.y() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.f19945e.y().b1());
                    statisticItem.param("fid", this.f19945e.y().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.f19945e.C = true;
                }
                if (this.f19945e.y().u1(false)) {
                    this.f19945e.v1();
                    if (this.f19945e.getPageContext() != null) {
                        TiebaStatic.eventStat(this.f19945e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.f19945e.y().L0() != null) {
                    this.f19945e.q1();
                }
            }
        }
    }

    public ReplyFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = null;
        this.n = null;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = 0;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.C = false;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this, 2016331);
        this.H = new f(this);
    }

    public static ReplyFragment n1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.f19936f = absVideoPbFragment;
            return replyFragment;
        }
        return (ReplyFragment) invokeL.objValue;
    }

    @Override // d.a.q0.h2.o.a
    public void D0(boolean z, int i2, int i3, int i4, d.a.q0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        X0(z, i2, i3, i4, eVar, str, i5);
    }

    public final void X0(boolean z, int i2, int i3, int i4, d.a.q0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(z()).get(VideoPbViewModel.class);
            if (!z || y() == null || eVar == null) {
                return;
            }
            this.y = y().Z0();
            boolean isEnabled = this.w.isEnabled();
            if (eVar.x().c() == 0 && this.y) {
                this.w.setEnabled(false);
            } else if (!isEnabled) {
                this.w.setEnabled(true);
                this.w.o();
            }
            this.f19939i.g(videoPbViewModel.l());
            this.f19939i.h(this.y);
            this.f19939i.f(eVar);
            this.p = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f19938h.setNextPage(this.l);
                this.s = 2;
                if (v() != null && v().T != null) {
                    this.f19936f.T.V();
                }
            } else {
                this.p = true;
                if (eVar.x().b() == 1) {
                    if (this.n == null) {
                        d.a.q0.h2.p.e eVar2 = new d.a.q0.h2.p.e(this, this);
                        this.n = eVar2;
                        eVar2.a();
                        this.n.g();
                    }
                    this.f19938h.setNextPage(this.n);
                } else {
                    this.f19938h.setNextPage(this.l);
                }
                this.s = 3;
            }
            if (this.u != null && this.v != null) {
                d.a.q0.h2.h.o oVar = new d.a.q0.h2.h.o(d.a.q0.h2.h.o.l);
                b2 N = eVar.N();
                if (N != null) {
                    N.Q0();
                }
                y().Z0();
                oVar.f57477h = m1();
                oVar.f57476g = eVar.f57443g;
                eVar.c();
                oVar.f57478i = eVar.e0();
                oVar.k = eVar.f57442f;
                oVar.j = N.t2();
                this.u.e(oVar);
            }
            ArrayList<PostData> E = eVar.E();
            if (eVar.x().b() != 0 && E != null && E.size() >= eVar.x().e()) {
                if (y().v0()) {
                    if (this.r) {
                        Z0();
                        if (eVar.x().b() != 0) {
                            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.l.x();
                        this.l.L();
                    }
                } else {
                    this.l.x();
                    this.l.L();
                }
                this.l.j();
            } else {
                if (ListUtils.getCount(E) != 0 && (ListUtils.getCount(E) != 1 || E.get(0) == null || E.get(0).A() != 1)) {
                    if (eVar.x().b() == 0) {
                        this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.l.j();
                } else if (m1()) {
                    this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
                } else {
                    this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
                }
                if (eVar.x().b() == 0 || E == null) {
                    q1();
                }
            }
            if (i3 == 2) {
                this.f19938h.setSelection(i4 > 1 ? (i4 + ((this.f19938h.getData() == null && eVar.E() == null) ? 0 : this.f19938h.getData().size() - eVar.E().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.r = false;
                } else if (i3 == 5) {
                    this.f19938h.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = m0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f19938h.onRestoreInstanceState(e2);
                        }
                    }
                    this.f19938h.setSelection(0);
                } else if (i3 == 8) {
                    int size = (this.f19938h.getData() == null && eVar.E() == null) ? 0 : this.f19938h.getData().size() - eVar.E().size();
                    this.k.setMaxOffset();
                    this.f19938h.setSelection(i4 > 0 ? i4 + size : 0);
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            } else if (i5 == 1) {
                Parcelable e3 = m0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f19938h.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(E) > 1 && eVar.x().b() > 0) {
                        this.l.f();
                        this.l.A(getString(R.string.pb_load_more_without_point));
                        this.l.v();
                    }
                }
            }
            if (this.q) {
                p1();
                this.q = false;
                if (i5 == 0) {
                    u1(true);
                }
            }
            v().j4(eVar);
        }
    }

    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PbListView pbListView = this.l;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.l.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.v();
                this.l.f();
            }
            if (v() == null || v().T == null) {
                return;
            }
            this.f19936f.T.V();
        }
    }

    public void a1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bdSwipeRefreshLayout = this.w) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.w.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: b1 */
    public d.a.q0.h2.o.c M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19939i : (d.a.q0.h2.o.c) invokeV.objValue;
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19938h;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int d1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19938h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f19938h.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19938h;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (y() == null || y().L0() == null || lastVisiblePosition < y().L0().E().size()) ? lastVisiblePosition : y().L0().E().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f19938h : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.A : invokeV.intValue;
    }

    public View h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.z : invokeV.intValue;
    }

    public d.a.q0.h2.o.g.b j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : (d.a.q0.h2.o.g.b) invokeV.objValue;
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.f19937g.findViewById(R.id.multi_nested_layout);
            this.k = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.E);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f19937g.findViewById(R.id.video_pb_reply_list);
            this.f19938h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            d.a.q0.h2.o.c cVar = new d.a.q0.h2.o.c(this, this.f19938h);
            this.f19939i = cVar;
            cVar.l(v().h3());
            this.f19939i.i(v().i3());
            this.f19939i.k(v().l3());
            this.f19939i.j(this.j.i());
            this.f19939i.m(this.j.l());
            this.o = this.f19937g.findViewById(R.id.reply_pager_title_shadow);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.l = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
            this.m = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(v().h3());
                SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
            }
            this.l.x();
            this.l.n(R.drawable.pb_foot_more_trans_selector);
            this.l.o(R.drawable.pb_foot_more_trans_selector);
            this.l.q();
            this.f19938h.setOnSrollToBottomListener(this.H);
            this.f19938h.addOnScrollListener(this.D);
            this.f19938h.setOnTouchListener(v().m3());
            if (this.x == null) {
                g gVar = new g(getPageContext());
                this.x = gVar;
                gVar.n();
                this.x.a(this.F);
            }
            if (this.w == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f19937g.findViewById(R.id.pb_video_pull_refresh_layout);
                this.w = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.x);
                this.w.setEnabled(false);
                SkinManager.setBackgroundColor(this.w, R.color.CAM_X0205);
            }
            View findViewById2 = this.f19937g.findViewById(R.id.video_pb_reply_all_title);
            this.v = findViewById2;
            d.a.q0.h2.o.k.b bVar = new d.a.q0.h2.o.k.b(findViewById2);
            this.u = bVar;
            bVar.i(v().h3());
            this.u.j(v().Q1);
            registerListener(this.G);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(0);
        }
    }

    public void l1() {
        d.a.q0.h2.h.e L0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (L0 = y().L0()) == null) {
            return;
        }
        this.f19939i.h(y().Z0());
        this.f19939i.f(L0);
        this.f19939i.e();
        ArrayList<PostData> E = L0.E();
        if (L0.x().b() == 0 || E == null || E.size() < L0.x().e()) {
            if (ListUtils.getCount(E) != 0 && (ListUtils.getCount(E) != 1 || E.get(0) == null || E.get(0).A() != 1)) {
                if (L0.x().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (m1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
            }
        }
        v().j4(L0);
    }

    public boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (y() != null) {
                return y().q0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (bdTypeRecyclerView = this.f19938h) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(z()).get(VideoPbViewModel.class);
            videoPbViewModel.n().observe(this, new e(this));
            X0(true, 0, 3, 0, videoPbViewModel.c(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.f19935e = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.d(i2);
                if (this.m != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.m);
                    SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
                }
            }
            d.a.q0.h2.o.k.b bVar = this.u;
            if (bVar != null) {
                bVar.h(i2);
            }
            d.a.q0.h2.o.c cVar = this.f19939i;
            if (cVar != null) {
                cVar.e();
            }
            View view = this.o;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            this.j = new d.a.q0.h2.o.g.b(this);
            this.f19937g = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
            k1();
            return this.f19937g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.G);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                n.a().f();
            } else {
                n.a().j(z());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
            this.t = false;
            if (isPrimary()) {
                n.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onStop();
            n.a().j(z());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            super.onUserChanged(z);
            y1(z);
            if (v() != null && v().T != null) {
                this.f19936f.T.H();
            }
            if (z && this.t) {
                v1();
                y().u1(true);
            }
        }
    }

    @Override // d.a.q0.h2.p.e.b
    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.t = z;
        }
    }

    public void p1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || this.f19938h == null) {
        }
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.s == 2) {
            return;
        }
        this.f19938h.setNextPage(this.l);
        this.s = 2;
    }

    public void r1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048609, this, i2, i3) == null) || (bdTypeRecyclerView = this.f19938h) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f19938h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f19938h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void s1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.A(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            super.showLoadingView(view);
        }
    }

    public void t1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.F(str, this.B);
    }

    public void u1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment v() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.f19936f == null && (absPbActivity = this.f19935e) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f19936f = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f19936f;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.l.x();
            this.l.O();
        }
    }

    public void w1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i2) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(8);
        }
        showLoadingView(viewGroup);
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? v().y() : (PbModel) invokeV.objValue;
    }

    public void y1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048619, this, z) == null) && z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f19938h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            AbsPbActivity absPbActivity = this.f19935e;
            return absPbActivity != null ? absPbActivity : v().z();
        }
        return (AbsPbActivity) invokeV.objValue;
    }
}
