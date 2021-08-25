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
import c.a.e.e.p.l;
import c.a.p0.s.f0.f;
import c.a.p0.s.q.c2;
import c.a.q0.i2.h.o;
import c.a.q0.i2.k.e.j0;
import c.a.q0.i2.p.g;
import c.a.q0.i3.i0.p;
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
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements c.a.q0.i2.o.a, g.b, c.a.p0.v0.a {
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
    public final BdListView.p K;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f55428e;

    /* renamed from: f  reason: collision with root package name */
    public AbsVideoPbFragment f55429f;

    /* renamed from: g  reason: collision with root package name */
    public View f55430g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f55431h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f55432i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.i2.o.f.a f55433j;
    public c.a.q0.i2.o.g.b k;
    public PbListView l;
    public View m;
    public c.a.q0.i2.p.g n;
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
    public c.a.p0.s.f0.g y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f55434a;

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
            this.f55434a = detailInfoAndReplyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    this.f55434a.getVideoPbFragment().resetCommentView();
                    this.f55434a.getVideoPbFragment().resetRecordLocation();
                }
                if (this.f55434a.getVideoPbFragment() != null) {
                    this.f55434a.getVideoPbFragment().onScrollStateChanged(i2);
                }
                if (i2 == 0) {
                    this.f55434a.p(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f55434a.o();
                if (recyclerView.canScrollVertically(-1)) {
                    this.f55434a.A = 2;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f55434a.A != 0) {
                    this.f55434a.o.setVisibility(8);
                }
                this.f55434a.A = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f55435e;

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
            this.f55435e = detailInfoAndReplyFragment;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f55435e.getPbModel() != null && this.f55435e.getPbModel().C1(true)) {
                    TiebaStatic.eventStat(this.f55435e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.f55435e.endPullRefresh();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f55436a;

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
            this.f55436a = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f55436a.getPbModel() == null || this.f55436a.getPbModel().O0() == null || this.f55436a.getPbModel().O0().F() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            p pVar = null;
            Iterator<PostData> it = this.f55436a.getPbModel().O0().F().iterator();
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
            if (pVar == null || this.f55436a.f55433j == null || this.f55436a.f55431h == null) {
                return;
            }
            this.f55436a.getPbModel().O0().F().remove(pVar);
            if (this.f55436a.f55433j.a() != null) {
                this.f55436a.f55433j.a().remove(pVar);
            }
            if (this.f55436a.f55431h.getListView2().getData() != null) {
                this.f55436a.f55431h.getListView2().getData().remove(pVar);
            }
            this.f55436a.f55433j.k();
        }
    }

    /* loaded from: classes7.dex */
    public class d extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f55437a;

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
            this.f55437a = detailInfoAndReplyFragment;
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

    /* loaded from: classes7.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f55438e;

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
            this.f55438e = detailInfoAndReplyFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55438e.F || this.f55438e.getVideoPbFragment() == null) {
                return;
            }
            this.f55438e.F = true;
            this.f55438e.getVideoPbFragment().checkEasterEgg(this.f55438e.f55431h, false);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f55439e;

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
            this.f55439e = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f55439e.showLoadingView();
                } else {
                    this.f55439e.hideLoadingView();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f55440e;

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
            this.f55440e = detailInfoAndReplyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f55440e.mIsLogin) {
                if (!this.f55440e.D && this.f55440e.checkNoData() && this.f55440e.getPbModel() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.f55440e.getPbModel().e1());
                    statisticItem.param("fid", this.f55440e.getPbModel().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.f55440e.D = true;
                }
                if (this.f55440e.getPbModel().y1(false)) {
                    this.f55440e.setPreLoadNext();
                    if (this.f55440e.getPageContext() != null) {
                        TiebaStatic.eventStat(this.f55440e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.f55440e.getPbModel().O0() != null) {
                    this.f55440e.refreshNextPageView();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f55441e;

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
            this.f55441e = detailInfoAndReplyFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f55441e.getContext());
                this.f55441e.resetLoadMoreFlag(true);
                this.f55441e.getPageContext().getPageActivity().finish();
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
        this.K = new g(this);
    }

    public static DetailInfoAndReplyFragment newInstance(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
            detailInfoAndReplyFragment.setArguments(bundle);
            detailInfoAndReplyFragment.f55429f = absVideoPbFragment;
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
            if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                this.f55429f.mDialogController.V();
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f55431h;
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f55431h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f55431h.getChildAt(0)) == null) {
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f55431h;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f55431h : (BdTypeRecyclerView) invokeV.objValue;
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
            AbsPbActivity absPbActivity = this.f55428e;
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

    @Override // c.a.p0.v0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public c.a.q0.i2.o.g.b getRichViewHepler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : (c.a.q0.i2.o.g.b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f55429f == null && (absPbActivity = this.f55428e) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f55429f = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f55429f;
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
            this.C = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            this.f55431h = (BdTypeRecyclerView) this.f55430g.findViewById(R.id.video_pb_reply_list);
            d dVar = new d(this, getContext());
            this.f55432i = dVar;
            this.f55431h.setLayoutManager(dVar);
            if (this.f55429f.isCommentFloatPage()) {
                this.f55433j = new c.a.q0.i2.o.f.b(this, this.f55431h);
            } else {
                this.f55433j = new c.a.q0.i2.o.f.d(this, this.f55431h);
            }
            this.f55433j.y(getVideoPbFragment().getListener());
            this.f55433j.u(getVideoPbFragment().getManageOnClickListener());
            this.f55433j.w(getVideoPbFragment().getOnLongClickListener());
            this.f55433j.v(this.k.i());
            this.f55433j.B(this.k.l());
            this.o = this.f55430g.findViewById(R.id.reply_pager_title_shadow);
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
            this.f55431h.setOnSrollToBottomListener(this.K);
            this.f55431h.addOnScrollListener(this.H);
            this.f55431h.setOnTouchListener(getVideoPbFragment().getOnTouchListener());
            this.E = new e(this);
            this.f55431h.getViewTreeObserver().addOnGlobalLayoutListener(this.E);
            if (this.y == null) {
                c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(getPageContext());
                this.y = gVar;
                gVar.i();
                this.y.a(this.I);
            }
            if (this.x == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f55430g.findViewById(R.id.pb_video_pull_refresh_layout);
                this.x = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.y);
                this.x.setEnabled(false);
                SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
            }
            this.u = (LinearLayout) this.f55430g.findViewById(R.id.video_pb_suck_container);
            n();
            this.f55433j.x(getVideoPbFragment().onSwitchChangeListener);
            registerListener(this.J);
            if (c.a.p0.e1.b.e.d()) {
                this.l.I(8);
                this.m.setVisibility(8);
            }
        }
    }

    public void invalidataData() {
        c.a.q0.i2.h.e O0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (O0 = getPbModel().O0()) == null) {
            return;
        }
        this.f55433j.t(getPbModel().c1());
        this.f55433j.q(O0);
        this.f55433j.k();
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
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.C);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.C);
            }
        }
        getVideoPbFragment().refreshBottomTool(O0);
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (getPbModel() != null) {
                return getPbModel().s0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.v0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.v0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f55431h;
            return (bdTypeRecyclerView == null || (childAt = bdTypeRecyclerView.getChildAt(0)) == null || childAt.getTop() != 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void m(boolean z, int i2, int i3, int i4, c.a.q0.i2.h.e eVar, String str, int i5, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getPbActivity()).get(VideoPbViewModel.class);
            if (!z || getPbModel() == null || eVar == null) {
                return;
            }
            if (!z2) {
                if (this.G) {
                    getPbModel().W();
                } else {
                    this.G = true;
                }
            }
            this.z = getPbModel().c1();
            boolean isEnabled = this.x.isEnabled();
            if (eVar.y().c() == 0 && this.z) {
                this.x.setEnabled(false);
            } else if (!isEnabled) {
                this.x.setEnabled(true);
                this.x.interruptRefresh();
            }
            this.f55433j.s(videoPbViewModel.isFromCDN());
            this.f55433j.t(this.z);
            this.f55433j.r(eVar, z2);
            this.p = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f55431h.setNextPage(this.l);
                this.s = 2;
                if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                    this.f55429f.mDialogController.V();
                }
            } else {
                this.p = true;
                if (eVar.y().b() == 1) {
                    if (this.n == null) {
                        c.a.q0.i2.p.g gVar = new c.a.q0.i2.p.g(this, this);
                        this.n = gVar;
                        gVar.a();
                        this.n.g();
                        if (this.f55433j instanceof c.a.q0.i2.o.f.b) {
                            this.n.h(new h(this));
                        }
                    }
                    this.f55431h.setNextPage(this.n);
                } else {
                    this.f55431h.setNextPage(this.l);
                }
                this.s = 3;
            }
            if (this.v != null) {
                o oVar = new o(o.l);
                c2 O = eVar.O();
                if (O != null) {
                    O.S0();
                }
                getPbModel().c1();
                oVar.f19104h = isHostOnlyMode();
                oVar.f19103g = eVar.f19068g;
                eVar.c();
                oVar.f19105i = eVar.f0();
                oVar.k = eVar.f19067f;
                this.v.bindDataToView(oVar);
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
                if (eVar.y().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
                if (eVar.y().b() == 0 || F == null) {
                    refreshNextPageView();
                }
            }
            if (i3 == 2) {
                this.f55431h.setSelection(i4 > 1 ? (i4 + ((this.f55431h.getData() == null && eVar.F() == null) ? 0 : this.f55431h.getData().size() - eVar.F().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.r = false;
                } else if (i3 == 5) {
                    this.f55431h.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = j0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f55431h.onRestoreInstanceState(e2);
                        }
                    }
                    this.f55431h.setSelection(0);
                } else if (i3 == 8) {
                    this.f55431h.setSelection(i4 > 0 ? i4 + ((this.f55431h.getData() == null && eVar.F() == null) ? 0 : this.f55431h.getData().size() - eVar.F().size()) : 0);
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            } else if (i5 == 1) {
                Parcelable e3 = j0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f55431h.onRestoreInstanceState(e3);
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
            if (this.l != null) {
                if (eVar.y().b() != 0 && !c.a.p0.e1.b.e.d()) {
                    this.l.I(0);
                } else {
                    this.l.I(8);
                }
            }
            if (c.a.q0.i2.k.e.y0.b.a(getListView()) && videoPbViewModel.isJumpCommentTab()) {
                videoPbViewModel.setJumpCommentTab(false);
                String q0 = getPbModel().q0();
                if (!TextUtils.isEmpty(q0)) {
                    c.a.q0.i2.k.e.y0.b.f(getListView(), q0);
                    PbReplyTitleViewHolder pbReplyTitleViewHolder = this.v;
                    if (pbReplyTitleViewHolder != null) {
                        pbReplyTitleViewHolder.setViewVisibility(0);
                        return;
                    }
                    return;
                }
                c.a.q0.i2.k.e.y0.b.e(getListView());
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
            this.v = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.isSticky = false;
            pbReplyTitleViewHolder.setPbCommonOnclickListener(getVideoPbFragment().getListener());
            this.v.setOnSwitchChangeListener(getVideoPbFragment().onSwitchChangeListener);
            this.v.setViewVisibility(8);
            if (!this.f55429f.isCommentFloatPage()) {
                this.u.addView(this.v.getRootView());
            }
            this.w = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
            c.a.q0.i2.h.d dVar = new c.a.q0.i2.h.d();
            dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.w.bindData(dVar);
            this.w.setViewVisibility(8);
            if (this.f55429f.isCommentFloatPage()) {
                return;
            }
            this.u.addView(this.w.getRootView());
        }
    }

    public final void o() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (bdTypeRecyclerView = this.f55431h) == null || this.f55432i == null || this.f55433j == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.f55433j.d();
        int headerViewsCount2 = this.f55431h.getHeaderViewsCount() + this.f55433j.c();
        int findFirstVisibleItemPosition = this.f55432i.findFirstVisibleItemPosition();
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getPbActivity()).get(VideoPbViewModel.class);
            videoPbViewModel.isLoading().observe(this, new f(this));
            m(true, 0, 3, 0, videoPbViewModel.getData(), "", 1, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.f55428e = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
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
                pbReplyTitleViewHolder.onChangeSkinType(i2);
            }
            PbChildTitleViewHolder pbChildTitleViewHolder = this.w;
            if (pbChildTitleViewHolder != null) {
                pbChildTitleViewHolder.onChangeSkinType();
            }
            c.a.q0.i2.o.f.a aVar = this.f55433j;
            if (aVar != null) {
                aVar.k();
            }
            View view = this.o;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
            if (c.a.p0.e1.b.e.d()) {
                SkinManager.setBackgroundColor(this.f55431h, R.color.CAM_X0202);
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f55431h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, layoutInflater, viewGroup, bundle)) == null) {
            this.k = new c.a.q0.i2.o.g.b(this);
            this.f55430g = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
            initUI();
            return this.f55430g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onDestroy();
            c.a.q0.i2.o.f.a aVar = this.f55433j;
            if (aVar != null) {
                aVar.m();
            }
            MessageManager.getInstance().unRegisterListener(this.J);
            c.a.q0.i2.k.e.l.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.f55431h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.E);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onPause();
            if (getVideoPbFragment() != null) {
                c.a.q0.i2.k.e.l.a().j(getPbActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onResume();
            this.t = false;
            p(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            super.onUserChanged(z);
            switchLoginStyle(z);
            if (getVideoPbFragment() != null && getVideoPbFragment().mDialogController != null) {
                this.f55429f.mDialogController.H();
            }
            if (z && this.t) {
                setPreLoadNext();
                getPbModel().y1(true);
            }
        }
    }

    @Override // c.a.p0.v0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || getVideoPbFragment() == null || getPbActivity() == null || getPbActivity().getPbModel() == null || this.f55433j.e() == null) {
            return;
        }
        c.a.q0.i2.k.e.l.a().g(getPbActivity().getPbModel().p1(), this.f55433j.e().k0(), this.v.getRootView(), getPbActivity().getPageStayDurationItem(), z, null, null);
    }

    public void receiveFling(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || (bdTypeRecyclerView = this.f55431h) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    public void recoverLastListViewPosition() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || this.f55431h == null) {
        }
    }

    @Override // c.a.q0.i2.o.a
    public void refresh(boolean z, int i2, int i3, int i4, c.a.q0.i2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        m(z, i2, i3, i4, eVar, str, i5, false);
    }

    public void refreshFirstFloor() {
        c.a.q0.i2.o.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (aVar = this.f55433j) == null) {
            return;
        }
        aVar.l();
    }

    public void refreshNextPageView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.s == 2) {
            return;
        }
        this.f55431h.setNextPage(this.l);
        this.s = 2;
    }

    @Override // c.a.q0.i2.p.g.b
    public void resetLoadMoreFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.t = z;
        }
    }

    public void scrollListView(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048619, this, i2, i3) == null) || (bdTypeRecyclerView = this.f55431h) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f55431h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f55431h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void setEndText(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.A(str);
    }

    public void setEndTextWithNoData(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.F(str, this.C);
    }

    public void setNeedRecoverPosition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.q = z;
        }
    }

    public void setPreLoadNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.l.x();
            this.l.O();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    public void setShadowVisible(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void setSwipeRefreshLayoutEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.x.setEnabled(z);
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || getView() == null) {
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
        if ((interceptable == null || interceptable.invokeZ(1048628, this, z) == null) && z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f55431h.setNextPage(this.l);
            this.s = 2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public c.a.q0.i2.o.f.a getAdapterManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55433j : (c.a.q0.i2.o.f.a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, view) == null) {
            super.showLoadingView(view);
        }
    }
}
