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
import c.a.e.e.p.l;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.d2;
import c.a.r0.j2.h.o;
import c.a.r0.j2.k.e.k0;
import c.a.r0.j2.k.e.m;
import c.a.r0.j2.p.g;
import c.a.r0.j3.i0.p;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements c.a.r0.j2.o.a, g.b {
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
    public AbsPbActivity f55601e;

    /* renamed from: f  reason: collision with root package name */
    public AbsVideoPbFragment f55602f;

    /* renamed from: g  reason: collision with root package name */
    public View f55603g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f55604h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.j2.o.c f55605i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.j2.o.g.b f55606j;
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
    public c.a.r0.j2.o.k.b u;
    public View v;
    public BdSwipeRefreshLayout w;
    public c.a.q0.s.f0.g x;
    public boolean y;
    public int z;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f55607a;

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
            this.f55607a = replyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    this.f55607a.getVideoPbFragment().resetCommentView();
                    this.f55607a.getVideoPbFragment().resetRecordLocation();
                }
                if (this.f55607a.getVideoPbFragment() != null) {
                    this.f55607a.getVideoPbFragment().onScrollStateChanged(i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (recyclerView.canScrollVertically(-1)) {
                    this.f55607a.z = 2;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f55607a.z != 0) {
                    this.f55607a.o.setVisibility(8);
                }
                this.f55607a.z = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements MultiNestedLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f55608a;

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
            this.f55608a = replyFragment;
        }

        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f55608a.A != 1 || i2 == 1 || this.f55608a.z == 0) {
                    if (this.f55608a.A != 0 || i2 == 0) {
                        if (this.f55608a.A != 0 && i2 == 0) {
                            this.f55608a.getVideoPbFragment().setShadowVisible(8);
                        }
                    } else if (this.f55608a.o.getVisibility() != 0) {
                        this.f55608a.getVideoPbFragment().setShadowVisible(0);
                    }
                } else {
                    this.f55608a.getVideoPbFragment().setShadowVisible(8);
                    this.f55608a.o.setVisibility(0);
                }
                this.f55608a.A = i2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f55609e;

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
            this.f55609e = replyFragment;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f55609e.getPbModel() != null && this.f55609e.getPbModel().C1(true)) {
                    TiebaStatic.eventStat(this.f55609e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.f55609e.endPullRefresh();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f55610a;

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
            this.f55610a = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f55610a.getPbModel() == null || this.f55610a.getPbModel().O0() == null || this.f55610a.getPbModel().O0().F() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            p pVar = null;
            Iterator<PostData> it = this.f55610a.getPbModel().O0().F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof p) {
                    p pVar2 = (p) next;
                    if (str.equals(pVar2.D0())) {
                        pVar = pVar2;
                        break;
                    }
                }
            }
            if (pVar == null || this.f55610a.f55605i == null || this.f55610a.f55604h == null) {
                return;
            }
            this.f55610a.getPbModel().O0().F().remove(pVar);
            if (this.f55610a.f55605i.a() != null) {
                this.f55610a.f55605i.a().remove(pVar);
            }
            if (this.f55610a.f55604h.getListView2().getData() != null) {
                this.f55610a.f55604h.getListView2().getData().remove(pVar);
            }
            this.f55610a.f55605i.e();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f55611e;

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
            this.f55611e = replyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f55611e.showLoadingView();
                } else {
                    this.f55611e.hideLoadingView();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyFragment f55612e;

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
            this.f55612e = replyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f55612e.mIsLogin) {
                if (!this.f55612e.C && this.f55612e.checkNoData() && this.f55612e.getPbModel() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.f55612e.getPbModel().e1());
                    statisticItem.param("fid", this.f55612e.getPbModel().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.f55612e.C = true;
                }
                if (this.f55612e.getPbModel().y1(false)) {
                    this.f55612e.setPreLoadNext();
                    if (this.f55612e.getPageContext() != null) {
                        TiebaStatic.eventStat(this.f55612e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.f55612e.getPbModel().O0() != null) {
                    this.f55612e.refreshNextPageView();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            ReplyFragment replyFragment = new ReplyFragment();
            replyFragment.setArguments(bundle);
            replyFragment.f55602f = absVideoPbFragment;
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
            return this.l.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public void endLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.v();
                this.l.f();
            }
            if (getVideoPbFragment() == null || getVideoPbFragment().mDialogController == null) {
                return;
            }
            this.f55602f.mDialogController.V();
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f55604h;
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f55604h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f55604h.getChildAt(0)) == null) {
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f55604h;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (getPbModel() == null || getPbModel().O0() == null || lastVisiblePosition < getPbModel().O0().F().size()) ? lastVisiblePosition : getPbModel().O0().F().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f55604h : (BdTypeRecyclerView) invokeV.objValue;
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
            AbsPbActivity absPbActivity = this.f55601e;
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

    public c.a.r0.j2.o.g.b getRichViewHepler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f55606j : (c.a.r0.j2.o.g.b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f55602f == null && (absPbActivity = this.f55601e) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f55602f = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f55602f;
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
            this.B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            MultiNestedLayout multiNestedLayout = (MultiNestedLayout) this.f55603g.findViewById(R.id.multi_nested_layout);
            this.k = multiNestedLayout;
            multiNestedLayout.setScrollStateChangeListener(this.F);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f55603g.findViewById(R.id.video_pb_reply_list);
            this.f55604h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            c.a.r0.j2.o.c cVar = new c.a.r0.j2.o.c(this, this.f55604h);
            this.f55605i = cVar;
            cVar.l(getVideoPbFragment().getListener());
            this.f55605i.i(getVideoPbFragment().getManageOnClickListener());
            this.f55605i.k(getVideoPbFragment().getOnLongClickListener());
            this.f55605i.j(this.f55606j.i());
            this.f55605i.m(this.f55606j.l());
            this.o = this.f55603g.findViewById(R.id.reply_pager_title_shadow);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.l = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
            this.m = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(getVideoPbFragment().getListener());
                SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
            }
            this.l.x();
            this.l.n(R.drawable.pb_foot_more_trans_selector);
            this.l.o(R.drawable.pb_foot_more_trans_selector);
            this.l.q();
            this.f55604h.setOnSrollToBottomListener(this.I);
            this.f55604h.addOnScrollListener(this.E);
            this.f55604h.setOnTouchListener(getVideoPbFragment().getOnTouchListener());
            if (this.x == null) {
                c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(getPageContext());
                this.x = gVar;
                gVar.i();
                this.x.a(this.G);
            }
            if (this.w == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f55603g.findViewById(R.id.pb_video_pull_refresh_layout);
                this.w = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.x);
                this.w.setEnabled(false);
                SkinManager.setBackgroundColor(this.w, R.color.CAM_X0205);
            }
            View findViewById2 = this.f55603g.findViewById(R.id.video_pb_reply_all_title);
            this.v = findViewById2;
            c.a.r0.j2.o.k.b bVar = new c.a.r0.j2.o.k.b(findViewById2);
            this.u = bVar;
            bVar.i(getVideoPbFragment().getListener());
            this.u.j(getVideoPbFragment().onSwitchChangeListener);
            registerListener(this.H);
        }
    }

    public void invalidataData() {
        c.a.r0.j2.h.e O0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (O0 = getPbModel().O0()) == null) {
            return;
        }
        this.f55605i.h(getPbModel().c1());
        this.f55605i.f(O0);
        this.f55605i.e();
        ArrayList<PostData> F = O0.F();
        if (O0.y().b() == 0 || F == null || F.size() < O0.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (O0.y().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (isHostOnlyMode()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
            }
        }
        getVideoPbFragment().refreshBottomTool(O0);
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (getPbModel() != null) {
                return getPbModel().s0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k(boolean z, int i2, int i3, int i4, c.a.r0.j2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getPbActivity()).get(VideoPbViewModel.class);
            if (!z || getPbModel() == null || eVar == null) {
                return;
            }
            if (this.D) {
                getPbModel().W();
            } else {
                this.D = true;
            }
            this.y = getPbModel().c1();
            boolean isEnabled = this.w.isEnabled();
            if (eVar.y().c() == 0 && this.y) {
                this.w.setEnabled(false);
            } else if (!isEnabled) {
                this.w.setEnabled(true);
                this.w.interruptRefresh();
            }
            this.f55605i.g(videoPbViewModel.isFromCDN());
            this.f55605i.h(this.y);
            this.f55605i.f(eVar);
            this.p = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f55604h.setNextPage(this.l);
                this.s = 2;
                if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                    this.f55602f.mDialogController.V();
                }
            } else {
                this.p = true;
                if (eVar.y().b() == 1) {
                    if (this.n == null) {
                        g gVar = new g(this, this);
                        this.n = gVar;
                        gVar.a();
                        this.n.g();
                    }
                    this.f55604h.setNextPage(this.n);
                } else {
                    this.f55604h.setNextPage(this.l);
                }
                this.s = 3;
            }
            if (this.u != null && this.v != null) {
                o oVar = new o(o.l);
                d2 O = eVar.O();
                if (O != null) {
                    O.U0();
                }
                getPbModel().c1();
                oVar.f19653h = isHostOnlyMode();
                oVar.f19652g = eVar.f19617g;
                eVar.c();
                oVar.f19654i = eVar.f0();
                oVar.k = eVar.f19616f;
                oVar.f19655j = O.F2();
                this.u.e(oVar);
            }
            ArrayList<PostData> F = eVar.F();
            if (eVar.y().b() != 0 && F != null && F.size() >= eVar.y().e()) {
                if (getPbModel().y0()) {
                    if (this.r) {
                        endLoadData();
                        if (eVar.y().b() != 0) {
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
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (eVar.y().b() == 0) {
                        this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.l.j();
                } else if (isHostOnlyMode()) {
                    this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.B);
                } else {
                    this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.B);
                }
                if (eVar.y().b() == 0 || F == null) {
                    refreshNextPageView();
                }
            }
            if (i3 == 2) {
                this.f55604h.setSelection(i4 > 1 ? (i4 + ((this.f55604h.getData() == null && eVar.F() == null) ? 0 : this.f55604h.getData().size() - eVar.F().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.r = false;
                } else if (i3 == 5) {
                    this.f55604h.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = k0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f55604h.onRestoreInstanceState(e2);
                        }
                    }
                    this.f55604h.setSelection(0);
                } else if (i3 == 8) {
                    int size = (this.f55604h.getData() == null && eVar.F() == null) ? 0 : this.f55604h.getData().size() - eVar.F().size();
                    this.k.setMaxOffset();
                    this.f55604h.setSelection(i4 > 0 ? i4 + size : 0);
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            } else if (i5 == 1) {
                Parcelable e3 = k0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f55604h.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(F) > 1 && eVar.y().b() > 0) {
                        this.l.f();
                        this.l.A(getString(R.string.pb_load_more_without_point));
                        this.l.v();
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
            getVideoPbFragment().refreshBottomTool(eVar);
            String q0 = getPbModel().q0();
            if (TextUtils.isEmpty(q0)) {
                return;
            }
            c.a.r0.j2.k.e.a1.l.b(getListView(), q0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getPbActivity()).get(VideoPbViewModel.class);
            videoPbViewModel.isLoading().observe(this, new e(this));
            k(true, 0, 3, 0, videoPbViewModel.getData(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.f55601e = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.d(i2);
                if (this.m != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.m);
                    SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
                }
            }
            c.a.r0.j2.o.k.b bVar = this.u;
            if (bVar != null) {
                bVar.h(i2);
            }
            c.a.r0.j2.o.c cVar = this.f55605i;
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
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f55606j = new c.a.r0.j2.o.g.b(this);
            this.f55603g = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
            initUI();
            return this.f55603g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.H);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                m.a().f();
            } else {
                m.a().j(getPbActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onResume();
            this.t = false;
            if (isPrimary()) {
                m.a().f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onStop();
            m.a().j(getPbActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            super.onUserChanged(z);
            switchLoginStyle(z);
            if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                this.f55602f.mDialogController.H();
            }
            if (z && this.t) {
                setPreLoadNext();
                getPbModel().y1(true);
            }
        }
    }

    public void receiveFling(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || (bdTypeRecyclerView = this.f55604h) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void recoverLastListViewPosition() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || this.f55604h == null) {
        }
    }

    @Override // c.a.r0.j2.o.a
    public void refresh(boolean z, int i2, int i3, int i4, c.a.r0.j2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        k(z, i2, i3, i4, eVar, str, i5);
    }

    public void refreshNextPageView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.s == 2) {
            return;
        }
        this.f55604h.setNextPage(this.l);
        this.s = 2;
    }

    @Override // c.a.r0.j2.p.g.b
    public void resetLoadMoreFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.t = z;
        }
    }

    public void scrollListView(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048612, this, i2, i3) == null) || (bdTypeRecyclerView = this.f55604h) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f55604h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f55604h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void setEndText(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.A(str);
    }

    public void setEndTextWithNoData(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.F(str, this.B);
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
            this.l.x();
            this.l.O();
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
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f55604h.setNextPage(this.l);
            this.s = 2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public c.a.r0.j2.o.c getAdapterManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55605i : (c.a.r0.j2.o.c) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view) == null) {
            super.showLoadingView(view);
        }
    }
}
