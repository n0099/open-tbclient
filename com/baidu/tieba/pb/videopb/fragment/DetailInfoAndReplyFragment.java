package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.r.f0.f;
import d.a.r0.r.q.b2;
import d.a.s0.h2.k.e.m0;
import d.a.s0.h2.p.e;
import d.a.s0.h3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements d.a.s0.h2.o.a, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public ViewTreeObserver.OnGlobalLayoutListener E;
    public boolean F;
    public RecyclerView.OnScrollListener G;
    public final f.g H;
    public CustomMessageListener I;
    public final BdListView.p J;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19769e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f19770f;

    /* renamed from: g  reason: collision with root package name */
    public View f19771g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f19772h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f19773i;
    public d.a.s0.h2.o.f.b j;
    public d.a.s0.h2.o.g.b k;
    public PbListView l;
    public View m;
    public d.a.s0.h2.p.e n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;
    public LinearLayout u;
    public PbReplyTitleViewHolder v;
    public PbChildTitleViewHolder w;
    public BdSwipeRefreshLayout x;
    public d.a.r0.r.f0.g y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19774a;

        public a(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19774a = detailInfoAndReplyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    this.f19774a.v().j4();
                    this.f19774a.v().l4();
                }
                if (this.f19774a.v() != null) {
                    this.f19774a.v().W3(i2);
                }
                if (i2 == 0) {
                    this.f19774a.r1(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f19774a.l1();
                if (recyclerView.canScrollVertically(-1)) {
                    this.f19774a.A = 2;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f19774a.A != 0) {
                    this.f19774a.o.setVisibility(8);
                }
                this.f19774a.A = 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19775e;

        public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19775e = detailInfoAndReplyFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f19775e.y() != null && this.f19775e.y().p1(true)) {
                    TiebaStatic.eventStat(this.f19775e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.f19775e.W0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19776a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DetailInfoAndReplyFragment detailInfoAndReplyFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, Integer.valueOf(i2)};
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
            this.f19776a = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19776a.y() == null || this.f19776a.y().D0() == null || this.f19776a.y().D0().E() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = this.f19776a.y().D0().E().iterator();
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
            if (oVar == null || this.f19776a.j == null || this.f19776a.f19772h == null) {
                return;
            }
            this.f19776a.y().D0().E().remove(oVar);
            if (this.f19776a.j.a() != null) {
                this.f19776a.j.a().remove(oVar);
            }
            if (this.f19776a.f19772h.getListView2().getData() != null) {
                this.f19776a.f19772h.getListView2().getData().remove(oVar);
            }
            this.f19776a.j.r();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19777a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(DetailInfoAndReplyFragment detailInfoAndReplyFragment, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19777a = detailInfoAndReplyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19778e;

        public e(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19778e = detailInfoAndReplyFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19778e.F || this.f19778e.v() == null) {
                return;
            }
            this.f19778e.F = true;
            this.f19778e.v().E2(this.f19778e.f19772h, false);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19779e;

        public f(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19779e = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f19779e.x1();
                } else {
                    this.f19779e.m();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19780e;

        public g(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19780e = detailInfoAndReplyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19780e.mIsLogin) {
                if (!this.f19780e.D && this.f19780e.U0() && this.f19780e.y() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.f19780e.y().T0());
                    statisticItem.param("fid", this.f19780e.y().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.f19780e.D = true;
                }
                if (this.f19780e.y().l1(false)) {
                    this.f19780e.v1();
                    if (this.f19780e.getPageContext() != null) {
                        TiebaStatic.eventStat(this.f19780e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.f19780e.y().D0() != null) {
                    this.f19780e.p1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f19781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19782f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19783g;

        public h(DetailInfoAndReplyFragment detailInfoAndReplyFragment, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19783g = detailInfoAndReplyFragment;
            this.f19781e = z;
            this.f19782f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19781e) {
                this.f19783g.q1(this.f19782f, UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
        }
    }

    public DetailInfoAndReplyFragment() {
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
        this.y = null;
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.D = false;
        this.G = new a(this);
        this.H = new b(this);
        this.I = new c(this, 2016331);
        this.J = new g(this);
    }

    public static DetailInfoAndReplyFragment k1(VideoPbFragment videoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, videoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
            detailInfoAndReplyFragment.setArguments(bundle);
            detailInfoAndReplyFragment.f19770f = videoPbFragment;
            return detailInfoAndReplyFragment;
        }
        return (DetailInfoAndReplyFragment) invokeL.objValue;
    }

    public final void T0(boolean z, int i2, int i3, int i4, d.a.s0.h2.h.e eVar, String str, int i5, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(z()).get(VideoPbViewModel.class);
            if (!z || y() == null || eVar == null) {
                return;
            }
            this.z = y().R0();
            boolean isEnabled = this.x.isEnabled();
            boolean z3 = true;
            int i6 = 0;
            if (eVar.x().c() == 0 && this.z) {
                this.x.setEnabled(false);
            } else if (!isEnabled) {
                this.x.setEnabled(true);
                this.x.o();
            }
            this.j.x(videoPbViewModel.l());
            this.j.y(this.z);
            this.j.w(eVar, z2);
            this.p = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f19772h.setNextPage(this.l);
                this.s = 2;
                if (v() != null && v().T != null) {
                    this.f19770f.T.V();
                }
            } else {
                this.p = true;
                if (eVar.x().b() == 1) {
                    if (this.n == null) {
                        d.a.s0.h2.p.e eVar2 = new d.a.s0.h2.p.e(this, this);
                        this.n = eVar2;
                        eVar2.a();
                        this.n.g();
                    }
                    this.f19772h.setNextPage(this.n);
                } else {
                    this.f19772h.setNextPage(this.l);
                }
                this.s = 3;
            }
            if (this.v != null) {
                d.a.s0.h2.h.o oVar = new d.a.s0.h2.h.o(d.a.s0.h2.h.o.l);
                b2 N = eVar.N();
                if (N != null) {
                    N.P0();
                }
                y().R0();
                oVar.f60177h = j1();
                oVar.f60176g = eVar.f60143g;
                eVar.c();
                oVar.f60178i = eVar.e0();
                oVar.k = eVar.f60142f;
                this.v.h(oVar);
            }
            ArrayList<PostData> E = eVar.E();
            if (eVar.x().b() != 0 && E != null && E.size() >= eVar.x().e()) {
                if (y().n0()) {
                    if (this.r) {
                        V0();
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
                if (eVar.x().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
                if (eVar.x().b() == 0 || E == null) {
                    p1();
                }
            }
            if (i3 == 2) {
                this.f19772h.setSelection(i4 > 1 ? (i4 + ((this.f19772h.getData() == null && eVar.E() == null) ? 0 : this.f19772h.getData().size() - eVar.E().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.r = false;
                } else if (i3 == 5) {
                    this.f19772h.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = m0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f19772h.onRestoreInstanceState(e2);
                        }
                    }
                    this.f19772h.setSelection(0);
                } else if (i3 == 8) {
                    this.f19772h.setSelection(i4 > 0 ? i4 + ((this.f19772h.getData() == null && eVar.E() == null) ? 0 : this.f19772h.getData().size() - eVar.E().size()) : 0);
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            } else if (i5 == 1) {
                Parcelable e3 = m0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f19772h.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(E) > 1 && eVar.x().b() > 0) {
                        this.l.f();
                        this.l.A(getString(R.string.pb_load_more_without_point));
                        this.l.v();
                    }
                }
            }
            if (this.q) {
                n1();
                this.q = false;
                if (i5 == 0) {
                    u1(true);
                }
            }
            v().e4(eVar);
            if (this.l != null) {
                if (eVar.x().b() != 0 && !d.a.r0.c1.b.e.d()) {
                    this.l.I(0);
                } else {
                    this.l.I(8);
                }
            }
            if (ListUtils.getCount(this.j.a()) <= 0 || !videoPbViewModel.m()) {
                return;
            }
            videoPbViewModel.w(false);
            String g0 = y().g0();
            ArrayList<n> a2 = this.j.a();
            if (a2 != null) {
                if (!k.isEmpty(g0)) {
                    for (int i7 = 0; i7 < a2.size(); i7++) {
                        if (a2.get(i7).getType() == PostData.u0 && g0.equals(((PostData) a2.get(i7)).E())) {
                            i6 = i7;
                            break;
                        }
                    }
                } else {
                    int i8 = 0;
                    while (true) {
                        if (i8 >= a2.size()) {
                            break;
                        } else if (a2.get(i8).getType() == d.a.s0.h2.h.o.l) {
                            i6 = i8;
                            break;
                        } else {
                            i8++;
                        }
                    }
                }
                z3 = false;
                if (i6 != 0) {
                    d.a.c.e.m.e.a().post(new h(this, z3, i6));
                }
            }
        }
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbListView pbListView = this.l;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.l.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.v();
                this.l.f();
            }
            if (v() != null && v().T != null) {
                this.f19770f.T.V();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public void W0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdSwipeRefreshLayout = this.x) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.x.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: X0 */
    public d.a.s0.h2.o.f.b G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : (d.a.s0.h2.o.f.b) invokeV.objValue;
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19772h;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int Z0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19772h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f19772h.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19772h;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (y() == null || y().D0() == null || lastVisiblePosition < y().D0().E().size()) ? lastVisiblePosition : y().D0().E().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19772h : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.B : invokeV.intValue;
    }

    public View d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.A : invokeV.intValue;
    }

    public d.a.s0.h2.o.g.b f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (d.a.s0.h2.o.g.b) invokeV.objValue;
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
            this.v = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.u = false;
            pbReplyTitleViewHolder.p(v().c3());
            this.v.o(v().P1);
            this.v.r(8);
            this.u.addView(this.v.j());
            this.w = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
            d.a.s0.h2.h.d dVar = new d.a.s0.h2.h.d();
            dVar.e(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.w.b(dVar);
            this.w.e(8);
            this.u.addView(this.w.c());
        }
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.C = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            this.f19772h = (BdTypeRecyclerView) this.f19771g.findViewById(R.id.video_pb_reply_list);
            d dVar = new d(this, getContext());
            this.f19773i = dVar;
            this.f19772h.setLayoutManager(dVar);
            d.a.s0.h2.o.f.b bVar = new d.a.s0.h2.o.f.b(this, this.f19772h);
            this.j = bVar;
            bVar.D(v().c3());
            this.j.z(v().d3());
            this.j.B(v().g3());
            this.j.A(this.k.i());
            this.j.E(this.k.l());
            this.o = this.f19771g.findViewById(R.id.reply_pager_title_shadow);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.l = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
            this.m = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(v().c3());
                SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
            }
            this.l.x();
            this.l.n(R.drawable.pb_foot_more_trans_selector);
            this.l.o(R.drawable.pb_foot_more_trans_selector);
            this.l.q();
            this.f19772h.setOnSrollToBottomListener(this.J);
            this.f19772h.addOnScrollListener(this.G);
            this.f19772h.setOnTouchListener(v().h3());
            this.E = new e(this);
            this.f19772h.getViewTreeObserver().addOnGlobalLayoutListener(this.E);
            if (this.y == null) {
                d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(getPageContext());
                this.y = gVar;
                gVar.n();
                this.y.a(this.H);
            }
            if (this.x == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f19771g.findViewById(R.id.pb_video_pull_refresh_layout);
                this.x = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.y);
                this.x.setEnabled(false);
                SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
            }
            this.u = (LinearLayout) this.f19771g.findViewById(R.id.video_pb_suck_container);
            g1();
            this.j.C(v().P1);
            registerListener(this.I);
            if (d.a.r0.c1.b.e.d()) {
                this.l.I(8);
                this.m.setVisibility(8);
            }
        }
    }

    public void i1() {
        d.a.s0.h2.h.e D0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (D0 = y().D0()) == null) {
            return;
        }
        this.j.y(y().R0());
        this.j.v(D0);
        this.j.r();
        ArrayList<PostData> E = D0.E();
        if (D0.x().b() == 0 || E == null || E.size() < D0.x().e()) {
            if (ListUtils.getCount(E) != 0 && (ListUtils.getCount(E) != 1 || E.get(0) == null || E.get(0).A() != 1)) {
                if (D0.x().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (j1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.C);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.C);
            }
        }
        v().e4(D0);
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (y() != null) {
                return y().i0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l1() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (bdTypeRecyclerView = this.f19772h) == null || this.f19773i == null || this.j == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.j.j();
        int headerViewsCount2 = this.f19772h.getHeaderViewsCount() + this.j.i();
        int findFirstVisibleItemPosition = this.f19773i.findFirstVisibleItemPosition();
        if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
            this.v.r(0);
        } else {
            this.v.r(8);
        }
        if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
            this.w.e(0);
            this.v.r(8);
        } else {
            this.w.e(8);
        }
        if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
            w1(0);
        } else {
            w1(8);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(0);
        }
    }

    @Override // d.a.s0.h2.p.e.b
    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.t = z;
        }
    }

    public void m1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (bdTypeRecyclerView = this.f19772h) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || this.f19772h == null) {
        }
    }

    public void o1() {
        d.a.s0.h2.o.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (bVar = this.j) == null) {
            return;
        }
        bVar.s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(z()).get(VideoPbViewModel.class);
            videoPbViewModel.n().observe(this, new f(this));
            T0(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, context) == null) {
            super.onAttach(context);
            if (context instanceof PbActivity) {
                this.f19769e = (PbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.d(i2);
                if (this.m != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.m);
                    SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
                }
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.v;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.l(i2);
            }
            PbChildTitleViewHolder pbChildTitleViewHolder = this.w;
            if (pbChildTitleViewHolder != null) {
                pbChildTitleViewHolder.d();
            }
            d.a.s0.h2.o.f.b bVar = this.j;
            if (bVar != null) {
                bVar.r();
            }
            View view = this.o;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
            if (d.a.r0.c1.b.e.d()) {
                SkinManager.setBackgroundColor(this.f19772h, R.color.CAM_X0202);
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f19772h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            this.k = new d.a.s0.h2.o.g.b(this);
            this.f19771g = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
            h1();
            return this.f19771g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onDestroy();
            d.a.s0.h2.o.f.b bVar = this.j;
            if (bVar != null) {
                bVar.t();
            }
            MessageManager.getInstance().unRegisterListener(this.I);
            d.a.s0.h2.k.e.n.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.f19772h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.E);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPause();
            if (v() != null) {
                d.a.s0.h2.k.e.n.a().j(z());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onResume();
            this.t = false;
            r1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            super.onUserChanged(z);
            y1(z);
            if (v() != null && v().T != null) {
                this.f19770f.T.H();
            }
            if (z && this.t) {
                v1();
                y().l1(true);
            }
        }
    }

    public void p1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.s == 2) {
            return;
        }
        this.f19772h.setNextPage(this.l);
        this.s = 2;
    }

    public void q1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048610, this, i2, i3) == null) || (bdTypeRecyclerView = this.f19772h) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f19772h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f19772h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public final void r1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || v() == null || z() == null || z().getPbModel() == null || this.j.k() == null) {
            return;
        }
        d.a.s0.h2.k.e.n.a().g(z().getPbModel().c1(), this.j.k().i0(), this.v.j(), z().getPageStayDurationItem(), z, null, null);
    }

    public void s1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.A(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view) == null) {
            super.showLoadingView(view);
        }
    }

    public void t1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.F(str, this.C);
    }

    public void u1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment v() {
        InterceptResult invokeV;
        PbActivity pbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.f19770f == null && (pbActivity = this.f19769e) != null) {
                Fragment findFragment = pbActivity.findFragment();
                if (findFragment instanceof VideoPbFragment) {
                    this.f19770f = (VideoPbFragment) findFragment;
                }
            }
            return this.f19770f;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.l.x();
            this.l.O();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    public void w1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i2) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || getView() == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? v().y() : (PbModel) invokeV.objValue;
    }

    public void y1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z) == null) && z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f19772h.setNextPage(this.l);
            this.s = 2;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            PbActivity pbActivity = this.f19769e;
            return pbActivity != null ? pbActivity : v().z();
        }
        return (PbActivity) invokeV.objValue;
    }

    @Override // d.a.s0.h2.o.a
    public void z0(boolean z, int i2, int i3, int i4, d.a.s0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        T0(z, i2, i3, i4, eVar, str, i5, false);
    }
}
