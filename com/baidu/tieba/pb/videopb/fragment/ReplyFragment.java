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
import c.a.d.f.p.n;
import c.a.s0.s.k0.f;
import c.a.s0.s.q.e2;
import c.a.t0.t2.h;
import c.a.t0.t2.i;
import c.a.t0.t2.j;
import c.a.t0.t2.l;
import c.a.t0.t2.r.q;
import c.a.t0.t2.u.f.m0;
import c.a.t0.t2.z.g;
import c.a.t0.x3.j0.p;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes12.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements c.a.t0.t2.y.b, g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public RecyclerView.OnScrollListener E;
    public MultiNestedLayout.b F;
    public final f.g G;
    public CustomMessageListener H;
    public final BdListView.p I;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f46928e;

    /* renamed from: f  reason: collision with root package name */
    public AbsVideoPbFragment f46929f;

    /* renamed from: g  reason: collision with root package name */
    public View f46930g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f46931h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.t2.y.d f46932i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.t0.t2.y.h.b f46933j;
    public MultiNestedLayout k;
    public PbListView l;
    public View m;
    public g n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;
    public c.a.t0.t2.y.l.b u;
    public View v;
    public BdSwipeRefreshLayout w;
    public c.a.s0.s.k0.g x;
    public boolean y;
    public int z;

    /* loaded from: classes12.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

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
            this.a = replyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    this.a.getVideoPbFragment().resetCommentView();
                    this.a.getVideoPbFragment().resetRecordLocation();
                }
                if (this.a.getVideoPbFragment() != null) {
                    this.a.getVideoPbFragment().onScrollStateChanged(i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (recyclerView.canScrollVertically(-1)) {
                    this.a.z = 2;
                    return;
                }
                if (Math.abs(i3) > 0 && this.a.z != 0) {
                    this.a.o.setVisibility(8);
                }
                this.a.z = 0;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements MultiNestedLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

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
            this.a = replyFragment;
        }

        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.a.A != 1 || i2 == 1 || this.a.z == 0) {
                    if (this.a.A != 0 || i2 == 0) {
                        if (this.a.A != 0 && i2 == 0) {
                            this.a.getVideoPbFragment().setShadowVisible(8);
                        }
                    } else if (this.a.o.getVisibility() != 0) {
                        this.a.getVideoPbFragment().setShadowVisible(0);
                    }
                } else {
                    this.a.getVideoPbFragment().setShadowVisible(8);
                    this.a.o.setVisibility(0);
                }
                this.a.A = i2;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f46934e;

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
            this.f46934e = replyFragment;
        }

        @Override // c.a.s0.s.k0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f46934e.getPbModel() != null && this.f46934e.getPbModel().J1(true)) {
                    TiebaStatic.eventStat(this.f46934e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.f46934e.endPullRefresh();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

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
            this.a = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.getPbModel() == null || this.a.getPbModel().R0() == null || this.a.getPbModel().R0().F() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            p pVar = null;
            Iterator<PostData> it = this.a.getPbModel().R0().F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof p) {
                    p pVar2 = (p) next;
                    if (str.equals(pVar2.K0())) {
                        pVar = pVar2;
                        break;
                    }
                }
            }
            if (pVar == null || this.a.f46932i == null || this.a.f46931h == null) {
                return;
            }
            this.a.getPbModel().R0().F().remove(pVar);
            if (this.a.f46932i.a() != null) {
                this.a.f46932i.a().remove(pVar);
            }
            if (this.a.f46931h.getListView2().getData() != null) {
                this.a.f46931h.getListView2().getData().remove(pVar);
            }
            this.a.f46932i.e();
        }
    }

    /* loaded from: classes12.dex */
    public class e implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyFragment a;

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
            this.a = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.showLoadingView();
                } else {
                    this.a.hideLoadingView();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f46935e;

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
            this.f46935e = replyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46935e.mIsLogin) {
                if (!this.f46935e.C && this.f46935e.checkNoData() && this.f46935e.getPbModel() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.f46935e.getPbModel().h1());
                    statisticItem.param("fid", this.f46935e.getPbModel().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.f46935e.C = true;
                }
                if (this.f46935e.getPbModel().F1(false)) {
                    this.f46935e.setPreLoadNext();
                    if (this.f46935e.getPageContext() != null) {
                        TiebaStatic.eventStat(this.f46935e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.f46935e.getPbModel().R0() != null) {
                    this.f46935e.refreshNextPageView();
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
        this.E = new a(this);
        this.F = new b(this);
        this.G = new c(this);
        this.H = new d(this, 2016331);
        this.I = new f(this);
    }

    public static ReplyFragment newInstance(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.f46929f = absVideoPbFragment;
            return replyFragment;
        }
        return (ReplyFragment) invokeL.objValue;
    }

    public boolean checkNoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbListView pbListView = this.l;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.l.h().equals(TbadkCoreApplication.getInst().getResources().getString(l.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public void endLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.y();
                this.l.f();
            }
            if (getVideoPbFragment() == null || getVideoPbFragment().mDialogController == null) {
                return;
            }
            this.f46929f.mDialogController.V();
        }
    }

    public void endPullRefresh() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdSwipeRefreshLayout = this.w) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.w.setRefreshing(false);
        }
    }

    public int getFirstItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f46931h;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getFirstItemOffset() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f46931h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f46931h.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public int getLastItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f46931h;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (getPbModel() == null || getPbModel().R0() == null || lastVisiblePosition < getPbModel().R0().F().size()) ? lastVisiblePosition : getPbModel().R0().F().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f46931h : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int getMultiNestedLayoutState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.A : invokeV.intValue;
    }

    public View getNextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AbsPbActivity absPbActivity = this.f46928e;
            return absPbActivity != null ? absPbActivity : getVideoPbFragment().getPbActivity();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? getVideoPbFragment().getPbModel() : (PbModel) invokeV.objValue;
    }

    public int getRecyclerViewState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.z : invokeV.intValue;
    }

    public c.a.t0.t2.y.h.b getRichViewHepler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f46933j : (c.a.t0.t2.y.h.b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f46929f == null && (absPbActivity = this.f46928e) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f46929f = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f46929f;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public void hideLoadingView() {
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

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.B = n.f(TbadkCoreApplication.getInst(), c.a.t0.t2.g.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.f46930g.findViewById(i.multi_nested_layout);
            this.k = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.F);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f46930g.findViewById(i.video_pb_reply_list);
            this.f46931h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            c.a.t0.t2.y.d dVar = new c.a.t0.t2.y.d(this, this.f46931h);
            this.f46932i = dVar;
            dVar.l(getVideoPbFragment().getListener());
            this.f46932i.i(getVideoPbFragment().getManageOnClickListener());
            this.f46932i.k(getVideoPbFragment().getOnLongClickListener());
            this.f46932i.j(this.f46933j.i());
            this.f46932i.m(this.f46933j.l());
            this.o = this.f46930g.findViewById(i.reply_pager_title_shadow);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.l = pbListView;
            View findViewById = pbListView.b().findViewById(i.pb_more_view);
            this.m = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(getVideoPbFragment().getListener());
                SkinManager.setBackgroundResource(this.m, h.pb_foot_more_trans_selector);
            }
            this.l.A();
            this.l.o(h.pb_foot_more_trans_selector);
            this.l.p(h.pb_foot_more_trans_selector);
            this.l.s();
            this.f46931h.setOnSrollToBottomListener(this.I);
            this.f46931h.addOnScrollListener(this.E);
            this.f46931h.setOnTouchListener(getVideoPbFragment().getOnTouchListener());
            if (this.x == null) {
                c.a.s0.s.k0.g gVar = new c.a.s0.s.k0.g(getPageContext());
                this.x = gVar;
                gVar.i();
                this.x.a(this.G);
            }
            if (this.w == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f46930g.findViewById(i.pb_video_pull_refresh_layout);
                this.w = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.x);
                this.w.setEnabled(false);
                SkinManager.setBackgroundColor(this.w, c.a.t0.t2.f.CAM_X0205);
            }
            View findViewById2 = this.f46930g.findViewById(i.video_pb_reply_all_title);
            this.v = findViewById2;
            c.a.t0.t2.y.l.b bVar = new c.a.t0.t2.y.l.b(findViewById2);
            this.u = bVar;
            bVar.i(getVideoPbFragment().getListener());
            this.u.j(getVideoPbFragment().onSwitchChangeListener);
            registerListener(this.H);
        }
    }

    public void invalidataData() {
        c.a.t0.t2.r.f R0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (R0 = getPbModel().R0()) == null) {
            return;
        }
        this.f46932i.h(getPbModel().f1());
        this.f46932i.f(R0);
        this.f46932i.e();
        ArrayList<PostData> F = R0.F();
        if (R0.y().b() == 0 || F == null || F.size() < R0.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (R0.y().b() == 0) {
                    this.l.D(TbadkCoreApplication.getInst().getResources().getString(l.list_has_no_more));
                } else {
                    this.l.D(TbadkCoreApplication.getInst().getResources().getString(l.load_more));
                }
                this.l.k();
            } else if (isHostOnlyMode()) {
                this.l.I(TbadkCoreApplication.getInst().getResources().getString(l.pb_no_host_reply), this.B);
            } else {
                this.l.I(TbadkCoreApplication.getInst().getResources().getString(l.pb_no_replay), this.B);
            }
        }
        getVideoPbFragment().refreshBottomTool(R0);
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (getPbModel() != null) {
                return getPbModel().v0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getPbActivity()).get(VideoPbViewModel.class);
            videoPbViewModel.isLoading().observe(this, new e(this));
            p(true, 0, 3, 0, videoPbViewModel.getData(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.f46928e = (AbsPbActivity) context;
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
                    SkinManager.setBackgroundResource(this.m, h.pb_foot_more_trans_selector);
                }
            }
            c.a.t0.t2.y.l.b bVar = this.u;
            if (bVar != null) {
                bVar.h(i2);
            }
            c.a.t0.t2.y.d dVar = this.f46932i;
            if (dVar != null) {
                dVar.e();
            }
            View view = this.o;
            if (view != null) {
                SkinManager.setBackgroundResource(view, h.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.w, c.a.t0.t2.f.CAM_X0201);
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
            this.f46933j = new c.a.t0.t2.y.h.b(this);
            this.f46930g = layoutInflater.inflate(j.pb_reply_fragment, (ViewGroup) null);
            initUI();
            return this.f46930g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.H);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                c.a.t0.t2.u.f.n.a().f();
            } else {
                c.a.t0.t2.u.f.n.a().j(getPbActivity());
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
                c.a.t0.t2.u.f.n.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onStop();
            c.a.t0.t2.u.f.n.a().j(getPbActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            super.onUserChanged(z);
            switchLoginStyle(z);
            if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                this.f46929f.mDialogController.H();
            }
            if (z && this.t) {
                setPreLoadNext();
                getPbModel().F1(true);
            }
        }
    }

    public final void p(boolean z, int i2, int i3, int i4, c.a.t0.t2.r.f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getPbActivity()).get(VideoPbViewModel.class);
            if (!z || getPbModel() == null || fVar == null) {
                return;
            }
            if (this.D) {
                getPbModel().Y();
            } else {
                this.D = true;
            }
            this.y = getPbModel().f1();
            boolean isEnabled = this.w.isEnabled();
            if (fVar.y().c() == 0 && this.y) {
                this.w.setEnabled(false);
            } else if (!isEnabled) {
                this.w.setEnabled(true);
                this.w.interruptRefresh();
            }
            this.f46932i.g(videoPbViewModel.isFromCDN());
            this.f46932i.h(this.y);
            this.f46932i.f(fVar);
            this.p = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f46931h.setNextPage(this.l);
                this.s = 2;
                if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                    this.f46929f.mDialogController.V();
                }
            } else {
                this.p = true;
                if (fVar.y().b() == 1) {
                    if (this.n == null) {
                        g gVar = new g(this, this);
                        this.n = gVar;
                        gVar.a();
                        this.n.g();
                    }
                    this.f46931h.setNextPage(this.n);
                } else {
                    this.f46931h.setNextPage(this.l);
                }
                this.s = 3;
            }
            if (this.u != null && this.v != null) {
                q qVar = new q(q.l);
                e2 O = fVar.O();
                if (O != null) {
                    O.W0();
                }
                getPbModel().f1();
                qVar.f22719h = isHostOnlyMode();
                qVar.f22718g = fVar.f22685g;
                fVar.c();
                qVar.f22720i = fVar.g0();
                qVar.k = fVar.f22684f;
                qVar.f22721j = O.J2();
                this.u.e(qVar);
            }
            ArrayList<PostData> F = fVar.F();
            if (fVar.y().b() != 0 && F != null && F.size() >= fVar.y().e()) {
                if (getPbModel().B0()) {
                    if (this.r) {
                        endLoadData();
                        if (fVar.y().b() != 0) {
                            this.l.D(TbadkCoreApplication.getInst().getResources().getString(l.pb_load_more));
                        }
                    } else {
                        this.l.A();
                        this.l.O();
                    }
                } else {
                    this.l.A();
                    this.l.O();
                }
                this.l.k();
            } else {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (fVar.y().b() == 0) {
                        this.l.D(TbadkCoreApplication.getInst().getResources().getString(l.list_has_no_more));
                    } else {
                        this.l.D(TbadkCoreApplication.getInst().getResources().getString(l.load_more));
                    }
                    this.l.k();
                } else if (isHostOnlyMode()) {
                    this.l.I(TbadkCoreApplication.getInst().getResources().getString(l.pb_no_host_reply), this.B);
                } else {
                    this.l.I(TbadkCoreApplication.getInst().getResources().getString(l.pb_no_replay), this.B);
                }
                if (fVar.y().b() == 0 || F == null) {
                    refreshNextPageView();
                }
            }
            if (i3 == 2) {
                this.f46931h.setSelection(i4 > 1 ? (i4 + ((this.f46931h.getData() == null && fVar.F() == null) ? 0 : this.f46931h.getData().size() - fVar.F().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.r = false;
                } else if (i3 == 5) {
                    this.f46931h.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = m0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f46931h.onRestoreInstanceState(e2);
                        }
                    }
                    this.f46931h.setSelection(0);
                } else if (i3 == 8) {
                    int size = (this.f46931h.getData() == null && fVar.F() == null) ? 0 : this.f46931h.getData().size() - fVar.F().size();
                    this.k.setMaxOffset();
                    this.f46931h.setSelection(i4 > 0 ? i4 + size : 0);
                    this.l.f();
                    this.l.D(getString(l.pb_load_more_without_point));
                    this.l.y();
                }
            } else if (i5 == 1) {
                Parcelable e3 = m0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f46931h.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(F) > 1 && fVar.y().b() > 0) {
                        this.l.f();
                        this.l.D(getString(l.pb_load_more_without_point));
                        this.l.y();
                    }
                }
            }
            if (this.q) {
                recoverLastListViewPosition();
                this.q = false;
                if (i5 == 0) {
                    setNeedRecoverPosition(true);
                }
            }
            getVideoPbFragment().refreshBottomTool(fVar);
            String t0 = getPbModel().t0();
            if (TextUtils.isEmpty(t0)) {
                return;
            }
            c.a.t0.t2.u.f.c1.l.b(getListView(), t0);
        }
    }

    public void receiveFling(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || (bdTypeRecyclerView = this.f46931h) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void recoverLastListViewPosition() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || this.f46931h == null) {
        }
    }

    @Override // c.a.t0.t2.y.b
    public void refresh(boolean z, int i2, int i3, int i4, c.a.t0.t2.r.f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        p(z, i2, i3, i4, fVar, str, i5);
    }

    public void refreshNextPageView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.s == 2) {
            return;
        }
        this.f46931h.setNextPage(this.l);
        this.s = 2;
    }

    @Override // c.a.t0.t2.z.g.b
    public void resetLoadMoreFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.t = z;
        }
    }

    public void scrollListView(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048612, this, i2, i3) == null) || (bdTypeRecyclerView = this.f46931h) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f46931h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f46931h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void setEndText(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.D(str);
    }

    public void setEndTextWithNoData(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.I(str, this.B);
    }

    public void setNeedRecoverPosition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.q = z;
        }
    }

    public void setPreLoadNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.l.A();
            this.l.R();
        }
    }

    public void setShadowVisible(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048617, this, i2) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void setSwipeRefreshLayoutEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.w.setEnabled(z);
        }
    }

    public void showLoadingView() {
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

    public void switchLoginStyle(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z) == null) && z && this.p) {
            this.l.D(TbadkCoreApplication.getInst().getResources().getString(l.click_load_more));
            this.f46931h.setNextPage(this.l);
            this.s = 2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public c.a.t0.t2.y.d getAdapterManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46932i : (c.a.t0.t2.y.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view) == null) {
            super.showLoadingView(view);
        }
    }
}
