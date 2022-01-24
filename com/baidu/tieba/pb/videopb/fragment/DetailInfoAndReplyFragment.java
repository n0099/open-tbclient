package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.content.Intent;
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
import c.a.d.f.p.n;
import c.a.s0.s.k0.f;
import c.a.s0.s.q.e2;
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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
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
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements c.a.t0.t2.y.b, g.b, c.a.s0.y0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public ViewTreeObserver.OnGlobalLayoutListener E;
    public boolean F;
    public boolean G;
    public RecyclerView.OnScrollListener H;
    public final f.g I;
    public CustomMessageListener J;
    public final CustomMessageListener K;
    public final BdListView.p L;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f46912e;

    /* renamed from: f  reason: collision with root package name */
    public AbsVideoPbFragment f46913f;

    /* renamed from: g  reason: collision with root package name */
    public View f46914g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f46915h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f46916i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.t0.t2.y.g.a f46917j;
    public c.a.t0.t2.y.h.b k;
    public PbListView l;
    public View m;
    public c.a.t0.t2.z.g n;
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
    public c.a.s0.s.k0.g y;
    public boolean z;

    /* loaded from: classes12.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

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
            this.a = detailInfoAndReplyFragment;
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
                if (i2 == 0) {
                    this.a.u(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.a.t();
                if (recyclerView.canScrollVertically(-1)) {
                    this.a.A = 2;
                    return;
                }
                if (Math.abs(i3) > 0 && this.a.A != 0) {
                    this.a.o.setVisibility(8);
                }
                this.a.A = 0;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f46918e;

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
            this.f46918e = detailInfoAndReplyFragment;
        }

        @Override // c.a.s0.s.k0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f46918e.getPbModel() != null && this.f46918e.getPbModel().J1(true)) {
                    TiebaStatic.eventStat(this.f46918e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.f46918e.endPullRefresh();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

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
            this.a = detailInfoAndReplyFragment;
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
            if (pVar == null || this.a.f46917j == null || this.a.f46915h == null) {
                return;
            }
            this.a.getPbModel().R0().F().remove(pVar);
            if (this.a.f46917j.a() != null) {
                this.a.f46917j.a().remove(pVar);
            }
            if (this.a.f46915h.getListView2().getData() != null) {
                this.a.f46915h.getListView2().getData().remove(pVar);
            }
            this.a.f46917j.k();
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(DetailInfoAndReplyFragment detailInfoAndReplyFragment, int i2) {
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
            this.a = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.getPbModel() == null || !(customResponsedMessage.getData() instanceof c.a.t0.t2.r.f)) {
                return;
            }
            c.a.t0.t2.r.f fVar = (c.a.t0.t2.r.f) customResponsedMessage.getData();
            if (StringHelper.equals(this.a.getPbModel().h1(), fVar.Q())) {
                this.a.getPbModel().c0(fVar.O());
                this.a.getPbModel().R1(fVar, 3, "");
                MessageManager.getInstance().unRegisterStickyMode(2921648);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(DetailInfoAndReplyFragment detailInfoAndReplyFragment, Context context) {
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
            this.a = detailInfoAndReplyFragment;
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

    /* loaded from: classes12.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f46919e;

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
            this.f46919e = detailInfoAndReplyFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f46919e.F || this.f46919e.getVideoPbFragment() == null) {
                return;
            }
            this.f46919e.F = true;
            this.f46919e.getVideoPbFragment().checkEasterEgg(this.f46919e.f46915h, false);
        }
    }

    /* loaded from: classes12.dex */
    public class g implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

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
            this.a = detailInfoAndReplyFragment;
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
    public class h implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f46920e;

        public h(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
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
            this.f46920e = detailInfoAndReplyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46920e.mIsLogin) {
                if (!this.f46920e.D && this.f46920e.checkNoData() && this.f46920e.getPbModel() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.f46920e.getPbModel().h1());
                    statisticItem.param("fid", this.f46920e.getPbModel().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.f46920e.D = true;
                }
                if (this.f46920e.getPbModel().F1(false)) {
                    this.f46920e.setPreLoadNext();
                    if (this.f46920e.getPageContext() != null) {
                        TiebaStatic.eventStat(this.f46920e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.f46920e.getPbModel().R0() != null) {
                    this.f46920e.refreshNextPageView();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f46921e;

        public i(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
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
            this.f46921e = detailInfoAndReplyFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f46921e.getContext());
                this.f46921e.resetLoadMoreFlag(true);
                this.f46921e.getPageContext().getPageActivity().finish();
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
        this.H = new a(this);
        this.I = new b(this);
        this.J = new c(this, 2016331);
        this.K = new d(this, 2921648);
        this.L = new h(this);
    }

    public static DetailInfoAndReplyFragment newInstance(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
            detailInfoAndReplyFragment.setArguments(bundle);
            detailInfoAndReplyFragment.f46913f = absVideoPbFragment;
            return detailInfoAndReplyFragment;
        }
        return (DetailInfoAndReplyFragment) invokeL.objValue;
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
            if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                this.f46913f.mDialogController.V();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public void endPullRefresh() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdSwipeRefreshLayout = this.x) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.x.setRefreshing(false);
        }
    }

    public int getFirstItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f46915h;
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f46915h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f46915h.getChildAt(0)) == null) {
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f46915h;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f46915h : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int getMultiNestedLayoutState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.B : invokeV.intValue;
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
            AbsPbActivity absPbActivity = this.f46912e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.A : invokeV.intValue;
    }

    @Override // c.a.s0.y0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public c.a.t0.t2.y.h.b getRichViewHepler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : (c.a.t0.t2.y.h.b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f46913f == null && (absPbActivity = this.f46912e) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f46913f = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f46913f;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || getView() == null) {
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
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.C = n.f(TbadkCoreApplication.getInst(), c.a.t0.t2.g.tbds120);
            this.f46915h = (BdTypeRecyclerView) this.f46914g.findViewById(c.a.t0.t2.i.video_pb_reply_list);
            e eVar = new e(this, getContext());
            this.f46916i = eVar;
            this.f46915h.setLayoutManager(eVar);
            if (this.f46913f.isCommentFloatPage()) {
                this.f46917j = new c.a.t0.t2.y.g.b(this, this.f46915h);
            } else {
                this.f46917j = new c.a.t0.t2.y.g.d(this, this.f46915h);
            }
            this.f46917j.y(getVideoPbFragment().getListener());
            this.f46917j.u(getVideoPbFragment().getManageOnClickListener());
            this.f46917j.w(getVideoPbFragment().getOnLongClickListener());
            this.f46917j.v(this.k.i());
            this.f46917j.C(this.k.l());
            this.o = this.f46914g.findViewById(c.a.t0.t2.i.reply_pager_title_shadow);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.l = pbListView;
            View findViewById = pbListView.b().findViewById(c.a.t0.t2.i.pb_more_view);
            this.m = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(getVideoPbFragment().getListener());
                SkinManager.setBackgroundResource(this.m, c.a.t0.t2.h.pb_foot_more_trans_selector);
            }
            this.l.A();
            this.l.o(c.a.t0.t2.h.pb_foot_more_trans_selector);
            this.l.p(c.a.t0.t2.h.pb_foot_more_trans_selector);
            this.l.s();
            this.f46915h.setOnSrollToBottomListener(this.L);
            this.f46915h.addOnScrollListener(this.H);
            this.f46915h.setOnTouchListener(getVideoPbFragment().getOnTouchListener());
            this.E = new f(this);
            this.f46915h.getViewTreeObserver().addOnGlobalLayoutListener(this.E);
            if (this.y == null) {
                c.a.s0.s.k0.g gVar = new c.a.s0.s.k0.g(getPageContext());
                this.y = gVar;
                gVar.i();
                this.y.a(this.I);
            }
            if (this.x == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f46914g.findViewById(c.a.t0.t2.i.pb_video_pull_refresh_layout);
                this.x = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.y);
                this.x.setEnabled(false);
                SkinManager.setBackgroundColor(this.x, c.a.t0.t2.f.CAM_X0205);
            }
            this.u = (LinearLayout) this.f46914g.findViewById(c.a.t0.t2.i.video_pb_suck_container);
            s();
            this.f46917j.x(getVideoPbFragment().onSwitchChangeListener);
            registerListener(this.J);
            registerListener(this.K);
            if (c.a.s0.g1.b.c.d()) {
                this.l.L(8);
                this.m.setVisibility(8);
            }
        }
    }

    public void invalidataData() {
        c.a.t0.t2.r.f R0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (R0 = getPbModel().R0()) == null) {
            return;
        }
        this.f46917j.t(getPbModel().f1());
        this.f46917j.q(R0);
        this.f46917j.k();
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
                this.l.I(TbadkCoreApplication.getInst().getResources().getString(l.pb_no_host_reply), this.C);
            } else {
                this.l.I(TbadkCoreApplication.getInst().getResources().getString(l.pb_no_replay), this.C);
            }
        }
        getVideoPbFragment().refreshBottomTool(R0);
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (getPbModel() != null) {
                return getPbModel().v0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f46915h;
            if (bdTypeRecyclerView == null) {
                return false;
            }
            return !bdTypeRecyclerView.canScrollVertically(-1);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getPbActivity()).get(VideoPbViewModel.class);
            videoPbViewModel.isLoading().observe(this, new g(this));
            r(true, 0, 3, 0, videoPbViewModel.getData(), "", 1, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.f46912e = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.d(i2);
                if (this.m != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.m);
                    SkinManager.setBackgroundResource(this.m, c.a.t0.t2.h.pb_foot_more_trans_selector);
                }
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.v;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.onChangeSkinType(i2);
            }
            PbChildTitleViewHolder pbChildTitleViewHolder = this.w;
            if (pbChildTitleViewHolder != null) {
                pbChildTitleViewHolder.onChangeSkinType();
            }
            c.a.t0.t2.y.g.a aVar = this.f46917j;
            if (aVar != null) {
                aVar.k();
            }
            View view = this.o;
            if (view != null) {
                SkinManager.setBackgroundResource(view, c.a.t0.t2.h.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.x, c.a.t0.t2.f.CAM_X0201);
            if (c.a.s0.g1.b.c.d()) {
                SkinManager.setBackgroundColor(this.f46915h, c.a.t0.t2.f.CAM_X0202);
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f46915h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, layoutInflater, viewGroup, bundle)) == null) {
            this.k = new c.a.t0.t2.y.h.b(this);
            this.f46914g = layoutInflater.inflate(j.pb_detail_info_and_reply_fragment, (ViewGroup) null);
            initUI();
            return this.f46914g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onDestroy();
            c.a.t0.t2.y.g.a aVar = this.f46917j;
            if (aVar != null) {
                aVar.m();
            }
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.K);
            c.a.t0.t2.u.f.n.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.f46915h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.E);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onPause();
            if (getVideoPbFragment() != null) {
                c.a.t0.t2.u.f.n.a().j(getPbActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onResume();
            this.t = false;
            u(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            super.onUserChanged(z);
            switchLoginStyle(z);
            if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                this.f46913f.mDialogController.H();
            }
            if (z && this.t) {
                setPreLoadNext();
                getPbModel().F1(true);
            }
        }
    }

    @Override // c.a.s0.y0.b
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
        }
    }

    public final void r(boolean z, int i2, int i3, int i4, c.a.t0.t2.r.f fVar, String str, int i5, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getPbActivity()).get(VideoPbViewModel.class);
            if (!z || getPbModel() == null || fVar == null) {
                return;
            }
            if (!z2) {
                if (this.G) {
                    getPbModel().Y();
                } else {
                    this.G = true;
                }
            }
            this.z = getPbModel().f1();
            boolean isEnabled = this.x.isEnabled();
            if (fVar.y().c() == 0 && this.z) {
                this.x.setEnabled(false);
            } else if (!isEnabled) {
                this.x.setEnabled(true);
                this.x.interruptRefresh();
            }
            this.f46917j.s(videoPbViewModel.isFromCDN());
            this.f46917j.t(this.z);
            this.f46917j.r(fVar, z2);
            this.p = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f46915h.setNextPage(this.l);
                this.s = 2;
                if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                    this.f46913f.mDialogController.V();
                }
            } else {
                this.p = true;
                if (fVar.y().b() == 1) {
                    if (this.n == null) {
                        c.a.t0.t2.z.g gVar = new c.a.t0.t2.z.g(this, this);
                        this.n = gVar;
                        gVar.a();
                        this.n.g();
                        if (this.f46917j instanceof c.a.t0.t2.y.g.b) {
                            this.n.h(new i(this));
                        }
                    }
                    this.f46915h.setNextPage(this.n);
                } else {
                    this.f46915h.setNextPage(this.l);
                }
                this.s = 3;
            }
            if (this.v != null) {
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
                this.v.bindDataToView(qVar);
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
                if (fVar.y().b() == 0) {
                    this.l.D(TbadkCoreApplication.getInst().getResources().getString(l.list_has_no_more));
                } else {
                    this.l.D(TbadkCoreApplication.getInst().getResources().getString(l.load_more));
                }
                this.l.k();
                if (fVar.y().b() == 0 || F == null) {
                    refreshNextPageView();
                }
            }
            if (i3 == 2) {
                this.f46915h.setSelection(i4 > 1 ? (i4 + ((this.f46915h.getData() == null && fVar.F() == null) ? 0 : this.f46915h.getData().size() - fVar.F().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.r = false;
                } else if (i3 == 5) {
                    this.f46915h.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = m0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f46915h.onRestoreInstanceState(e2);
                        }
                    }
                    this.f46915h.setSelection(0);
                } else if (i3 == 8) {
                    this.f46915h.setSelection(i4 > 0 ? i4 + ((this.f46915h.getData() == null && fVar.F() == null) ? 0 : this.f46915h.getData().size() - fVar.F().size()) : 0);
                    this.l.f();
                    this.l.D(getString(l.pb_load_more_without_point));
                    this.l.y();
                }
            } else if (i5 == 1) {
                Parcelable e3 = m0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f46915h.onRestoreInstanceState(e3);
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
            if (this.l != null) {
                if (fVar.y().b() != 0 && !c.a.s0.g1.b.c.d()) {
                    this.l.L(0);
                } else {
                    this.l.L(8);
                }
            }
            if (c.a.t0.t2.u.f.c1.b.a(getListView())) {
                if (getPbModel().P1()) {
                    c.a.t0.t2.u.f.c1.b.f(getListView(), getPbModel().s0());
                } else if (videoPbViewModel.isJumpCommentTab()) {
                    videoPbViewModel.setJumpCommentTab(false);
                    if (getPbModel().Q1()) {
                        c.a.t0.t2.u.f.c1.b.g(getListView(), getPbModel().t0());
                        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.v;
                        if (pbReplyTitleViewHolder != null) {
                            pbReplyTitleViewHolder.setViewVisibility(0);
                            return;
                        }
                        return;
                    }
                    c.a.t0.t2.u.f.c1.b.e(getListView());
                }
            }
        }
    }

    public void receiveFling(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || (bdTypeRecyclerView = this.f46915h) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void recoverLastListViewPosition() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || this.f46915h == null) {
        }
    }

    @Override // c.a.t0.t2.y.b
    public void refresh(boolean z, int i2, int i3, int i4, c.a.t0.t2.r.f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        r(z, i2, i3, i4, fVar, str, i5, false);
    }

    public void refreshFirstFloor() {
        c.a.t0.t2.y.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (aVar = this.f46917j) == null) {
            return;
        }
        aVar.l();
    }

    public void refreshNextPageView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || this.s == 2) {
            return;
        }
        this.f46915h.setNextPage(this.l);
        this.s = 2;
    }

    @Override // c.a.t0.t2.z.g.b
    public void resetLoadMoreFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.t = z;
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(j.pb_reply_title_layout, (ViewGroup) null));
            this.v = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.isSticky = false;
            pbReplyTitleViewHolder.setPbCommonOnclickListener(getVideoPbFragment().getListener());
            this.v.setOnSwitchChangeListener(getVideoPbFragment().onSwitchChangeListener);
            this.v.setViewVisibility(8);
            if (!this.f46913f.isCommentFloatPage()) {
                this.u.addView(this.v.getRootView());
            }
            this.w = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(j.pb_child_title, (ViewGroup) null));
            c.a.t0.t2.r.e eVar = new c.a.t0.t2.r.e();
            eVar.g(TbadkCoreApplication.getInst().getString(l.related_recommendation));
            this.w.bindData(eVar);
            this.w.setViewVisibility(8);
            if (this.f46913f.isCommentFloatPage()) {
                return;
            }
            this.u.addView(this.w.getRootView());
        }
    }

    public void scrollListView(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048617, this, i2, i3) == null) || (bdTypeRecyclerView = this.f46915h) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f46915h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f46915h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void setEndText(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.D(str);
    }

    public void setEndTextWithNoData(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.I(str, this.C);
    }

    public void setNeedRecoverPosition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.q = z;
        }
    }

    public void setPreLoadNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.l.A();
            this.l.R();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    public void setShadowVisible(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048622, this, i2) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void setSwipeRefreshLayoutEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.x.setEnabled(z);
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || getView() == null) {
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
        if ((interceptable == null || interceptable.invokeZ(1048626, this, z) == null) && z && this.p) {
            this.l.D(TbadkCoreApplication.getInst().getResources().getString(l.click_load_more));
            this.f46915h.setNextPage(this.l);
            this.s = 2;
        }
    }

    public final void t() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (bdTypeRecyclerView = this.f46915h) == null || this.f46916i == null || this.f46917j == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.f46917j.d();
        int headerViewsCount2 = this.f46915h.getHeaderViewsCount() + this.f46917j.c();
        int findFirstVisibleItemPosition = this.f46916i.findFirstVisibleItemPosition();
        if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
            this.v.setViewVisibility(0);
        } else {
            this.v.setViewVisibility(8);
        }
        if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
            this.w.setViewVisibility(0);
            this.v.setViewVisibility(8);
        } else {
            this.w.setViewVisibility(8);
        }
        if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
            setShadowVisible(0);
        } else {
            setShadowVisible(8);
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048628, this, z) == null) || getVideoPbFragment() == null || getPbActivity() == null || getPbActivity().getPbModel() == null || this.f46917j.e() == null) {
            return;
        }
        c.a.t0.t2.u.f.n.a().g(getPbActivity().getPbModel().w1(), this.f46917j.e().c0(), this.v.getRootView(), getPbActivity().getPageStayDurationItem(), z, null, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public c.a.t0.t2.y.g.a getAdapterManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46917j : (c.a.t0.t2.y.g.a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, view) == null) {
            super.showLoadingView(view);
        }
    }
}
